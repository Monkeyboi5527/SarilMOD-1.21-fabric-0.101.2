package net.saril.sarilmod.block.entity.custom;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.saril.sarilmod.block.entity.ImplementedInventory;
import net.saril.sarilmod.block.entity.ModBlockEntities;
import net.saril.sarilmod.item.ModItems;
import net.saril.sarilmod.recipe.MatterStabilizerRecipe;
import net.saril.sarilmod.recipe.MatterStabilizerRecipeInput;
import net.saril.sarilmod.recipe.ModRecipes;
import net.saril.sarilmod.screen.custom.MatterStabilizerScreenHandler;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class MatterStabilizerBlockEntity extends BlockEntity implements ImplementedInventory, ExtendedScreenHandlerFactory<BlockPos> {
   private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(2, ItemStack.EMPTY);

   private static final int INPUT_SLOT = 0;
   private static final int OUTPUT_SLOT = 1;

   protected PropertyDelegate propertyDelegate;
   private int progress = 0;
   private int maxProgress = 72;

   public MatterStabilizerBlockEntity(BlockPos pos, BlockState state) {
       super(ModBlockEntities.MATTER_STABILIZER_BE, pos, state);
       this.propertyDelegate = new PropertyDelegate() {
           @Override
           public int get(int index) {
               return switch (index) {
                   case 0 -> MatterStabilizerBlockEntity.this.progress;
                   case 1 -> MatterStabilizerBlockEntity.this.maxProgress;
                   default -> 0;
               };
           }

           @Override
           public void set(int index, int value) {
               switch (index) {
                   case 0: MatterStabilizerBlockEntity.this.progress = value;
                   case 1: MatterStabilizerBlockEntity.this.maxProgress = value;
               }
           }

           @Override
           public int size() {
               return 2;
           }
       };
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    private float rotation = 0;
    public float getRenderingRotation() {
        rotation += 0.7f;
        if(rotation >= 360) {
            rotation = 0;
        }
        return rotation;
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt, inventory, registryLookup);
        nbt.putInt("matter_stabilizer.progress", progress);
        nbt.putInt("matter_stabilizer.max_progress", maxProgress);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        Inventories.readNbt(nbt, inventory, registryLookup);
        progress = nbt.getInt("matter_stabilizer.progress");
        maxProgress = nbt.getInt("matter_stabilizer.max_progress");
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return createNbt(registryLookup);
    }

    @Override
    public BlockPos getScreenOpeningData(ServerPlayerEntity player) {
        return this.pos;
    }

    @Override
    public Text getDisplayName() {
        return Text.of("Matter Stabilizer");
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new MatterStabilizerScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }




    public void tick(World world, BlockPos pos, BlockState state) {


        if(hasRecipe()) {
            increaseCraftingProgress();
            markDirty(world, pos, state);
            world.updateListeners(pos, getCachedState(), getCachedState(), 3);

            if(hasCraftingFinished()) {
                craftItem();
                resetProgress();
                world.updateListeners(pos, getCachedState(), getCachedState(), 3);
            }
        } else {
            resetProgress();
        }
    }

    private void resetProgress() {
        this.progress = 0;
        this.maxProgress = 72;
    }

    private void craftItem() {
        Optional<RecipeEntry<MatterStabilizerRecipe>> recipe = getCurrentRecipe();

        ItemStack output = recipe.get().value().output();
        this.removeStack(INPUT_SLOT, 1);
        this.setStack(OUTPUT_SLOT, new ItemStack(output.getItem(),
                this.getStack(OUTPUT_SLOT).getCount() + output.getCount()));
    }

    public boolean hasCraftingFinished() {
        return this.progress >= this.maxProgress;
    }

    private void increaseCraftingProgress() {
        this.progress++;
    }

    private boolean hasRecipe() {
        Optional<RecipeEntry<MatterStabilizerRecipe>> recipe = getCurrentRecipe();
        if(recipe.isEmpty()) {
            return false;
        }
        ItemStack output = recipe.get().value().output();

        return canInsertAmountIntoOutputSlot(output.getCount()) && canInsertItemIntoOutputSlot(output);
    }

    private Optional<RecipeEntry<MatterStabilizerRecipe>> getCurrentRecipe() {
        return this.getWorld().getRecipeManager().
                getFirstMatch(ModRecipes.MATTER_STABILIZER_TYPE, new MatterStabilizerRecipeInput(inventory.get(INPUT_SLOT)), this.world);
    }

    private boolean canInsertItemIntoOutputSlot(ItemStack output) {
        return this.getStack(OUTPUT_SLOT).isEmpty() || this.getStack(OUTPUT_SLOT).getItem() == output.getItem();
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        int maxCount = this.getStack(OUTPUT_SLOT).isEmpty() ? 64 : this.getStack(OUTPUT_SLOT).getMaxCount();
        int currentCount = this.getStack(OUTPUT_SLOT).getCount();

        return maxCount >= currentCount + count;
    }
}

