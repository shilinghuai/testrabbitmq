package slh.rabbit;


/**
 * created by fuyd on 2018/12/24
 */
public class MQProperties {
    private String exchange;
    private String addressKey;
    private String quntumInQueue;

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getAddressKey() {
        return addressKey;
    }

    public void setAddressKey(String addressKey) {
        this.addressKey = addressKey;
    }

    public String getQuntumInQueue() {
        return quntumInQueue;
    }

    public void setQuntumInQueue(String quntumInQueue) {
        this.quntumInQueue = quntumInQueue;
    }
}
