package me.juggl;

import static org.junit.Assert.assertEquals;
import me.juggl.server.DataAccessHelperImpl;
import me.juggl.server.DataAccessHelper;
import me.juggl.server.JugglServiceImpl;
import me.juggl.shared.WorkStream;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMock.class)
public class JugglServiceImplTest {

	Mockery context = new JUnit4Mockery();
	final DataAccessHelper helper = context.mock(DataAccessHelper.class);

	private JugglServiceImpl subject;

	@Before
	public void setUp() {
		subject = new JugglServiceImpl();
		subject.setDataAccessHelper(helper);
	}

	@Test
	public void defaultConstruction() {
		// Arrange
		JugglServiceImpl subject = new JugglServiceImpl(); // not using the
															// setUp one.

		// Assert
		assertEquals(DataAccessHelperImpl.getInstance(), subject.getDataAccessHelper());
	}

	@Test
	public void addWorkStream() {
		// Arrange
		final WorkStream workStream = new WorkStream();

		// i expect ofy.put to be called.
		context.checking(new Expectations() {
			{
				oneOf(helper).addWorkStream(workStream);
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
				oneOf(helper).getAllWorkStreams();
			}
		});

		// Act
		subject.getWorkStreams();
	}
}