package ssm_test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Type;
import model.Type2;

public class java_test {
	
	@Test
	public void aa() {
		ApplicationContext act = new ClassPathXmlApplicationContext("aa.xml");
		Type2 t = act.getBean(Type2.class);
		System.out.println(t.getName());
	}
}
