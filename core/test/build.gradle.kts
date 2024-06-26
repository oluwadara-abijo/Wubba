plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.dara.core.test"

    buildFeatures {
        buildConfig = true
    }

    compileSdk = 34

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        minSdk = 24
    }

}

tasks.withType<Test> {
    useJUnitPlatform()
}

dependencies {
    implementation(project(":core:network"))
    implementation(project(":app"))

    testImplementation(libs.androidx.lifecycle.runtime.ktx)
    testImplementation(libs.androidx.lifecycle.viewmodel)
    testImplementation(libs.androidx.ui)
    testImplementation(libs.androidx.core.testing)
    testImplementation(libs.junit.jupiter)
    testImplementation(libs.junit.jupiter.engine)
    testImplementation(libs.mockk)
    testImplementation(libs.kotlinx.coroutines.test)
}
