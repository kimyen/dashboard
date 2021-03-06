package org.sagebionetworks.dashboard.service;

import javax.annotation.Resource;

import org.sagebionetworks.dashboard.metric.CertifiedUserMetric;
import org.sagebionetworks.dashboard.metric.CertifiedUserQuizSubmitMetric;
import org.sagebionetworks.dashboard.metric.QuestionFailMetric;
import org.sagebionetworks.dashboard.metric.QuestionPassMetric;
import org.sagebionetworks.dashboard.parse.CuPassingRecord;
import org.sagebionetworks.dashboard.parse.Response;
import org.springframework.stereotype.Service;

@Service("updateCuPassingRecordService")
public class UpdateCuPassingRecordService {

    @Resource
    private CertifiedUserMetric certifiedUsersMetric;

    @Resource
    private UniqueCountWriter uniqueCountWriter;

    @Resource
    private QuestionPassMetric questionPassMetric;

    @Resource
    private QuestionFailMetric questionFailMetric;

    @Resource
    private CertifiedUserQuizSubmitMetric submissionMetric;
    /**
     * process a given passing record and update certified users metric
     */
    public void updateCertifiedUsers(CuPassingRecord record) {
        if (record != null && record.isPassed()) {
            uniqueCountWriter.writeCertifiedUsersMetric(record, certifiedUsersMetric);
        }
    }

    /**
     * process a given passing record and update certified users metric
     */
    public void updateResponses(Response record) {
        if (record == null) {
            return;
        }
        if (record.isCorrect()) {
            uniqueCountWriter.writeResponse(record, questionPassMetric, true);
        } else {
            uniqueCountWriter.writeResponse(record, questionFailMetric, false);
        }
    }

    /**
     * remove the user whom takes the test in staging, but not in production
     */
    public void removeSubmission(String userId) {
        uniqueCountWriter.removeValue(userId, submissionMetric.getName());
    }
}
