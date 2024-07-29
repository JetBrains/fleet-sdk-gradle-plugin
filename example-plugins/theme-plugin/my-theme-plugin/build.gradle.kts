plugins {
    base
    id("org.jetbrains.fleet-plugin")
}

listOf(
    repositories,
    *subprojects.map { it.repositories }.toTypedArray()
).forEach {
    it.mavenCentral()
    it.maven("https://cache-redirector.jetbrains.com/intellij-dependencies") // needed to retrieve `rhizomedb-compiler-plugin` and `noria-compiler-plugin`
}

version = "0.1.0"

fleetPlugin {
    id = "my.super.theme"

    metadata {
        readableName = "My Super Theme"
        description = "A super theme plugin"
    }

    fleetRuntime {
        version = "1.37.56"
    }
}
