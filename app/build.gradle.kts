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
    implementation(libs.android.lottie) // lottie airbnb
    implementation(libs.hilt.android.v251)  // Основная библиотека Hilt
    kapt(libs.dagger.hilt.android.compiler)
    kapt(libs.androidx.hilt.compiler.v100)

    // Swiperefresh
    implementation(libs.androidx.swiperefreshlayout)

    // Room
    implementation(libs.androidx.room.runtime)
    // Компилятор аннотаций для Room
    kapt(libs.androidx.room.compiler)
    // Дополнительно: расширения для Kotlin
    implementation(libs.androidx.room.ktx)

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
