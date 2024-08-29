package me.mical.aiyatsbus.library.parrotx.data

import org.bukkit.inventory.ItemStack
import me.mical.aiyatsbus.library.parrotx.config.MenuConfiguration

data class BuildContext(
    val config: MenuConfiguration,
    val extra: Map<String, Any?>,
    val slot: Int,
    val index: Int,
    val icon: ItemStack,
    val args: Map<String, Any?>
)
