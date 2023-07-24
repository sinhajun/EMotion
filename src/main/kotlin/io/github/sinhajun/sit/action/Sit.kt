package io.github.sinhajun.sit.action

import io.github.sinhajun.plugin.plugin
import org.bukkit.Location
import org.bukkit.entity.ArmorStand
import org.bukkit.entity.Arrow
import org.bukkit.entity.Player
import org.bukkit.scheduler.BukkitRunnable


val Player.isSit: Boolean
    get() = this.vehicle?.customName == this.name

fun Player.sit(location: Location) {
    if (!this.isSit) {
        if (this.isOnGround) {
            val markerSpawnLocation = location.add(0.0, -0.3, 0.0)
            val marker = this.world.spawn(markerSpawnLocation, ArmorStand::class.java).apply {
                isMarker = true
                isInvisible = true
                isSmall = true
                isInvulnerable = true
                customName = this@sit.name
                isCustomNameVisible = false
                setGravity(false)
                this.addPassenger(this@sit)
            }
            object : BukkitRunnable() {
                override fun run() {
                    if (this@sit.isSneaking) {
                        this@sit.teleport(location.add(0.0, 0.8, 0.0))
                        plugin.logger.info("$location")
                        marker.remove()
                        cancel()
                    }
                }
            }.runTaskTimer(plugin, 0L, 0L)
        }
    }
}