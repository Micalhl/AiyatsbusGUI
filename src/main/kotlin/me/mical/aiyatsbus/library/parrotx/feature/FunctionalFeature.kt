package me.mical.aiyatsbus.library.parrotx.feature

import org.bukkit.inventory.ItemStack
import me.mical.aiyatsbus.library.parrotx.MenuFeature
import me.mical.aiyatsbus.library.parrotx.data.ActionContext
import me.mical.aiyatsbus.library.parrotx.data.BuildContext
import me.mical.aiyatsbus.library.parrotx.function.value
import me.mical.aiyatsbus.library.parrotx.registry.MenuFunctions

object FunctionalFeature : MenuFeature() {

    override val name: String = "Functional"

    override fun build(context: BuildContext): ItemStack = MenuFunctions[keyword(context.extra)]?.build(context) ?: context.icon

    override fun handle(context: ActionContext) {
        MenuFunctions[keyword(context.extra)]?.handle(context)
    }

    fun keyword(extra: Map<*, *>): String = extra.value("keyword")

}