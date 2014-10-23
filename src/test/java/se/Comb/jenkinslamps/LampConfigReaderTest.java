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

/*
 * Created by KDMA02 2013-09-30 13:41
 */
public class LampConfigReaderTest {
    @Test
    public void testRead() throws Exception {
        LampConfig c = LampConfigReader.read(getClass().getResourceAsStream("/config.xml"));
        assertThat(c.getJenkinsUrl(), is(new URL("http://your-ci-server:8080/")));
        assertThat(c.getPollTimeMsec(), is(10000));
        assertThat(c.getTurnOnTime(), is(LocalTime.parse("09:00:00")));
        assertThat(c.getTurnOffTime(), is(LocalTime.parse("17:00:00")));
        assertThat(c.isActiveHolidays(), is(false));

        List<Lamp> lamps = c.getLamps();
        assertThat(lamps.size(), is(2));
        {
            Lamp lamp = lamps.get(0);
            assertThat(lamp.getName(), is("green"));
            assertThat(lamp.getDescription(), is("Turn on green lamp when job unit-test is ok"));
            assertThat(lamp.getOnCommand(), is("\"C:\\\\Program Files (x86)\\\\Telldus\\\\tdtool.exe\" --on 1"));
            assertThat(lamp.getOffCommand(), is("\"C:\\\\Program Files (x86)\\\\Telldus\\\\tdtool.exe\" --off 1"));
            assertThat(lamp.getJobNames().size(), is(1));
            assertThat(lamp.getJobNames().get(0), is("unit-test"));

            List<Action> actions = lamp.getActions();
            assertThat(actions.size(), is(3));
            assertThat(actions.get(0).getEvent(), is(EventType.whenAllJobsOk));
            assertThat(actions.get(0).isOn(), is(true));
            assertThat(actions.get(1).getEvent(), is(EventType.whenAnyJobFails));
            assertThat(actions.get(1).isOn(), is(false));
            assertThat(actions.get(2).getEvent(), is(EventType.whenAnyJobUndefined));
            assertThat(actions.get(2).isOn(), is(false));
        }
        {
            Lamp lamp = lamps.get(1);
            assertThat(lamp.getName(), is("red"));
            assertThat(lamp.getDescription(), is("Turn on red lamp when job unit-test has failed"));
            assertThat(lamp.getOnCommand(), is("\"C:\\\\Program Files (x86)\\\\Telldus\\\\tdtool.exe\" --on 2"));
            assertThat(lamp.getOffCommand(), is("\"C:\\\\Program Files (x86)\\\\Telldus\\\\tdtool.exe\" --off 2"));
            assertThat(lamp.getJobNames().size(), is(2));
            assertThat(lamp.getJobNames().get(0), is("unit-test"));
            assertThat(lamp.getJobNames().get(1), is("unit-test2"));

            List<Action> actions = lamp.getActions();
            assertThat(actions.size(), is(3));
            assertThat(actions.get(0).getEvent(), is(EventType.whenAllJobsOk));
            assertThat(actions.get(0).isOn(), is(false));
            assertThat(actions.get(1).getEvent(), is(EventType.whenAnyJobUndefined));
            assertThat(actions.get(1).isOn(), is(false));
            assertThat(actions.get(2).getEvent(), is(EventType.whenAnyJobFails));
            assertThat(actions.get(2).isOn(), is(true));
        }
    }
}
