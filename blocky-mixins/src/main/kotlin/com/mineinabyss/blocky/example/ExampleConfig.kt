package com.mineinabyss.blocky.example

import org.spongepowered.configurate.objectmapping.ConfigSerializable
import org.spongepowered.configurate.objectmapping.meta.Comment
import org.spongepowered.configurate.objectmapping.meta.Setting


@ConfigSerializable
class ExampleConfig {
    @Setting(value = "test")
    @Comment(value = "Test configuration property.")
    private val test = false

    @Setting(value = "container")
    @Comment(value = "A test container.")
    private val container: TestContainer? = null
    fun test(): Boolean {
        return test
    }

    fun container(): TestContainer? {
        return container
    }

    @ConfigSerializable
    class TestContainer {
        @Setting(value = "foo")
        @Comment(value = "A test boolean in a container.")
        private val foo = false
        fun foo(): Boolean {
            return foo
        }
    }
}