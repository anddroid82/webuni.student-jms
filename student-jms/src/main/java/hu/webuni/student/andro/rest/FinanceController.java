package hu.webuni.student.andro.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import hu.webuni.student.andro.model.StudentPayment;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/finance")
@AllArgsConstructor
public class FinanceController {

	private JmsTemplate jmsTemplate;
	
	@RequestMapping("/addStudentPayment")
	public ResponseEntity<Void> addStudentPayment(@RequestParam String identifier,@RequestParam int payment){
		this.jmsTemplate.convertAndSend("payment", new StudentPayment(identifier,payment));
		return ResponseEntity.ok(null);
	}
	
}
