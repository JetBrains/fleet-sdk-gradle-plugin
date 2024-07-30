[![official JetBrains project](https://jb.gg/badges/official.svg)][jb:github]
[![Twitter Follow](https://img.shields.io/twitter/follow/jetbrains_fleet?style=flat&logo=twitter)][jb:twitter]

# JetBrains Fleet SDK Gradle Plugins

The JetBrains Fleet SDK is a collection of plugins for the [Gradle][gradle] build system to help to configure your environment for building
and publishing plugins for [JetBrains Fleet][fleet:website].

## Getting started

1. Use the [JetBrains Fleet Theme Plugin template][fleet:theme-plugin-template-repository] to bootstrap your plugin's repository
2. Specify in `my-theme-plugin/build.gradle.kts` (you will find commented out value to replace in that file)
    1. your plugin `fleetPlugin.id`
    2. your plugin `fleetPlugin.metadata.readableName`
    3. your plugin `fleetPlugin.metadata.description`
3. (optional) Feel free to rename `my-theme-plugin` directory, but don't forget to update values in `settings.gradle.kts`'s `include()` when doing so. 
4. (optional) Once ready to publish your plugin, follow the [Marketplace Publishing Setup][fleet:marketplace-publishing]
5. (optional) Take a look at [example plugins][fleet:example-plugins]

## Gradle tasks

Here is the list of tasks that the JetBrains Fleet SDK Gradle plugin provide to your project:

| Task name                 | Command                                                                                   | Description                                                                                                                  | Requires Marketplace Token       |
|---------------------------|-------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------|----------------------------------|
| runFleet                  | `./gradlew runFleet`                                                                      | runs Fleet locally with your plugin and its dependencies automatically loaded                                                | No                               |
| distZip                   | `./gradlew distZip -Porg.jetbrains.fleet-plugin.marketplaceUploadToken=<your_token>`      | assembles a `.zip` containing metadata, your plugin layers jars and all dependency jars that are relevant, ready for upload. | Yes, to infer vendor information |
| uploadPlugin              | `./gradlew uploadPlugin -Porg.jetbrains.fleet-plugin.marketplaceUploadToken=<your_token>` | uploads the distribution built by `distZip` to Marketplace.                                                                  | Yes                              |
| deleteAllDownloadedCaches | `./gradlew deleteAllDownloadedCaches`                                                     | Deletes all caches downloaded by the `org.jetbrains.fleet-plugin` (/!\ regardless of the Gradle project)                     | No                               |

## Documentations

- [Example plugins][fleet:example-plugins]
- TODO: [Theme Documentation]<!--TODO: [fleet:theme-documentation]-->
- TODO: [Fleet API documentation]<!--TODO: [fleet:api-documentation]-->
- [SDK configuration (DSLs)](./docs/dsl.md), to know more about how to configure the SDK
- [Layout of plugin's code built using the SDK](./docs/code_layout.md)

[jb:twitter]: https://twitter.com/jetbrains_fleet
[jb:github]: https://github.com/JetBrains/.github/blob/main/profile/README.md
[gradle]: https://gradle.org/
[fleet:website]: https://www.jetbrains.com/fleet/
[fleet:theme-plugin-template-repository]: https://github.com/JetBrains/fleet-theme-plugin-template
[fleet:marketplace-publishing]: ./docs/marketplace_publishing_setup.md
[fleet:plugin-docs]: https://jetbrains.team/p/fleet-plugins-private-preview/repositories/fleet-plugins-docs
[fleet:example-plugins]: examples/README.md
