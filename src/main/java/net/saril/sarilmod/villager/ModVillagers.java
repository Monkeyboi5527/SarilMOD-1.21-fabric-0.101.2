package net.saril.sarilmod.villager;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;
import net.saril.sarilmod.SarilMod;
import net.saril.sarilmod.block.ModBlocks;

public class ModVillagers {
    public static final RegistryKey<PointOfInterestType> SKL_POI_KEY = registerPoiKey("skl_poi");
    public static final PointOfInterestType SKL_POI = registerPOI("skl_poi", ModBlocks.CHAIR);

    public static final VillagerProfession MONKEY = registerProfession("monkey", SKL_POI_KEY);


    private static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registries.VILLAGER_PROFESSION, Identifier.of(SarilMod.MOD_ID, name),
                new VillagerProfession(name, entry -> entry.matchesKey(type), entry -> entry.matchesKey(type),
                        ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_LIBRARIAN));
    }

    private static PointOfInterestType registerPOI(String name, Block block) {
        return PointOfInterestHelper.register(Identifier.of(SarilMod.MOD_ID, name),
                1, 1, block);
    }

    private static RegistryKey<PointOfInterestType> registerPoiKey(String name) {
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, Identifier.of(SarilMod.MOD_ID, name));
    }

    public static void registerVillagers() {
        SarilMod.LOGGER.info("Registering Villagers for " + SarilMod.MOD_ID);
    }
}