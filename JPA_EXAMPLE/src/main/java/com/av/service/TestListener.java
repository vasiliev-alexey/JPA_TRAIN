package com.av.service;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class TestListener {
	@PrePersist
	public void prePersist(Object o) {
		System.out.println(o + "==== @PrePersist");
	}

	@PostPersist
	public void postPersist(Object o){
		System.out.println(o  + "  @PostPersist  ");
	}

	@PreUpdate
	public void PreUpdate(Object o) {
		System.out.println(o +"==== @@@PreUpdate");
	}

	@PostUpdate
	public void PostUpdate(Object o) {
		System.out.println(o +"==== @@@@PostUpdate");
	}

	@PreRemove
	public void PreRemove(Object o) {
		System.out.println(o +"==== @@@@@PreRemove");
	}

	@PostRemove
	public void PostRemove(Object o) {
		System.out.println(o +"==== @@@@@@PostRemove");
	}

	@PostLoad
	public void PostLoad(Object o){
		System.out.println(o +"==== @@@@@@@PostLoad");
	}

}
