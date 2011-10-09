package me.juggl;

import static org.junit.Assert.*;

import java.io.Serializable;

import me.juggl.shared.WorkStream;

import org.junit.Test;

public class WorkStreamTest {

	@Test
	public void defaultConstruction() {
		// Arrange
		WorkStream subject = new WorkStream();
		String expected = "";
		
		// Assert
		assertEquals(expected, subject.getName());
		assertTrue(subject instanceof Serializable); // GWT requirement when sharing between client and server
	}
	
	@Test
	public void constructionWithName() {
		// Arrange
		String name = "this is a test workstream";
		WorkStream subject = new WorkStream(name);

		// Assert
		assertEquals(name, subject.getName());
	}
	
	@Test
	public void setName() {
		// Arrange
		WorkStream subject = new WorkStream("old name");
		String expected = "new name";
		
		// Act
		subject.setName("new name");

		// Assert
		assertEquals(expected, subject.getName());
	}
}
