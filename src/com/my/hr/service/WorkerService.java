package com.my.hr.service;

import java.time.LocalDate;
import java.util.List;

import com.my.hr.domain.Worker;

public interface WorkerService {
	public List<Worker> getWorker();
	public void addWorker(Worker worker);
	public void fixWorker(String workerName, LocalDate hireDate, int choice);
	public void delWorker(int choice);
}
