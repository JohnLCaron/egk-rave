buildscript {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

plugins {
    kotlin("jvm") version "1.9.10"
    alias(libs.plugins.ktor)
    alias(libs.plugins.serialization)

    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(files("/home/stormy/dev/github/electionguard-kotlin-multiplatform/egklib/build/libs/egklib-jvm-2.0.0-SNAPSHOT.jar"))
    implementation(files("/home/stormy/dev/github/verificatum-vcr/build/libs/verificatum-vcr-3.1.0.jar"))
    implementation(files("/home/stormy/dev/github/verificatum-vmn/build/libs/verificatum-vmn-3.1.0.jar"))

    implementation(libs.bundles.eglib)
    implementation(libs.bundles.xmlutil)

    implementation(libs.oshai.logging)
    implementation(libs.logback.classic)
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(19)
}

application {
    mainClass.set("MainKt")
}