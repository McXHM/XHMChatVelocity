package cn.mrxhm.xHMChatVelocity.utils;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * 聊天格式
 */
public class ChatFormat {
    /**
     * 前缀
     */
    @JSONField(ordinal = 3)
    private String prefix;
    /**
     * 后缀
     */
    @JSONField(ordinal = 2)
    private String suffix;
    /**
     * 颜色
     */
    @JSONField(ordinal = 1)
    private String color;
    /**
     * 称号
     */
    @JSONField(ordinal = 0)
    private String title;

    /**
     * 无参构造
     */
    public ChatFormat() {
        setPrefix("");
        setSuffix("");
        setColor("");
        setTitle("&aPlayer");
    }

    /**
     * 有参构造
     *
     * @param prefix 前缀
     * @param suffix 后缀
     * @param color  颜色
     * @param title  称号
     */
    public ChatFormat(String prefix, String suffix, String color, String title) {
        this.prefix = prefix;
        this.suffix = suffix;
        this.color = color;
        this.title = title;
    }

    /**
     * 获取前缀
     *
     * @return String
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * 设置前缀
     *
     * @param prefix 前缀
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix.replaceAll("&", "§");
    }

    /**
     * 获取后缀
     *
     * @return String
     */
    public String getSuffix() {
        return suffix;
    }

    /**
     * 设置后缀
     *
     * @param suffix 后缀
     */
    public void setSuffix(String suffix) {
        this.suffix = suffix.replaceAll("&", "§");
    }

    /**
     * 获取颜色
     *
     * @return String
     */
    public String getColor() {
        return color;
    }

    /**
     * 设置颜色
     *
     * @param color 颜色
     */
    public void setColor(String color) {
        this.color = color.replaceAll("&", "§");
    }

    /**
     * 获取称号
     *
     * @return String
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置称号
     *
     * @param title 称号
     */
    public void setTitle(String title) {
        this.title = title.replaceAll("&", "§");
    }
}
