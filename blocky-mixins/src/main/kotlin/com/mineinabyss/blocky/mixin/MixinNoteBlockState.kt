package com.mineinabyss.blocky.mixin

import net.minecraft.world.level.block.NoteBlock
import org.spongepowered.asm.mixin.Mixin
import org.spongepowered.asm.mixin.injection.At
import org.spongepowered.asm.mixin.injection.Inject
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo


@Mixin(value = [NoteBlock::class], remap = false)
abstract class MixinNoteBlockState {
    @Inject(method = ["updateShape"], at = [At("HEAD")], cancellable = true)
    fun onUpdate(ci: CallbackInfo) {
        println("notblocks baby")
        ci.cancel()
    }
}
