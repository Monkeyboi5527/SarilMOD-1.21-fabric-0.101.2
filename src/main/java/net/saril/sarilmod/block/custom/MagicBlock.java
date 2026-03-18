package net.saril.sarilmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.saril.sarilmod.item.ModItems;
import net.saril.sarilmod.particle.ModParticles;
import net.saril.sarilmod.util.ModTags;

import java.util.List;

public class MagicBlock extends Block {
    public MagicBlock(Settings settings) {
        super(settings);
    }


    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {

        for (int i = 0; i < 1000; i++) {
            world.addParticle(ModParticles.SOLAR_MATTER_PARTICLE, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5,
                    1+i, 1+i, 1+i);
        }

        world.createExplosion(player,pos.getX(), pos.getY()-1, pos.getZ(), 12f, World.ExplosionSourceType.TNT);
        return ActionResult.SUCCESS;
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if(entity instanceof ItemEntity itemEntity) {
            if(isValidItem(itemEntity.getStack())) {
                itemEntity.setStack(new ItemStack(Items.DIAMOND, itemEntity.getStack().getCount()));
                for (int i = 0; i < 1000; i++) {
                    world.addParticle(ModParticles.SOLAR_MATTER_PARTICLE, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5,
                            1, 1, 1);
                }

            }
        }

        super.onSteppedOn(world, pos, state, entity);
    }

    private boolean isValidItem(ItemStack stack) {
        return stack.isIn(ModTags.Items.TRANSFORMABLE_ITEMS);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        tooltip.add(Text.translatable("tooltip.sarilmod.magicblock.tooltip"));
        super.appendTooltip(stack, context, tooltip, options);
    }
}
