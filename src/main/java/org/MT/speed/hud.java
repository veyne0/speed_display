package org.MT.speed;

import net.minecraft.client.Minecraft;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;
import net.neoforged.neoforge.client.gui.VanillaGuiLayers;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import java.text.DecimalFormat;

import static java.awt.Color.white;
import static org.MT.speed.coordinates.speed;
import static org.MT.speed.listen.playerspeed;

@EventBusSubscriber(modid = "speed_display", bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class hud {
    @SubscribeEvent
    public static void onRegisterGuiLayers(RegisterGuiLayersEvent event) {
        // 注册一个绘制层，ID 为 speed:my_hud
        event.registerAbove(
                VanillaGuiLayers.HOTBAR,
                net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("speed_display", "my_hud"),
                (guiGraphics, deltaTracker) -> {
                    DecimalFormat a = new DecimalFormat("0.00");

                    String text = "当前速度为" + a.format(playerspeed) + "m/s" ;
                    int x = 10;
                    int y = 10;
                    int color = 0xFFFFFF; // 白色
                    boolean shadow = true;

                    guiGraphics.drawString(
                            Minecraft.getInstance().font,
                            text,
                            x,
                            y,
                            color,
                            shadow
                    );
                }
        );
    }
}
