package org.sagebionetworks.dashboard.metric;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.sagebionetworks.dashboard.parse.QuestionFailFilter;
import org.sagebionetworks.dashboard.parse.QuestionIndexReader;
import org.sagebionetworks.dashboard.parse.RecordFilter;
import org.sagebionetworks.dashboard.parse.RecordReader;
import org.springframework.stereotype.Component;

@Component("questionFailMetric")
public class QuestionFailMetric extends QuestionMetric {

    private List<RecordFilter> filters = Collections.unmodifiableList(Arrays.asList(
            (RecordFilter) new QuestionFailFilter()));;
    private RecordReader<String> reader = new QuestionIndexReader();

    @Override
    public String getName() {
        return "questionFailMetric";
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
