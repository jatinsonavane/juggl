package me.juggl;

import static org.junit.Assert.*;

import java.io.Serializable;

import me.juggl.shared.WorkStream;

import org.junit.Test;

public class WorkStreamTest {

	@Test
	public void construction() {
		// Arrange
		long timeBefore = System.currentTimeMillis();
		WorkStream subject = new WorkStream("test name");
		long timeAfter = System.currentTimeMillis();
		
		// Assert
		assertEquals("test name", subject.getName());
		assertTrue(subject.getLastUpdateTime() <= timeAfter && subject.getLastUpdateTime() >= timeBefore);
		assertTrue(subject instanceof Serializable); // GWT requirement when sharing objects between client and server
	}
}
