package cn.mrxhm.xHMChatVelocity.utils;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.annotation.JSONField;

/**
 * 全局配置类
 *
 * @author Mr_XHM
 */
public class Global {
    /**
     * 全局配置对象
     */
    @JSONField(serialize = false)
    public static Global global;
    /**
     * 格式
     */
    @JSONField(ordinal = 0)
    public String format;
    /**
     * 称号长度
     */
    @JSONField(ordinal = 1)
    public int[] titleLength;
    /**
     * 颜色长度
     */
    @JSONField(ordinal = 2)
    public int[] colorLength;
    /**
     * 前缀长度
     */
    @JSONField(ordinal = 3)
    public int[] prefixLength;
    /**
     * 后缀长度
     */
    @JSONField(ordinal = 4)
    public int[] suffixLength;

    /**
     * 默认构造方法
     */
    public Global() {
        format = "&7%xcv_server% -> &e『&r%xcv_title%&e』&b%xcv_name% &e>> &r%xcv_prefix%&r%xcv_color%%xcv_message%&r%xcv_suffix%";
        titleLength = new int[]{1, 16};
        colorLength = new int[]{1, 8};
        prefixLength = new int[]{1, 16};
        suffixLength = new int[]{1, 16};
    }

    /**
     * 构造方法
     *
     * @param format       格式
     * @param titleLength  称号长度
     * @param colorLength  颜色长度
     * @param prefixLength 前缀长度
     * @param suffixLength 后缀长度
     */
    public Global(String format, int[] titleLength, int[] colorLength, int[] prefixLength, int[] suffixLength) {
        this.format = format;
        this.titleLength = titleLength;
        this.colorLength = colorLength;
        this.prefixLength = prefixLength;
        this.suffixLength = suffixLength;
    }

    /**
     * 初始化全局配置
     */
    public static void init() {
        try {
            // 读取配置文件内容
            String configContent = GlobalConfig.readConfig();
            if (configContent != null && !configContent.trim().isEmpty()) {
                // 反序列化 JSON 字符串到 Global 对象
                Global newGlobal = JSON.parseObject(configContent, Global.class);

                // 更新 global 对象的字段
                global = newGlobal;
            } else {
                // 如果配置内容为空，重置为默认的 Global 对象
                resetToDefault();
            }
        } catch (Exception e) {
            // 处理 JSON 解析过程中发生的其他异常
            e.printStackTrace();
            resetToDefault();
        }
    }

    /**
     * 重置全局配置为默认值
     */
    private static void resetToDefault() {
        global = new Global();
    }

    /**
     * 获取格式
     *
     * @return 格式
     */
    public static String getFormat() {
        return global.format;
    }

    /**
     * 获取称号长度
     *
     * @return 称号长度
     */
    public static int[] getTitleLength() {
        return global.titleLength;
    }

    /**
     * 获取颜色长度
     *
     * @return 颜色长度
     */
    public static int[] getColorLength() {
        return global.colorLength;
    }

    /**
     * 获取后缀长度
     *
     * @return 后缀长度
     */
    public static int[] getPrefixLength() {
        return global.prefixLength;
    }

    /**
     * 获取后缀长度
     *
     * @return 后缀长度
     */
    public static int[] getSuffixLength() {
        return global.suffixLength;
    }
}
