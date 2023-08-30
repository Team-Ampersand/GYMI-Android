import java.io.FileInputStream
import java.util.Properties

@Suppress("DSL_SCOPE_VIOLATION")

plugins {
    alias(libs.plugins.library)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.kapt)
}

android {
    namespace = "com.mpersand.presentation"
    compileSdk = 33

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        buildConfigField(
            "String",
            "CLIENT_ID",
            getApiKey("CLIENT_ID")
        )

        buildConfigField(
            "String",
            "REDIRECT_URI",
            getApiKey("REDIRECT_URI")
        )
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.6"
    }
}

dependencies {
    implementation(project(":domain"))

    implementation(libs.androidx.core)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.navigation)
    implementation(libs.androidx.viewmodel)
    implementation(libs.androidx.hilt.navigation)

    implementation(libs.compose)
    implementation(libs.compose.tooling)
    implementation(libs.compose.material)
    implementation(libs.compose.preview)

    implementation(libs.google.material)
    implementation(libs.google.hilt)
    kapt(libs.google.hilt.compiler)

    implementation(libs.libraries.gauth)
    implementation(libs.libraries.orbit.core)
    implementation(libs.libraries.orbit.viewmodel)
    implementation(libs.libraries.orbit.compose)
    implementation(libs.libraries.orbit.test)
    implementation(libs.libraries.collections.immutable)

    implementation(libs.libraries.gus)
    implementation(libs.libraries.coil)

    testImplementation(libs.test.junit)
    androidTestImplementation(libs.test.android.junit)
    androidTestImplementation(libs.test.espresso)
}

fun getApiKey(propertyKey: String): String {
    val propFile = rootProject.file("./local.properties")
    val properties = Properties()
    properties.load(FileInputStream(propFile))
    return properties.getProperty(propertyKey)
}
