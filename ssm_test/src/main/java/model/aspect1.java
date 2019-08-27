package model;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class aspect1 {
	public void before(JoinPoint p) throws Throwable {
		System.out.println(p.getTarget().getClass().getName());
		System.out.println("ǰ��.......");
	}
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("hǰ��.......");
		Object o = pjp.proceed();
		System.out.println("h����.......");
		return o;
	}
	

	public void after(JoinPoint p) throws Throwable {
		System.out.println("����.......");
	}
	public void after_return(JoinPoint p, Object result) throws Throwable {
		System.out.println("����......."+result);
	}
	
	public void after_throw( JoinPoint jp, Throwable e) throws Throwable{
			System.out.println("������"+e.getMessage());
		}
}