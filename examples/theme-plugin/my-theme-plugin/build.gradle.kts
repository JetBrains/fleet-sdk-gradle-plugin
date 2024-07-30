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
}
