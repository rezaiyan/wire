import org.jetbrains.compose.compose

plugins {
    id("com.android.application")
    kotlin("android")
    id("org.jetbrains.compose")
}

android {
    compileSdkVersion(30)

    defaultConfig {
        minSdkVersion(23)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    packagingOptions {
        exclude("META-INF/*")
    }
}

dependencies {
    // val koin_version = "2.2.0-alpha-1"
    // implementation("org.koin:koin-androidx-scope:$koin_version")
    // implementation("org.koin:koin-androidx-viewmodel:$koin_version")
    // implementation("org.koin:koin-androidx-fragment:$koin_version")

    implementation(project(":common:compose-ui"))
    implementation(compose.material)
    implementation(Deps.AndroidX.AppCompat.appCompat)
    implementation(Deps.AndroidX.Activity.activityCompose)
    implementation(Deps.Koin.android)
    implementation("androidx.compose.ui:ui-tooling:1.0.0-beta07")
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.0-alpha07")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07")
    implementation("androidx.compose.runtime:runtime-livedata:1.0.0-beta07")
    implementation("com.google.accompanist:accompanist-coil:0.12.0")
    implementation("androidx.compose.ui:ui:1.0.0-beta07")
    implementation("androidx.compose.material:material:1.0.0-beta07")
    implementation("androidx.compose.runtime:runtime-livedata:1.0.0-beta07")
    implementation("androidx.compose.ui:ui-tooling:1.0.0-beta07")
    debugImplementation("androidx.compose.ui:ui-tooling:1.0.0-beta07")

    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")
    implementation("androidx.activity:activity-compose:1.3.0-beta01")
}
