import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.DeleteMessageRequest;
import software.amazon.awssdk.services.sqs.model.GetQueueUrlRequest;
import software.amazon.awssdk.services.sqs.model.GetQueueUrlResponse;
import software.amazon.awssdk.services.sqs.model.Message;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageRequest;

import java.util.List;
public class SQSConsumer {

    public String readMessage() {

        String msg = null; 
        try{

            SqsClient sqsClient = SqsClient.builder().build();

            //Specify Queue Name
            String queueName = "sqsTestQueue";

            //Get the queue URL
           GetQueueUrlRequest getQueueUrlRequest = GetQueueUrlRequest.builder().queueName(queueName).build();
           GetQueueUrlResponse getQueueUrlResponse = sqsClient.getQueueUrl(getQueueUrlRequest);
           String queueUrl = getQueueUrlResponse.queueUrl();

           //Print Queue url
           System.out.println("Queue URl: " + queueUrl);

           //Receive Message
           ReceiveMessageRequest receiveMessageRequest = ReceiveMessageRequest.builder().queueUrl(queueUrl)
                .maxNumberOfMessages(1).build();

            List<Message> messages = sqsClient.receiveMessage(receiveMessageRequest).messages();
            
        
            for(Message message: messages){
                 System.out.println("Message Body: " + message.body());
                 msg = message.body().toString();

                //Delete Message
                DeleteMessageRequest deleteMessageRequest = DeleteMessageRequest.builder().queueUrl(queueUrl)
                .receiptHandle(message.receiptHandle()).build();
                sqsClient.deleteMessage(deleteMessageRequest);
           
                System.out.println("Message Deleted: " + message.messageId());

           }
        }catch(Exception e){
            e.printStackTrace();
           }
        return msg;             
        
    }
}


