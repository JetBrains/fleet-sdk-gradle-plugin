package fleet.sample.frontendImpl

import fleet.dock.api.ThemeId
import fleet.frontend.theme.registerTheme
import fleet.kernel.plugins.ContributionScope
import fleet.kernel.plugins.Plugin
import fleet.kernel.plugins.PluginScope

class MyPlugin : Plugin<Unit> {
    companion object : Plugin.Key<Unit>

    override val key: Plugin.Key<Unit> = MyPlugin

    override fun ContributionScope.load(pluginScope: PluginScope) {
        registerTheme(ThemeId(id = "example-blue-background-tint"))
        registerTheme(ThemeId(id = "example-green-tab-colors"))
        registerTheme(ThemeId(id = "example-high-contrast-text"))
        registerTheme(ThemeId(id = "example-no-syntax-highlighting"))
    }
}
