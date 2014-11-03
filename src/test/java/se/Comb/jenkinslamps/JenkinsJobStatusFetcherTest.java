/*
 * Created by U017121
 */
package se.Comb.jenkinslamps;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Created by u017121
 */
public class JenkinsJobStatusFetcherTest {
    @Test
    public void JenkinsJobStatusFetcherTest_url() throws Exception {
        
		JenkinsJobStatusFetcher tempFetcher = new JenkinsJobStatusFetcher(url(http://www.temp.com));
		assertThat(tempFetcher(), is(url(http://www.temp.com)));
		
		
		/*Calendar rightNow = Calendar.getInstance();
		Holiday tempHoliday = new Holiday(rightNow, "HolidayName");
		assertThat(tempHoliday.getDate(), is(rightNow));*/
    }
}
