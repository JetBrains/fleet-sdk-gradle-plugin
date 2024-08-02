plugins {
    base
    alias(libs.plugins.fleet.plugin)
}

version = "0.1.0"

fleetPlugin {
    id = "my.super.theme"

    metadata {
        readableName = "My Super Theme"
        description = "A super theme plugin"
    }

    fleetRuntime {
        version = libs.versions.fleet.runtime
    }

    publishing {
        licenseUrl = "https://www.apache.org/licenses/LICENSE-2.0"
        sourceCodeUrl = "https://github.com/JetBrains/fleet-sdk-gradle-plugin/tree/main/examples/theme-plugin"
    }
}
