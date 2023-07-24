package io.github.sinhajun.sit.event
import io.github.sinhajun.sit.action.sit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractEvent

class SitStair : Listener {
    @EventHandler
    fun onClick(event: PlayerInteractEvent) {
        val block = event.clickedBlock
        val player = event.player
        if (block != null) {
            val material = block.type
            if (material.toString() in "STAIRS") {
                player.sit(block.location)
            }
        }
    }
}