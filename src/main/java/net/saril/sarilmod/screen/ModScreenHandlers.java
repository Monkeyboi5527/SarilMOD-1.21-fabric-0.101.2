package net.saril.sarilmod.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.saril.sarilmod.SarilMod;
import net.saril.sarilmod.screen.custom.MatterStabilizerScreenHandler;

public class ModScreenHandlers {
    public static final ScreenHandlerType<MatterStabilizerScreenHandler> MATTER_STABILIZER_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(SarilMod.MOD_ID, "matter_stabilizer_screen_handler"),
                    new ExtendedScreenHandlerType<>(MatterStabilizerScreenHandler::new, BlockPos.PACKET_CODEC));

    public static void registerScreenHandlers() {
        SarilMod.LOGGER.info("Registering ModScreenHandlers");
    }
}
