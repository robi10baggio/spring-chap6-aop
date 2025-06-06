package com.example.demo.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class Account {

	private String name;
	
	private LocalDate birthday;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday.getYear() + "年" +
			   birthday.getMonthValue() + "月" +
			   birthday.getDayOfMonth() + "日";
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public long getAge() {
		LocalDate today = LocalDate.now(); // 現在日の取得
		long age = ChronoUnit.YEARS.between(birthday, today); // 現在日-誕生日
		return age;
	}

	// 誕生日からの日数
	public long getDayCount() {
		LocalDate today = LocalDate.now();
		long days = ChronoUnit.DAYS.between(birthday, today);
		return days;
	}
}
