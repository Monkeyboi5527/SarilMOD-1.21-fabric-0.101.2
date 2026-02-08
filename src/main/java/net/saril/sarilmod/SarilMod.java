package net.saril.sarilmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.saril.sarilmod.component.ModDataComponentTypes;
import net.saril.sarilmod.item.ModItemGroups;
import net.saril.sarilmod.item.ModItems;
import net.saril.sarilmod.block.ModBlocks;
import net.saril.sarilmod.util.HammerUsageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Very important comment
public class SarilMod implements ModInitializer {
	public static final String MOD_ID = "sarilmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerModItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModDataComponentTypes.registerDataComponentTypes();
		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());

		FuelRegistry.INSTANCE.add(ModItems.DARK_CRYSTAL, 20000);

	}
}