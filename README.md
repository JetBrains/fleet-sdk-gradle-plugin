[![official JetBrains project](https://jb.gg/badges/official.svg)][jb:github]
[![Twitter Follow](https://img.shields.io/twitter/follow/jetbrains_fleet?style=flat&logo=twitter)][jb:twitter]

# Fleet Gradle Plugin
The Gradle Fleet Plugin is a plugin for the Gradle build system to help configuring your environment for building and publishing plugins for Fleet.

# Usage

```kotlin

plugins {
    kotlin("jvm") version "1.8.0"
    `kotlin-dsl`
    id("org.jetbrains.fleet") version "0.2-SNAPSHOT"
}

fleet {
    fleetVersion.set("1.15.6")

    common {
        // add common dependencies with add(...)
    }

    frontend {
        // add frontend dependencies with add(...)
    }

    workspace {
        // add workspace dependencies with add(...)
    }

    plugins.addAll(
        "fleet.run" // add dependencies to other plugins
    )
}

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://cache-redirector.jetbrains.com/intellij-dependencies")
}
```

## Useful tasks

### runFleet
To run Fleet with your plugin, you can use the runFleet task. This will start Fleet and automatically load your plugin.

```./gradlew runFleet```

### distZip
To build a distribution zip for your plugin, you can use the distZip task. This will create a zip file containing your plugin and all of its dependencies, ready for distribution.

```./gradlew distZip```

[jb:twitter]: https://twitter.com/jetbrains_fleet
[jb:github]: https://github.com/JetBrains/.github/blob/main/profile/README.md
