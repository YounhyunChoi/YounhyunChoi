package com.my.hr.presentation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.my.hr.domain.Worker;
import com.my.hr.service.WorkerService;

public class WorkerIo {
	private int userId = 1;
	private WorkerService workerService;
	
	public WorkerIo(WorkerService workerService) {
		this.workerService = workerService;
	}
	
	public void play() {
		int choice = 0;
		
		do {
			boolean isGood = false;
			
			do {
				choice = Console.inNum("1.목록, 2.추가, 3.수정, 4.삭제, 0.종료");
				isGood = 0 <= choice && choice <= 4;
				if(!isGood) Console.err("0에서 4사이 숫자를 입력하세요.");
			} while(!isGood);
			
			switch(Job.valueOf(choice)) {
				case EXIT -> Console.info("프로그램을 종료합니다.");
				case LIST -> this.list();
				case ADD -> this.add();
				case FIX -> this.fix();
				case DEL -> this.del();
			}
		} while(choice != 0);
	}
	
	private void list() {
		if(workerService.getWorker().size() != 0) {
			Console.info(" ID    이름      입사일");
			for(Worker worker: workerService.getWorker())
				Console.info(worker);
		} else Console.info("노동자가 없습니다.");
	}
	
	private void add() {
		LocalDate hireDate = null;
		String workerName = Console.inName("추가할 노동자명을 입력하세요.");
		
		if(!workerName.equals("0")) {
			hireDate = Console.inDate("입사일을 입력하세요.");
		
			workerService.addWorker(new Worker(userId, workerName, hireDate));
			userId++;
		} else Console.info("취소");
	}
	
	private void fix() {
		int choiceId = 0;
		boolean isGood = false;
		boolean cancel = false;
		LocalDate hireDate = null;
		
		do {
			choiceId = Console.inNum("수정할 노동자의 ID를 입력하세요.");
			if(choiceId == 0) cancel = true;
			else {
				List<Integer> workerId = new ArrayList<>();
				for(Worker worker: workerService.getWorker())
					workerId.add(worker.getWorkerId());
				isGood = -1 != workerId.indexOf(choiceId);
				if(!isGood) Console.err("잘못된 노동자ID 입니다.");
			}
		} while(!isGood && !cancel);
		
		if(!cancel) {
			String workerName = Console.inStr("수정할 노동자명을 입력하세요.");
			hireDate = Console.inDate("입사을 입력하세요.");
			
			workerService.fixWorker(workerName, hireDate, choiceId);
		} else Console.info("취소");
	}
	
	private void del() {
		int choiceId = 0;
		boolean isGood = false;
		boolean cancel = false;
		
		do {
			choiceId = Console.inNum("삭제할 노동자의 ID를 입력하세요.");
			if(choiceId == 0) cancel = true;
			else {
				List<Integer> workerId = new ArrayList<>();
				for(Worker worker: workerService.getWorker())
					workerId.add(worker.getWorkerId());
				isGood = -1 != workerId.indexOf(choiceId);
				if(!isGood) Console.err("잘못된 노동자ID 입니다.");
			}
		} while(!isGood && !cancel);
		
		if(!cancel) {
			do {
				workerService.delWorker(choiceId);
			} while(!isGood);
		} else Console.info("취소");
	}
}
