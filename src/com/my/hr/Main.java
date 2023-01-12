package com.my.hr;

import java.util.ArrayList;

import com.my.hr.dao.WorkerDao;
import com.my.hr.dao.WorkerDaoImpl;
import com.my.hr.presentation.WorkerIo;
import com.my.hr.service.WorkerService;
import com.my.hr.service.WorkerServiceImpl;

public class Main {
	public static void main(String[] args) {
		WorkerDao workerdao = new WorkerDaoImpl(new ArrayList<>());
		WorkerService workerService = new WorkerServiceImpl(workerdao);
		WorkerIo workerIo = new WorkerIo(workerService);
		
		workerIo.play();		
	}
}
