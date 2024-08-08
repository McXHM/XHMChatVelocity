package cn.mrxhm.xHMChatVelocity.utils;

//权限枚举
public enum XCVP {
    SETTITLE_SELF("xhmchat.settitle.self"),
    SETTITLE_OTHER("xhmchat.settitle.other"),
    SETCOLOR_SELF("xhmchat.setcolor.self"),
    SETCOLOR_OTHER("xhmchat.setcolor.other"),
    SETPREFIX_SELF("xhmchat.setprefix.self"),
    SETPREFIX_OTHER("xhmchat.setprefix.other"),
    SETSUFFIX_SELF("xhmchat.setsuffix.self"),
    SETSUFFIX_OTHER("xhmchat.setsuffix.other"),
    RELOAD("xhmchat.reload"),
    ;
    private final String permission;

    private XCVP(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return permission;
    }
}
