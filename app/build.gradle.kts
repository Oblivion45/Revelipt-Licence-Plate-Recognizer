plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.exampleplaterecognition"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.exampleplaterecognition"
        minSdk = 24
        targetSdk = 33
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

    packagingOptions {
        exclude("META-INF/INDEX.LIST")
        exclude("META-INF/DEPENDENCIES")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation ("androidx.core:core:1.12.0")
    implementation ("androidx.annotation:annotation:1.7.0")
    implementation ("com.google.cloud:google-cloud-vision:3.28.0")
    implementation ("com.theartofdev.edmodo:android-image-cropper:2.8.0")
    implementation ("com.google.android.gms:play-services-vision:20.1.3")
    implementation("com.google.mlkit:vision-common:17.3.0")
    implementation("com.google.android.gms:play-services-mlkit-text-recognition-common:19.0.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}