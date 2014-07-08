package org.sagebionetworks.dashboard.parse;

public class UriCUQRequestFilter implements RecordFilter {
    @Override
    public boolean matches(Record record) {
        String uri = record.getUri();
        return "/repo/v1/certifiedUserTest".equalsIgnoreCase(uri);
    }
}
