[![official JetBrains project](https://jb.gg/badges/official.svg)][jb:github]
[![Twitter Follow](https://img.shields.io/twitter/follow/jetbrains_fleet?style=flat&logo=twitter)][jb:twitter]

# Fleet SDK Gradle Plugins

The Fleet SDK is a collection of plugins for the Gradle build system to help configuring your environment for building and publishing
plugins for Fleet.

> [!CAUTION]
> 🚧 Building Fleet plugins is not yet available publically, this repository is under construction, links and instructions will not work. 🚧

## Getting started

1. Use the [Fleet Theme Plugin template][fleet:template-repo] to bootstrap your plugin's repository
2. (optional) Once ready to publish your plugin, follow the [Marketplace Publishing Setup][fleet:marketplace-publishing]
3. (optional) Take a look at [example plugins directory][fleet:example-plugins]

## Gradle tasks

Here is the list of tasks that the Fleet SDK Gradle plugin provide to your project:

| Task name                 | Command                                                                                   | Description                                                                                                                  | Requires Marketplace Token       |
|---------------------------|-------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------|----------------------------------|
| runFleet                  | `./gradlew runFleet`                                                                      | runs Fleet locally with your plugin and its dependencies automatically loaded                                                | No                               |
| distZip                   | `./gradlew distZip -Porg.jetbrains.fleet-plugin.marketplaceUploadToken=<your_token>`      | assembles a `.zip` containing metadata, your plugin layers jars and all dependency jars that are relevant, ready for upload. | Yes, to infer vendor information |
| uploadPlugin              | `./gradlew uploadPlugin -Porg.jetbrains.fleet-plugin.marketplaceUploadToken=<your_token>` | uploads the distribution built by `distZip` to Marketplace.                                                                  | Yes                              |
| deleteAllDownloadedCaches | `./gradlew deleteAllDownloadedCaches`                                                     | Deletes all caches downloaded by the `org.jetbrains.fleet-plugin` (/!\ regardless of the Gradle project)                     | No                               |

## Documentations

1. [Fleet Plugin documentation][fleet:plugin-docs]
1. [SDK configuration (DSLs)](./docs/dsl.md), to know more about how to configure the SDK
3. [Example plugins][fleet:example-plugins]
4. [Layout of plugin's code built using the SDK](./docs/code_layout.md)
5. TODO: add Fleet API documentation here
6. TODO: add Fleet Theme documentation here

<!-- ---------------- -->

[jb:twitter]: https://twitter.com/jetbrains_fleet
[jb:github]: https://github.com/JetBrains/.github/blob/main/profile/README.md
[fleet:template-repo]: https://github.com/JetBrains/fleet-plugin-template
[fleet:plugin-docs]: https://jetbrains.team/p/fleet-plugins-private-preview/repositories/fleet-plugins-docs
[fleet:example-plugins]: ./example-plugins/README.md
[fleet:marketplace-publishing]: ./docs/marketplace_publishing_setup.md
