package se.ju.csi.oom.lab4;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;

//import org.junit.Before;
import org.junit.Test;

public class TimeZoneTranslatorTest {

	@Test
	public void testShiftTimeZone() {
		TimeZoneTranslator timezoneTranslator = new TimeZoneTranslator();
		DateTime date1 = new DateTime(2016, 1, 1, 6, 0, 0);
		date1 = timezoneTranslator.shiftTimeZone(date1, TimeZone.CENTRAL_EUROPEAN_TIME.getOffset() , TimeZone.US_PACIFIC.getOffset());
		DateTime expected = new DateTime(2015, 12, 31, 21, 0, 0);
		assertEquals(expected.toString(),date1.toString());
	}

	@Test
	public void testShiftEventTimeZone() {
		TimeZoneTranslator timezoneTranslator = new TimeZoneTranslator();
		DateTime startdate = new DateTime(2018, 8, 27, 10, 0, 0);
		DateTime endDate = new DateTime(2018, 8, 27, 11, 45, 0);
		Person bjorn = new Person("bjorn borg");
		Person nalle = new Person("nalle phu");
		Place HC218 = new Place("Hc218",57.7785672,14.1614833,20.0);
		
		Event event1 = new Event("University standup",startdate,endDate,new HashSet<>(Arrays.asList(bjorn, nalle)),HC218);
		Event response = TimeZoneTranslator.shiftEventTimeZone(event1, TimeZone.CENTRAL_EUROPEAN_TIME, TimeZone.ALASKA);
		
		DateTime exStartdate = new DateTime(2018, 8, 27, 0, 0, 0);
		DateTime exEndDate = new DateTime(2018, 8, 27, 1, 45, 0);
		Event event2 = new Event("University standup",exStartdate,exEndDate,new HashSet<>(Arrays.asList(bjorn, nalle)),HC218);
		
		assertEquals(response.getStartDate().toString(), event2.getStartDate().toString());
		assertEquals(response.getEndDate().toString(), event2.getEndDate().toString());
	}
	
//	@Test
//	public void testShiftTimeZone2() {
//		TimeZoneTranslator timezoneTranslator = new TimeZoneTranslator();
//		DateTime date1 = new DateTime(2016, 1, 1, 6, 0, 0);
//		date1 = timezoneTranslator.shiftTimeZone(date1, TimeZone.CENTRAL_EUROPEAN_TIME.getOffset() , TimeZone.US_PACIFIC.getOffset());
//		DateTime expected = new DateTime(2015, 12, 31, 21, 0, 0);
//		assertEquals(expected.toString(),date1.toString());
//	}
}

