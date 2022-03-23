package com.mineinabyss.blocky.mixin

import org.spongepowered.asm.mixin.Mixin
import org.spongepowered.asm.mixin.Shadow
import org.spongepowered.asm.mixin.injection.At
import org.spongepowered.asm.mixin.injection.Inject
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo
import java.util.logging.Logger


@Mixin(targets = ["CraftServer"], remap = false)
abstract class MixinServer {
    @get:Shadow
    abstract val logger: Logger

    @Inject(method = ["<init>"], at = [At("RETURN")])
    private fun onConstruction(callback: CallbackInfo) {
        logger.info("Blocky-Mixin loaded!")
        println("test dfsdfdsfsdfdsfsdfdsfsd")
    }
}