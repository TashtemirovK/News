plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "kadyr.search_presentation"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
    buildFeatures {
        dataBinding = true
    }
}

dependencies {

    implementation(project(":common:common_utils"))
    implementation(project(":search:search_domain"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Основная библиотека Hilt
    implementation(libs.hilt.android.v251)
    kapt(libs.dagger.hilt.android.compiler)
    kapt(libs.androidx.hilt.compiler.v100)

    // Сoroutines
    implementation(libs.kotlinx.coroutines.core.v173) // Core
    implementation(libs.kotlinx.coroutines.android.v173) // Android
    implementation(libs.androidx.lifecycle.runtime.ktx.v262) // LifecycleScope
    implementation(libs.androidx.lifecycle.runtime.compose) // Для Compose

    // Glide
    implementation(libs.glide)
    annotationProcessor(libs.glide.compiler)

    // swiperefresh
    implementation(libs.androidx.swiperefreshlayout)
}