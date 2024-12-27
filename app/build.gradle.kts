plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "kadyr.news"
    compileSdk = 35

    defaultConfig {
        applicationId = "kadyr.news"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
}

dependencies {


    implementation(project(":news:news_data"))
    implementation(project(":news:news_domain"))
    implementation(project(":news:news_presentation"))

    implementation(project(":search:search_data"))
    implementation(project(":search:search_domain"))
    implementation(project(":search:search_presentation"))

    implementation(project(":common:common_utils"))

    // Lottie Animations
    implementation(libs.lottie)
    // lottie airbnb
    implementation(libs.android.lottie)
    // Основная библиотека Hilt
    implementation(libs.hilt.android.v251)
    kapt(libs.dagger.hilt.android.compiler)
    kapt(libs.androidx.hilt.compiler.v100)
//    // retrofit
//    implementation(libs.retrofit)
//    // gson converter
//    implementation(libs.converter.gson)
//    implementation(libs.converter.scalars)
//    // OkHttp
//    implementation(libs.okhttp)
//    // Coroutines
//    implementation(libs.kotlinx.coroutines.core)
//    implementation(libs.kotlinx.coroutines.android.v163)
//    implementation(libs.androidx.lifecycle.viewmodel.ktx.v240)
//    implementation(libs.androidx.lifecycle.runtime.ktx)
//    // Glide
//    implementation(libs.glide)
//    implementation(libs.compiler)
//    // ViewModel Delegate
//    implementation(libs.androidx.activity.ktx)
//    // Dagger Hilt
//    implementation(libs.dagger.hilt.android)
//    implementation(libs.hilt.android.compiler)
//    implementation(libs.androidx.hilt.compiler)
//    kapt(libs.hilt.compiler)
//    implementation(libs.hilt.android)


//    // Room
//    kapt (libs.androidx.room.compiler)
//    implementation(libs.androidx.room.ktx)
//    // CircularProgressBar
//    implementation(libs.androidx.swiperefreshlayout)


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
