package spring.di.entity;

import org.springframework.beans.factory.annotation.Value;

public class NewlecExam implements Exam {

	//@Value("20")
	private int kor;
	private int eng;
	private int math;
	private int com;
	
	public NewlecExam() {}
	
	public NewlecExam(int kor, int eng, int math, int com) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.com = com;
	}
	
	@Override
	public int total() {
		
		
		// Before
		
		
		int result = kor+eng+math+com;
		
		
		// After
		
		
		return result;
	}

	@Override
	public float avg() {
		return total() / 4.0f;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getCom() {
		return com;
	}

	public void setCom(int com) {
		this.com = com;
	}
}
