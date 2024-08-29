@file:Suppress("unused")

package me.mical.aiyatsbus.library.parrotx.function

import taboolib.library.configuration.ConfigurationSection
import java.util.*

inline fun <reified E> Map<*, *>.asList(node: String): List<E>? {
    return when (val obj = this[node]) {
        is E -> listOf(obj)
        is Collection<*> -> obj.filterIsInstance<E>()
        else -> null
    }
}

fun <V> ConfigurationSection.asMap(path: String = "", transfer: ConfigurationSection.(String) -> V?): Map<String, V> {
    val map: MutableMap<String, V> = HashMap()
    (if (path.isEmpty()) this else getConfigurationSection(path))?.let { root ->
        root.getKeys(false).forEach { key ->
            map[key] = runCatching {
                root.transfer(key)
            }.onFailure {
                it.printStackTrace()
            }.getOrNull() ?: return@forEach
        }
    }
    return map
}

fun <V> ConfigurationSection.oneOf(
    vararg paths: String,
    validate: (V) -> Boolean = { true },
    getter: ConfigurationSection.(String) -> V?
): V? {
    return paths.firstNotNullOfOrNull {
        getter(this, it)?.takeIf(validate)
    }
}