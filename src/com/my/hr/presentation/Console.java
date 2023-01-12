package com.my.hr.presentation;

import java.time.LocalDate;
import java.util.Scanner;

public interface Console {
	Scanner sc = new Scanner(System.in);

	private static void inMsg(String msg) {
		System.out.print(msg + "\n> ");
	}
	
	public static String inStr(String msg) {
		String input = "";
		boolean isGood = false;
		
		do {
			Console.inMsg(msg);
			input = sc.nextLine();
			isGood = input.matches("[a-zA-Z가-힣]+");
			if(!isGood) Console.err("문자가 아닙니다.");
		} while(!isGood);
		return input;
	}
	
	public static String inName(String msg) {
		String input = "";
		boolean isGood = false;
		
		do {
			Console.inMsg(msg);
			input = sc.nextLine();
			if(input.equals("0")) isGood = true;
			else {
				isGood = input.matches("[a-zA-Z가-힣]+");
				if(!isGood) Console.err("문자가 아닙니다.");
				else {
					isGood = input.length() <= 5;
					if(!isGood) Console.err("5글자를 초과했습니다.");
				}
			}
		} while(!isGood);
		return input;
	}
	
	static int inNum(String msg) {
		String input = "";
		boolean isGood = false;
		
		do {
			Console.inMsg(msg);
			input = sc.nextLine();
			isGood = input.matches("[0-9]+");
			if(!isGood)	Console.err("0 이상의 정수가 아닙니다.");			
		} while(!isGood);
		return Integer.parseInt(input);
	}
	
	public static LocalDate inDate(String msg) {
		String input = "";
		boolean isGood = false;
		LocalDate Date = null;
		
		do {
			try {
				Console.inMsg(msg);
				input = sc.nextLine();
				isGood = input.matches("^[0-9]{4}-[0-9]{2}-[0-9]{2}$");
				if(!isGood) Console.err("날짜가 아닙니다.");
				else Date = LocalDate.parse(input);
			} catch(RuntimeException e) {
				Console.err("날짜가 아닙니다.");
				isGood = false;}
		} while(!isGood);
		
		return Date;
	}
	
	public static void info(Object obj) {
		System.out.println(obj);
	}
	
	public static void err(String msg) {
		System.out.println("ERROR]" + msg);
	}
}
