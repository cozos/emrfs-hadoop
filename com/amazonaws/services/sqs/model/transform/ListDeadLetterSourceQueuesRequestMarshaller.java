package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazonaws.services.sqs.model.ListDeadLetterSourceQueuesRequest;

public class ListDeadLetterSourceQueuesRequestMarshaller
  implements Marshaller<Request<ListDeadLetterSourceQueuesRequest>, ListDeadLetterSourceQueuesRequest>
{
  public Request<ListDeadLetterSourceQueuesRequest> marshall(ListDeadLetterSourceQueuesRequest listDeadLetterSourceQueuesRequest)
  {
    if (listDeadLetterSourceQueuesRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<ListDeadLetterSourceQueuesRequest> request = new DefaultRequest(listDeadLetterSourceQueuesRequest, "AmazonSQS");
    
    request.addParameter("Action", "ListDeadLetterSourceQueues");
    request.addParameter("Version", "2012-11-05");
    request.setHttpMethod(HttpMethodName.POST);
    if (listDeadLetterSourceQueuesRequest.getQueueUrl() != null) {
      request.addParameter("QueueUrl", StringUtils.fromString(listDeadLetterSourceQueuesRequest.getQueueUrl()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.ListDeadLetterSourceQueuesRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */