pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "News"
include(":app")

// News modules
include(":news:news_data")
include(":news:news_domain")
include(":news:news_presentation")

// Search modules
include(":search:search_data")
include(":search:search_domain")
include(":search:search_presentation")

// Common modules
include(":common:common_utils")
