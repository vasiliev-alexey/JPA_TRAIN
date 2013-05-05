package com.av.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value = "StaffEmp")
@Table(name = "STAFF_EMP")
public class StaffEmp extends Emp {

	@Column(name = "ROOM")
	private String room;

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((room == null) ? 0 : room.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof StaffEmp))
			return false;
		StaffEmp other = (StaffEmp) obj;
		if (room == null) {
			if (other.room != null)
				return false;
		} else if (!room.equals(other.room))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StaffEmp [room=" + room + ", getSalary()=" + getSalary()
				+ ", getId()=" + getId() + "]";
	}

}
