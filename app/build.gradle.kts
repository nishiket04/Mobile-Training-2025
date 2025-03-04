plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.google.android.libraries.mapsplatform.secrets.gradle.plugin)
    id("kotlin-kapt")
    alias(libs.plugins.google.gms.google.services)
    id("com.google.dagger.hilt.android")
}
val room_version = "2.6.1"
android {
    namespace = "com.nishiket.task"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.nishiket.task"
        minSdk = 27
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.play.services.maps)
    implementation(libs.play.services.location)
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("androidx.room:room-runtime:$room_version")
    implementation(libs.firebase.messaging)
    implementation(libs.androidx.work.runtime.ktx)
    testImplementation(libs.junit)
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")
    kapt("androidx.room:room-compiler:2.5.0")
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation("com.google.dagger:hilt-android:2.51.1")
    kapt("com.google.dagger:hilt-android-compiler:2.51.1")
}