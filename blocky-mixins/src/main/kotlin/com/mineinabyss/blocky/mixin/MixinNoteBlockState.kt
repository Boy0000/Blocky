package com.mineinabyss.blocky.mixin

import net.minecraft.world.level.block.NoteBlock
import org.bukkit.block.Block
import org.spongepowered.asm.mixin.Mixin
import org.spongepowered.asm.mixin.injection.At
import org.spongepowered.asm.mixin.injection.Inject
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo


@Mixin(NoteBlock::class)
abstract class MixinNoteBlockState : Block {
//    @Inject(method = ["updateShape"], at = [At("HEAD")])
//    fun onUpdate(block: Block, ci: CallbackInfo) {
//        if (block.type == Material.NOTE_BLOCK) {
//            println("cockcockxocxcxzczxczxczxczxczxczxczxczxczxczxczxcxzc")
//            block.state.update(true, false)
//            ci.cancel()
//        }
//    }
    @Inject(method = ["use"], at = [At("HEAD")])
    fun onPlayNote(ci: CallbackInfo) {
        println("etetetet")
        ci.cancel()
    }
}
