package net.saril.sarilmod.block.entity.renderer;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ModelTransformationMode;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.saril.sarilmod.block.entity.custom.MatterStabilizerBlockEntity;

public class MatterStabilizerBlockEntityRenderer implements BlockEntityRenderer<MatterStabilizerBlockEntity> {
   public MatterStabilizerBlockEntityRenderer(BlockEntityRendererFactory.Context context) {}

    @Override
    public void render(MatterStabilizerBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();

        ItemStack input = entity.getStack(0);
        ItemStack output = entity.getStack(1);

        ItemStack stack;
        if (input.isEmpty() && !output.isEmpty()) {
            stack = output;
        } else if (!input.isEmpty()) {
            stack = input;
        } else {
            return;
        }

        matrices.push();
        matrices.translate(0.5f, 0.62f, 0.5f);
        matrices.scale(0.3f, 0.3f, 0.3f);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90));
        if (!input.isEmpty()) {
            matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(entity.getRenderingRotation()));
        }

        itemRenderer.renderItem(stack, ModelTransformationMode.GUI, getLightLevel(entity.getWorld(),
                entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
        matrices.pop();
    }

    private int getLightLevel(World world, BlockPos pos) {
        int bLight = world.getLightLevel(LightType.BLOCK, pos);
        int sLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(bLight, sLight);
    }
}