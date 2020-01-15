package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazonaws.services.sqs.model.RemovePermissionRequest;

public class RemovePermissionRequestMarshaller
  implements Marshaller<Request<RemovePermissionRequest>, RemovePermissionRequest>
{
  public Request<RemovePermissionRequest> marshall(RemovePermissionRequest removePermissionRequest)
  {
    if (removePermissionRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<RemovePermissionRequest> request = new DefaultRequest(removePermissionRequest, "AmazonSQS");
    request.addParameter("Action", "RemovePermission");
    request.addParameter("Version", "2012-11-05");
    request.setHttpMethod(HttpMethodName.POST);
    if (removePermissionRequest.getQueueUrl() != null) {
      request.addParameter("QueueUrl", StringUtils.fromString(removePermissionRequest.getQueueUrl()));
    }
    if (removePermissionRequest.getLabel() != null) {
      request.addParameter("Label", StringUtils.fromString(removePermissionRequest.getLabel()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.RemovePermissionRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */