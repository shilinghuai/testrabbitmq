package slh.message;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

@Component(value = "tests")
public class Tests implements MessageListener {

    @Override
    public void onMessage(Message message) {
        System.out.println(message.getBody());
    }
}
