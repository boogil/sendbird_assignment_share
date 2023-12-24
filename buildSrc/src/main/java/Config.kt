import org.gradle.api.JavaVersion

object Config {
    const val applicationId = "com.example"
    const val compileSdk = 33
    const val buildToolsVersion = "30.0.2"
    const val minSdk = 24
    const val targetSdk = 33
    const val versionCode = 1
    const val versionName = "0.0.1"

    val javaCompileTarget = JavaVersion.VERSION_17
}