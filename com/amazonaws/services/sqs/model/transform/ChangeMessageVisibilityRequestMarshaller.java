package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityRequest;

public class ChangeMessageVisibilityRequestMarshaller
  implements Marshaller<Request<ChangeMessageVisibilityRequest>, ChangeMessageVisibilityRequest>
{
  public Request<ChangeMessageVisibilityRequest> marshall(ChangeMessageVisibilityRequest changeMessageVisibilityRequest)
  {
    if (changeMessageVisibilityRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<ChangeMessageVisibilityRequest> request = new DefaultRequest(changeMessageVisibilityRequest, "AmazonSQS");
    request.addParameter("Action", "ChangeMessageVisibility");
    request.addParameter("Version", "2012-11-05");
    request.setHttpMethod(HttpMethodName.POST);
    if (changeMessageVisibilityRequest.getQueueUrl() != null) {
      request.addParameter("QueueUrl", StringUtils.fromString(changeMessageVisibilityRequest.getQueueUrl()));
    }
    if (changeMessageVisibilityRequest.getReceiptHandle() != null) {
      request.addParameter("ReceiptHandle", StringUtils.fromString(changeMessageVisibilityRequest.getReceiptHandle()));
    }
    if (changeMessageVisibilityRequest.getVisibilityTimeout() != null) {
      request.addParameter("VisibilityTimeout", StringUtils.fromInteger(changeMessageVisibilityRequest.getVisibilityTimeout()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.ChangeMessageVisibilityRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */