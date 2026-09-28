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

    public static double speed(ServerPlayer player){
        UUID uuid = player.getUUID();
        int count = counters.getOrDefault(uuid , 0 ) + 1 ;
        if (count >=20){
            count = 0;
            Vec3 now = player.position();
            Vec3 last = lastPositions.get(uuid);
            lastPositions.put(uuid,now);


            if (last != null ){
                double x = last.x - now.x;
                double y = last.y - now.y;
                double z = last.z - now.z;
                double speed = Math.sqrt(x*x + y*y + z*z);
                return speed ;
            }

        }
        counters.put(uuid,count);
        return -1;


    }


}

