plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("maven-publish")
}

android {
    namespace = "io.padam.android_ui.customer"
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
    buildFeatures {
        compose = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.14"
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

publishing {


    val githubUsername = project.property("github_username").toString()
    val githubToken = project.property("github_token").toString()




    repositories {
        mavenCentral()
        maven {
            println(githubUsername)
            println(githubToken)
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/optiways/padam-android-ui")
            credentials {
                username = githubUsername
                password = githubToken
            }
        }
    }

    publications {
        create<MavenPublication>("padam-ui") {
            version = "0.0.1"
            groupId = "io.padam.android"
            artifactId = "padam-ui"

        }
    }


}




dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.foundation)
    testImplementation(libs.junit)
    implementation(libs.foundation)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}