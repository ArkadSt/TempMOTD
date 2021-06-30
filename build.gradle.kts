import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.20"
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

group = "org.arkadst"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        url = uri("https://papermc.io/repo/repository/maven-public/")
    }
}

dependencies {
    testImplementation(kotlin("test"))
    compileOnly("io.papermc.paper:paper-api:1.17-R0.1-SNAPSHOT")
}

tasks.test {
    useTestNG()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "16"
}