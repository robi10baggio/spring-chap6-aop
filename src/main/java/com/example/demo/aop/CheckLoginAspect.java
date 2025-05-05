package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.Account;

@Aspect
@Component
public class CheckLoginAspect {

	@Autowired
	Account account;

	@Before("execution(* com.exsample.demo.controller.*Controller.*(..))")
	public void writelog(JoinPoint jp) {
		if (account == null || account.getName() == null ||
				account.getName().length() == 0) {
			System.out.print("ゲスト:");
		} else {
			System.out.print(account.getName() + ":");
		}
		System.out.println(jp.getSignature());
	}
}
