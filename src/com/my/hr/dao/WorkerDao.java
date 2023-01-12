package com.my.hr.dao;

import java.time.LocalDate;
import java.util.List;

import com.my.hr.domain.Worker;

public interface WorkerDao {
	public List<Worker> selectWorker();
	public void insertWorker(Worker worker);
	public void updateWorker(String workerName, LocalDate hireDate);
	public void deleteWorker();
	public void chooseWorker(int choice);
}
