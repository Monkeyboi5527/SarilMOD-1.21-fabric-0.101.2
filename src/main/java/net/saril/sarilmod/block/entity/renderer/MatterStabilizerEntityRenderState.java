package net.saril.sarilmod.block.entity.renderer;

import net.minecraft.client.render.block.entity.state.BlockEntityRenderState;
import net.minecraft.client.render.item.ItemRenderState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MatterStabilizerEntityRenderState extends BlockEntityRenderState {
    public BlockPos lightPosition;
    public World blockEntityWorld;
    public float rotation;

    final ItemRenderState itemRenderState = new ItemRenderState();
}
