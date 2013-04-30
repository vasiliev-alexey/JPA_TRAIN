package com.av.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@DiscriminatorValue (value = "ContractEmp")
@Table(name= "CONTRACT_EMP")
public class ContractEmp extends Emp {

	@Column(name = "CONTRACT_NUM" )
	private String contract;

	public String getContract() {
		return contract;
	}

	public void setContract(String contract) {
		this.contract = contract;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((contract == null) ? 0 : contract.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof ContractEmp))
			return false;
		ContractEmp other = (ContractEmp) obj;
		if (contract == null) {
			if (other.contract != null)
				return false;
		} else if (!contract.equals(other.contract))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ContractEmp [contract=" + contract + ", getSalary()="
				+ getSalary() + ", getId()=" + getId() + ", getName()="
				+ getSname() + ", getsDate()=" + getsDate() + "]";
	}
	
	
}
