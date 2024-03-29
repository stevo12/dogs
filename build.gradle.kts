buildscript {
    //ext {
        val compose_ui_version = "1.4.8"
   // }

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath ("com.google.android.libraries.mapsplatform.secrets-gradle-plugin:secrets-gradle-plugin:2.0.1")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.44")

    }
}// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id ("com.android.application") version "8.1.1" apply false
    id ("com.android.library") version "8.1.1" apply false
    id ("org.jetbrains.kotlin.android") version "1.8.22" apply false
    id ("com.google.dagger.hilt.android") version "2.44" apply false
}