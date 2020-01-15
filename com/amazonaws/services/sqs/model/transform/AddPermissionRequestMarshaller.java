package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazonaws.services.sqs.model.AddPermissionRequest;
import java.util.List;

public class AddPermissionRequestMarshaller
  implements Marshaller<Request<AddPermissionRequest>, AddPermissionRequest>
{
  public Request<AddPermissionRequest> marshall(AddPermissionRequest addPermissionRequest)
  {
    if (addPermissionRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<AddPermissionRequest> request = new DefaultRequest(addPermissionRequest, "AmazonSQS");
    request.addParameter("Action", "AddPermission");
    request.addParameter("Version", "2012-11-05");
    request.setHttpMethod(HttpMethodName.POST);
    if (addPermissionRequest.getQueueUrl() != null) {
      request.addParameter("QueueUrl", StringUtils.fromString(addPermissionRequest.getQueueUrl()));
    }
    if (addPermissionRequest.getLabel() != null) {
      request.addParameter("Label", StringUtils.fromString(addPermissionRequest.getLabel()));
    }
    int aWSAccountIdsListIndex;
    if ((!addPermissionRequest.getAWSAccountIds().isEmpty()) || 
      (!((SdkInternalList)addPermissionRequest.getAWSAccountIds()).isAutoConstruct()))
    {
      SdkInternalList<String> aWSAccountIdsList = (SdkInternalList)addPermissionRequest.getAWSAccountIds();
      aWSAccountIdsListIndex = 1;
      for (String aWSAccountIdsListValue : aWSAccountIdsList)
      {
        if (aWSAccountIdsListValue != null) {
          request.addParameter("AWSAccountId." + aWSAccountIdsListIndex, StringUtils.fromString(aWSAccountIdsListValue));
        }
        aWSAccountIdsListIndex++;
      }
    }
    int actionsListIndex;
    if ((!addPermissionRequest.getActions().isEmpty()) || 
      (!((SdkInternalList)addPermissionRequest.getActions()).isAutoConstruct()))
    {
      SdkInternalList<String> actionsList = (SdkInternalList)addPermissionRequest.getActions();
      actionsListIndex = 1;
      for (String actionsListValue : actionsList)
      {
        if (actionsListValue != null) {
          request.addParameter("ActionName." + actionsListIndex, StringUtils.fromString(actionsListValue));
        }
        actionsListIndex++;
      }
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.AddPermissionRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */