package io.github.sinhajun.plugin

import io.github.sinhajun.sit.command.Sit
import io.github.sinhajun.sit.event.SitStair
import org.bukkit.plugin.java.JavaPlugin

lateinit var plugin: JavaPlugin

class JavaPlugin : JavaPlugin() {
    override fun onEnable() {
        plugin = this
//        server.pluginManager.registerEvents(SitStair(), this)
        Sit.registerCommand(this)
    }
}