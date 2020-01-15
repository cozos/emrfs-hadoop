package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazonaws.services.sqs.model.DeleteQueueRequest;

public class DeleteQueueRequestMarshaller
  implements Marshaller<Request<DeleteQueueRequest>, DeleteQueueRequest>
{
  public Request<DeleteQueueRequest> marshall(DeleteQueueRequest deleteQueueRequest)
  {
    if (deleteQueueRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<DeleteQueueRequest> request = new DefaultRequest(deleteQueueRequest, "AmazonSQS");
    request.addParameter("Action", "DeleteQueue");
    request.addParameter("Version", "2012-11-05");
    request.setHttpMethod(HttpMethodName.POST);
    if (deleteQueueRequest.getQueueUrl() != null) {
      request.addParameter("QueueUrl", StringUtils.fromString(deleteQueueRequest.getQueueUrl()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.DeleteQueueRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */