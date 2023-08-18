pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()

    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("/Users/dennisanderson/Local_repo/FlutterPluginDemo/flutter_module/build/host/outputs/repo")
        maven( "https://storage.googleapis.com/download.flutter.io")
    }
}

rootProject.name = "FlutterPluginDemo"
include(":app")
