import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    id("multiplatform-setup")
    id("android-setup")
    id("kotlinx-serialization")
}

kotlin {

    android()
    jvm("desktop")

    sourceSets {
        named("commonMain") {
            dependencies {
                implementation(Deps.Ktor.clientCore)
                implementation(Deps.Ktor.clientJson)
                implementation(Deps.Ktor.clientLogging)
                implementation(Deps.Ktor.clientSerialization)
                implementation(Deps.Serialization.core)
                implementation(Deps.kotlinxDateTime)
                api(Deps.Koin.core)
                api(Deps.Koin.test)
            }
        }

        named("androidMain") {
            dependencies {
                implementation(Deps.Ktor.clientAndroid)
            }
        }

        named("desktopMain") {
            dependencies {
                implementation(Deps.Ktor.clientApache)
                implementation(Deps.Ktor.slf4j)
            }
        }

        named("commonTest") {
            dependencies {
            }
        }
    }

}
