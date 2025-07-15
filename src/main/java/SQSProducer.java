import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.CreateQueueRequest;
import software.amazon.awssdk.services.sqs.model.CreateQueueResponse;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

public class SQSProducer {

    public void sendMessage(String msg) {
		
		try {
		
		//Initialize SQS client
		SqsClient sqsClient = SqsClient.builder().build();
		
		//Create a queue
		CreateQueueRequest createQueueRequest = CreateQueueRequest.builder().queueName("sqsTestQueue").build();
		CreateQueueResponse createQueueResponse = sqsClient.createQueue(createQueueRequest);
		String queueUrl = createQueueResponse.queueUrl();		
		System.out.println("Queue URL: "+queueUrl);
		
		//Send a message 
		SendMessageRequest sendMessageRequest = SendMessageRequest.builder().queueUrl(queueUrl)
				.messageBody(msg).build();
		sqsClient.sendMessage(sendMessageRequest);
		System.out.println("Message sent successfully");
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}



}
