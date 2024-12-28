plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "kadyr.news_data"
    compileSdk = 35

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
}

dependencies {

    implementation(project(":news:news_domain"))
    implementation(project(":common:common_utils"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)


    // Основная библиотека Hilt
    implementation(libs.hilt.android.v251)
    kapt(libs.dagger.hilt.android.compiler)
    kapt(libs.androidx.hilt.compiler.v100)

    // Retrofit
    implementation(libs.retrofit)
    // Retrofit Gson Converter
    implementation(libs.converter.gson)
    // Retrofit OkHttp
    implementation(libs.okhttp)

    // Dagger Hilt
//    implementation(libs.dagger.hilt.android)
//    implementation(libs.hilt.android.compiler)
//    implementation(libs.androidx.hilt.compiler)
//    implementation(libs.hilt.android)
//    kapt(libs.hilt.compiler)
//    implementation(libs.dagger.hilt.android)
//    implementation(libs.hilt.android.compiler)
//    implementation(libs.androidx.hilt.compiler)
//    // Hilt
//    implementation(libs.hilt.android)
//    kapt(libs.hilt.compiler)
//
//    implementation(libs.retrofit)
//    implementation(libs.converter.gson)
//    implementation(libs.okhttp)
//    implementation(libs.androidx.room.ktx)
//    kapt(libs.androidx.room.compiler)
//    implementation(libs.kotlinx.coroutines.core)
//    // Lottie
//    implementation(libs.lottie)
}