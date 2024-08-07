package cn.mrxhm.xHMChatVelocity;

import com.google.inject.Inject;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.plugin.Plugin;
import org.slf4j.Logger;

@Plugin(
        id = "xhmchatvelocity",
        name = "XHMChatVelocity",
        version = "1.0-SNAPSHOT")
    ,description ="A Chat Plugin For Velocity"
        ,authors ={"Mr_XHM"}
        )

public class XHMChatVelocity {

    @Inject
    private Logger logger;

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
    }
}
