 package ssm_test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import model.Type2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:aa.xml"})
public class junit_test {

    @Resource(name="t")
	Type2 t;
	
	@Test
	public void ee(){
	    System.out.println(t.getName());
	    System.out.println(t.getId());
	}
}
