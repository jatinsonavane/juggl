package me.juggl;

import static org.junit.Assert.assertTrue;
import me.juggl.client.JugglClient;

import org.junit.Test;

import com.google.gwt.core.client.EntryPoint;

public class JugglClientTest {

	@Test
	public void defaultConstruction() {
		// Arrange
		JugglClient subject = new JugglClient();

		// Assert
		assertTrue(subject instanceof EntryPoint);
	}
}
