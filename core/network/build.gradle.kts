plugins {
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.android.library)
}

android {
    namespace = "com.dara.core.network"

    buildFeatures {
        buildConfig = true
    }

    compileSdk = 34
}

dependencies {
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.kotlin.serialization)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.coroutines)
    implementation(libs.okhttp.logging.interceptor)
}
