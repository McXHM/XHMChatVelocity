package cn.mrxhm.xHMChatVelocity.events;

import cn.mrxhm.xHMChatVelocity.utils.Broadcast;
import cn.mrxhm.xHMChatVelocity.utils.Debug;
import cn.mrxhm.xHMChatVelocity.utils.Global;
import cn.mrxhm.xHMChatVelocity.utils.Players;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.player.PlayerChatEvent;
import com.velocitypowered.api.proxy.Player;

/**
 * 侦听聊天事件
 */
public class SendMsgEvent {
    /**
     * 发送消息事件
     * @param event 聊天事件
     */
    @Subscribe
    public void onSendMsgEvent(PlayerChatEvent event) {
        String msg = event.getMessage();
        Player player = event.getPlayer();
        String name = player.getUsername();
        String title = Players.getFormChatFormat(player,"title");
        String color = Players.getFormChatFormat(player,"color");
        String prefix = Players.getFormChatFormat(player,"prefix");
        String suffix = Players.getFormChatFormat(player,"suffix");
        String server = player.getCurrentServer().get().getServerInfo().getName();
        String format = Global.global.getFormat()
                .replaceAll("%xcv_server%",server)
                .replaceAll("%xcv_name%",name)
                .replaceAll("%xcv_message%",msg)
                .replaceAll("%xcv_title%",title)
                .replaceAll("%xcv_color%",color)
                .replaceAll("%xcv_prefix%",prefix)
                .replaceAll("%xcv_suffix%",suffix);
        event.setResult(PlayerChatEvent.ChatResult.denied());
        Broadcast.broadcast(format);
    }
}
