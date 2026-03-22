package net.saril.sarilmod.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.saril.sarilmod.block.entity.ModBlockEntities;
import net.saril.sarilmod.block.entity.custom.MatterStabilizerBlockEntity;
import org.jetbrains.annotations.Nullable;

public class MatterStabilizerBlock extends BlockWithEntity implements BlockEntityProvider {
    private static final VoxelShape SHAPE =
            Block.createCuboidShape(0,0,0, 16,14,16);
    public static final MapCodec<MatterStabilizerBlock> CODEC = MatterStabilizerBlock.createCodec(MatterStabilizerBlock::new);

    public MatterStabilizerBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new MatterStabilizerBlockEntity(pos, state);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    protected void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if(state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if(blockEntity instanceof MatterStabilizerBlockEntity) {
                ItemScatterer.spawn(world, pos, ((MatterStabilizerBlockEntity) blockEntity));
                world.updateComparators(pos, this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }


    @Override
    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos,
                                         PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(world.getBlockEntity(pos) instanceof MatterStabilizerBlockEntity matterStabilizerBlockEntity) {
            if(matterStabilizerBlockEntity.isEmpty() && !stack.isEmpty()) {
                matterStabilizerBlockEntity.setStack(0, stack.copyWithCount(stack.getCount()));
                world.playSound(player, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.BLOCKS, 1f, 2f);
                stack.decrement(stack.getCount());

                matterStabilizerBlockEntity.markDirty();
                world.updateListeners(pos, state, state, 0);
            } else if(stack.isEmpty() && !player.isSneaking()) {
                player.openHandledScreen(matterStabilizerBlockEntity);

            } else if(player.isSneaking() && !world.isClient()) {
                ItemStack stackOnMatterStabilizer = matterStabilizerBlockEntity.getStack(0);
                player.setStackInHand(Hand.MAIN_HAND, stackOnMatterStabilizer);
                world.playSound(player, pos, SoundEvents.ENCHANT_THORNS_HIT, SoundCategory.BLOCKS, 1f, 1f);
                matterStabilizerBlockEntity.clear();
                matterStabilizerBlockEntity.markDirty();
                world.updateListeners(pos, state, state, 0);

            }
        }

        return ActionResult.SUCCESS;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        if(world.isClient()) {
            return null;
        }

        return validateTicker(type, ModBlockEntities.MATTER_STABILIZER_BE,
                (world1, pos, state1, blockEntity) -> blockEntity.tick(world1, pos, state1));
    }
}
