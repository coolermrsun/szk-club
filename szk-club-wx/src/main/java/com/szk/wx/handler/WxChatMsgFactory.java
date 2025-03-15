package com.szk.wx.handler;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 工厂+策略
 * 基本思想为定义一个策略接口，具体的处理策略来实现该接口，通过spring的bean管理机制
 * afterPropertiesSet会将全部实现了策略接口的bean放到wxChatMsgHandlerList来进行遍历
 * 并且注入到handlerMap当中，业务要用的时候，直接Resource注入，然后通过key，value，迅速找到需要处理的方法。
 */
@Component
public class WxChatMsgFactory implements InitializingBean {

    @Resource
    private List<WxChatMsgHandler> wxChatMsgHandlerList;

    private Map<WxChatMsgTypeEnum, WxChatMsgHandler> handlerMap = new HashMap<>();

    public WxChatMsgHandler getHandlerByMsgType(String msgType) {
        WxChatMsgTypeEnum msgTypeEnum = WxChatMsgTypeEnum.getByMsgType(msgType);
        return handlerMap.get(msgTypeEnum);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        for (WxChatMsgHandler wxChatMsgHandler : wxChatMsgHandlerList) {
            handlerMap.put(wxChatMsgHandler.getMsgType(), wxChatMsgHandler);
        }
    }

}
