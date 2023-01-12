package com.my.hr.presentation;

public enum Job {
	EXIT, LIST, ADD, FIX, DEL;
		
		public static final Job valueOf(int ordinal) {
			return values()[ordinal];
		}
}
