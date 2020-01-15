package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazonaws.services.sqs.model.GetQueueUrlRequest;

public class GetQueueUrlRequestMarshaller
  implements Marshaller<Request<GetQueueUrlRequest>, GetQueueUrlRequest>
{
  public Request<GetQueueUrlRequest> marshall(GetQueueUrlRequest getQueueUrlRequest)
  {
    if (getQueueUrlRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<GetQueueUrlRequest> request = new DefaultRequest(getQueueUrlRequest, "AmazonSQS");
    request.addParameter("Action", "GetQueueUrl");
    request.addParameter("Version", "2012-11-05");
    request.setHttpMethod(HttpMethodName.POST);
    if (getQueueUrlRequest.getQueueName() != null) {
      request.addParameter("QueueName", StringUtils.fromString(getQueueUrlRequest.getQueueName()));
    }
    if (getQueueUrlRequest.getQueueOwnerAWSAccountId() != null) {
      request.addParameter("QueueOwnerAWSAccountId", StringUtils.fromString(getQueueUrlRequest.getQueueOwnerAWSAccountId()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.GetQueueUrlRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */