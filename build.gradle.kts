// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(ProjectProperties.Gradle.APPLICATION) version Versions.GRADLE apply false
    id(ProjectProperties.Gradle.LIBRARY) version Versions.GRADLE apply false
    id(ProjectProperties.Gradle.KOTLIN) version Versions.KOTLIN apply false
    id(ProjectProperties.Gradle.KTLINT) version Versions.KTLINT
}
