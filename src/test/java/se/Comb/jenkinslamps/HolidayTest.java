/*
 * Created by U017121
 */
package se.Comb.jenkinslamps;

import org.joda.time.LocalTime;
import org.junit.Test;

import java.net.URL;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/*  2014-11-03 Add import of Calendar class*/
import java.util.Calendar;

/*
 * Created by u017121
 */
public class HolidayTest {
    @Test
    public void HolidayTest_getDate() throws Exception {
        
		Calendar rightNow = Calendar.getInstance();
		Holiday tempHoliday = new Holiday(rightNow, "HolidayName");
		assertThat(tempHoliday.getDate(), is(rightNow));
    }
    @Test
    public void HolidayTest_getName() throws Exception {
        
		Calendar rightNow = Calendar.getInstance();
		Holiday tempHoliday = new Holiday(rightNow, "HolidayName");
		assertThat(tempHoliday.getName(), is("HolidayName"));
    }
    @Test
    public void HolidayTest_toString() throws Exception {
        
		Calendar rightNow = Calendar(2014-11-03);
		Holiday tempHoliday = new Holiday(rightNow, "HolidayName");
		assertThat(tempHoliday.toString(), is("Holiday{date=2014-11-03, name='HolidayName'}"));
    }
}
