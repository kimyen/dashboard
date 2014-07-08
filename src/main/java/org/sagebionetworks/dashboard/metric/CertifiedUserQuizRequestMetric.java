package org.sagebionetworks.dashboard.metric;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.sagebionetworks.dashboard.parse.MethodFilter;
import org.sagebionetworks.dashboard.parse.RecordFilter;
import org.sagebionetworks.dashboard.parse.RecordReader;
import org.sagebionetworks.dashboard.parse.UriCUQRequestFilter;
import org.sagebionetworks.dashboard.parse.UserIdReader;
import org.springframework.stereotype.Component;

@Component("certifiedUserQuizRequestMetric")
public class CertifiedUserQuizRequestMetric implements UniqueCountMetric {
    
    private final RecordReader<String> reader = new UserIdReader();

    private final List<RecordFilter> filters = Collections.unmodifiableList(Arrays.asList(
            new MethodFilter("get"), new UriCUQRequestFilter()));

    @Override
    public String getName() {
        return "certifiedUserQuizRequestMetric";
    }

    @Override
    public List<RecordFilter> getFilters() {
        return filters ;
    }

    @Override
    public RecordReader<String> getRecordReader() {
        return reader;
    }
    
}
