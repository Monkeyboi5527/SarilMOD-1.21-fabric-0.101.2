package net.saril.sarilmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.BlockRenderLayer;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.saril.sarilmod.block.ModBlocks;
import net.saril.sarilmod.block.entity.ModBlockEntities;
import net.saril.sarilmod.block.entity.renderer.MatterStabilizerBlockEntityRenderer;
import net.saril.sarilmod.entity.ModEntities;
import net.saril.sarilmod.entity.client.*;
import net.saril.sarilmod.particle.ModParticles;
import net.saril.sarilmod.particle.SolarMatterParticle;
import net.saril.sarilmod.screen.ModScreenHandlers;
import net.saril.sarilmod.screen.custom.MatterStabilizerScreen;

public class SarilModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.putBlock(ModBlocks.SOLAR_MATTER_DOOR, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.SOLAR_MATTER_TRAPDOOR, BlockRenderLayer.CUTOUT);

        BlockRenderLayerMap.putBlock(ModBlocks.CAULIFLOWER_CROP, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.BANANA_BUSH_BLOCK, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.STELLAR_SAPLING, BlockRenderLayer.CUTOUT);

        EntityModelLayerRegistry.registerModelLayer(MantisModel.MANTIS, MantisModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.MANTIS, MantisRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(TomahawkProjectileModel.TOMAHAWK, TomahawkProjectileModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.TOMAHAWK, TomahawkProjectileRenderer::new);

        EntityRendererRegistry.register(ModEntities.CHAIR, ChairRenderer::new);

        ParticleFactoryRegistry.getInstance().register(ModParticles.SOLAR_MATTER_PARTICLE, SolarMatterParticle.Factory::new);

        BlockEntityRendererFactories.register(ModBlockEntities.MATTER_STABILIZER_BE, MatterStabilizerBlockEntityRenderer::new);
        HandledScreens.register(ModScreenHandlers.MATTER_STABILIZER_SCREEN_HANDLER, MatterStabilizerScreen::new);
        BlockRenderLayerMap.putBlock(ModBlocks.MATTER_STABILIZER, BlockRenderLayer.CUTOUT);
    }
}
