object Deps {
  const val kotlinxDateTime = "org.jetbrains.kotlinx:kotlinx-datetime:0.1.1"

  object JetBrains {
    object Kotlin {
      private const val VERSION = "1.4.32"
      const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$VERSION"
      const val serializationPlugin = "org.jetbrains.kotlin:kotlin-serialization:$VERSION"
      const val testCommon = "org.jetbrains.kotlin:kotlin-test-common:$VERSION"
      const val testJunit = "org.jetbrains.kotlin:kotlin-test-junit:$VERSION"
      const val testAnnotationsCommon =
        "org.jetbrains.kotlin:kotlin-test-annotations-common:$VERSION"
    }

    object Compose {
      private const val VERSION = "0.4.0-build183"
      const val gradlePlugin = "org.jetbrains.compose:compose-gradle-plugin:$VERSION"
    }
  }

  object Android {
    object Tools {
      object Build {
        const val gradlePlugin = "com.android.tools.build:gradle:4.2.1"
      }
    }
  }

  object AndroidX {
    object AppCompat {
      const val appCompat = "androidx.appcompat:appcompat:1.3.0-beta01"
    }

    object Activity {
      const val activityCompose = "androidx.activity:activity-compose:1.3.0-beta01"
    }
  }

  object Koin {
    private const val VERSION = "3.0.1"
    val core = "io.insert-koin:koin-core:${VERSION}"
    val test = "io.insert-koin:koin-test:${VERSION}"
    val android = "io.insert-koin:koin-android:${VERSION}"
    val compose = "io.insert-koin:koin-androidx-compose:${VERSION}"
  }

  object Serialization {
    private const val VERSION = "1.1.0"
    val core = "org.jetbrains.kotlinx:kotlinx-serialization-core:${VERSION}"
  }

  object Ktor {
    private const val VERSION = "1.5.3"
    val clientCore = "io.ktor:ktor-client-core:${VERSION}"
    val clientJson = "io.ktor:ktor-client-json:${VERSION}"
    val clientLogging = "io.ktor:ktor-client-logging:${VERSION}"
    val clientSerialization = "io.ktor:ktor-client-serialization:${VERSION}"

    val clientAndroid = "io.ktor:ktor-client-android:${VERSION}"
    val clientApache = "io.ktor:ktor-client-apache:${VERSION}"
    val clientIos = "io.ktor:ktor-client-ios:${VERSION}"
    val slf4j = "org.slf4j:slf4j-simple:1.7.30"
  }
}
