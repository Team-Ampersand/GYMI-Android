import java.io.FileInputStream
import java.util.Properties

@Suppress("DSL_SCOPE_VIOLATION")

plugins {
    alias(libs.plugins.library)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.mpersand.data"
    compileSdk = 33

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        buildConfigField(
            "String",
            "BASE_URL",
            getApiKey("BASE_URL")
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
    testOptions {
        unitTests.all {
            it.useJUnitPlatform()
        }
    }
}

dependencies {
    implementation(project(":domain"))

    implementation(libs.androidx.core)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.datastore)

    implementation(libs.google.material)
    implementation(libs.google.hilt)
    ksp(libs.google.hilt.compiler)

    implementation(libs.libraries.retrofit)
    implementation(libs.libraries.okhttp)
    implementation(libs.libraries.okhttp.logging.interceptor)
    implementation(libs.libraries.moshi.converter)
    implementation(libs.libraries.moshi)
    ksp(libs.libraries.moshi.codegen)

    testImplementation(libs.test.junit)
    testImplementation(libs.libraries.kotest)
    testImplementation(libs.libraries.mockk)
    androidTestImplementation(libs.test.android.junit)
    androidTestImplementation(libs.test.espresso)
}

fun getApiKey(propertyKey: String): String {
    val propFile = rootProject.file("./local.properties")
    val properties = Properties()
    properties.load(FileInputStream(propFile))
    return properties.getProperty(propertyKey)
}
