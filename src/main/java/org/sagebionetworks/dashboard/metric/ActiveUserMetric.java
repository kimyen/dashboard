package org.sagebionetworks.dashboard.metric;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.sagebionetworks.dashboard.parse.ProdFilter;
import org.sagebionetworks.dashboard.parse.RecordFilter;
import org.sagebionetworks.dashboard.parse.RecordReader;
import org.sagebionetworks.dashboard.parse.UserIdReader;
import org.springframework.stereotype.Component;

@Component("activeUserMetric")
public class ActiveUserMetric implements DayCountMetric {

    private final List<RecordFilter> filters = Collections.unmodifiableList(Arrays.asList(
            (RecordFilter)new ProdFilter()));

    private final RecordReader<String> reader = new UserIdReader();

    @Override
    public String getName() {
        return "activeUserMetric";
    }

    @Override
    public List<RecordFilter> getFilters() {
        return filters;
    }

    @Override
    public RecordReader<String> getRecordReader() {
        return reader;
    }
}
