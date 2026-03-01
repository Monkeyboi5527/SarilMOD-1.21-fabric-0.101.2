package net.saril.sarilmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.saril.sarilmod.component.ModDataComponentTypes;
import net.saril.sarilmod.effect.ModEffects;
import net.saril.sarilmod.enchantment.ModEnchantmentEffects;
import net.saril.sarilmod.item.ModItemGroups;
import net.saril.sarilmod.item.ModItems;
import net.saril.sarilmod.block.ModBlocks;
import net.saril.sarilmod.potion.ModPotions;
import net.saril.sarilmod.sound.ModSounds;
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

		AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
			if(entity instanceof SheepEntity sheepEntity && world.isClient) {
				if(player.getMainHandStack().getItem() == Items.END_ROD) {
					player.sendMessage(Text.literal("ayo? sussy baka"));
					player.getMainHandStack().decrement(1);
					sheepEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 20, 255));
				}

				return ActionResult.PASS;
			}

			return ActionResult.PASS;
		});

		ModSounds.registerSounds();
		ModEffects.registerEffects();
		ModPotions.registerPotions();
		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.AWKWARD, Items.SLIME_BALL, ModPotions.SLIMEY_POTION);
		});
		ModEnchantmentEffects.registerEnchantmentEffects();
		CompostingChanceRegistry.INSTANCE.add(ModItems.BANANA, 200f);
		CompostingChanceRegistry.INSTANCE.add(ModItems.CAULIFLOWER_SEEDS, 0.5f);
	}
}