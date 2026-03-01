package net.saril.sarilmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;
import net.saril.sarilmod.block.ModBlocks;
import net.saril.sarilmod.block.custom.CauliflowerCropBlock;
import net.saril.sarilmod.block.custom.SolarMatterLampBlock;
import net.saril.sarilmod.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool solarMatterPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SOLAR_MATTER_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.UNSTABLE_SOLAR_MATTER_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.UNSTABLE_SOLAR_MATTER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_UNSTABLE_SOLAR_MATTER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGIC_BLOCK);

        solarMatterPool.stairs(ModBlocks.SOLAR_MATTER_STAIRS);
        solarMatterPool.slab(ModBlocks.SOLAR_MATTER_SLAB);

        solarMatterPool.button(ModBlocks.SOLAR_MATTER_BUTTON);
        solarMatterPool.pressurePlate(ModBlocks.SOLAR_MATTER_PRESSURE_PLATE);

        solarMatterPool.fence(ModBlocks.SOLAR_MATTER_FENCE);
        solarMatterPool.fenceGate(ModBlocks.SOLAR_MATTER_FENCE_GATE);
        solarMatterPool.wall(ModBlocks.SOLAR_MATTER_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.SOLAR_MATTER_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.SOLAR_MATTER_TRAPDOOR);

        Identifier lampOffIdentifier = TexturedModel.CUBE_ALL.upload(ModBlocks.SOLAR_MATTER_LAMP, blockStateModelGenerator.modelCollector);
        Identifier lampOnIdentifier = blockStateModelGenerator.createSubModel(ModBlocks.SOLAR_MATTER_LAMP, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.SOLAR_MATTER_LAMP)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(SolarMatterLampBlock.CLICKED, lampOnIdentifier, lampOffIdentifier)));

        blockStateModelGenerator.registerCrop(ModBlocks.CAULIFLOWER_CROP, CauliflowerCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6);

        

    }


    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.SOLAR_MATTER, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNSTABLE_SOLAR_MATTER, Models.GENERATED);
        //itemModelGenerator.register(ModItems.CHISEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.BANANA, Models.GENERATED);
        itemModelGenerator.register(ModItems.DARK_CRYSTAL, Models.GENERATED);


        itemModelGenerator.register(ModItems.SOLAR_MATTER_SWORD, Models.HANDHELD_MACE);
        itemModelGenerator.register(ModItems.SOLAR_MATTER_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SOLAR_MATTER_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SOLAR_MATTER_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SOLAR_MATTER_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SOLAR_MATTER_HAMMER, Models.HANDHELD);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.SOLAR_MATTER_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.SOLAR_MATTER_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.SOLAR_MATTER_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.SOLAR_MATTER_BOOTS);

        itemModelGenerator.register(ModItems.SOLAR_MATTER_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.SKL_SMITHING_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.FEIN_MUSIC_DISC, Models.GENERATED);

        //itemModelGenerator.register(ModItems.SOLAR_MATTER_HAMMER,new Model(Optional.of(id("item/solar_matter_hammer")), Optional.empty()));


    }
}
