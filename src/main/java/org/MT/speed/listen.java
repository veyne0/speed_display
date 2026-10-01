package org.MT.speed;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

@EventBusSubscriber(modid = "speed_display",value= Dist.CLIENT)
public class listen {
    public static boolean p = true ;

    public static double s_playerspeed = 0;
    public static double c_playerspeed = 0;

    @SubscribeEvent
    public static void onPlayerTick(ClientTickEvent.Post event) {
        LocalPlayer player = Minecraft.getInstance().player;
        if (player == null) return;
        double s_speed = coordinates.speed(player);

        if (s_speed >= 0) {
            s_playerspeed = s_speed;
        }

    }

    @SubscribeEvent
    public static void onClientTick(ClientTickEvent.Post event) {
        if (key_binding.speed_hud.consumeClick()) {
            p = !p;
        }
    }
}