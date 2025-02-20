import java.util.Properties

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    `maven-publish`
}

android {
    namespace = "io.github.u1tramarinet.samplelibrary.lib"
    compileSdk = 35

    defaultConfig {
        minSdk = 28
        aarMetadata {
            minCompileSdk = 28
        }

        version = "0.0.2"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    base.archivesName = "sample-library"

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
    @Suppress("UnstableApiUsage")
    testFixtures {
        enable = true
        androidResources = true
    }
    publishing {
        singleVariant("release") {
            withJavadocJar()
            withSourcesJar()
        }
    }
}

publishing {
    publications {
        register<MavenPublication>("gpr") {
            groupId = "io.github.u1tramarinet"
            artifactId = "sample-library"
            version = "0.0.2"

            afterEvaluate {
                from(components["release"])
            }

            pom {
                url = "https://maven.pkg.github.com/u1tramarinet/SampleLibrary"

                licenses {
                    license {
                        name = "Apache License Version 2.0"
                    }
                }
            }
        }
    }
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/u1tramarinet/SampleLibrary")
            credentials {
                val localProperties = Properties()
                localProperties.load(rootProject.file("local.properties").inputStream())

                username = localProperties.getProperty("gpr.user") ?: System.getenv("USERNAME")
                password = localProperties.getProperty("gpr.key") ?: System.getenv("TOKEN")
            }
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    testFixturesImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
