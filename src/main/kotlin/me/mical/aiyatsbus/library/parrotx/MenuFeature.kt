package me.mical.aiyatsbus.library.parrotx

import org.bukkit.inventory.ItemStack
import me.mical.aiyatsbus.library.parrotx.data.ActionContext
import me.mical.aiyatsbus.library.parrotx.data.BuildContext

abstract class MenuFeature {

    abstract val name: String

    open fun build(context: BuildContext): ItemStack = context.icon

    open fun handle(context: ActionContext) {}

}