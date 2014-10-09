/*
 * Created by KDMA02 2013-09-30 15:30
 */
package se.caglabs.jenkinslamps;

import java.util.Collection;
import java.util.Map;

public interface JobStatusFetcher {
    Map<String, JobStatus> getJobStatus(Collection<String> jobNames);
}
