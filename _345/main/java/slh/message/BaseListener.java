package slh.message;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

/**
 * created by fuyd on 2018/12/24
 */
@Component(value = "quntumListener")
public  class BaseListener implements MessageListener {




    @Override
    public void onMessage(Message message) {
        System.out.print("hello world");
    }

}
