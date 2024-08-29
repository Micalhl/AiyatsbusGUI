package me.mical.aiyatsbus.library.parrotx.function

import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.SkullMeta
import taboolib.library.xseries.profiles.builder.XSkull
import taboolib.library.xseries.profiles.objects.Profileable
import taboolib.platform.util.modifyMeta

/**
 * Aiyatsbus
 * com.mcstarrysky.aiyatsbus.module.ui.internal.function.Skull
 *
 * @author mical
 * @since 2024/2/18 12:21
 */
infix fun ItemStack.textured(headBase64: String): ItemStack {
    return modifyMeta<SkullMeta> {
        XSkull.of(this).profile(Profileable.detect(headBase64)).lenient().apply()
    }
}