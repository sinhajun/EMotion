package io.github.sinhajun.sit.command

import io.github.monun.kommand.kommand
import io.github.sinhajun.plugin.JavaPlugin
import io.github.sinhajun.sit.action.sit
import org.bukkit.entity.Player

object Sit {
    fun registerCommand(plugin: JavaPlugin) {
        plugin.kommand {
            register("sit") {
                requires { isPlayer }
                executes {
                    (sender as Player).sit((sender as Player).location)
                }
            }
        }
    }
}