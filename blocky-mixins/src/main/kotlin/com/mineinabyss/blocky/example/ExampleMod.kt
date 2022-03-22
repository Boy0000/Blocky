package com.mineinabyss.blocky.example

import com.google.inject.Inject
import org.apache.logging.log4j.Logger
import org.spongepowered.configurate.CommentedConfigurationNode
import space.vectrix.ignite.api.Platform
import space.vectrix.ignite.api.config.Configuration
import space.vectrix.ignite.api.config.Configurations
import space.vectrix.ignite.api.event.Subscribe
import space.vectrix.ignite.api.event.platform.PlatformInitializeEvent


class ExampleMod @Inject constructor(
    private val logger: Logger,
    private val platform: Platform
) {
    @Subscribe
    fun onInitialize(event: PlatformInitializeEvent) {
        logger.info("Hello Example!")
        val configWrapper: Configuration<ExampleConfig, CommentedConfigurationNode> =
            Configurations.getOrCreate(Configurations.HOCON_LOADER, ExampleInfo.EXAMPLE_CONFIG!!)
        val config: ExampleConfig? = configWrapper.instance()
        if (config != null) {
            logger.info("Foo is set to: " + if (config.container()?.foo() == true) "Enabled" else "Disabled")
        }
    }
}