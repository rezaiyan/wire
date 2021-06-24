plugins {
    `kotlin-dsl`
}
kotlinDslPluginOptions {
    experimentalWarning.set(false)
}
repositories {
    mavenLocal()
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
    implementation("org.jetbrains.compose:compose-gradle-plugin:0.4.0-build183")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.32")
    implementation("com.android.tools.build:gradle:4.2.1")
    implementation("org.jetbrains.kotlin:kotlin-serialization:1.4.32")
}