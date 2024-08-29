package me.mical.aiyatsbus.library.parrotx.registry

import me.mical.aiyatsbus.library.parrotx.container.SimpleRegistry
import me.mical.aiyatsbus.library.parrotx.feature.util.MenuFunction
import java.util.*

object MenuFunctions : SimpleRegistry<String, MenuFunction>(TreeMap(String.CASE_INSENSITIVE_ORDER)) {
    override fun getKey(value: MenuFunction): String = value.name
}