class Dependency {
    object AndroidX {
        const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX}"
        const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.APPCOMPAT}"
        const val LIFECYCLE = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE}"
        const val VIEWMODEl = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.VIEWMODEL}"
        const val DATASTORE = "androidx.datastore:datastore-preferences:${Versions.DATASTORE}"
    }

    object Test {
        const val JUNIT = "junit:junit:${Versions.JUNIT}"
        const val ANDROID_JUNIT = "androidx.test.ext:junit:${Versions.ANDROID_JUNIT}"
        const val ESPRESSO = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO}"
        const val COMPOSE_JUNIT = "androidx.compose.ui:ui-test-junit4:${Versions.COMPOSE}"
        const val COMPOSE_MANIFEST = "androidx.compose.ui:ui-test-manifest:${Versions.COMPOSE}"
    }

    object Compose {
        const val ACTIVITY_COMPOSE = "androidx.activity:activity-compose:${Versions.ACTIVITY_COMPOSE}"
        const val COMPOSE = "androidx.compose.ui:ui:${Versions.COMPOSE}"
        const val COMPOSE_PREVIEW = "androidx.compose.ui:ui-tooling-preview:${Versions.COMPOSE}"
        const val COMPOSE_MATERIAL = "androidx.compose.material:material:${Versions.COMPOSE_MATERIAL}"
        const val COMPOSE_TOOLING = "androidx.compose.ui:ui-tooling:${Versions.COMPOSE}"
    }

    object Google {
        const val MATERIAL = "com.google.android.material:material:${Versions.GOOGLE_MATERIAL}"
        const val HILT = "com.google.dagger:hilt-android:${Versions.HILT}"
        const val HILT_COMPILER = "com.google.dagger:hilt-android-compiler:${Versions.HILT}"
        const val GSON = "com.google.code.gson:gson:${Versions.GSON}"
    }

    object Libraries {
        const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
        const val RETROFIT_CONVERTER_GSON =
            "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}"
        const val OKHTTP = "com.squareup.okhttp3:okhttp:${Versions.OKHTTP}"
        const val OKHTTP_LOGGING_INTERCEPTOR =
            "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP}"
        const val GUS = "com.github.Team-Ampersand:GUS:${Versions.GUS}"
        const val COIL = "io.coil-kt:coil-compose:${Versions.COIL}"
    }

    object MSG {
        const val GAUTH = "com.github.GSM-MSG:GAuth-Signin-Android:${Versions.GAUTH}"
    }

    object Orbit {
        const val CORE = "org.orbit-mvi:orbit-core:${Versions.ORBIT}"
        const val VIEWMODEL = "org.orbit-mvi:orbit-viewmodel:${Versions.ORBIT}"
        const val COMPOSE = "org.orbit-mvi:orbit-compose:${Versions.ORBIT}"
        const val TEST = "org.orbit-mvi:orbit-test:${Versions.ORBIT}"
    }
}
