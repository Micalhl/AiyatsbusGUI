package me.mical.aiyatsbus.library.parrotx.feature

import me.mical.aiyatsbus.library.parrotx.MenuFeature
import me.mical.aiyatsbus.library.parrotx.data.ActionContext
import taboolib.common.platform.function.submit

@Suppress("unused")
object CloseFeature : MenuFeature() {

    override val name: String = "Close"

    override fun handle(context: ActionContext) {
        submit {
            context.event.clicker.closeInventory()
        }
    }

}