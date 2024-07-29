# Marketplace publishing setup

To build a distribution and publish the Fleet plugin, a Marketplace vendor and a Marketplace token is required.

1. Create a vendor [here][fleet:marketplace-vendor-creation-page]
2. Generate a Marketplace token [here][fleet:marketplace-token-page]
3. Set the Marketplace token in `org.jetbrains.fleet-plugin.marketplaceUploadToken` Gradle property, there is multiple options for that:
   1. add `org.jetbrains.fleet-plugin.marketplaceUploadToken=your_token_here` in `$HOME/.gradle/gradle.properties` (macOS, Linux) or `C:\Users\<USERNAME>\.gradle\gradle.properties` (Windows)
   2. or, export an environment variable `ORG_GRADLE_PROJECT_org.jetbrains.fleet-plugin.marketplaceUploadToken` which value is the token
   3. or, specify `-Porg.jetbrains.fleet-plugin.marketplaceUploadToken=your_token_here` when using `./gradlew`
4. `distZip` and `uploadPlugin` Gradle tasks are now usable

[fleet:marketplace-vendor-creation-page]: https://plugins.jetbrains.com/vendor/new
[fleet:marketplace-token-page]: https://plugins.jetbrains.com/author/me/tokens
