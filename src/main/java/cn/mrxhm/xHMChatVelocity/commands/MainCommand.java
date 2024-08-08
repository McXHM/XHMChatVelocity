package cn.mrxhm.xHMChatVelocity.commands;

import cn.mrxhm.xHMChatVelocity.XHMChatVelocity;
import cn.mrxhm.xHMChatVelocity.utils.*;
import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.command.SimpleCommand;
import com.velocitypowered.api.proxy.Player;
import net.kyori.adventure.text.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 插件的主命令
 */
public class MainCommand implements SimpleCommand {
    /**
     * 命令发送者
     */
    CommandSource source;

    /**
     * 命令执行
     *
     * @param invocation 参数等信息
     */
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
        } else if (args.length == 1) {
            if (args[0].equalsIgnoreCase("reload") && source.hasPermission(XCVP.RELOAD.toString())) {
                PlayerConfig.reload();
                GlobalConfig.reload();
                Debug.RELOAD_CONFIG_SUCCESS(source);
            } else {
                Debug.ERROR_NP_PERM(source);
            }
        } else if (args.length >= 3) {
            //参数大于等于3时
            if (args[0].equalsIgnoreCase("setTitle")) {
                //设置称号
                String sender = args[1];
                //args 第三段字符及以后为称号
                String title = String.join(" ", Arrays.copyOfRange(args, 2, args.length));
                if (checkLength(Global.getTitleLength()[0], Global.getTitleLength()[1], title)) {
                    if (isPlayer) {
                        Player player = (Player) source;
                        if (player.getUsername().equalsIgnoreCase(sender) && player.hasPermission(XCVP.SETTITLE_SELF.toString())) {
                            Players.getChatFormat(player).setTitle(title);
                            Debug.SETTITLE_SUCCESS(source);
                        } else {
                            Debug.ERROR_NP_PERM(source);
                        }
                    } else if (source.hasPermission(XCVP.SETTITLE_OTHER.toString())) {
                        Players.getChatFormat(sender).setTitle(title);
                        Debug.SETTITLE_SUCCESS(source);
                    } else {
                        Debug.ERROR_NP_PERM(source);
                    }
                } else {
                    Debug.ERROR_LENGTH(source);
                }
            } else if (args[0].equalsIgnoreCase("setColor")) {
                //设置颜色
                String sender = args[1];
                //args 第三段字符及以后为颜色
                String color = String.join(" ", Arrays.copyOfRange(args, 2, args.length));
                if (checkLength(Global.getColorLength()[0], Global.getColorLength()[1], color)) {
                    if (isPlayer) {
                        Player player = (Player) source;
                        if (player.getUsername().equalsIgnoreCase(sender) && player.hasPermission(XCVP.SETCOLOR_SELF.toString())) {
                            Players.getChatFormat(player).setColor(color);
                            Debug.SETCOLOR_SUCCESS(source);
                        } else {
                            Debug.ERROR_NP_PERM(source);
                        }
                    } else if (source.hasPermission(XCVP.SETCOLOR_OTHER.toString())) {
                        Players.getChatFormat(sender).setColor(color);
                        Debug.SETCOLOR_SUCCESS(source);
                    } else {
                        Debug.ERROR_NP_PERM(source);
                    }
                } else {
                    Debug.ERROR_LENGTH(source);
                }
            } else if (args[0].equalsIgnoreCase("setPrefix")) {
                //设置前缀
                String sender = args[1];
                //args 第三段字符及以后为前缀
                String prefix = String.join(" ", Arrays.copyOfRange(args, 2, args.length));
                if (checkLength(Global.getPrefixLength()[0], Global.getPrefixLength()[1], prefix)) {
                    if (isPlayer) {
                        Player player = (Player) source;
                        if (player.getUsername().equalsIgnoreCase(sender) && player.hasPermission(XCVP.SETPREFIX_SELF.toString())) {
                            Players.getChatFormat(player).setPrefix(prefix);
                            Debug.SETPREFIX_SUCCESS(source);
                        } else {
                            Debug.ERROR_NP_PERM(source);
                        }
                    } else if (source.hasPermission(XCVP.SETPREFIX_OTHER.toString())) {
                        Players.getChatFormat(sender).setPrefix(prefix);
                        Debug.SETPREFIX_SUCCESS(source);
                    } else {
                        Debug.ERROR_NP_PERM(source);
                    }
                } else {
                    Debug.ERROR_LENGTH(source);
                }
            } else if (args[0].equalsIgnoreCase("setSuffix")) {
                //设置后缀
                String sender = args[1];
                //args 第三段字符及以后为后缀
                String suffix = String.join(" ", Arrays.copyOfRange(args, 2, args.length));
                if (checkLength(Global.getSuffixLength()[0], Global.getSuffixLength()[1], suffix)) {
                    if (isPlayer) {
                        Player player = (Player) source;
                        if (player.getUsername().equalsIgnoreCase(sender) && player.hasPermission(XCVP.SETSUFFIX_SELF.toString())) {
                            Players.getChatFormat(player).setSuffix(suffix);
                            Debug.SETSUFFIX_SUCCESS(source);
                        } else {
                            Debug.ERROR_NP_PERM(source);
                        }
                    } else if (source.hasPermission(XCVP.SETSUFFIX_OTHER.toString())) {
                        Players.getChatFormat(sender).setSuffix(suffix);
                        Debug.SETSUFFIX_SUCCESS(source);
                    } else {
                        Debug.ERROR_NP_PERM(source);
                    }
                }
            } else {
                Debug.ERROR_NP_PERM(source);
            }
        } else {
            Debug.ERROR_NP_PERM(source);
        }
        PlayerConfig.save();
    }

    /**
     * 提供命令建议
     *
     * @param invocation 命令参数
     * @return 建议列表
     */
    @Override
    public List<String> suggest(Invocation invocation) {
        String[] args = invocation.arguments();
        List<String> result = new ArrayList<>();
        source = invocation.source();
        boolean isPlayer = source instanceof Player;
        if (args.length == 1) {
            if (source.hasPermission(XCVP.SETTITLE_SELF.toString()) || source.hasPermission(XCVP.SETTITLE_OTHER.toString())) {
                result.add("setTitle");
            }
            if (source.hasPermission(XCVP.SETCOLOR_SELF.toString()) || source.hasPermission(XCVP.SETCOLOR_OTHER.toString())) {
                result.add("setColor");
            }
            if (source.hasPermission(XCVP.SETPREFIX_SELF.toString()) || source.hasPermission(XCVP.SETPREFIX_OTHER.toString())) {
                result.add("setPrefix");
            }
            if (source.hasPermission(XCVP.SETSUFFIX_SELF.toString()) || source.hasPermission(XCVP.SETSUFFIX_OTHER.toString())) {
                result.add("setSuffix");
            }
            if (source.hasPermission(XCVP.RELOAD.toString())) {
                result.add("reload");
            }
        } else if (args.length == 2) {
            if (args[0].equalsIgnoreCase("setTitle")) {
                if (source.hasPermission(XCVP.SETTITLE_SELF.toString())) {
                    if (isPlayer) {
                        result.add(((Player) source).getUsername());
                    }
                }
                if (source.hasPermission(XCVP.SETTITLE_OTHER.toString())) {
                    result.addAll(getPlayerList());
                }
            } else if (args[0].equalsIgnoreCase("setColor")) {
                if (source.hasPermission(XCVP.SETCOLOR_SELF.toString())) {
                    if (isPlayer) {
                        result.add(((Player) source).getUsername());
                    }
                }
                if (source.hasPermission(XCVP.SETCOLOR_OTHER.toString())) {
                    result.addAll(getPlayerList());
                }
            } else if (args[0].equalsIgnoreCase("setPrefix")) {
                if (source.hasPermission(XCVP.SETPREFIX_SELF.toString())) {
                    if (isPlayer) {
                        result.add(((Player) source).getUsername());
                    }
                }
                if (source.hasPermission(XCVP.SETPREFIX_OTHER.toString())) {
                    result.addAll(getPlayerList());
                }
            } else if (args[0].equalsIgnoreCase("setSuffix")) {
                if (source.hasPermission(XCVP.SETSUFFIX_SELF.toString())) {
                    if (isPlayer) {
                        result.add(((Player) source).getUsername());
                    }
                }
                if (source.hasPermission(XCVP.SETSUFFIX_OTHER.toString())) {
                    result.addAll(getPlayerList());
                }
            }
        } else if (args.length == 3) {
            if (args[0].equalsIgnoreCase("setTitle")) {
                if (source.hasPermission(XCVP.SETTITLE_SELF.toString()) || source.hasPermission(XCVP.SETTITLE_OTHER.toString())) {
                    result.add(Players.getFormChatFormat(args[1], "title"));
                }
            } else if (args[0].equalsIgnoreCase("setColor")) {
                if (source.hasPermission(XCVP.SETCOLOR_SELF.toString()) || source.hasPermission(XCVP.SETCOLOR_OTHER.toString())) {
                    result.add(Players.getFormChatFormat(args[1], "color"));
                }
            } else if (args[0].equalsIgnoreCase("setPrefix")) {
                if (source.hasPermission(XCVP.SETPREFIX_SELF.toString()) || source.hasPermission(XCVP.SETPREFIX_OTHER.toString())) {
                    result.add(Players.getFormChatFormat(args[1], "prefix"));
                }
            } else if (args[0].equalsIgnoreCase("setSuffix")) {
                if (source.hasPermission(XCVP.SETSUFFIX_SELF.toString()) || source.hasPermission(XCVP.SETSUFFIX_OTHER.toString())) {
                    result.add(Players.getFormChatFormat(args[1], "suffix"));
                }
            }
        }
        return result;
    }

    /**
     * 获取玩家列表
     *
     * @return 玩家列表
     */
    public List<String> getPlayerList() {
        List<String> result = new ArrayList<>();
        for (Player player : XHMChatVelocity.instance.getServer().getAllPlayers()) {
            result.add(player.getUsername());
        }
        return result;
    }

    /**
     * 发送消息
     *
     * @param msg 消息
     */
    public void sendMsg(String msg) {
        //判断发送者是否为空
        if (source != null) {
            source.sendMessage(Component.text(msg));
        } else {
            Debug.ERROR_NO_SOURCE();
        }
    }

    /**
     * 判断长度
     *
     * @param min 最小长度
     * @param max 最大长度
     * @param msg 消息
     * @return
     */
    public boolean checkLength(int min, int max, String msg) {
        return msg.length() >= min && msg.length() <= max;
    }
}
