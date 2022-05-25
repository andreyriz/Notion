plugins {
    id ("com.android.application")
    id ("kotlin-android")
    id ("kotlin-kapt")
    //id("dagger.hilt.android.plugin")
}

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "com.andrey.Susie"
        minSdk = 21
        targetSdk = 30
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        viewBinding = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled  = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
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
        val nav_version = "2.3.5"
    val material_version = "1.6.0-alpha01"
    val lifecycle_version = "2.4.0"
    val paging_version = "3.1.0"
    val retrofit_version="2.9.0"
    val glide_version = "4.12.0"
    val dagger_version = "2.40.5"

    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")

    implementation ("androidx.core:core-ktx:1.7.0")
    implementation ("androidx.appcompat:appcompat:1.4.1")
    implementation ("com.google.android.material:material:1.5.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.3")

    //Paging
    implementation("androidx.paging:paging-runtime:$paging_version")

    //Glide
    implementation("com.github.bumptech.glide:glide:$glide_version")

    //hilt
    //implementation("com.google.dagger:hilt-android:$dagger_version")
    //kapt("com.google.dagger:hilt-compiler:$dagger_version")

    //dagger
    implementation("com.google.dagger:dagger:$dagger_version")
    kapt("com.google.dagger:dagger-compiler:$dagger_version")
    implementation ("com.google.dagger:dagger-android-support:$dagger_version")
    kapt ("com.google.dagger:dagger-android-processor:$dagger_version")

    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:$retrofit_version")
    implementation("com.squareup.retrofit2:converter-gson:$retrofit_version")
    //implementation("tech.thdev:flow-call-adapter-factory:1.0.0")

    //RecyclerView
    implementation ("androidx.recyclerview:recyclerview:1.2.1")

    //Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")

    //Shimmer
    implementation ("com.facebook.shimmer:shimmer:0.5.0")

    //Logger
    implementation ("com.jakewharton.timber:timber:5.0.1")

    //Pagination
    implementation ("androidx.paging:paging-runtime-ktx:3.1.0")

    //Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")

    implementation("com.google.android.material:material:$material_version")
}