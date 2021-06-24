plugins {
    id("multiplatform-compose-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        named("commonMain") {
            dependencies {
                api(project(":common:main"))
                implementation("com.google.accompanist:accompanist-coil:0.11.1")
            }
        }
    }
}
