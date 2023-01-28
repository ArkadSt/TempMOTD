plugins {
    kotlin("jvm") version "1.8.0"
    id("com.github.johnrengelman.shadow") version "7.1.2"
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
    compileOnly("io.papermc.paper:paper-api:1.19.3-R0.1-SNAPSHOT")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}