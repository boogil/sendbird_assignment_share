object Libraries {
    object GradlePlugin {
        const val android = "com.android.tools.build:gradle:${Versions.GradlePlugin.android}"
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.Kotlin.kotlin}"
        const val kotlinSerializable ="org.jetbrains.kotlin:kotlin-serialization:${Versions.Kotlin.kotlin}"
        const val daggerHilt = "com.google.dagger:hilt-android-gradle-plugin:${Versions.Dagger2.hilt}"
        const val safeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.AndroidX.navigation}"
    }

    object Kotlin {
        const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.Kotlin.kotlin}"
        const val kotlinSerializable = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.Kotlin.kotlinSerializable}"
        const val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Kotlin.coroutine}"
    }

    object AndroidX {
        const val core = "androidx.core:core-ktx:${Versions.AndroidX.core}"
        const val constraint = "androidx.constraintlayout:constraintlayout:${Versions.AndroidX.constraint}"
        const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.AndroidX.recyclerview}"
        const val appcompat = "androidx.appcompat:appcompat:${Versions.AndroidX.appcompat}"
        const val design = "com.google.android.material:material:${Versions.AndroidX.design}"
        const val activity = "androidx.activity:activity-ktx:${Versions.AndroidX.activity}"
        const val fragment = "androidx.fragment:fragment-ktx:${Versions.AndroidX.fragment}"
        const val startUp = "androidx.startup:startup-runtime:${Versions.AndroidX.startUp}"

        object Lifecycle {
            const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.AndroidX.lifecycle}"
            const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.AndroidX.lifecycle}"
            const val savedState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.AndroidX.lifecycle}"
            const val compiler = "androidx.lifecycle:lifecycle-compiler:${Versions.AndroidX.lifecycle}"// For Kotlin use kapt instead of annotationProcessor
        }

        object Navigation {
            const val ui = "androidx.navigation:navigation-ui-ktx:${Versions.AndroidX.navigation}"
            const val fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.AndroidX.navigation}"
        }

        object Hilt {
            const val common = "androidx.hilt:hilt-common:${Versions.AndroidX.hilt}"
            const val navigation = "androidx.hilt:hilt-navigation-fragment:${Versions.AndroidX.hilt}"
            const val compiler = "androidx.hilt:hilt-compiler:${Versions.AndroidX.hilt}" // For Kotlin use kapt instead of annotationProcessor
        }

        object Paging {
            const val paging3 = "androidx.paging:paging-runtime-ktx:${Versions.AndroidX.paging3}" // For Kotlin use kapt instead of annotationProcessor
        }
    }

    object Dagger {
        const val hilt = "com.google.dagger:hilt-core:${Versions.Dagger2.hilt}"
        const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.Dagger2.hilt}" // For Kotlin use kapt instead of annotationProcessor

        const val androidHilt = "com.google.dagger:hilt-android:${Versions.Dagger2.hilt}"
        const val androidHiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.Dagger2.hilt}" // For Kotlin use kapt instead of annotationProcessor
    }

    object Glide {
        const val core = "com.github.bumptech.glide:glide:${Versions.glide}"
        const val compiler = "com.github.bumptech.glide:ksp:${Versions.glide}"  // For Kotlin use kapt instead of annotationProcessor
    }

    object Retrofit2 {
        const val core = "com.squareup.retrofit2:retrofit:${Versions.retrofit2}"
        const val converterMoshi = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit2}"
        const val converterKotlin = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.retrofitConverter}"
        const val gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit2}"
    }

    object OkHttp {
        const val logger = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
    }

    object Room {
        const val runtime = "androidx.room:room-runtime:${Versions.Room.room}"
        const val kapt = "androidx.room:room-compiler:${Versions.Room.room}"
        const val ktx = "androidx.room:room-ktx:${Versions.Room.room}"
        const val test = "androidx.room:room-testing:${Versions.Room.room}"
    }

    object RxBinding {
        const val rxBinding =  "com.jakewharton.rxbinding3:rxbinding:${Versions.Rx.rxBinding}"
        const val rxBindingCore =   "com.jakewharton.rxbinding3:rxbinding-core:${Versions.Rx.rxBinding}"
    }

    const val desugar = "com.android.tools:desugar_jdk_libs:${Versions.desugar}" // coreLibraryDesugaring
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

}