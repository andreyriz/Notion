plugins {
    id ("com.android.application")
    id ("kotlin-android")
    id ("kotlin-kapt")
    id ("dagger.hilt.android.plugin")
    id ("androidx.navigation.safeargs")
}

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "com.andrey.susie"
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
    val viewbinding_property_delegate_version = "1.5.3"
    val material_design_version = "1.6.0"
    val constraint_version = "2.1.4"
    val recycler_version = "1.2.1"
    val coroutine_core_version = "1.6.1"
    val paging_runtime= "3.1.1"
    val core_ktx_version = "1.7.0"
    val app_compat_version = "1.4.1"
    val legacy_support_version = "1.0.0"
    val timber_version = "5.0.1"
    val shimmer_version = "0.5.0"

    implementation("androidx.legacy:legacy-support-v4:$legacy_support_version")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    implementation ("androidx.core:core-ktx:$core_ktx_version")
    implementation ("androidx.appcompat:appcompat:$app_compat_version")
    implementation ("com.google.android.material:material:$material_design_version")
    implementation ("androidx.constraintlayout:constraintlayout:$constraint_version")
    //Paging
    implementation("androidx.paging:paging-runtime:$paging_version")
    //Pagination
    implementation ("androidx.paging:paging-runtime-ktx:$paging_runtime")
    //Glide
    implementation("com.github.bumptech.glide:glide:$glide_version")
    //hilt
    implementation ("com.google.dagger:hilt-android:$dagger_version")
    kapt ("com.google.dagger:hilt-compiler:$dagger_version")
    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:$retrofit_version")
    implementation("com.squareup.retrofit2:converter-gson:$retrofit_version")
    //RecyclerView
    implementation ("androidx.recyclerview:recyclerview:$recycler_version")
    //Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutine_core_version")
    //Shimmer
    implementation ("com.facebook.shimmer:shimmer:$shimmer_version")
    //Logger
    implementation ("com.jakewharton.timber:timber:$timber_version")
    //Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")
    implementation ("com.github.kirich1409:viewbindingpropertydelegate:$viewbinding_property_delegate_version")
}