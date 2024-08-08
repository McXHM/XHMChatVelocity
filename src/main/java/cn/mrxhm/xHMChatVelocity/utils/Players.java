package cn.mrxhm.xHMChatVelocity.utils;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import com.velocitypowered.api.proxy.Player;

import java.util.HashMap;
import java.util.Map;

public class Players {
    public static HashMap<String, ChatFormat> players = new HashMap<>();

    public static ChatFormat getChatFormat(Player player) {
        if (player != null) {
            return getChatFormat(player.getUsername());
        } else {
            return new ChatFormat();
        }
    }

    public static ChatFormat getChatFormat(String name) {
        if (!players.containsKey(name)){
            players.put(name,new ChatFormat());
        }
        return players.get(name);
    }

    public static String getFormChatFormat(Player player, String arg) {
        if (player != null) {
            return getFormChatFormat(player.getUsername(), arg);
        } else {
            return "";
        }
    }

    public static String getFormChatFormat(String name, String arg) {
        if (!players.containsKey(name)) {
            players.put(name, new ChatFormat());
        }
        switch (arg) {
            case "title" -> {
                return players.get(name).getTitle();
            }
            case "color" -> {
                return players.get(name).getColor();
            }
            case "prefix" -> {
                return players.get(name).getPrefix();
            }
            case "suffix" -> {
                return players.get(name).getSuffix();
            }
            default -> {
                return "";
            }
        }
    }

    public static void init() {
        try {
            String configContent = PlayerConfig.readConfig();
            if (configContent != null && !configContent.trim().isEmpty()) {
                // 使用 TypeReference 来指定期望的类型
                Map<String, ChatFormat> tempPlayers = JSON.parseObject(configContent, new TypeReference<Map<String, ChatFormat>>(){});
                // 使用新的 HashMap 来避免直接赋值可能的问题
                players = new HashMap<>(tempPlayers);
            } else {
                // 如果配置内容为空，初始化一个空的 HashMap
                players = new HashMap<>();
            }
        } catch (Exception e) {
            // 处理解析错误或类型不匹配的情况
            Debug.ERROR_READ_CONFIG();
            // 可以选择记录日志或抛出异常，根据实际需要
            e.printStackTrace();
        }
    }
}
