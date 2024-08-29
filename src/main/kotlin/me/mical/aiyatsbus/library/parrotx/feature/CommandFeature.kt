package me.mical.aiyatsbus.library.parrotx.feature

import me.mical.aiyatsbus.library.parrotx.MenuFeature
import me.mical.aiyatsbus.library.parrotx.data.ActionContext
import me.mical.aiyatsbus.library.parrotx.registry.VariableProviders
import me.mical.aiyatsbus.library.parrotx.function.VariableReaders
import me.mical.aiyatsbus.library.parrotx.function.asList

@Suppress("unused")
object CommandFeature : MenuFeature() {

    override val name: String = "Command"

    override fun handle(context: ActionContext) {
        val (_, extra, _, event, _) = context
        val commands = extra.asList<String>("commands") ?: return
        val user = event.clicker
        commands.map {
            VariableReaders.BRACES.replaceNested(it) {
                VariableProviders[this]?.produce(context) ?: ""
            }
        }.forEach(user::performCommand)
    }

}