package me.mical.aiyatsbus.library.parrotx.feature

import org.bukkit.inventory.ItemStack
import me.mical.aiyatsbus.library.parrotx.MenuFeature
import me.mical.aiyatsbus.library.parrotx.data.BuildContext
import me.mical.aiyatsbus.library.parrotx.function.textured
import me.mical.aiyatsbus.library.parrotx.function.value
import taboolib.library.xseries.XMaterial

@Suppress("unused")
object HeadFeature : MenuFeature() {

    override val name: String = "Head"

    override fun build(context: BuildContext): ItemStack {
        val (_, extra, _, _, icon, _) = context
        if (!XMaterial.PLAYER_HEAD.isSimilar(icon)) {
            return icon
        }
        return icon textured extra.value("texture")
    }

}