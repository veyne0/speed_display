package org.MT.speed;

import net.minecraft.client.Minecraft;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;
import net.neoforged.neoforge.client.gui.VanillaGuiLayers;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import java.awt.*;
import java.text.DecimalFormat;

import static java.awt.Color.white;
import static org.MT.speed.coordinates.chuizhi_speed;
import static org.MT.speed.coordinates.shuiping_speed;
import static org.MT.speed.listen.*;
import net.minecraft.network.chat.Component;
@EventBusSubscriber(modid = "speed_display", bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class hud {
    @SubscribeEvent
    public static void onRegisterGuiLayers(RegisterGuiLayersEvent event){

        event.registerAbove(
                VanillaGuiLayers.HOTBAR,
                net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("speed_display", "my_hud"),
                (guiGraphics, deltaTracker) -> {
                    DecimalFormat a = new DecimalFormat("0.00");
                    Component text1;
                    Component text ;

                    if (listen.p){
                        text =Component.translatable("shuiping_speed",a.format(shuiping_speed));
                        text1 = Component.translatable("chuizhi_speed",a.format(chuizhi_speed));


                    }else { text1=Component.literal(""); text =Component.literal("") ;}


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
                    guiGraphics.drawString(
                            Minecraft.getInstance().font,
                            text1,
                            x,
                            y+10,
                            color,
                            shadow
                    );


                }
        );
    }
}
