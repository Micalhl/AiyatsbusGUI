package me.mical.aiyatsbus.ui

import me.mical.aiyatsbus.library.parrotx.MenuComponent
import me.mical.aiyatsbus.library.parrotx.config.MenuConfiguration
import me.mical.aiyatsbus.library.parrotx.feature.util.MenuFunctionBuilder
import me.mical.aiyatsbus.util.buildToLegacyText
import org.bukkit.entity.Player
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.module.configuration.Config
import taboolib.module.configuration.Configuration
import taboolib.module.ui.openMenu
import taboolib.module.ui.type.Chest

/**
 * AiyatsbusGUI
 * me.mical.aiyatsbus.ui.MainMenu
 *
 * @author mical
 * @date 2024/8/29 15:18
 */
@MenuComponent("main")
object MainMenu {

    @Config("core/ui/menu.yml", autoReload = true)
    lateinit var source: Configuration
        private set
    private lateinit var config: MenuConfiguration

    @Awake(LifeCycle.ENABLE)
    fun init() {
        config = MenuConfiguration(source)
        source.onReload {
            config = MenuConfiguration(source)
        }
    }

    fun openMenu(player: Player) {
        player.openMenu<Chest>(config.title().buildToLegacyText()) {
            val (shape, templates) = config
            rows(shape.rows)
            map(*shape.array)

            onBuild(async = true) { _, inventory ->
                shape.all { slot, index, item, _ ->
                    inventory.setItem(slot, item(slot, index))
                }
            }

            onClick { event ->
                event.isCancelled = true
                if (event.rawSlot in shape) {
                    templates[event.rawSlot]?.handle(this, event)
                }
            }
        }
    }

    @MenuComponent
    private val enchant_search = MenuFunctionBuilder {

    }

    @MenuComponent
    private val item_check = MenuFunctionBuilder {

    }

    @MenuComponent
    private val anvil_check = MenuFunctionBuilder {

    }

    @MenuComponent
    private val favorites = MenuFunctionBuilder {

    }
}