package net.saril.sarilmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.saril.sarilmod.SarilMod;
import net.saril.sarilmod.item.custom.ChiselItem;
import net.saril.sarilmod.item.custom.HammerItem;
import net.saril.sarilmod.item.custom.ModArmorItem;
import net.saril.sarilmod.sound.ModSounds;

import java.util.List;

public class ModItems {

    public static final Item SOLAR_MATTER = registerItem("solar_matter", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SarilMod.MOD_ID, "solar_matter")))));
    public static final Item UNSTABLE_SOLAR_MATTER = registerItem("unstable_solar_matter", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SarilMod.MOD_ID, "unstable_solar_matter")))));

    public static final Item CHISEL = registerItem("chisel", new ChiselItem(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SarilMod.MOD_ID, "chisel"))).maxDamage(32)));

    public static final Item BANANA = registerItem("banana", new Item(new Item.Settings()
            .food(ModFoodComponents.BANANA, ModFoodComponents.BANANA_EFFECT)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SarilMod.MOD_ID, "banana")))){

        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.sarilmod.banana"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item DARK_CRYSTAL = registerItem("dark_crystal", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SarilMod.MOD_ID, "solar_matter")))));

    public static final Item SOLAR_MATTER_SWORD = registerItem("solar_matter_sword", new SwordItem(ModToolMaterials.SOLAR_MATTER,
             10, -3.0F,new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SarilMod.MOD_ID, "solar_matter")))
                    .rarity(Rarity.EPIC)));

    public static final Item SOLAR_MATTER_PICKAXE = registerItem("solar_matter_pickaxe",
            new PickaxeItem(ModToolMaterials.SOLAR_MATTER,  1, -2.8f, new Item.Settings()
                    .rarity(Rarity.EPIC)
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM,
                            Identifier.of(SarilMod.MOD_ID, "solar_matter_pickaxe")))));

    public static final Item SOLAR_MATTER_SHOVEL = registerItem("solar_matter_shovel",
            new ShovelItem(ModToolMaterials.SOLAR_MATTER,  1.5f, -3.0f, new Item.Settings()
                    .rarity(Rarity.EPIC)
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM,
                            Identifier.of(SarilMod.MOD_ID, "solar_matter_shovel")))));

    public static final Item SOLAR_MATTER_AXE = registerItem("solar_matter_axe",
            new AxeItem(ModToolMaterials.SOLAR_MATTER, 12, -2.8f,new Item.Settings()
                    .rarity(Rarity.EPIC)
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM,
                            Identifier.of(SarilMod.MOD_ID, "solar_matter_axe")))));

    public static final Item SOLAR_MATTER_HOE = registerItem("solar_matter_hoe",
            new HoeItem(ModToolMaterials.SOLAR_MATTER, 0, -3f, new Item.Settings()
                    .rarity(Rarity.EPIC)
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM,
                            Identifier.of(SarilMod.MOD_ID, "solar_matter_hoe")))));

    public static final Item SOLAR_MATTER_HAMMER = registerItem("solar_matter_hammer",
            new HammerItem(ModToolMaterials.SOLAR_MATTER,  7, -3.0f, new Item.Settings()
                    .rarity(Rarity.EPIC)
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM,
                            Identifier.of(SarilMod.MOD_ID, "solar_matter_hammer")))));

    public static final Item SOLAR_MATTER_BOW = registerItem("solar_matter_bow",
            new BowItem(new Item.Settings()
                    .maxDamage(1000)
                    .rarity(Rarity.EPIC)
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM,
                            Identifier.of(SarilMod.MOD_ID, "solar_matter_bow")))));

    public static final Item SOLAR_MATTER_HELMET = registerItem("solar_matter_helmet",
            new ArmorItem(ModArmorMaterials.SOLAR_MATTER_ARMOR_MATERIAL, EquipmentType.HELMET, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM,
                            Identifier.of(SarilMod.MOD_ID, "solar_matter_helmet")))
                    .rarity(Rarity.EPIC)
                    .fireproof()));

    public static final Item SOLAR_MATTER_CHESTPLATE = registerItem("solar_matter_chestplate",
            new ModArmorItem(ModArmorMaterials.SOLAR_MATTER_ARMOR_MATERIAL, EquipmentType.CHESTPLATE, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM,
                            Identifier.of(SarilMod.MOD_ID, "solar_matter_chestplate")))
                    .rarity(Rarity.EPIC)
                    .fireproof()));

    public static final Item SOLAR_MATTER_LEGGINGS = registerItem("solar_matter_leggings",
            new ArmorItem(ModArmorMaterials.SOLAR_MATTER_ARMOR_MATERIAL, EquipmentType.LEGGINGS, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM,
                            Identifier.of(SarilMod.MOD_ID, "solar_matter_leggings")))
                    .rarity(Rarity.EPIC)
                    .fireproof()));

    public static final Item SOLAR_MATTER_BOOTS = registerItem("solar_matter_boots",
            new ArmorItem(ModArmorMaterials.SOLAR_MATTER_ARMOR_MATERIAL, EquipmentType.BOOTS, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM,
                            Identifier.of(SarilMod.MOD_ID, "solar_matter_boots")))
                    .rarity(Rarity.EPIC)
                    .fireproof()));

    public static final Item SOLAR_MATTER_HORSE_ARMOR = registerItem("pink_garnet_horse_armor",
            new AnimalArmorItem(ModArmorMaterials.SOLAR_MATTER_ARMOR_MATERIAL, AnimalArmorItem.Type.EQUESTRIAN, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SarilMod.MOD_ID, "solar_matter_horse_armor"))).maxCount(1)));

    public static final Item SKL_SMITHING_TEMPLATE = registerItem("skl_armor_smithing_template",
            SmithingTemplateItem.of( new Item.Settings() .registryKey(RegistryKey.of(RegistryKeys.ITEM,
                    Identifier.of(SarilMod.MOD_ID, "solar_matter_boots")))));

    public static final Item FEIN_MUSIC_DISC = registerItem("fein_music_disc",
            new Item(new Item.Settings()
                    .maxCount(1)
                    .rarity(Rarity.EPIC)
                    .jukeboxPlayable(ModSounds.FEIN_KEY)
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM,
                            Identifier.of(SarilMod.MOD_ID, "solar_matter_boots")))));



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(SarilMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        SarilMod.LOGGER.info("Registering Mod Items for " + SarilMod.MOD_ID);


        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(SOLAR_MATTER);
            entries.add(UNSTABLE_SOLAR_MATTER);
            entries.add(CHISEL);
            entries.add(BANANA);
            entries.add(DARK_CRYSTAL);
            entries.add(SOLAR_MATTER_SWORD);
        });
    }
}
