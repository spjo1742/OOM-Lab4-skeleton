package se.ju.csi.oom.lab4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DateTimeTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testToString() {
		DateTime birth = new DateTime(1985, 4, 21, 21, 13, 37);
		assertEquals(birth.toString(), "1985-04-21 21:13:37");
	}

	@Test
	public void testDateTimeString() {
		DateTime birth = new DateTime("1985-04-21 21:13:37");
		assertEquals(birth.toString(), "1985-04-21 21:13:37");
	}

}
