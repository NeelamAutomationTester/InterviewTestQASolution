import org.junit.Assert;
import org.junit.Test;

public class SqsTest {

   
    @Test
    public void sqsTest(){

    SQSProducer producer = new SQSProducer();
    SQSConsumer consumer = new SQSConsumer();
    String sentMessage = "This is my first message!!";
    String receivedMessage = null;


        producer.sendMessage(sentMessage);
        receivedMessage = consumer.readMessage().trim();
        System.err.println(receivedMessage);
        Assert.assertEquals(receivedMessage, sentMessage);

    }

}
