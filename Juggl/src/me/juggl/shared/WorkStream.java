package me.juggl.shared;

import java.io.Serializable;


public class WorkStream implements Serializable {

	private static final long serialVersionUID = -7993839882410507563L;
	
	private long lastUpdateTime;
	private String name;
	
	public WorkStream() {} // GWT needs a default constructor
	
	public WorkStream(String name) {
		this.name = name;
		lastUpdateTime = System.currentTimeMillis();
	}

	public String getName() {
		return name;
	}

	public long getLastUpdateTime() {
		return lastUpdateTime;
	}
}
