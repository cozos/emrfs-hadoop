package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.SetAlarmStateRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class SetAlarmStateRequestMarshaller
  implements Marshaller<Request<SetAlarmStateRequest>, SetAlarmStateRequest>
{
  public Request<SetAlarmStateRequest> marshall(SetAlarmStateRequest setAlarmStateRequest)
  {
    if (setAlarmStateRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<SetAlarmStateRequest> request = new DefaultRequest(setAlarmStateRequest, "AmazonCloudWatch");
    request.addParameter("Action", "SetAlarmState");
    request.addParameter("Version", "2010-08-01");
    request.setHttpMethod(HttpMethodName.POST);
    if (setAlarmStateRequest.getAlarmName() != null) {
      request.addParameter("AlarmName", StringUtils.fromString(setAlarmStateRequest.getAlarmName()));
    }
    if (setAlarmStateRequest.getStateValue() != null) {
      request.addParameter("StateValue", StringUtils.fromString(setAlarmStateRequest.getStateValue()));
    }
    if (setAlarmStateRequest.getStateReason() != null) {
      request.addParameter("StateReason", StringUtils.fromString(setAlarmStateRequest.getStateReason()));
    }
    if (setAlarmStateRequest.getStateReasonData() != null) {
      request.addParameter("StateReasonData", StringUtils.fromString(setAlarmStateRequest.getStateReasonData()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.SetAlarmStateRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */