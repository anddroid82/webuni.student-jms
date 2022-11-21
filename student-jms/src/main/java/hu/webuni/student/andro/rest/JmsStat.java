package hu.webuni.student.andro.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.jms.JMSException;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.advisory.DestinationSource;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jms")
public class JmsStat {

	@GetMapping
	public ResponseEntity<List<String>> getAllTopicAndQueue() {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:8090");
		List<String> result=new ArrayList<>();
		try {
			ActiveMQConnection connection = (ActiveMQConnection) connectionFactory.createConnection();
			connection.start();
			DestinationSource ds = connection.getDestinationSource();
			Set<ActiveMQQueue> queues = ds.getQueues();
			for (ActiveMQQueue queue : queues) {
				String qn="Queue:" + queue.getQueueName();
				result.add(qn);
			}
			Set<ActiveMQTopic> topics = ds.getTopics();
			for (ActiveMQTopic topic : topics) {
				String tn = "Topic:" + topic.getTopicName();
				result.add(tn);
			}

		} catch (JMSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return ResponseEntity.ok(result);
	}

}
