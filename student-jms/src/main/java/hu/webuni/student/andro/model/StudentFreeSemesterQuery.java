package hu.webuni.student.andro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class StudentFreeSemesterQuery {
	
	private String identifier;
	private int freeSemester;
	private String replyTopicName;

}
