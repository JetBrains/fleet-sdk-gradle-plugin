# Plugin code's layout

> [!NOTE]
> More layout will be added when the SDK supports other plugin use-cases.

## Example: a theme plugin

```
.
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradle.properties
├── gradlew
├── gradlew.bat
├── my-super-fleet-plugin
│   ├── build.gradle.kts                      // uses `plugins { id("org.jetbrains.fleet-plugin") }`
│   └── frontendImpl
│       ├── build.gradle.kts                  // uses `plugins { id("org.jetbrains.fleet-plugin-layer") }`
│       └── src
│           └── jvmMain
│               ├── java
│               │   └── module-info.java
│               └── kotlin
│                   └── <your .kt code here>
└── settings.gradle.kts                       // specifies `include("my-super-fleet-plugin")` and `include("my-super-fleet-plugin:frontendImpl")`
```
