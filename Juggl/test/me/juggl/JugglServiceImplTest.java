package me.juggl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import me.juggl.server.JugglServiceImpl;
import me.juggl.shared.WorkStream;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.googlecode.objectify.Objectify;

@RunWith(JMock.class)
public class JugglServiceImplTest {

	Mockery context = new JUnit4Mockery();
	final Objectify ofy = context.mock(Objectify.class);

	private JugglServiceImpl subject;

	@Before
	public void setUp() {
		subject = new JugglServiceImpl();
		subject.setObjectify(ofy);
	}

	@Test
	public void addWorkStream() {
		// Arrange
		final WorkStream workStream = new WorkStream();

		// i expect ofy.put to be called.
		context.checking(new Expectations() {
			{
				oneOf(ofy).put(workStream);
			}
		});

		// Act
		subject.addWorkStream(workStream);
	}

	@Test
	public void getWorkStreams() {
		// Arrange
		context.checking(new Expectations() {
			{
				oneOf(ofy).query(WorkStream.class).fetch();
			}
		});

		// Act
		List<WorkStream> actual = subject.getWorkStreams();

		// Assert
		assertEquals(0, actual.size());
	}
}