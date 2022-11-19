package hu.webuni.student.andro.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import hu.webuni.student.andro.model.StudentPayment;
import hu.webuni.student.andro.model.StudentFreeSemesterQuery;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class StudentFreeSemesterQueryConsumer {

	private JmsTemplate jmsTemplate;
	
	@JmsListener(destination = "freesemesterquery")
	public void onStudentFreeSemesterQuery(StudentFreeSemesterQuery fsq) {
		this.jmsTemplate.convertAndSend("freesemesterqueryfromserver",fsq);
		//this.jmsTemplate.convertAndSend(fsq.getReplyTopicName(), fsq);
	}

}
