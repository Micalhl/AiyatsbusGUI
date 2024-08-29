import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    id("io.izzel.taboolib") version "2.0.13"
    id("org.jetbrains.kotlin.jvm") version "1.8.22"
}

taboolib {
    env {
        // 安装模块
        install(
            "bukkit-ui",
            "bukkit-util",
            "bukkit-xseries",
            "bukkit-xseries-item",
            "bukkit-xseries-skull",
            "minecraft-chat",
            "basic-configuration",
            "minecraft-i18n",
            "minecraft-command-helper",
            "platform-bukkit"
        )
        repoTabooLib = "http://mcstarrysky.com:8081/repository/releases/"
    }
    version { taboolib = "6.2.0-beta20-dev" }
}

repositories {
    maven("http://mcstarrysky.com:8081/repository/releases/") {
        isAllowInsecureProtocol = true
    }
    mavenCentral()
}

dependencies {
    compileOnly("ink.ptms.core:v11605:11605")
    compileOnly("ink.ptms.core:v12004:12004:mapped")
    compileOnly("ink.ptms.core:v12101:12101:mapped")
    compileOnly(kotlin("stdlib"))
    compileOnly(fileTree("libs"))
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = listOf("-Xjvm-default=all")
    }
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}
