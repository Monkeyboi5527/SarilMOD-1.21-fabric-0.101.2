package net.saril.sarilmod.block.entity.renderer;

import net.minecraft.client.item.ItemModelManager;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.command.ModelCommandRenderer;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemDisplayContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.saril.sarilmod.block.entity.custom.MatterStabilizerBlockEntity;
import org.jetbrains.annotations.Nullable;

public class MatterStabilizerBlockEntityRenderer implements BlockEntityRenderer<MatterStabilizerBlockEntity, MatterStabilizerEntityRenderState> {
    private final ItemModelManager itemModelManager;

    public MatterStabilizerBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
        itemModelManager = context.itemModelManager();
    }


    @Override
    public MatterStabilizerEntityRenderState createRenderState() {
        return new MatterStabilizerEntityRenderState();

    }

    @Override
    public void updateRenderState(MatterStabilizerBlockEntity blockEntity, MatterStabilizerEntityRenderState state, float tickProgress, Vec3d cameraPos, @Nullable ModelCommandRenderer.CrumblingOverlayCommand crumblingOverlay) {
        BlockEntityRenderer.super.updateRenderState(blockEntity, state, tickProgress, cameraPos, crumblingOverlay);

        state.lightPosition = blockEntity.getPos();
        state.blockEntityWorld = blockEntity.getWorld();
        state.rotation = blockEntity.getRenderingRotation();

        itemModelManager.clearAndUpdate(state.itemRenderState,
                blockEntity.getStack(0), ItemDisplayContext.FIXED, blockEntity.getWorld(), null, 0);
    }

    @Override
    public void render(MatterStabilizerEntityRenderState state, MatrixStack matrices, OrderedRenderCommandQueue queue, CameraRenderState cameraState) {

        matrices.push();

        matrices.translate(0.5f, 0.62f, 0.5f);
        matrices.scale(0.3f, 0.3f, 0.3f);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(state.rotation));
        state.itemRenderState.render(matrices, queue, getLightLevel(state.blockEntityWorld, state.pos), OverlayTexture.DEFAULT_UV, 0);


        matrices.pop();
    }

    private int getLightLevel(World world, BlockPos pos) {
        int bLight = world.getLightLevel(LightType.BLOCK, pos);
        int sLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(bLight, sLight);
    }


}