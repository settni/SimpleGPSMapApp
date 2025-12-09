plugins {
    id("com.android.application")
    // Si usaste el Secrets Plugin para la API Key, agrégalo también:
    // id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
}

android {
    namespace = "com.example.gpsmapapp"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.gpsmapapp"
        minSdk = 26
        targetSdk = 36
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
}

dependencies {
    // Dependencias básicas de AndroidX
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)

    // 1. GOOGLE MAPS SDK (Para mostrar el mapa)
    implementation("com.google.android.gms:play-services-maps:18.2.0")

    // 2. GOOGLE LOCATION SERVICES (Para obtener la ubicación GPS, la que faltaba)
    implementation("com.google.android.gms:play-services-location:21.0.1")
    // Usamos la versión más reciente (21.0.1)

    // Dependencias de prueba
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}