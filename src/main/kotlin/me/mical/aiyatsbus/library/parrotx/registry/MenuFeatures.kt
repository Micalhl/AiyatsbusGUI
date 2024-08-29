package me.mical.aiyatsbus.library.parrotx.registry

import me.mical.aiyatsbus.library.parrotx.container.SimpleRegistry
import me.mical.aiyatsbus.library.parrotx.MenuFeature
import me.mical.aiyatsbus.library.parrotx.feature.CloseFeature
import me.mical.aiyatsbus.library.parrotx.feature.CommandFeature
import me.mical.aiyatsbus.library.parrotx.feature.FunctionalFeature
import me.mical.aiyatsbus.library.parrotx.feature.HeadFeature
import java.util.*

object MenuFeatures : SimpleRegistry<String, MenuFeature>(TreeMap(String.CASE_INSENSITIVE_ORDER)) {
    override fun getKey(value: MenuFeature): String = value.name

    private var initialized = false

    init {
        if (!initialized) {
            // 注册内置 Features
            register(CloseFeature)
            register(CommandFeature)
            register(FunctionalFeature)
            register(HeadFeature)
        }
    }
}