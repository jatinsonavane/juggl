package me.juggl;

import static org.junit.Assert.*;

import java.io.Serializable;

import me.juggl.shared.WorkStream;

import org.junit.Test;

public class WorkStreamTest {

	@Test
	public void construction() {
		// Arrange
		WorkStream subject = new WorkStream();
		
		// Assert
		assertNull(subject.getName());
		assertTrue(subject instanceof Serializable); // GWT needs this pass objects between client and server.
	}
	
	@Test
	public void setName() {
		// Arrange
		String expected = "test name";
		WorkStream subject = new WorkStream();
		
		// Act
		subject.setName(expected);

		// Assert
		assertEquals(expected, subject.getName());
	}
}
