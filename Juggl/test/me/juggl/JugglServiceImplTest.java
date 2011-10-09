package me.juggl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import me.juggl.client.JugglService;
import me.juggl.server.JugglServiceImpl;
import me.juggl.shared.WorkStream;

import org.junit.Test;

public class JugglServiceImplTest {

	@Test
	public void defaultConstruction() {
		// Arrange
		JugglServiceImpl subject = new JugglServiceImpl();
		
		// Assert
		assertTrue(subject instanceof JugglService);
	}
	
	@Test
	public void addWorkStream() {
		// Arrange
		WorkStream expected = new WorkStream("a test workstream");
		JugglServiceImpl subject = new JugglServiceImpl();
		
		// Act
		long id = subject.addWorkStream(expected);

		// Assert
		assertEquals(expected, subject.getWorkStream(id));
	}
	
	@Test
	public void getWorkStreams() {
		// Arrange
		JugglServiceImpl subject = new JugglServiceImpl();

		List<WorkStream> expected = new ArrayList<WorkStream>();
		
		WorkStream one = new WorkStream("one");
		WorkStream two = new WorkStream("two");
		WorkStream thr = new WorkStream("thr");
		
		subject.addWorkStream(one);
		expected.add(one);
		subject.addWorkStream(two);
		expected.add(two);
		subject.addWorkStream(thr);
		expected.add(thr);

		// Act
		List<WorkStream> actual = subject.getWorkStreams();

		// Assert
		assertEquals(expected, actual);
	}
}
