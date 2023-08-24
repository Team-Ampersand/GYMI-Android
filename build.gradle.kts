@file:Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.application) apply false
    alias(libs.plugins.library) apply false
    alias(libs.plugins.kotlin) apply false
    alias(libs.plugins.ktlint)
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.kapt) apply false
}
