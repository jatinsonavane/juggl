package me.juggl.shared;

import java.io.Serializable;

import javax.persistence.Id;

public class WorkStream implements Serializable {

	private static final long serialVersionUID = -7993839882410507563L;

	@Id
	private Long id; // used by Objectify to store this entity

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}
}
