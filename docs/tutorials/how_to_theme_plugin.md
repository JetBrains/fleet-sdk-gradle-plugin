# How to build a custom theme plugin for Fleet

## Setting up your environment

Follow the [Getting Started][fleet:getting-started] instructions.

## Build your own theme and register it

> [!NOTE]
> Need an example of a theme plugin? See our [Theme plugin example][fleet:theme-plugin-example]

To create your own theme:
1. Create a `.json` file in `my-theme-plugin/frontendImpl/src/jvmMain/resources/`, e.g. `my-super-theme.json`
2. Declare it in your plugin's code in `MyThemePlugin.kt` like so
```kotlin
import fleet.dock.api.ThemeId
import fleet.frontend.theme.registerTheme
import fleet.kernel.plugins.ContributionScope
import fleet.kernel.plugins.Plugin
import fleet.kernel.plugins.PluginScope

class MyThemePlugin : Plugin<Unit> {
    companion object : Plugin.Key<Unit>

    override val key: Plugin.Key<Unit> = MyThemePlugin

    override fun ContributionScope.load(pluginScope: PluginScope) {
        registerTheme(ThemeId(id = "my-super-theme"))
    }
}
```

> [!IMPORTANT]
> The JSON filename (without `.json` extension) must match `ident`, e.g. here `my-super-plugin` is used to point to the `my-super-plugin.json` resource file.

To know more on how to write the content of the JSON file that describes a Fleet Theme, please follow our [Theme Documentation][TODO].

## Run Fleet with your custom theme plugin

A few example themes have been wired in the template for demonstration purposes, let's start Fleet with our custom plugin to check these themes.

### From JetBrains Fleet

1. Open Run dialog
2. Run `Run Fleet with local plugin` Run Configuration

Once Fleet is started, you can use `Color Theme...` action to select your theme and try it out!

### From Terminal

```shell
./gradlew runFleet
```

Once Fleet is started, you can use `Color Theme...` action to select your theme and try it out!

## Limitations & Tips

- Theme plugins are not reloaded automatically, however, you can use `Edit Color Theme...` to tweak your theme, and then copy the JSON opened in your editor to your `.json` theme file

## Documentations

- [Theme Documentation][fleet:theme-documentation]

[gh:template]: https://docs.github.com/en/repositories/creating-and-managing-repositories/creating-a-repository-from-a-template#creating-a-repository-from-a-template
[fleet:template-repo]: https://github.com/JetBrains/fleet-plugin-template
[fleet:theme-documentation]: TODO
[fleet:getting-started]: https://github.com/JetBrains/fleet-sdk-gradle-plugin/blob/main/README.md#getting-started
[fleet:theme-plugin-example]: https://github.com/JetBrains/fleet-sdk-gradle-plugin/tree/main/example-plugins/theme-plugin