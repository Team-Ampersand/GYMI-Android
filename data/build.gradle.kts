plugins {
    id(ProjectProperties.Gradle.LIBRARY)
    id(ProjectProperties.Gradle.KOTLIN)
    kotlin(ProjectProperties.Gradle.KAPT)
}

android {
    namespace = ProjectProperties.NameSpace.DATA
    compileSdk = ProjectProperties.Versions.COMPILE_SDK

    defaultConfig {
        minSdk = ProjectProperties.Versions.MIN_SDK

        testInstrumentationRunner = ProjectProperties.Test.TEST_RUNNER
        consumerProguardFiles(ProjectProperties.Files.CONSUMER_PROGUARD)
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile(ProjectProperties.Files.DEFAULT_PROGUARD), ProjectProperties.Files.PROGUARD)
        }
    }
    compileOptions {
        sourceCompatibility = ProjectProperties.Versions.JAVA_VERSION
        targetCompatibility = ProjectProperties.Versions.JAVA_VERSION
    }
    kotlinOptions {
        jvmTarget = ProjectProperties.Versions.JVM_TARGET
    }
}

dependencies {
    implementation(project(":domain"))

    implementation(Dependency.AndroidX.CORE_KTX)
    implementation(Dependency.AndroidX.APPCOMPAT)
    implementation(Dependency.Google.MATERIAL)
    testImplementation(Dependency.Test.JUNIT)
    androidTestImplementation(Dependency.Test.ANDROID_JUNIT)
    androidTestImplementation(Dependency.Test.ESPRESSO)
    implementation(Dependency.Google.HILT)
    kapt(Dependency.Google.HILT_COMPILER)

    implementation(Dependency.Libraries.RETROFIT)
    implementation(Dependency.Libraries.OKHTTP)
    implementation(Dependency.Libraries.OKHTTP_LOGGING_INTERCEPTOR)
}