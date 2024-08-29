package me.mical.aiyatsbus.util

import taboolib.module.chat.component

/**
 * Chesed
 * com.mcstarrysky.chesed.util.Utils
 *
 * @author mical
 * @since 2024/8/9 13:10
 */
fun String.buildToLegacyText(): String = component().buildColored().toLegacyText()

fun List<String>.buildToLegacyText(): List<String> = map { it.buildToLegacyText() }
