package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DescribeAlarmHistoryRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class DescribeAlarmHistoryRequestMarshaller
  implements Marshaller<Request<DescribeAlarmHistoryRequest>, DescribeAlarmHistoryRequest>
{
  public Request<DescribeAlarmHistoryRequest> marshall(DescribeAlarmHistoryRequest describeAlarmHistoryRequest)
  {
    if (describeAlarmHistoryRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<DescribeAlarmHistoryRequest> request = new DefaultRequest(describeAlarmHistoryRequest, "AmazonCloudWatch");
    request.addParameter("Action", "DescribeAlarmHistory");
    request.addParameter("Version", "2010-08-01");
    request.setHttpMethod(HttpMethodName.POST);
    if (describeAlarmHistoryRequest.getAlarmName() != null) {
      request.addParameter("AlarmName", StringUtils.fromString(describeAlarmHistoryRequest.getAlarmName()));
    }
    if (describeAlarmHistoryRequest.getHistoryItemType() != null) {
      request.addParameter("HistoryItemType", StringUtils.fromString(describeAlarmHistoryRequest.getHistoryItemType()));
    }
    if (describeAlarmHistoryRequest.getStartDate() != null) {
      request.addParameter("StartDate", StringUtils.fromDate(describeAlarmHistoryRequest.getStartDate()));
    }
    if (describeAlarmHistoryRequest.getEndDate() != null) {
      request.addParameter("EndDate", StringUtils.fromDate(describeAlarmHistoryRequest.getEndDate()));
    }
    if (describeAlarmHistoryRequest.getMaxRecords() != null) {
      request.addParameter("MaxRecords", StringUtils.fromInteger(describeAlarmHistoryRequest.getMaxRecords()));
    }
    if (describeAlarmHistoryRequest.getNextToken() != null) {
      request.addParameter("NextToken", StringUtils.fromString(describeAlarmHistoryRequest.getNextToken()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.DescribeAlarmHistoryRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */