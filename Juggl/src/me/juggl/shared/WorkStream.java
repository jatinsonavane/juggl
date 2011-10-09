package me.juggl.shared;

import java.io.Serializable;


public class WorkStream implements Serializable {

	private static final long serialVersionUID = -7993839882410507563L;

	private String name = "";
	
	public WorkStream() {}
	
	public WorkStream(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
