package spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.di.ui.ExamConsole;

public class App {
	public static void main(String[] args) {
		
		/* 기존 방식
		Exam exam = new NewlecExam();
		ExamConsole console = new InlineExamConsole(exam); // opt 1
		ExamConsole console = new GridExamConsole(exam); // opt 2
		*/
		
		/* 새로운 방식 : 스프링에게 지시한다 (지시서 = Beans, 부품 = Bean) */
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(NewlecDIConfig.class);
				//new ClassPathXmlApplicationContext("spring/di/setting.xml");
		
		// ExamConsole console = (ExamConsole) context.getBean("console");
		ExamConsole console = context.getBean(ExamConsole.class); // Prefer
		console.print();
	}
}