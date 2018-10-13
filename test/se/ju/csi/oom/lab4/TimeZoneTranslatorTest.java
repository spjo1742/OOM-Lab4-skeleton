package se.ju.csi.oom.lab4;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class TimeZoneTranslatorTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testShiftTimeZone() {
		DateTime birth = new DateTime(1985, 4, 21, 7, 13, 37);
		assertEquals(TimeZoneTranslator.shiftTimeZone(birth, -5, 9).toString(), "1985-04-21 21:13:37");
	}

	@Test
	public void testShiftEventTimeZone() {
		DateTime LectureStart = new DateTime(2018, 8, 27, 8, 0, 0);
		DateTime LectureEnd = new DateTime(2018, 8, 27, 9, 45, 0);
		Person johannes = new Person("Johannes Schmidt");
		Place HC218 = new Place("Hc218",57.7785672,14.1614833,20.0);
		
		Event firstOomLecture = new Event("OOM 2018 Lecture 1",
				LectureStart,
				LectureEnd,
				new HashSet<>(Arrays.asList(johannes)),
				HC218);
		System.out.println(firstOomLecture.toString());
		assertEquals(TimeZoneTranslator.shiftEventTimeZone(firstOomLecture, TimeZone.CENTRAL_EUROPEAN_TIME, TimeZone.JAPAN).toString(),
				"Event label:\tOOM 2018 Lecture 1\nStart date:\t2018-08-27 16:00:00\nEnd date:\t2018-08-27 17:45:00"
				+ "\nAttendees:\t[Johannes Schmidt]\nPlace:\t\tHc218");
	}
	
	@Test
	public void testShiftTimeZone2() {
		DateTime newYear = new DateTime(2016, 1, 1, 06, 00, 00);
		assertEquals(TimeZoneTranslator.shiftTimeZone(newYear, 1, -8).toString(), "2015-12-31 21:00:00");
	}
	
	@Test
	public void testShiftTimeZone3() {
		DateTime newYear = new DateTime(2016, 12, 31, 23, 00, 00);
		assertEquals(TimeZoneTranslator.shiftTimeZone(newYear, -8, 1).toString(), "2017-01-01 08:00:00");
	}

}
