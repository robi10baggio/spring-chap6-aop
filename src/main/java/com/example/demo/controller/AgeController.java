package com.example.demo.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Account;

@Controller
public class AgeController {

	@Autowired
	Account account;

	// 年齢計算結果の出力
	@PostMapping("/calcAge")
	public String calcAge(
			@RequestParam(name = "year", defaultValue = "2000") int year,
			@RequestParam(name = "month", defaultValue = "1") int month,
			@RequestParam(name = "day", defaultValue = "1") int day) {

		// 日付型のオブジェクトの生成
		LocalDate birthday = LocalDate.of(year, month, day);
		// セッションスコープのアカウント情報に生年月日をセット
		account.setBirthday(birthday);

		return "result";
	}
}
