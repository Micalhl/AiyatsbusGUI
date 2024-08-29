package me.mical.aiyatsbus.library.parrotx.registry

import me.mical.aiyatsbus.library.parrotx.container.SimpleRegistry
import me.mical.aiyatsbus.library.parrotx.feature.util.MenuOpener
import java.util.*

object MenuOpeners : SimpleRegistry<String, MenuOpener>(TreeMap(String.CASE_INSENSITIVE_ORDER)) {
    override fun getKey(value: MenuOpener): String = value.name
}