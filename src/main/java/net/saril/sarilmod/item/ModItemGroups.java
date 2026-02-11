package net.saril.sarilmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.saril.sarilmod.SarilMod;
import net.saril.sarilmod.block.ModBlocks;

public class ModItemGroups {


    public static final ItemGroup SARIL_MOD_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(SarilMod.MOD_ID, "sarilmod"),
            FabricItemGroup.builder().icon(() -> new ItemStack( ModItems.SOLAR_MATTER))
                    .displayName(Text.translatable("itemgroup.sarilmod.sarilmod"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.SOLAR_MATTER);
                        entries.add(ModItems.UNSTABLE_SOLAR_MATTER);
                        entries.add(ModBlocks.SOLAR_MATTER_BLOCK);
                        entries.add(ModBlocks.UNSTABLE_SOLAR_MATTER_BLOCK);
                        entries.add(ModBlocks.UNSTABLE_SOLAR_MATTER_ORE);
                        entries.add(ModBlocks.DEEPSLATE_UNSTABLE_SOLAR_MATTER_ORE);
                        entries.add(ModItems.CHISEL);
                        entries.add(ModBlocks.MAGIC_BLOCK);
                        entries.add(ModItems.BANANA);
                        entries.add(ModBlocks.SOLAR_MATTER_STAIRS);
                        entries.add(ModBlocks.SOLAR_MATTER_BUTTON);
                        entries.add(ModBlocks.SOLAR_MATTER_PRESSURE_PLATE);
                        entries.add(ModBlocks.SOLAR_MATTER_FENCE);
                        entries.add(ModBlocks.SOLAR_MATTER_FENCE_GATE);
                        entries.add(ModBlocks.SOLAR_MATTER_DOOR);
                        entries.add(ModBlocks.SOLAR_MATTER_TRAPDOOR);
                        entries.add(ModBlocks.SOLAR_MATTER_WALL);
                        entries.add(ModBlocks.SOLAR_MATTER_SLAB);
                        entries.add(ModBlocks.SOLAR_MATTER_LAMP);
                        entries.add(ModItems.SOLAR_MATTER_SWORD);
                        entries.add(ModItems.SOLAR_MATTER_PICKAXE);
                        entries.add(ModItems.SOLAR_MATTER_SHOVEL);
                        entries.add(ModItems.SOLAR_MATTER_AXE);
                        entries.add(ModItems.SOLAR_MATTER_HOE);
                        entries.add(ModItems.SOLAR_MATTER_HAMMER);
                        entries.add(ModItems.SOLAR_MATTER_HELMET);
                        entries.add(ModItems.SOLAR_MATTER_CHESTPLATE);
                        entries.add(ModItems.SOLAR_MATTER_LEGGINGS);
                        entries.add(ModItems.SOLAR_MATTER_BOOTS);
                        entries.add(ModItems.SOLAR_MATTER_HORSE_ARMOR);






                    }).build());

    public static void registerModItemGroups(){
        SarilMod.LOGGER.info("Registering Mod Items Groups for " + SarilMod.MOD_ID);
    }
}
