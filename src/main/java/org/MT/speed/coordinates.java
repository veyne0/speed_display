package org.MT.speed;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class coordinates{
    private static final Map<UUID, Vec3> lastPositions = new HashMap<>();

    private static final Map<UUID, Integer> counters = new HashMap<>();
    public static double chuizhi_speed = 0;
    public static double shuiping_speed=0;
    public static double smooth=0.3;

    public static double speed(ServerPlayer player){
        UUID uuid = player.getUUID();
        int count = counters.getOrDefault(uuid , 0 ) + 1 ;
        if (count >=20){
            count = 0;
            Vec3 now = player.position();
            Vec3 last = lastPositions.get(uuid);
            lastPositions.put(uuid,now);

            if (last != null ){
                double x = now.x - last.x;
                double z = now.z - last.z;
                double y = now.y - last.y;
                double chui_speed = Math.sqrt(y*y);
                chuizhi_speed=chui_speed *smooth + chui_speed *(1-smooth);
                double shui_speed = Math.sqrt(x*x+ z*z);
                shuiping_speed=shui_speed *smooth +shui_speed * (1-smooth);
                counters.put(uuid,count);

            }
        }
        counters.put(uuid,count);

        return -1.00000000000000;
    }

}

