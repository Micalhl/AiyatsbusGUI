package me.mical.aiyatsbus.library.parrotx.registry

import me.mical.aiyatsbus.library.parrotx.container.SimpleRegistry
import me.mical.aiyatsbus.library.parrotx.feature.util.VariableProvider
import java.util.*

object VariableProviders : SimpleRegistry<String, VariableProvider>(TreeMap(String.CASE_INSENSITIVE_ORDER)) {
    override fun getKey(value: VariableProvider): String = value.name
}