package com.av.domain;

import java.util.Calendar;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
@Table(name = "EMPLOYEE_VACATIONBOOKINGS")
public class VacationEntry {
	@Override
	public String toString() {
		return "VacationEntry [startDate=" + startDate + ", daysTaken="
				+ daysTaken + "]";
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public int getDaysTaken() {
		return daysTaken;
	}
	public void setDaysTaken(int daysTaken) {
		this.daysTaken = daysTaken;
	}
	
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Column(name = "DAYS")
	private int daysTaken;
}
