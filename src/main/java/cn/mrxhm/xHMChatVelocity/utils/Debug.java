package cn.mrxhm.xHMChatVelocity.utils;

import cn.mrxhm.xHMChatVelocity.XHMChatVelocity;
import com.velocitypowered.api.command.CommandSource;
import net.kyori.adventure.text.Component;

/**
 * Debug
 */
public class Debug {
    /**
     * 日志
     *
     * @param msg 消息
     */
    public static void log(String msg) {
        XHMChatVelocity.instance.getLogger().info(msg.replaceAll("&", "§"));
    }

    /**
     * 发送消息
     *
     * @param msg    消息
     * @param source 发送者
     */
    public static void sendMessage(String msg, CommandSource source) {
        source.sendMessage(Component.text(msg.replace("&", "§")));
    }

    /**
     * 未找到命令发送者
     */
    public static void ERROR_NO_SOURCE() {
        log("&c未找到命令发送者");
    }

    /**
     * 读取配置文件失败
     */
    public static void ERROR_READ_CONFIG() {
        log("&c读取配置文件失败");
    }

    /**
     * 读取配置文件成功
     */
    public static void READ_CONFIG_SUCCESS() {
        log("&a读取配置文件成功");
    }

    /**
     * 重载配置文件成功
     *
     * @param source 发送者
     */
    public static void RELOAD_CONFIG_SUCCESS(CommandSource source) {
        sendMessage("&a重载配置文件成功", source);
    }

    /**
     * 设置称号成功
     *
     * @param source 发送者
     */
    public static void SETTITLE_SUCCESS(CommandSource source) {
        sendMessage("&a设置称号成功", source);
    }

    /**
     * 设置颜色成功
     *
     * @param source 发送者
     */
    public static void SETCOLOR_SUCCESS(CommandSource source) {
        sendMessage("&a设置颜色成功", source);
    }

    /**
     * 设置前缀成功
     *
     * @param source 发送者
     */
    public static void SETPREFIX_SUCCESS(CommandSource source) {
        sendMessage("&a设置前缀成功", source);
    }

    /**
     * 设置后缀成功
     *
     * @param source 发送者
     */
    public static void SETSUFFIX_SUCCESS(CommandSource source) {
        sendMessage("&a设置后缀成功", source);
    }

    /**
     * 通用长度方法
     *
     * @param source 命令发送者
     */
    public static void ERROR_LENGTH(CommandSource source) {
        sendMessage("&c长度过长或过短", source);
    }

    public static void ERROR_NP_PERM(CommandSource source) {
        sendMessage("&c权限不足或语法错误", source);
    }
}
