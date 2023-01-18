package com01.my.hr.service;

import java.time.LocalDate;
import java.util.List;

import com01.my.hr.domain.Laborer;

public interface LaborerService {
	List<Laborer> getLaborers();
	void addLaborer(String laborerName, LocalDate hireDate);
	void fixLaborer(Laborer laborer);
	void delLaborer(int laborerId);
}
