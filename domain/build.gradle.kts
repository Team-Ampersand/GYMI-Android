@Suppress("DSL_SCOPE_VIOLATION")

plugins {
    alias(libs.plugins.library)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.mpersand.domain"
    compileSdk = 33

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    testOptions {
        unitTests.all {
            it.useJUnitPlatform()
        }
    }
}

dependencies {
    implementation(libs.androidx.core)
    implementation(libs.androidx.appcompat)

    implementation(libs.google.material)
    implementation(libs.google.hilt)
    ksp(libs.google.hilt.compiler)

    testImplementation(libs.test.junit)
    testImplementation(libs.libraries.kotest)
    testImplementation(libs.libraries.mockk)
    androidTestImplementation(libs.test.android.junit)
    androidTestImplementation(libs.test.espresso)

    implementation(libs.libraries.okhttp)
}
