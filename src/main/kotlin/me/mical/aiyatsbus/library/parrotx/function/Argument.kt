@file:Suppress("unused")

package me.mical.aiyatsbus.library.parrotx.function

inline fun <reified T> Map<*, *>.valueOrNull(node: String): T? {
    val value = this[node] ?: return null
    return requireNotNull(value as? T) {
        "配置项 $node 类型不正确 (要求: ${T::class.java.simpleName}, 实际: ${value::class.java.simpleName})"
    }
}

inline fun <reified T> Map<*, *>.value(node: String): T = requireNotNull(valueOrNull(node)) { "缺少配置项 $node" }