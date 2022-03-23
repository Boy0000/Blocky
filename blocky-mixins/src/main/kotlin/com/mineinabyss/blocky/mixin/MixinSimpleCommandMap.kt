package com.mineinabyss.blocky.mixin

import com.mineinabyss.blocky.plugin.HelloCommand
import org.bukkit.command.Command
import org.bukkit.command.SimpleCommandMap
import org.spongepowered.asm.mixin.Mixin
import org.spongepowered.asm.mixin.Shadow
import org.spongepowered.asm.mixin.injection.At
import org.spongepowered.asm.mixin.injection.Inject
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo


@Mixin(value = [SimpleCommandMap::class])
abstract class MixinSimpleCommandMap {
    @Shadow
    abstract fun register(fallbackPrefix: String?, command: Command?): Boolean
    @Inject(method = ["setDefaultCommands"], at = [At("TAIL")], remap = false)
    fun registerOwnCommands(ci: CallbackInfo?) {
        register("blocky-mixin", HelloCommand("hello"))
    }
}