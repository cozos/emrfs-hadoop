package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazonaws.services.sqs.model.ListQueuesRequest;

public class ListQueuesRequestMarshaller
  implements Marshaller<Request<ListQueuesRequest>, ListQueuesRequest>
{
  public Request<ListQueuesRequest> marshall(ListQueuesRequest listQueuesRequest)
  {
    if (listQueuesRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<ListQueuesRequest> request = new DefaultRequest(listQueuesRequest, "AmazonSQS");
    request.addParameter("Action", "ListQueues");
    request.addParameter("Version", "2012-11-05");
    request.setHttpMethod(HttpMethodName.POST);
    if (listQueuesRequest.getQueueNamePrefix() != null) {
      request.addParameter("QueueNamePrefix", StringUtils.fromString(listQueuesRequest.getQueueNamePrefix()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.ListQueuesRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */