package com.my.hr.domain;

import java.time.LocalDate;

public class Worker {
	private int workerId;
	private String workerName;
	private LocalDate hireDate;

	public Worker(int workerId, String workerName, LocalDate hireDate) {
		this.workerId = workerId;
		this.workerName = workerName;
		this.hireDate = hireDate;
	}

	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}
	
	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}
	
	public int getWorkerId() {
		return workerId;
	}

	@Override
	public String toString() {
		return String.format("%3d %4s %11s", workerId, workerName, hireDate);
	}
}
