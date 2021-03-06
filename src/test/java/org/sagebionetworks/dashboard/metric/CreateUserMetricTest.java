package org.sagebionetworks.dashboard.metric;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.sagebionetworks.dashboard.parse.MethodFilter;
import org.sagebionetworks.dashboard.parse.ProdFilter;
import org.sagebionetworks.dashboard.parse.SuccessFilter;
import org.sagebionetworks.dashboard.parse.UriCreateUserFilter;
import org.sagebionetworks.dashboard.parse.UserIdReader;

public class CreateUserMetricTest {
    @Test
    public void test() {
        UniqueCountMetric metric = new CreateUserMetric();
        assertEquals("createUserMetric", metric.getName());
        assertTrue(metric.getRecordReader() instanceof UserIdReader);
        assertEquals(4, metric.getFilters().size());
        assertTrue(metric.getFilters().get(0) instanceof ProdFilter);
        assertTrue(metric.getFilters().get(1) instanceof SuccessFilter);
        assertTrue(metric.getFilters().get(2) instanceof MethodFilter);
        assertTrue(metric.getFilters().get(3) instanceof UriCreateUserFilter);
    }
}
