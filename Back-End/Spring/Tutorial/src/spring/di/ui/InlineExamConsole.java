package spring.di.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.di.entity.Exam;

@Service("console")
public class InlineExamConsole implements ExamConsole {
	 
	@Autowired(required=false)
	//@Qualifier("exam2")
	private Exam exam;
	
	public InlineExamConsole() {
		// TODO Auto-generated constructor stub
	}
	
	public InlineExamConsole(Exam exam) {
		this.exam = exam;
	}

	@Override
	public void print() {
		System.out.printf("Total is %d, Avg is %f\n", exam.total(), exam.avg());
	}
	
	@Override
	public void setExam(Exam exam) {
		// TODO Auto-generated method stub
		this.exam = exam;
	}
}
