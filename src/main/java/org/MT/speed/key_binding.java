package org.MT.speed;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

@EventBusSubscriber(modid = "speed_display", bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class key_binding {

    public static final KeyMapping speed_hud = new KeyMapping(
                "key.speed.display_hud",          // 翻译键
                KeyConflictContext.IN_GAME,      // 只在游戏内生效
                InputConstants.Type.KEYSYM,
                GLFW.GLFW_KEY_Z,                 // 默认按键Z
                "category.speed_display"
        );

    @SubscribeEvent
    public static void registerKeys(RegisterKeyMappingsEvent event) {
            event.register(speed_hud);
    }
}

