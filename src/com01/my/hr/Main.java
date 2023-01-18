package com01.my.hr;

import java.util.ArrayList;
import java.util.List;

import com.my.hr.presentation.Console;

import com01.my.hr.dao.LaborerDao;
import com01.my.hr.dao.LaborerDaoImpl;
import com01.my.hr.domain.Laborer;
import com01.my.hr.presentation.LaborerIo;
import com01.my.hr.service.LaborerService;
import com01.my.hr.service.LaborerServiceImpl;

public class Main {
	public static void main(String[] args) {
		List<Laborer> laborers = new ArrayList<>();
		
		LaborerDao laborerDao = new LaborerDaoImpl(laborers);
		LaborerService laborerService = new LaborerServiceImpl(laborerDao);
		LaborerIo laborerIo = new LaborerIo(laborerService);
		
		laborerIo.play();
		Console.info("end.");
	}
}
