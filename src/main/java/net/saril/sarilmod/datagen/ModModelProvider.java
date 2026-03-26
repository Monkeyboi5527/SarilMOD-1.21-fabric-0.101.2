package net.saril.sarilmod.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.*;
import net.minecraft.client.item.ItemAsset;
import net.minecraft.client.render.item.model.ConditionItemModel;
import net.minecraft.client.render.item.model.ItemModel;
import net.minecraft.client.render.item.property.bool.HasComponentProperty;
import net.minecraft.client.render.model.json.ModelVariant;
import net.minecraft.client.render.model.json.WeightedVariant;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.Pool;
import net.saril.sarilmod.block.ModBlocks;
import net.saril.sarilmod.block.custom.BananaBushBlock;
import net.saril.sarilmod.block.custom.CauliflowerCropBlock;
import net.saril.sarilmod.block.custom.SolarMatterLampBlock;
import net.saril.sarilmod.component.ModDataComponentTypes;
import net.saril.sarilmod.item.ModArmorMaterials;
import net.saril.sarilmod.item.ModItems;

import java.util.Optional;

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
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.UNSTABLE_SOLAR_MATTER_NETHER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.UNSTABLE_SOLAR_MATTER_END_ORE);
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
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockModelDefinitionCreator.of(ModBlocks.SOLAR_MATTER_LAMP)
                .with(BlockStateModelGenerator.createBooleanModelMap(SolarMatterLampBlock.CLICKED,
                        new WeightedVariant(Pool.<ModelVariant>builder().add(new ModelVariant(lampOnIdentifier)).build()),
                        new WeightedVariant(Pool.<ModelVariant>builder().add(new ModelVariant(lampOffIdentifier)).build()))));


        blockStateModelGenerator.registerCrop(ModBlocks.CAULIFLOWER_CROP, CauliflowerCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6);

        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.BANANA_BUSH_BLOCK, BlockStateModelGenerator.CrossType.NOT_TINTED,
                BananaBushBlock.AGE, 0, 1, 2, 3);


        blockStateModelGenerator.createLogTexturePool(ModBlocks.STELLAR_LOG).log(ModBlocks.STELLAR_LOG).wood(ModBlocks.STELLAR_WOOD);
        blockStateModelGenerator.createLogTexturePool(ModBlocks.STRIPPED_STELLAR_LOG).log(ModBlocks.STRIPPED_STELLAR_LOG).wood(ModBlocks.STRIPPED_STELLAR_WOOD);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STELLAR_PLANKS);
        blockStateModelGenerator.registerSingleton(ModBlocks.STELLAR_LEAVES, TexturedModel.LEAVES);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.STELLAR_SAPLING, BlockStateModelGenerator.CrossType.NOT_TINTED);

        blockStateModelGenerator.registerNorthDefaultHorizontalRotatable(ModBlocks.CHAIR);
    }


    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.SOLAR_MATTER, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNSTABLE_SOLAR_MATTER, Models.GENERATED);
        //itemModelGenerator.register(ModItems.CHISEL, Models.GENERATED);
//        itemModelGenerator.register(ModItems.BANANA, Models.GENERATED);
        itemModelGenerator.register(ModItems.DARK_CRYSTAL, Models.GENERATED);


        itemModelGenerator.register(ModItems.SOLAR_MATTER_SWORD, Models.HANDHELD_MACE);
        itemModelGenerator.register(ModItems.SOLAR_MATTER_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SOLAR_MATTER_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SOLAR_MATTER_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SOLAR_MATTER_HOE, Models.HANDHELD);
//        itemModelGenerator.register(ModItems.SOLAR_MATTER_HAMMER, Models.HANDHELD);

        itemModelGenerator.registerArmor(ModItems.SOLAR_MATTER_HELMET, ModArmorMaterials.SOLAR_MATTER_KEY, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.SOLAR_MATTER_CHESTPLATE, ModArmorMaterials.SOLAR_MATTER_KEY, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.SOLAR_MATTER_LEGGINGS, ModArmorMaterials.SOLAR_MATTER_KEY, ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.SOLAR_MATTER_BOOTS, ModArmorMaterials.SOLAR_MATTER_KEY, ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);

        itemModelGenerator.upload(ModItems.SOLAR_MATTER_BOW, Models.BOW);
        itemModelGenerator.registerBow(ModItems.SOLAR_MATTER_BOW);

        itemModelGenerator.register(ModItems.SOLAR_MATTER_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.SKL_SMITHING_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.FEIN_MUSIC_DISC, Models.GENERATED);

        itemModelGenerator.register(ModBlocks.STELLAR_SAPLING.asItem(),  Models.GENERATED);

        itemModelGenerator.register(ModItems.MANTIS_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));

        ItemModel.Unbaked unbakedChisel = ItemModels.basic(itemModelGenerator.upload(ModItems.CHISEL, Models.GENERATED));
        ItemModel.Unbaked unbakedUsedChisel = ItemModels.basic(itemModelGenerator.registerSubModel(ModItems.CHISEL, "_used", Models.GENERATED));
        itemModelGenerator.output.accept(ModItems.CHISEL,
                new ItemAsset(new ConditionItemModel.Unbaked(new HasComponentProperty(ModDataComponentTypes.COORDINATES, false),
                        unbakedUsedChisel, unbakedChisel),
                        new ItemAsset.Properties(false, false)).model());
    }
}
