package com.mineinabyss.blocky.plugin

import com.mineinabyss.blocky.example.ExampleConfig
import com.mineinabyss.blocky.example.ExampleInfo.exampleConfig
import org.objectweb.asm.tree.ClassNode
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin
import org.spongepowered.asm.mixin.extensibility.IMixinInfo
import org.spongepowered.configurate.CommentedConfigurationNode
import space.vectrix.ignite.api.config.Configuration
import space.vectrix.ignite.api.config.Configurations


class BlockyMixinPlugin : IMixinConfigPlugin {
    override fun onLoad(mixinPackage: String) {
    }

    override fun getRefMapperConfig(): String? {
        return null
    }

    override fun shouldApplyMixin(targetClassName: String?, mixinClassName: String?): Boolean {
        val configWrapper: Configuration<ExampleConfig, CommentedConfigurationNode> =
            Configurations.getOrCreate(Configurations.HOCON_LOADER, exampleConfig)
        val config: ExampleConfig = configWrapper.instance()
        return config.test()

    }

    override fun acceptTargets(myTargets: MutableSet<String>?, otherTargets: MutableSet<String>?) {
    }

    override fun getMixins(): MutableList<String>? {
        return null
    }

    override fun preApply(
        targetClassName: String?,
        targetClass: ClassNode?,
        mixinClassName: String?,
        mixinInfo: IMixinInfo?
    ) {
    }

    override fun postApply(
        targetClassName: String?,
        targetClass: ClassNode?,
        mixinClassName: String?,
        mixinInfo: IMixinInfo?
    ) {
    }
}