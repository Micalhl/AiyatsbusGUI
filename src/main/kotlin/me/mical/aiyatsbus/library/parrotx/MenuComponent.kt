package me.mical.aiyatsbus.library.parrotx

@Target(AnnotationTarget.CLASS, AnnotationTarget.FIELD, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class MenuComponent(val name: String = "")