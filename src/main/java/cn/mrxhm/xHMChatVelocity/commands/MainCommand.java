package cn.mrxhm.xHMChatVelocity;

import cn.mrxhm.xHMChatVelocity.utils.Debug;
import cn.mrxhm.xHMChatVelocity.utils.Players;
import cn.mrxhm.xHMChatVelocity.utils.XCVP;
import com.velocitypowered.api.command.Command;
import com.velocitypowered.api.command.CommandManager;
import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.command.SimpleCommand;
import com.velocitypowered.api.proxy.Player;
import net.kyori.adventure.text.Component;

import java.util.Arrays;

public class MainCommand implements SimpleCommand {
    //命令的发送者
    CommandSource source;

    @Override
    public void execute(Invocation invocation) {
        // 获取命令参数
        String[] args = invocation.arguments();
        // 获取命令发送者
        source = invocation.source();
        // 检测命令发送者是否为玩家
        boolean isPlayer = source instanceof Player;
        // 根据参数执行不同的操作
        if (args.length == 0) {
            //无参数时，发送欢迎信息
            sendMsg("欢迎使用XHMChatVelocity插件！");
        } else if (args.length >= 3) {
            //参数大于等于3时
            if (args[0].equalsIgnoreCase("setTitle"))){
                //设置称号
                String sender = args[1];
                //args 第三段字符及以后为称号
                String title = String.join(" ", Arrays.copyOfRange(args, 2, args.length));
                if (isPlayer){
                    Player player = (Player) source;
                    if(player.getUsername().equalsIgnoreCase(sender)&&player.hasPermission(XCVP.SETTITLE_SELF.toString())){
                        Players.getChatFormat(player).setTitle(title);
                    }
                }
            }
        }
    }

    //简化的sendMsg方法
    public void sendMsg(String msg) {
        //判断发送者是否为空
        if (source != null) {
            source.sendMessage(Component.text(msg));
        } else {
            Debug.ERROR_NO_SOURCE();
        }
    }
}
