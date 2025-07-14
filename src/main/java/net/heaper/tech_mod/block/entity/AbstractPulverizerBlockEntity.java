package net.heaper.tech_mod.block.entity;

import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.objects.Reference2IntOpenHashMap;
import it.unimi.dsi.fastutil.objects.Reference2IntMap.Entry;
import net.heaper.tech_mod.block.AbstractPulverizerBlock;
import net.heaper.tech_mod.recipe.AbstractPulverizingRecipe;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.LockableContainerBlockEntity;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.*;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.RegistryKey;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

public abstract class AbstractPulverizerBlockEntity extends LockableContainerBlockEntity implements SidedInventory, RecipeUnlocker, RecipeInputProvider {
    protected static final int INPUT_SLOT_INDEX = 0;
    protected static final int OUTPUT_SLOT_INDEX = 1;
    private static final int[] TOP_SLOTS = new int[]{0, 1};
    private static final int[] BOTTOM_SLOTS = new int[]{0, 1};
    private static final int[] AVAILABLE_SLOTS = new int[]{0, 1};
    private static final int PULVERIZE_TIME_PROPERTY_INDEX = 1;
    private static final int PULVERIZE_TIME_TOTAL_PROPERTY_INDEX = 2;
    private static final int PROPERTY_COUNT = 4;
    private static final int DEFAULT_PULVERIZE_TIME = 200;
    private static final Codec<Map<RegistryKey<Recipe<?>>, Integer>> CODEC = Codec.unboundedMap(Recipe.KEY_CODEC, Codec.INT);
    private static final short DEFAULT_RUNNING_TIME_REMAINING = 0;
    private static final short DEFAULT_RUNNING_TOTAL_TIME = 0;
    private static final short DEFAULT_PULVERIZING_TIME_SPENT = 0;
    private static final short DEFAULT_PULVERIZING_TOTAL_TIME = 0;
    protected DefaultedList<ItemStack> inventory = DefaultedList.ofSize(2, ItemStack.EMPTY);
    int runningTimeRemaining;
    int runningTotalTime;
    int pulverizingTimeSpent;
    int pulverizingTotalTime;
    protected final PropertyDelegate propertyDelegate = new PropertyDelegate() {
        @Override
        public int get(int index) {
            switch(index) {
                case 0:
                    return AbstractPulverizerBlockEntity.this.runningTimeRemaining;
                case 1:
                    return AbstractPulverizerBlockEntity.this.runningTotalTime;
                case 2:
                    return AbstractPulverizerBlockEntity.this.pulverizingTimeSpent;
                case 3:
                    return AbstractPulverizerBlockEntity.this.pulverizingTotalTime;
                default:
                    return 0;
            }
        }

        @Override
        public void set(int index, int value) {
            switch (index) {
                case 0:
                    AbstractPulverizerBlockEntity.this.runningTimeRemaining = value;
                case 1:
                    AbstractPulverizerBlockEntity.this.runningTotalTime = value;
                case 2:
                    AbstractPulverizerBlockEntity.this.pulverizingTimeSpent = value;
                case 3:
                    AbstractPulverizerBlockEntity.this.pulverizingTotalTime = value;
            }
        }

        @Override
        public int size() {
            return 4;
        }
    };
    private final Reference2IntOpenHashMap<RegistryKey<Recipe<?>>> recipesUsed = new Reference2IntOpenHashMap<>();
    private final ServerRecipeManager.MatchGetter<SingleStackRecipeInput, ? extends AbstractPulverizingRecipe> matchGetter;

    protected AbstractPulverizerBlockEntity(
            BlockEntityType<?> blockEntityType, BlockPos pos, BlockState state, RecipeType<? extends AbstractPulverizingRecipe> recipeType
    ) {
        super(blockEntityType, pos, state);
        this.matchGetter = ServerRecipeManager.createCachedMatchGetter(recipeType);
    }

    private boolean isRunning() {
        return this.runningTimeRemaining > 0;
    }

    @Override
    protected void readData(ReadView view) {
        super.readData(view);
        this.inventory = DefaultedList.ofSize(this.size(), ItemStack.EMPTY);
        Inventories.readData(view, this.inventory);
        pulverizingTimeSpent = view.getShort("pulverizing_time_spent", (short) 0);
        pulverizingTotalTime = view.getShort("pulverizing_total_time", (short) 0);
        runningTimeRemaining = view.getShort("running_time_remaining", (short) 0);
        runningTotalTime = view.getShort("running_total_time", (short) 0);
        this.recipesUsed.clear();
        this.recipesUsed.putAll((Map<? extends RegistryKey<Recipe<?>>, ? extends Integer>) view.read("RecipesUsed", CODEC).orElse(Map.of()));
    }

    @Override
    protected void writeData(WriteView view) {
        super.writeData(view);
        view.putShort("pulverizing_time_spent", (short) this.pulverizingTimeSpent);
        view.putShort("pulverizing_total_time", (short) this.pulverizingTotalTime);
        view.putShort("running_time_remaining", (short) this.runningTimeRemaining);
        view.putShort("running_total_time", (short) this.runningTotalTime);
        Inventories.writeData(view, this.inventory);
        view.put("RecipesUsed", CODEC, this.recipesUsed);
    }

    public static void tick(ServerWorld world, BlockPos pos, BlockState state, AbstractPulverizerBlockEntity blockEntity) {
        boolean bl = blockEntity.isRunning();
        boolean bl2 = false;
        if (blockEntity.isRunning()) {
            blockEntity.runningTimeRemaining--;
        }

        ItemStack itemStack2 = blockEntity.inventory.get(0);
        boolean bl3 = !itemStack2.isEmpty();
        if (blockEntity.isRunning() || bl3) {
            SingleStackRecipeInput singleStackRecipeInput = new SingleStackRecipeInput(itemStack2);
            RecipeEntry<? extends AbstractPulverizingRecipe> recipeEntry;
            if (bl3) {
                recipeEntry = (RecipeEntry<? extends AbstractPulverizingRecipe>) blockEntity.matchGetter.getFirstMatch(singleStackRecipeInput, world).orElse(null);
            } else {
                recipeEntry = null;
            }

            if (!bl3 || recipeEntry == null) {
                if (blockEntity.isRunning()) {
                    blockEntity.runningTimeRemaining = 0;
                    blockEntity.pulverizingTimeSpent = 0;
                    state = state.with(AbstractPulverizerBlock.ENABLED, false);
                    world.setBlockState(pos, state, Block.NOTIFY_ALL);
                    markDirty(world, pos, state);
                }
                return;
            }

            int i = blockEntity.getMaxCountPerStack();
            if (!blockEntity.isRunning() && canAcceptRecipeOutput(world.getRegistryManager(), recipeEntry, singleStackRecipeInput, blockEntity.inventory, i)) {
                blockEntity.runningTimeRemaining = getPulverizingTime(world, blockEntity);
                blockEntity.runningTotalTime = blockEntity.runningTimeRemaining;
            }

            if (blockEntity.isRunning() && canAcceptRecipeOutput(world.getRegistryManager(), recipeEntry, singleStackRecipeInput, blockEntity.inventory, i)) {
                blockEntity.pulverizingTimeSpent++;
                if (blockEntity.pulverizingTimeSpent == blockEntity.runningTotalTime) {
                    blockEntity.pulverizingTimeSpent = 0;
                    blockEntity.pulverizingTotalTime = getPulverizingTime(world, blockEntity);
                    if (craftRecipe(world.getRegistryManager(), recipeEntry, singleStackRecipeInput, blockEntity.inventory, i)) {
                        blockEntity.setLastRecipe(recipeEntry);
                    }

                    bl2 = true;
                }
            } else {
                blockEntity.pulverizingTimeSpent = 0;
            }
        } else if (!blockEntity.isRunning() && blockEntity.pulverizingTimeSpent > 0) {
            blockEntity.pulverizingTimeSpent = MathHelper.clamp(blockEntity.pulverizingTimeSpent - 2, 0, blockEntity.pulverizingTotalTime);
        }

        if (bl != blockEntity.isRunning()) {
            bl2 = true;
            state = state.with(AbstractPulverizerBlock.ENABLED, blockEntity.isRunning());
            world.setBlockState(pos, state, Block.NOTIFY_ALL);
        }

        if (bl2) {
            markDirty(world, pos, state);
        }
    }

    private static boolean canAcceptRecipeOutput(
            DynamicRegistryManager dynamicRegistryManager,
            @Nullable RecipeEntry<? extends AbstractPulverizingRecipe> recipe,
            SingleStackRecipeInput input,
            DefaultedList<ItemStack> inventory,
            int maxCount
    ) {
        if (!inventory.get(0).isEmpty() && recipe != null) {
            ItemStack itemStack = recipe.value().craft(input, dynamicRegistryManager);
            if (itemStack.isEmpty()) {
                return false;
            } else {
                ItemStack itemStack2 = inventory.get(1);
                if (itemStack2.isEmpty()) {
                    return true;
                } else if (!ItemStack.areItemsAndComponentsEqual(itemStack2, itemStack)) {
                    return false;
                } else {
                    return itemStack2.getCount() + itemStack.getCount() <= Math.min(maxCount, itemStack2.getMaxCount());
                }
            }
        } else {
            return false;
        }
    }

    private static boolean craftRecipe(
            DynamicRegistryManager dynamicRegistryManager,
            @Nullable RecipeEntry<? extends AbstractPulverizingRecipe> recipe,
            SingleStackRecipeInput input,
            DefaultedList<ItemStack> inventory,
            int maxCount
    ) {
        if (recipe != null && canAcceptRecipeOutput(dynamicRegistryManager, recipe, input, inventory, maxCount)) {
            ItemStack itemStack = inventory.get(0);
            ItemStack itemStack2 = recipe.value().craft(input, dynamicRegistryManager);
            ItemStack itemStack3 = inventory.get(1);
            if (itemStack3.isEmpty()) {
                inventory.set(1, itemStack2.copy());
            } else if (ItemStack.areItemsAndComponentsEqual(itemStack3, itemStack2)) {
                itemStack3.increment(itemStack2.getCount());
            }

            itemStack.decrement(1);
            return true;
        } else {
            return false;
        }
    }

    private static int getPulverizingTime(ServerWorld world, AbstractPulverizerBlockEntity pulverizer) {
        SingleStackRecipeInput singleStackRecipeInput = new SingleStackRecipeInput(pulverizer.getStack(0));
        return (Integer) pulverizer.matchGetter
                .getFirstMatch(singleStackRecipeInput, world)
                .map(recipe -> ((AbstractPulverizingRecipe) recipe.value()).getPulverizationTime())
                .orElse(200);
    }

    @Override
    public int[] getAvailableSlots(Direction side) {
        return AVAILABLE_SLOTS;
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction dir) {
        return switch (slot) {
            case 0 -> true;
            case 1 -> false;
            default -> throw new IllegalStateException("Unexpected value: " + slot);
        };
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction dir) {
        return switch (slot) {
            case 0 -> false;
            case 1 -> true;
            default -> throw new IllegalStateException("Unexpected value: " + slot);
        };
    }

    @Override
    public int size() {
        return this.inventory.size();
    }

    @Override
    protected DefaultedList<ItemStack> getHeldStacks() {
        return this.inventory;
    }

    @Override
    protected void setHeldStacks(DefaultedList<ItemStack> inventory) {
        this.inventory = inventory;
    }

    @Override
    public void setStack(int slot, ItemStack stack) {
        ItemStack itemStack = this.inventory.get(slot);
        boolean bl = !stack.isEmpty() && ItemStack.areItemsAndComponentsEqual(itemStack, stack);
        this.inventory.set(slot, stack);
        stack.capCount(this.getMaxCount(stack));
        if (slot == 0 && !bl && this.world instanceof ServerWorld serverWorld) {
            this.pulverizingTotalTime = getPulverizingTime(serverWorld, this);
            this.pulverizingTimeSpent = 0;
            this.markDirty();
        }
    }

    @Override
    public void setLastRecipe(@Nullable RecipeEntry<?> recipe) {
        if (recipe != null) {
            RegistryKey<Recipe<?>> registryKey = recipe.id();
            this.recipesUsed.addTo(registryKey, 1);
        }
    }

    @Override
    public @Nullable RecipeEntry<?> getLastRecipe() {
        return null;
    }

    @Override
    public void unlockLastRecipe(PlayerEntity player, List<ItemStack> ingredients) {
    }

    public void dropExperienceForRecipesUsed(ServerPlayerEntity player) {
        List<RecipeEntry<?>> list = this.getRecipesUsedAndDroppedExperience(player.getWorld(), player.getPos());
        player.unlockRecipes(list);

        for (RecipeEntry<?> recipeEntry : list) {
            if (recipeEntry != null) {
                player.onRecipeCrafted(recipeEntry, this.inventory);
            }
        }

        this.recipesUsed.clear();
    }

    public List<RecipeEntry<?>> getRecipesUsedAndDroppedExperience(ServerWorld world, Vec3d pos) {
        List<RecipeEntry<?>> list = Lists.<RecipeEntry<?>>newArrayList();

        for (Entry<RegistryKey<Recipe<?>>> entry : this.recipesUsed.reference2IntEntrySet()) {
            world.getRecipeManager().get((RegistryKey<Recipe<?>>) entry.getKey()).ifPresent(recipe -> {
                list.add(recipe);
                dropExperience(world, pos, entry.getIntValue(), ((AbstractPulverizingRecipe) recipe.value()).getExperience());
            });
        }

        return list;
    }

    public static void dropExperience(ServerWorld world, Vec3d pos, int multiplier, float experience) {
        int i = MathHelper.floor(multiplier * experience);
        float f = MathHelper.fractionalPart(multiplier * experience);
        if (f != 0.0F && Math.random() < f) {
            i++;
        }

        ExperienceOrbEntity.spawn(world, pos, i);
    }

    @Override
    public void provideRecipeInputs(RecipeFinder finder) {
        for (ItemStack itemStack : this.inventory) {
            finder.addInput(itemStack);
        }
    }

    @Override
    public void onBlockReplaced(BlockPos pos, BlockState oldState) {
        super.onBlockReplaced(pos, oldState);
        if (this.world instanceof ServerWorld serverWorld) {
            this.getRecipesUsedAndDroppedExperience(serverWorld, Vec3d.of(pos));
        }
    }
}