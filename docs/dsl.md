# DSLs

> [!NOTE]
> The DSL documentation will be updated when the SDK supports other plugin use-cases.

## Plugin `org.jetbrains.fleet-plugin`

```kotlin
fleetPlugin {
  id = "my.plugin"

  metadata {
    readableName = "My super plugin"
    description = "A super plugin that add support for X"

    attribute("somekey", "someValue")
    attribute("somekey2", "someValue2")
    
    icons {
      default = layout.projectDirectory.file("myicon.svg")
      dark = layout.projectDirectory.file("myicon_dark.svg")
    }
  }

  fleetRuntime {
    version = "1.23.59"                                         // if not specified, configuration will fail stating which is the latest public preview version
    minVersion = "1.23.0"                                       // default = fleetRuntime.version
    maxVersion = "1.23.100"                                     // default = fleetRuntime.version.replacePatch("9999")
    downloadDirectory = "/tmp/fleetDistribution"                // default = `<os cache dir>/JetBrains/org.jetbrains.fleet-plugin` (see DSL KDoc for more details)
    marketplaceUrl = "https://plugins-mirror.my-company.com"    // default = "https://plugins.jetbrains.com"
  }

  publishing {
    vendorId = "your-vendor-id"                              // default = inferred using a query to Marketplace using specified `publishing.token`
    marketplaceUrl = "https://plugins-mirror.my-company.com" // default = "https://plugins.jetbrains.com"
    token = providers.gradleProperty("myprop")               // default = value of `org.jetbrains.fleet-plugin.marketplaceUploadToken` Gradle property
    channel = "nightly"                                      // default = value of `org.jetbrains.fleet-plugin.marketplaceUploadChannel` Gradle property if set, `stable` otherwise
  }
}
```

## Plugin `org.jetbrains.fleet-plugin-layer`

The `org.jetbrains.fleet-plugin-layer` is a simple `kotlin("multiplatform")` project, as of today, there is no custom DSL for it.
See the [Kotlin Multiplatform DSL Reference][kotlin:multiplatform-dsl] for more information on what is customizable.

Here is still an example on how to declare a dependency, and a custom Kotlin source directory:

```kotlin
kotlin {
  sourceSets {
    jvmMain {
      dependencies {
        // `runtimeOnly` and `implementation` are forbidden here, as every dependency behaves as an `api` in Fleet runtime
        // isolating exposure of dependencies is done via `*Api` vs. `*Impl` layers, please see the section above explaining it.
        api("org.jetbrains.kotlinx:kotlinx-io-core:0.4.0")
      }
      kotlin {
        srcDirs("src/kotlin")                              // default = "src/jvmMain/kotlin"
      }
    }
  }
}
```

[kotlin:multiplatform-dsl]: https://kotlinlang.org/docs/multiplatform-dsl-reference.html
