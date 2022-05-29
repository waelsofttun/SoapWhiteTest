package de.tekup.demo.data.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.stereotype.Service;

import de.tekup.soap.models.whitetest.Address;
import de.tekup.soap.models.whitetest.Exam;
import de.tekup.soap.models.whitetest.Student;
import de.tekup.soap.models.whitetest.StudentRequest;
import de.tekup.soap.models.whitetest.WhiteTestResponse;
@Service
public class WhiteTestService {
	
	
	
	public WhiteTestResponse whiteTest(StudentRequest request) {
		
		ArrayList<Student> List_student = new ArrayList<>();
		ArrayList<Exam> List_exam= new ArrayList<>();
		WhiteTestResponse response = new WhiteTestResponse();
		
		
		
		
		Address Myadress1 = new Address();
		Student student1  = new Student();
		Exam exam1 = new Exam();
		Address address2 = new Address();
		Student student2 = new Student();
		Exam exam2 = new Exam();


		Myadress1.setStreet("Rue newton");
		Myadress1.setCity("tunis");
		Myadress1.setPosteCode(1012);
		student1.setId(1);
		student1.setName("wael");
		student1.setAddress(address1);
		List_student.add(student1);	
		exam1.setCode("Aws");
		exam1.setName("Amazon Aws");
		exams.add(exam1);
		address2.setStreet("Rue Ariana");
		address2.setCity("tunis");
		address2.setPosteCode(2040);
		student2.setId(2);
		student2.setName("dali");
		student2.setAddress(address2);
		List_student.add(student2);
		exam2.setCode("CCNP");
		exam2.setName("CCNP");
		List_exam.add(exam2);
		
		
		
		

		
		
		if(request.getStudentId() <=0 || request.getStudentId() > students.size())
			response.getBadRequests().add("Student ID is not valid or Not found");
		
		if(response.getBadRequests().isEmpty()) {
		for(Student student : List_student) {
			if (request.getStudentId()==student.getId())
			{
				response.setStudent(student);
				for(Exam exam : List_exam) {
					if(request.getExamCode().equals(exam.getCode())) {
						response.setExam(exam);
						LocalDate date = LocalDate.now();
						GregorianCalendar gcal = GregorianCalendar.from(date.atStartOfDay(ZoneId.systemDefault()));
						XMLGregorianCalendar xcal =null;
						try {
							xcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
						} catch (DatatypeConfigurationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						response.setDate(xcal);
						}
			}
		} 		
	}
	

	}
		
		System.out.println(response.getBadRequests());
		return response;

		
		
		
	}
	}


