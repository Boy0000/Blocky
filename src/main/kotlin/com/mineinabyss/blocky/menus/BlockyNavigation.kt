package com.mineinabyss.blocky.menus

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.mineinabyss.blocky.helpers.ui.Navigator
import com.mineinabyss.blocky.helpers.ui.composables.Button
import com.mineinabyss.guiy.components.Item
import com.mineinabyss.guiy.components.canvases.Chest
import com.mineinabyss.guiy.inventory.GuiyOwner
import com.mineinabyss.guiy.modifiers.Modifier
import com.mineinabyss.guiy.modifiers.height
import com.mineinabyss.idofront.font.Space
import de.erethon.headlib.HeadLib
import org.bukkit.ChatColor
import org.bukkit.entity.Player

sealed class BlockyScreen(val title: String, val height: Int) {
    object Default : BlockyScreen("${Space.of(-18)}${ChatColor.WHITE}:something:", 5)
    object NoteBlock : BlockyScreen("${Space.of(-18)}${ChatColor.WHITE}:something:", 6)
    object Decoration : BlockyScreen("${Space.of(-18)}${ChatColor.WHITE}:something:", 6)
    object JavaEntity : BlockyScreen("${Space.of(-18)}${ChatColor.WHITE}:something:", 6)
    object AnimatedEntity : BlockyScreen("${Space.of(-18)}${ChatColor.WHITE}:something:", 6)

}

typealias BlockyNav = Navigator<BlockyScreen>

class BlockyUIScope(
    val player: Player,
) {
    val nav = BlockyNav { BlockyScreen.Default }
}

@Composable
fun GuiyOwner.BlockyMainMenu(player: Player) {
    val scope = remember { BlockyUIScope(player) }
    scope.apply {
        nav.withScreen(setOf(player), onEmpty = ::exit) { screen ->
            Chest(setOf(player), screen.title,
                Modifier.height(screen.height),
                onClose = { nav.back() ?: exit() }) {
                when (screen) {
                    BlockyScreen.Default -> BlockyMenu()
                    BlockyScreen.NoteBlock -> BlockyNoteBlockMenu()
                    BlockyScreen.Decoration -> BlockyDecorationMenu()
                    BlockyScreen.JavaEntity -> BlockyJavaEntityMenu()
                    BlockyScreen.AnimatedEntity -> BlockyAnimatedEntityMenu()
                }
            }
        }
    }
}

@Composable
fun BlockyUIScope.BackButton(modifier: Modifier = Modifier) {
    Button(onClick = { nav.back() }, modifier = modifier) {
        Item(HeadLib.STONE_ARROW_LEFT.toItemStack("Back"))
    }
}
