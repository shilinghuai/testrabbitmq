package com.rabbit;



/**
 * created by fuyd on 2018/12/24
 */

public class MQMessage {
    // 交换机
    private String exchange;
    // 路由关键字
    private String routerKey;
    // 传输数据
    private Object data;

    public MQMessage(String exchange, String routerKey, Object data) {
        this.exchange = exchange;
        this.routerKey = routerKey;
        this.data = data;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getRouterKey() {
        return routerKey;
    }

    public void setRouterKey(String routerKey) {
        this.routerKey = routerKey;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
