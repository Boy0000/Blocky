package com.mineinabyss.blocky.plugin

import org.bukkit.command.CommandSender

import org.bukkit.command.defaults.BukkitCommand


class HelloCommand(name: String?) : BukkitCommand(name!!) {
    init {
        permission = "example.hello"
    }

    override fun execute(commandSender: CommandSender, currentAlias: String, args: Array<String>): Boolean {
        if (!testPermission(commandSender)) {
            return true
        } else {
            commandSender.sendMessage("BLocky-Mixin Loaded")
        }
        return false
    }
}