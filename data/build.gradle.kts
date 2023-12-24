plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("kotlinx-serialization")
    id("dagger.hilt.android.plugin")
}
android {

    defaultConfig {
        namespace = "com.example.data"
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
    implementation(project(":domain"))

    // Retrofit2
    implementation(Libraries.Retrofit2.core)
    implementation(Libraries.Retrofit2.converterKotlin)
    implementation(Libraries.Retrofit2.gson)

    // logging interceptor
    implementation(Libraries.OkHttp.logger)
    // Kotlin
    implementation(Libraries.Kotlin.kotlin)
    implementation(Libraries.Kotlin.kotlinSerializable)
    implementation(Libraries.Kotlin.coroutine)

    // Dagger2 ( DI )
    implementation(Libraries.Dagger.androidHilt)
    kapt(Libraries.Dagger.androidHiltCompiler)

    // ETC
    coreLibraryDesugaring(Libraries.desugar)
    api(Libraries.timber)

    // AndroidX
    implementation(Libraries.AndroidX.Paging.paging3)
}