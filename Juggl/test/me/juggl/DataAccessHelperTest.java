package me.juggl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import me.juggl.server.DataAccessHelperImpl;
import me.juggl.shared.WorkStream;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.googlecode.objectify.Objectify;

@RunWith(JMock.class)
public class DataAccessHelperTest {

	Mockery context = new JUnit4Mockery();
	final Objectify ofy = context.mock(Objectify.class);

	private DataAccessHelperImpl subject = DataAccessHelperImpl.getInstance();

	@Test
	public void defaultConstruction() {
		assertNotNull(subject.getOfy());
	}

	@Test
	public void getAllWorkStreams() {
		// Arrange
		subject.setOfy(ofy);

		context.checking(new Expectations() {
			{
				oneOf(ofy).query(WorkStream.class).fetch();
			}
		});

		// Act
		List<WorkStream> actual = subject.getAllWorkStreams();

		// Assert
		assertEquals(0, actual.size());
	}

	@Test
	public void addWorkStream() {
		// Arrange
		final WorkStream workStream = new WorkStream();
		long expected = 7;
		workStream.setId(expected);

		subject.setOfy(ofy);

		// i expect ofy.put to be called.
		context.checking(new Expectations() {
			{
				oneOf(ofy).put(workStream);
			}
		});

		// Act
		long actual = subject.addWorkStream(workStream);

		// Assert
		assertEquals(expected, actual);
	}
}
