package net.saril.sarilmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.TooltipDisplayComponent;
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
import net.saril.sarilmod.block.ModBlocks;
import net.saril.sarilmod.entity.ModEntities;
import net.saril.sarilmod.item.custom.ChiselItem;
import net.saril.sarilmod.item.custom.HammerItem;
import net.saril.sarilmod.item.custom.ModArmorItem;
import net.saril.sarilmod.item.custom.TomahawkItem;
import net.saril.sarilmod.sound.ModSounds;

import java.util.function.Consumer;
import java.util.function.Function;

public class ModItems {

    public static final Item SOLAR_MATTER = registerItem("solar_matter", Item::new);
    public static final Item UNSTABLE_SOLAR_MATTER = registerItem("unstable_solar_matter", Item::new);

    public static final Item CHISEL = registerItem("chisel", setting -> new ChiselItem(setting.maxDamage(32)));

    public static final Item BANANA = registerItem("banana", setting -> new BlockItem(ModBlocks.BANANA_BUSH_BLOCK,
            setting.food(ModFoodComponents.BANANA, ModFoodComponents.BANANA_EFFECT)){
        @Override
        public void appendTooltip(ItemStack stack, Item.TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
            textConsumer.accept(Text.translatable("tooltip.sarilmod.banana"));
            super.appendTooltip(stack, context, displayComponent, textConsumer, type);
        }
    });

    public static final Item DARK_CRYSTAL = registerItem("dark_crystal", Item::new);

    public static final Item SOLAR_MATTER_SWORD = registerItem("solar_matter_sword",
            setting -> new Item(setting.sword(ModToolMaterials.SOLAR_MATTER, 10, -3.0f)
                    .rarity(Rarity.EPIC).fireproof()));

    public static final Item SOLAR_MATTER_PICKAXE = registerItem("solar_matter_pickaxe",
            setting -> new Item(setting.pickaxe(ModToolMaterials.SOLAR_MATTER, 1, -2.8f).rarity(Rarity.EPIC)));

    public static final Item SOLAR_MATTER_SHOVEL = registerItem("solar_matter_shovel",
            setting -> new ShovelItem(ModToolMaterials.SOLAR_MATTER, 1.5f, -3.0f, setting.rarity(Rarity.EPIC)));

    public static final Item SOLAR_MATTER_AXE = registerItem("solar_matter_axe",
            setting -> new AxeItem(ModToolMaterials.SOLAR_MATTER, 12, -2.8f, setting.rarity(Rarity.EPIC)));

    public static final Item SOLAR_MATTER_HOE = registerItem("solar_matter_hoe",
            setting -> new HoeItem(ModToolMaterials.SOLAR_MATTER, 0, -3.0f, setting.rarity(Rarity.EPIC)));

    public static final Item SOLAR_MATTER_HAMMER = registerItem("solar_matter_hammer",
            setting -> new HammerItem(ModToolMaterials.SOLAR_MATTER, 36, -3.0f, setting.rarity(Rarity.EPIC)));

    public static final Item SOLAR_MATTER_HELMET = registerItem("solar_matter_helmet",
            setting -> new ModArmorItem(setting.armor(ModArmorMaterials.SOLAR_MATTER_ARMOR_MATERIAL, EquipmentType.HELMET)
                    .maxDamage(EquipmentType.HELMET.getMaxDamage(15))
                    .rarity(Rarity.EPIC)
                    .fireproof()));

    public static final Item SOLAR_MATTER_CHESTPLATE = registerItem("solar_matter_chestplate",
            setting -> new ModArmorItem(setting.armor(ModArmorMaterials.SOLAR_MATTER_ARMOR_MATERIAL, EquipmentType.CHESTPLATE)
                    .maxDamage(EquipmentType.CHESTPLATE.getMaxDamage(15))
                    .rarity(Rarity.EPIC)
                    .fireproof()));

    public static final Item SOLAR_MATTER_LEGGINGS = registerItem("solar_matter_leggings",
            setting -> new ModArmorItem(setting.armor(ModArmorMaterials.SOLAR_MATTER_ARMOR_MATERIAL, EquipmentType.LEGGINGS)
                    .maxDamage(EquipmentType.LEGGINGS.getMaxDamage(15))
                    .rarity(Rarity.EPIC)
                    .fireproof()));

    public static final Item SOLAR_MATTER_BOOTS = registerItem("solar_matter_boots",
            setting -> new ModArmorItem(setting.armor(ModArmorMaterials.SOLAR_MATTER_ARMOR_MATERIAL, EquipmentType.BOOTS)
                    .maxDamage(EquipmentType.BOOTS.getMaxDamage(15))
                    .rarity(Rarity.EPIC)
                    .fireproof()));

    public static final Item SOLAR_MATTER_BOW = registerItem("solar_matter_bow",
            setting -> new BowItem(setting.maxDamage(500)));

    public static final Item SOLAR_MATTER_HORSE_ARMOR = registerItem("solar_matter_horse_armor",
            setting -> new Item(setting.horseArmor(ModArmorMaterials.SOLAR_MATTER_ARMOR_MATERIAL).maxCount(1)));

    public static final Item SKL_SMITHING_TEMPLATE = registerItem("skl_armor_smithing_template",
            SmithingTemplateItem::of);

    public static final Item FEIN_MUSIC_DISC = registerItem("fein_music_disc",
            setting -> new Item(setting.maxCount(1).rarity(Rarity.EPIC).jukeboxPlayable(ModSounds.FEIN_KEY)));

    public static final Item CAULIFLOWER_SEEDS = registerItem("cauliflower_seeds",
            setting -> new BlockItem(ModBlocks.CAULIFLOWER_CROP, setting));

    public static final Item MANTIS_SPAWN_EGG = registerItem("mantis_spawn_egg",
            setting -> new SpawnEggItem(setting.spawnEgg(ModEntities.MANTIS)));

    public static final Item TOMAHAWK = registerItem("tomahawk",
            setting -> new TomahawkItem(setting.maxCount(16).rarity(Rarity.EPIC)));

    public static final Item SPECTRE_STAFF = registerItem("spectre_staff",
            setting -> new Item(setting.maxCount(1).rarity(Rarity.EPIC).fireproof()));

    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(SarilMod.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SarilMod.MOD_ID, name)))));
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
