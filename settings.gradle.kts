pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        jcenter()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        repositories {
            jcenter()
            maven {
                url = uri("https://maven.google.com")
            }
            // Add any additional repositories if needed
            mavenCentral()
            google()
        }

    }
}

rootProject.name = "Example Plate Recognition"
include(":app")
