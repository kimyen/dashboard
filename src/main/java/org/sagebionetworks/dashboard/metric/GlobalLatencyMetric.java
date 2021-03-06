package org.sagebionetworks.dashboard.metric;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.sagebionetworks.dashboard.parse.LatencyReader;
import org.sagebionetworks.dashboard.parse.ProdFilter;
import org.sagebionetworks.dashboard.parse.RecordFilter;
import org.sagebionetworks.dashboard.parse.RecordReader;
import org.springframework.stereotype.Component;

/** Latencies of all the REST API calls. */
@Component("globalLatencyMetric")
public class GlobalLatencyMetric implements TimeSeriesMetric {

    private final List<RecordFilter> filters = Collections.unmodifiableList(Arrays.asList(
            (RecordFilter)new ProdFilter()));

    private final RecordReader<Long> reader = new LatencyReader();

    @Override
    public String getName() {
        return "globalLatencyMetric";
    }

    @Override
    public List<RecordFilter> getFilters() {
        return filters;
    }

    @Override
    public RecordReader<Long> getRecordReader() {
        return reader;
    }
}
