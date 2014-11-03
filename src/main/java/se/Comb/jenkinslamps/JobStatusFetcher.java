/*
 * Created by u017121
 */
package se.Comb.jenkinslamps;

import java.util.Collection;
import java.util.Map;

public interface JobStatusFetcher {
    Map<String, JobStatus> getJobStatus(Collection<String> jobNames);
}
