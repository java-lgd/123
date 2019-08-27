package model;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class aspect1 {
	public void before(JoinPoint p) throws Throwable {
		System.out.println(p.getTarget().getClass().getName());
		System.out.println("前置.......");
	}
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("h前置.......");
		Object o = pjp.proceed();
		System.out.println("h后置.......");
		return o;
	}
	

	public void after(JoinPoint p) throws Throwable {
		System.out.println("后置.......");
	}
	public void after_return(JoinPoint p, Object result) throws Throwable {
		System.out.println("返回......."+result);
	}
	
	public void after_throw( JoinPoint jp, Throwable e) throws Throwable{
			System.out.println("出错了"+e.getMessage());
		}
}