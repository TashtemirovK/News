plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
//    id("com.google.dagger.hilt.android")
}

android {
    namespace = "kadyr.news_domain"
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
}

dependencies {

//    implementation(project(":news:news_data"))

    // Корутин для бизнес-логики
//    implementation(libs.kotlinx.coroutines.core)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Dagger Hilt
// /   implementation(libs.dagger.hilt.android)
// /   implementation(libs.hilt.android.compiler)
// /   implementation(libs.androidx.hilt.compiler)
//    implementation(libs.hilt.android)
//    kapt(libs.hilt.compiler)

//    implementation(libs.dagger.hilt.android)
//    implementation(libs.hilt.android.compiler)
//    implementation(libs.androidx.hilt.compiler)
//    // Hilt
//    implementation(libs.hilt.android)
//    kapt(libs.hilt.compiler)
}