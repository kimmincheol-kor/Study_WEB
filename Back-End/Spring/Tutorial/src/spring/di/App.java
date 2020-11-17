package spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.di.ui.ExamConsole;

public class App {
	public static void main(String[] args) {
		
		/* ���� ���
		Exam exam = new NewlecExam();
		ExamConsole console = new InlineExamConsole(exam); // opt 1
		ExamConsole console = new GridExamConsole(exam); // opt 2
		*/
		
		/* ���ο� ��� : ���������� �����Ѵ� (���ü� = Beans, ��ǰ = Bean) */
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(NewlecDIConfig.class);
				//new ClassPathXmlApplicationContext("spring/di/setting.xml");
		
		// ExamConsole console = (ExamConsole) context.getBean("console");
		ExamConsole console = context.getBean(ExamConsole.class); // Prefer
		console.print();
	}
}