package me.mical.aiyatsbus.library.parrotx.config

import me.mical.aiyatsbus.library.parrotx.function.VariableReaders
import me.mical.aiyatsbus.library.parrotx.function.oneOf
import me.mical.aiyatsbus.library.parrotx.config.advance.KeywordConfiguration
import me.mical.aiyatsbus.library.parrotx.config.advance.ShapeConfiguration
import me.mical.aiyatsbus.library.parrotx.config.advance.TemplateConfiguration
import taboolib.library.configuration.ConfigurationSection
import taboolib.module.configuration.Configuration
import taboolib.module.ui.type.PageableChest

@Suppress("MemberVisibilityCanBePrivate", "unused")
class MenuConfiguration(internal val source: Configuration) {

    val isDebug: Boolean = source.oneOf(*MenuSection.DEBUG.paths, getter = ConfigurationSection::getBoolean) ?: false

    val title: String? = source.oneOf(*MenuSection.TITLE.paths, getter = ConfigurationSection::getString)
    val shape: ShapeConfiguration = ShapeConfiguration(this)
    val templates: TemplateConfiguration = TemplateConfiguration(this)
    val keywords: KeywordConfiguration = KeywordConfiguration(this)
    val cached: MutableMap<String, Any?> = HashMap()
    val mapped: MutableMap<Int, Any?> = HashMap()

    fun title(vararg variables: Pair<String, () -> String>): String {
        return with(variables.toMap()) {
            VariableReaders.BRACES.replaceNested(title ?: MenuSection.TITLE.missing()) {
                get(this)?.invoke() ?: ""
            }
        }
    }

    fun setPreviousPage(menu: PageableChest<*>, keyword: String = "Previous") {
        shape[keyword].first().let { slot ->
            menu.setPreviousPage(slot) { _, it ->
                templates(keyword, slot, 0, !it)
            }
        }
    }

    fun setNextPage(menu: PageableChest<*>, keyword: String = "Next") {
        shape[keyword].first().let { slot ->
            menu.setNextPage(slot) { _, it ->
                templates(keyword, slot, 0, !it)
            }
        }
    }

    operator fun component1(): ShapeConfiguration = shape
    operator fun component2(): TemplateConfiguration = templates
    operator fun component3(): KeywordConfiguration = keywords
    operator fun component4(): MenuConfiguration = this
    operator fun component5(): MutableMap<String, Any?> = cached
    operator fun component6(): MutableMap<Int, Any?> = mapped

}