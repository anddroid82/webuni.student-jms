package hu.webuni.student.andro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentPayment {

	private String identifier;
	private int payment;
	
}
