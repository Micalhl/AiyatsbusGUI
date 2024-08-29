package me.mical.aiyatsbus

import me.mical.aiyatsbus.ui.MainMenu
import org.bukkit.entity.Player
import taboolib.common.platform.Plugin
import taboolib.common.platform.command.CommandBody
import taboolib.common.platform.command.CommandHeader
import taboolib.common.platform.command.mainCommand
import taboolib.common.platform.function.info

/**
 * ExamplePlugin
 * me.mical.aiyatsbus.AiyatsbusGUI
 *
 * @author mical
 * @date 2024/8/29 15:09
 */
@CommandHeader(name = "agui")
object AiyatsbusGUI : Plugin() {

    override fun onEnable() {
        info("Successfully running ExamplePlugin!")
    }

    @CommandBody
    val main = mainCommand {
        execute<Player> { sender, _, _ -> MainMenu.openMenu(sender) }
    }
}