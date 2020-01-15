package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.EnableAlarmActionsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import java.util.List;

public class EnableAlarmActionsRequestMarshaller
  implements Marshaller<Request<EnableAlarmActionsRequest>, EnableAlarmActionsRequest>
{
  public Request<EnableAlarmActionsRequest> marshall(EnableAlarmActionsRequest enableAlarmActionsRequest)
  {
    if (enableAlarmActionsRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<EnableAlarmActionsRequest> request = new DefaultRequest(enableAlarmActionsRequest, "AmazonCloudWatch");
    request.addParameter("Action", "EnableAlarmActions");
    request.addParameter("Version", "2010-08-01");
    request.setHttpMethod(HttpMethodName.POST);
    int alarmNamesListIndex;
    if ((!enableAlarmActionsRequest.getAlarmNames().isEmpty()) || 
      (!((SdkInternalList)enableAlarmActionsRequest.getAlarmNames()).isAutoConstruct()))
    {
      SdkInternalList<String> alarmNamesList = (SdkInternalList)enableAlarmActionsRequest.getAlarmNames();
      alarmNamesListIndex = 1;
      for (String alarmNamesListValue : alarmNamesList)
      {
        if (alarmNamesListValue != null) {
          request.addParameter("AlarmNames.member." + alarmNamesListIndex, StringUtils.fromString(alarmNamesListValue));
        }
        alarmNamesListIndex++;
      }
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.EnableAlarmActionsRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */