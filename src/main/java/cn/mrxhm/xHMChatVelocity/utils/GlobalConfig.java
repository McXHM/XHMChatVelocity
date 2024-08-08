package cn.mrxhm.xHMChatVelocity.utils;

import cn.mrxhm.xHMChatVelocity.XHMChatVelocity;
import com.alibaba.fastjson2.JSON;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class GlobalConfig {
    public static File config;
    public static String path = XHMChatVelocity.instance.getDataDirectory() + "\\" + "global.json";

    //加载global.json文件并储存到config中
    public static void loadConfig() {
        File file = new File(path);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        config = file;
    }

    //读取global.json文件
    public static String readConfig() {
        try {
            FileInputStream fis = new FileInputStream(config);
            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);
            return new String(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Debug.ERROR_READ_CONFIG();
        return "null";
    }

    public static void saveConfig() {
        String json = JSON.toJSONString(Global.global);
        try {
            FileOutputStream fos = new FileOutputStream(config);
            fos.write(json.getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void reload() {
        loadConfig();
        Global.init();
        saveConfig();
    }
    public static void save() {
        saveConfig();
        loadConfig();
        Global.init();
    }
}
