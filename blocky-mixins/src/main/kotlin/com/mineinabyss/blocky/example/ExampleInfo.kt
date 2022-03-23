package com.mineinabyss.blocky.example

import org.checkerframework.checker.nullness.qual.MonotonicNonNull
import space.vectrix.ignite.api.Blackboard
import space.vectrix.ignite.api.config.Configuration
import java.nio.file.Path


object ExampleInfo {
    private val CONFIGS_PATH = Blackboard.getProperty(Blackboard.CONFIG_DIRECTORY_PATH)
    private var EXAMPLE_PATH: @MonotonicNonNull Path? = null
    var EXAMPLE_CONFIG: @MonotonicNonNull Configuration.Key<ExampleConfig>? = null
    val examplePath: @MonotonicNonNull Path?
        get() {
            if (EXAMPLE_PATH != null) return EXAMPLE_PATH
            return CONFIGS_PATH?.resolve("example")?.also { EXAMPLE_PATH = it }
        }
    val exampleConfig: Configuration.Key<ExampleConfig>
        get() {
            if (EXAMPLE_CONFIG != null) return EXAMPLE_CONFIG!!
            val examplePath = examplePath ?: throw IllegalStateException("Unable to locate example path.")
            return Configuration.key(ExampleConfig::class.java, examplePath.resolve("example.conf")).also {
                EXAMPLE_CONFIG = it
            }
        }
}