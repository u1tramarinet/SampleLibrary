plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    id("maven-publish")
}

subprojects {
    apply(plugin = "maven-publish")

    configure<PublishingExtension> {
        repositories {
            maven {
                name = "github"
                url = uri("https://maven.pkg.github.com/u1tramarinet/SampleLibrary")
            }
        }
    }
}