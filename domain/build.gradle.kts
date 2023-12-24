plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("kotlinx-serialization")
    id("kotlin-parcelize")
}

android {
    defaultConfig {
        namespace = "com.example.domain"
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        compileSdk = Config.compileSdk
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            buildConfigField("String", "API_BASE_URL", properties["API_BASE_URL"] as String)
        }

        debug {
            buildConfigField("String", "API_BASE_URL", properties["API_BASE_URL"] as String)
        }
    }
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = Config.javaCompileTarget
        targetCompatibility = Config.javaCompileTarget
    }
    kotlinOptions {
        jvmTarget = Config.javaCompileTarget.toString()
    }
}

dependencies {
    // Retrofit2
    implementation(Libraries.Retrofit2.core)
    implementation(Libraries.Retrofit2.converterKotlin)
    implementation(Libraries.Retrofit2.gson)

    // Kotlin
    implementation(Libraries.Kotlin.kotlin)
    implementation(Libraries.Kotlin.coroutine)

    // Dagger2 ( DI )
    implementation(Libraries.Dagger.hilt)
    kapt(Libraries.Dagger.hiltCompiler)

    // AndroidX
    implementation(Libraries.AndroidX.Paging.paging3)
}