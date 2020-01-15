package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazonaws.services.sqs.model.DeleteMessageRequest;

public class DeleteMessageRequestMarshaller
  implements Marshaller<Request<DeleteMessageRequest>, DeleteMessageRequest>
{
  public Request<DeleteMessageRequest> marshall(DeleteMessageRequest deleteMessageRequest)
  {
    if (deleteMessageRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<DeleteMessageRequest> request = new DefaultRequest(deleteMessageRequest, "AmazonSQS");
    request.addParameter("Action", "DeleteMessage");
    request.addParameter("Version", "2012-11-05");
    request.setHttpMethod(HttpMethodName.POST);
    if (deleteMessageRequest.getQueueUrl() != null) {
      request.addParameter("QueueUrl", StringUtils.fromString(deleteMessageRequest.getQueueUrl()));
    }
    if (deleteMessageRequest.getReceiptHandle() != null) {
      request.addParameter("ReceiptHandle", StringUtils.fromString(deleteMessageRequest.getReceiptHandle()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.DeleteMessageRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */