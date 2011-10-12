package me.juggl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import me.juggl.client.JugglService;
import me.juggl.server.JugglServiceImpl;
import me.juggl.shared.WorkStream;

import org.junit.Before;
import org.junit.Test;

public class JugglServiceImplTest {

	private JugglServiceImpl subject;

	@Before
	public void testSetup() {
		subject = new JugglServiceImpl();
	}

	@Test
	public void defaultConstruction() {
		// Assert
		assertTrue(subject instanceof JugglService);
	}

	@Test
	public void addWorkStream() {
		// Arrange
		WorkStream expected = getNewWorkStream("test"); 
		
		// Act
		long id = subject.addWorkStream(expected);

		// Assert
		assertEquals(expected, subject.getWorkStream(id));
	}
	
	@Test
	public void getWorkStreams() {
		// Arrange
		WorkStream one = getNewWorkStream("one");
		WorkStream two = getNewWorkStream("two");
		
		subject.addWorkStream(one);
		subject.addWorkStream(two);

		// Act
		List<WorkStream> actual = subject.getWorkStreams();

		// Assert
		assertTrue(actual.size() == 2);
		assertTrue(actual.contains(one));
		assertTrue(actual.contains(two));		
	}
	
	private WorkStream getNewWorkStream(String name) {
		WorkStream workStream = new WorkStream();
		workStream.setName(name);
		return workStream;
	}
}
