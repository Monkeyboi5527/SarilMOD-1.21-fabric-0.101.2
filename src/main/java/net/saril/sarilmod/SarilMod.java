package net.saril.sarilmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;
import net.saril.sarilmod.block.entity.ModBlockEntities;
import net.saril.sarilmod.component.ModDataComponentTypes;
import net.saril.sarilmod.effect.ModEffects;
import net.saril.sarilmod.enchantment.ModEnchantmentEffects;
import net.saril.sarilmod.entity.ModEntities;
import net.saril.sarilmod.entity.custom.MantisEntity;
import net.saril.sarilmod.item.ModItemGroups;
import net.saril.sarilmod.item.ModItems;
import net.saril.sarilmod.block.ModBlocks;
import net.saril.sarilmod.particle.ModParticles;
import net.saril.sarilmod.potion.ModPotions;
import net.saril.sarilmod.recipe.ModRecipes;
import net.saril.sarilmod.screen.ModScreenHandlers;
import net.saril.sarilmod.sound.ModSounds;
import net.saril.sarilmod.util.HammerUsageEvent;
import net.saril.sarilmod.util.ModLootTableModifiers;
import net.saril.sarilmod.villager.ModVillagers;
import net.saril.sarilmod.world.gen.ModWorldGeneration;
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

		FuelRegistryEvents.BUILD.register((builder, context) -> {
			builder.add(ModItems.DARK_CRYSTAL, 20);
		});

		AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
			if(entity instanceof SheepEntity sheepEntity && world.isClient) {
				if(player.getMainHandStack().getItem() == Items.END_ROD) {
					player.sendMessage(Text.literal("ayo? sussy baka"), true);
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
		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> builder.registerPotionRecipe(Potions.AWKWARD, Items.SLIME_BALL, ModPotions.SLIMEY_POTION));
		ModEnchantmentEffects.registerEnchantmentEffects();
		CompostingChanceRegistry.INSTANCE.add(ModItems.BANANA, 200f);
		CompostingChanceRegistry.INSTANCE.add(ModItems.CAULIFLOWER_SEEDS, 0.5f);

		ModWorldGeneration.generateModWorldGen();

		StrippableBlockRegistry.register(ModBlocks.STELLAR_LOG, ModBlocks.STRIPPED_STELLAR_LOG);
		StrippableBlockRegistry.register(ModBlocks.STELLAR_WOOD, ModBlocks.STRIPPED_STELLAR_WOOD);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STELLAR_LEAVES, 20, 40);

		ModEntities.registerModEntities();

		FabricDefaultAttributeRegistry.register(ModEntities.MANTIS, MantisEntity.createAttributes());
		ModVillagers.registerVillagers();

		TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1, factories ->
				factories.add(((entity, random) -> new TradeOffer(
						new TradedItem(Items.EMERALD, 3),
						new ItemStack(ModItems.BANANA, 1), 7, 2, 0.6f)
				)));

		TradeOfferHelper.registerVillagerOffers(ModVillagers.MONKEY_KEY, 1, factories -> {
				factories.add(((entity, random) -> new TradeOffer(
						new TradedItem(Items.EMERALD, 3),
						new ItemStack(ModItems.BANANA, 4), 7, 2, 0.6f)));



			});

		TradeOfferHelper.registerVillagerOffers(ModVillagers.MONKEY_KEY, 2, factories -> {
			factories.add(((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 15),
					new ItemStack(ModItems.CHISEL, 1), 3, 5, 0.12f)));

			factories.add(((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.UNSTABLE_SOLAR_MATTER, 20),
					new ItemStack(ModItems.SOLAR_MATTER_HAMMER, 1), 3, 10, 0.18f)));


		});

		TradeOfferHelper.registerWanderingTraderOffers( factories ->
				factories.addAll(Identifier.of(SarilMod.MOD_ID, "emerald_for_chisel"), (entity, random) -> new TradeOffer(
						new TradedItem(Items.EMERALD, 128),
						new ItemStack(ModItems.TOMAHAWK, 1), 4, 2000, 20)));

		ModParticles.registerParticles();
		ModLootTableModifiers.modifyLootTables();
		ModBlockEntities.registerBlockEntities();
		ModScreenHandlers.registerScreenHandlers();
		ModRecipes.registerRecipes();
	}
}