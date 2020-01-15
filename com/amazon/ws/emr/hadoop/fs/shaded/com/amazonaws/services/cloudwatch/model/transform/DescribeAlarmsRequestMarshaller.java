package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DescribeAlarmsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import java.util.List;

public class DescribeAlarmsRequestMarshaller
  implements Marshaller<Request<DescribeAlarmsRequest>, DescribeAlarmsRequest>
{
  public Request<DescribeAlarmsRequest> marshall(DescribeAlarmsRequest describeAlarmsRequest)
  {
    if (describeAlarmsRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<DescribeAlarmsRequest> request = new DefaultRequest(describeAlarmsRequest, "AmazonCloudWatch");
    request.addParameter("Action", "DescribeAlarms");
    request.addParameter("Version", "2010-08-01");
    request.setHttpMethod(HttpMethodName.POST);
    int alarmNamesListIndex;
    if ((!describeAlarmsRequest.getAlarmNames().isEmpty()) || 
      (!((SdkInternalList)describeAlarmsRequest.getAlarmNames()).isAutoConstruct()))
    {
      SdkInternalList<String> alarmNamesList = (SdkInternalList)describeAlarmsRequest.getAlarmNames();
      alarmNamesListIndex = 1;
      for (String alarmNamesListValue : alarmNamesList)
      {
        if (alarmNamesListValue != null) {
          request.addParameter("AlarmNames.member." + alarmNamesListIndex, StringUtils.fromString(alarmNamesListValue));
        }
        alarmNamesListIndex++;
      }
    }
    if (describeAlarmsRequest.getAlarmNamePrefix() != null) {
      request.addParameter("AlarmNamePrefix", StringUtils.fromString(describeAlarmsRequest.getAlarmNamePrefix()));
    }
    if (describeAlarmsRequest.getStateValue() != null) {
      request.addParameter("StateValue", StringUtils.fromString(describeAlarmsRequest.getStateValue()));
    }
    if (describeAlarmsRequest.getActionPrefix() != null) {
      request.addParameter("ActionPrefix", StringUtils.fromString(describeAlarmsRequest.getActionPrefix()));
    }
    if (describeAlarmsRequest.getMaxRecords() != null) {
      request.addParameter("MaxRecords", StringUtils.fromInteger(describeAlarmsRequest.getMaxRecords()));
    }
    if (describeAlarmsRequest.getNextToken() != null) {
      request.addParameter("NextToken", StringUtils.fromString(describeAlarmsRequest.getNextToken()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.DescribeAlarmsRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */