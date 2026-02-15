package net.saril.sarilmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlag;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.saril.sarilmod.SarilMod;
import net.saril.sarilmod.item.custom.ChiselItem;
import net.saril.sarilmod.item.custom.HammerItem;
import net.saril.sarilmod.item.custom.ModArmorItem;

import java.util.List;

public class ModItems {

    public static final Item SOLAR_MATTER = registerItem("solar_matter", new Item(new Item.Settings()));
    public static final Item UNSTABLE_SOLAR_MATTER = registerItem("unstable_solar_matter", new Item(new Item.Settings()));

    public static final Item CHISEL = registerItem("chisel", new ChiselItem(new Item.Settings().maxDamage(32)));

    public static final Item BANANA = registerItem("banana", new Item(new Item.Settings().food(ModFoodComponents.BANANA)){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.sarilmod.banana"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item DARK_CRYSTAL = registerItem("dark_crystal", new Item(new Item.Settings()));

    public static final Item SOLAR_MATTER_SWORD = registerItem("solar_matter_sword", new SwordItem(ModToolMaterials.SOLAR_MATTER,
            (new Item.Settings())
                    .rarity(Rarity.EPIC)
                    .fireproof()
                    .attributeModifiers(
                            SwordItem.createAttributeModifiers(
                                    ModToolMaterials.SOLAR_MATTER, 10, -3.0F))));

    public static final Item SOLAR_MATTER_PICKAXE = registerItem("solar_matter_pickaxe",
            new PickaxeItem(ModToolMaterials.SOLAR_MATTER, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.SOLAR_MATTER, 1, -2.8f)).rarity(Rarity.EPIC)));

    public static final Item SOLAR_MATTER_SHOVEL = registerItem("solar_matter_shovel",
            new ShovelItem(ModToolMaterials.SOLAR_MATTER, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.SOLAR_MATTER, 1.5f, -3.0f)).rarity(Rarity.EPIC)));

    public static final Item SOLAR_MATTER_AXE = registerItem("solar_matter_axe",
            new AxeItem(ModToolMaterials.SOLAR_MATTER, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.SOLAR_MATTER, 12, -2.8f)).rarity(Rarity.EPIC)));

    public static final Item SOLAR_MATTER_HOE = registerItem("solar_matter_hoe",
            new HoeItem(ModToolMaterials.SOLAR_MATTER, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.SOLAR_MATTER, 0, -3f)).rarity(Rarity.EPIC)));

    public static final Item SOLAR_MATTER_HAMMER = registerItem("solar_matter_hammer",
            new HammerItem(ModToolMaterials.SOLAR_MATTER, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.SOLAR_MATTER, 7, -3.0f)).rarity(Rarity.EPIC)));

    public static final Item SOLAR_MATTER_HELMET = registerItem("solar_matter_helmet",
            new ArmorItem(ModArmorMaterials.SOLAR_MATTER_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))
                    .rarity(Rarity.EPIC)
                    .fireproof()));

    public static final Item SOLAR_MATTER_CHESTPLATE = registerItem("solar_matter_chestplate",
            new ModArmorItem(ModArmorMaterials.SOLAR_MATTER_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))
                    .rarity(Rarity.EPIC)
                    .fireproof()));

    public static final Item SOLAR_MATTER_LEGGINGS = registerItem("solar_matter_leggings",
            new ArmorItem(ModArmorMaterials.SOLAR_MATTER_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))
                    .rarity(Rarity.EPIC)
                    .fireproof()));

    public static final Item SOLAR_MATTER_BOOTS = registerItem("solar_matter_boots",
            new ArmorItem(ModArmorMaterials.SOLAR_MATTER_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))
                    .rarity(Rarity.EPIC)
                    .fireproof()));
    public static final Item SOLAR_MATTER_HORSE_ARMOR = registerItem("solar_matter_horse_armor",
            new AnimalArmorItem(ModArmorMaterials.SOLAR_MATTER_ARMOR_MATERIAL, AnimalArmorItem.Type.EQUESTRIAN,
                    false, new Item.Settings().maxCount(1)));

    public static final Item SKL_SMITHING_TEMPLATE = registerItem("skl_armor_smithing_template",
            SmithingTemplateItem.of(Identifier.of(SarilMod.MOD_ID, "skl"), FeatureFlags.VANILLA));



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
