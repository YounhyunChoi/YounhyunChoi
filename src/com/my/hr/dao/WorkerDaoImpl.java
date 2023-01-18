package com.my.hr.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.my.hr.domain.Worker;

public class WorkerDaoImpl implements WorkerDao {
	private List<Worker> workers;
	private int choice;
	
	public WorkerDaoImpl(List<Worker> worker) {
		workers = worker;
	}

	@Override
	public List<Worker> selectWorker() {
		return workers;
	}

	@Override
	public void insertWorker(Worker worker) {
		workers.add(worker);
	}

	@Override
	public void updateWorker(String workerName, LocalDate hireDate) {
		Worker worker = this.workers.get(choice);
		worker.setWorkerName(workerName);
		worker.setHireDate(hireDate);
		workers.set(choice, worker);
	}

	@Override
	public void deleteWorker() {
		workers.remove(choice);
	}

	@Override
	public void chooseWorker(int choice) {
		List<Integer> idList = new ArrayList<>();
		for(int i = 0; i < workers.size(); i++) {
			idList.add(this.workers.get(i).getWorkerId());
		}
		this.choice = idList.indexOf(choice);
	}
}
