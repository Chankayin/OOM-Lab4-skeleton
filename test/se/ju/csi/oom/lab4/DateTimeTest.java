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
		DateTime dateTime = new DateTime(2018, 10, 21, 0, 0, 0);
		String s2 = ("2018-10-21 00:00:00");
		assertEquals(dateTime.toString(), s2);
	}

	
	@Test
	public void testDateTimeString() {
		String s2 = ("2018-10-21 00:00:00");
		DateTime dateTime = new DateTime(s2);
		assertEquals(s2, dateTime.toString());
	}

}
