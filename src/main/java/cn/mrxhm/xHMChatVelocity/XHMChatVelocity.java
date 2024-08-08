package cn.mrxhm.xHMChatVelocity;

import cn.mrxhm.xHMChatVelocity.commands.MainCommand;
import cn.mrxhm.xHMChatVelocity.events.SendMsgEvent;
import cn.mrxhm.xHMChatVelocity.utils.Global;
import cn.mrxhm.xHMChatVelocity.utils.GlobalConfig;
import cn.mrxhm.xHMChatVelocity.utils.PlayerConfig;
import cn.mrxhm.xHMChatVelocity.utils.Players;
import com.google.inject.Inject;
import com.velocitypowered.api.command.CommandManager;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.plugin.annotation.DataDirectory;
import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.proxy.ProxyServer;
import org.slf4j.Logger;

import java.nio.file.Path;

@Plugin(
        id = "xhmchatvelocity",
        name = "XHMChatVelocity",
        version = "1.0-SNAPSHOT",
        description = "A Chat Plugin For Velocity"
        , authors = {"Mr_XHM"}
)
/**
 * 本插件的主类
 */
public class XHMChatVelocity {
    //插件实例
    public static XHMChatVelocity instance;
    //服务器实例
    private final ProxyServer server;
    //日志实例
    private final Logger logger;
    //数据目录
    private final Path dataDirectory;

    //构造器
    @Inject
    public XHMChatVelocity(ProxyServer server, Logger logger, @DataDirectory Path dataDirectory) {
        this.server = server;
        this.logger = logger;
        this.dataDirectory = dataDirectory;
    }

    //侦听器 -> 当插件启动时 -> 初始化配置文件
    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        instance = this;
        logger.info("""
                 欢迎使用XHMChatVelocity插件！
                 __   __      __  __                  ____       __  __      ______      ______  \s
                /\\ \\ /\\ \\    /\\ \\/\\ \\     /'\\_/`\\    /\\  _`\\    /\\ \\/\\ \\    /\\  _  \\    /\\__  _\\ \s
                \\ `\\`\\/'/'   \\ \\ \\_\\ \\   /\\      \\   \\ \\ \\/\\_\\  \\ \\ \\_\\ \\   \\ \\ \\L\\ \\   \\/_/\\ \\/ \s
                 `\\/ > <      \\ \\  _  \\  \\ \\ \\__\\ \\   \\ \\ \\/_/_  \\ \\  _  \\   \\ \\  __ \\     \\ \\ \\ \s
                    \\/'/\\`\\    \\ \\ \\ \\ \\  \\ \\ \\_/\\ \\   \\ \\ \\L\\ \\  \\ \\ \\ \\ \\   \\ \\ \\/\\ \\     \\ \\ \\\s
                    /\\_\\\\ \\_\\   \\ \\_\\ \\_\\  \\ \\_\\\\ \\_\\   \\ \\____/   \\ \\_\\ \\_\\   \\ \\_\\ \\_\\     \\ \\_\\
                    \\/_/ \\/_/    \\/_/\\/_/   \\/_/ \\/_/    \\/___/     \\/_/\\/_/    \\/_/\\/_/      \\/_/
                                                                                                 \s
                                                                                                 \s""");
        CommandManager manager = server.getCommandManager();
        manager.register("xhmchatvelocity", new MainCommand(), "xcv");
        server.getEventManager().register(this, new SendMsgEvent());
        PlayerConfig.loadConfig();
        GlobalConfig.loadConfig();
        Players.init();
        Global.init();
        PlayerConfig.saveConfig();
        GlobalConfig.saveConfig();
        for (Player p : server.getAllPlayers()) {
            //若玩家有OP，则给予其权限
            if (p.hasPermission("operator")) {

            }
        }
    }

    //获取服务器实例
    public ProxyServer getServer() {
        return server;
    }

    //获取日志实例
    public Logger getLogger() {
        return logger;
    }

    //获取数据目录
    public Path getDataDirectory() {
        return dataDirectory;
    }
}
