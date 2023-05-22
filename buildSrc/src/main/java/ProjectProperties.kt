import org.gradle.api.JavaVersion

object ProjectProperties {
    object Gradle {
        const val APPLICATION = "com.android.application"
        const val LIBRARY = "com.android.library"
        const val KOTLIN = "org.jetbrains.kotlin.android"
        const val KTLINT = "org.jlleitschuh.gradle.ktlint"
        const val HILT_PLUGIN = "com.google.dagger.hilt.android"
        const val KAPT = "kapt"
    }
    object Test {
        const val TEST_RUNNER = "androidx.test.runner.AndroidJUnitRunner"
    }

    object Id {
        const val APPLICATION_ID = "com.mpersand.gymi_android"
    }

    object Files {
        const val CONSUMER_PROGUARD = "consumer-rules.pro"
        const val DEFAULT_PROGUARD = "proguard-android-optimize.txt"
        const val PROGUARD = "proguard-rules.pro"
    }

    object Versions {
        const val COMPILE_SDK = 33
        const val MIN_SDK = 24
        const val TARGET_SDK = 33
        const val JVM_TARGET = "11"
        const val VERSION_CODE = 1
        const val VERSION_NAME = "1.0"
        val JAVA_VERSION = JavaVersion.VERSION_11
    }

    object NameSpace {
        const val DESIGN_SYSTEM = "com.mpersand.design_system"
        const val PRESENTATION = "com.mpersand.presentation"
        const val DOMAIN = "com.mpersand.domain"
        const val DATA = "com.mpersand.data"
        const val APP = "com.mpersand.gymi_android"
    }

    object Action {
        const val EXCLUDES = "/META-INF/{AL2.0,LGPL2.1}"
    }
}
