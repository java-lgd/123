package model;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

public class myaspect implements MethodBeforeAdvice, AfterReturningAdvice, MethodInterceptor, ThrowsAdvice {

	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		System.out.println("֮ǰִ�С�����");
	}

	public void afterReturning(Object returnValue, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		System.out.println("��������---"+returnValue);
	}

	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("����ǰ");
		Object o = invocation.proceed();
		System.out.println("���ƺ�");
		return o;
	}

	public void afterThrowing(Method method, Object[] args, Object target, Exception ex) {
		System.out.println("������");
	}

}
