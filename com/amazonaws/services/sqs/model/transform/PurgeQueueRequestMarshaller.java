package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazonaws.services.sqs.model.PurgeQueueRequest;

public class PurgeQueueRequestMarshaller
  implements Marshaller<Request<PurgeQueueRequest>, PurgeQueueRequest>
{
  public Request<PurgeQueueRequest> marshall(PurgeQueueRequest purgeQueueRequest)
  {
    if (purgeQueueRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<PurgeQueueRequest> request = new DefaultRequest(purgeQueueRequest, "AmazonSQS");
    request.addParameter("Action", "PurgeQueue");
    request.addParameter("Version", "2012-11-05");
    request.setHttpMethod(HttpMethodName.POST);
    if (purgeQueueRequest.getQueueUrl() != null) {
      request.addParameter("QueueUrl", StringUtils.fromString(purgeQueueRequest.getQueueUrl()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.PurgeQueueRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */