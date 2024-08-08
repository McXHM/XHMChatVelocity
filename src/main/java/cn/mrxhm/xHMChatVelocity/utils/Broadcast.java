package cn.mrxhm.xHMChatVelocity.utils;

import cn.mrxhm.xHMChatVelocity.XHMChatVelocity;
import com.velocitypowered.api.proxy.Player;
import net.kyori.adventure.text.Component;

/**
 * 广播器
 */
public class Broadcast {
    /**
     * 广播消息
     * @param message 消息
     */
    public static void broadcast(String message) {
        // TODO: 实现广播功能
        for (Player player : XHMChatVelocity.instance.getServer().getAllPlayers()) {
            player.sendMessage(Component.text(message.replaceAll("&", "§")));
        }
    }
}
