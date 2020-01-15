package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazonaws.services.sqs.model.ListQueueTagsRequest;

public class ListQueueTagsRequestMarshaller
  implements Marshaller<Request<ListQueueTagsRequest>, ListQueueTagsRequest>
{
  public Request<ListQueueTagsRequest> marshall(ListQueueTagsRequest listQueueTagsRequest)
  {
    if (listQueueTagsRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<ListQueueTagsRequest> request = new DefaultRequest(listQueueTagsRequest, "AmazonSQS");
    request.addParameter("Action", "ListQueueTags");
    request.addParameter("Version", "2012-11-05");
    request.setHttpMethod(HttpMethodName.POST);
    if (listQueueTagsRequest.getQueueUrl() != null) {
      request.addParameter("QueueUrl", StringUtils.fromString(listQueueTagsRequest.getQueueUrl()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.ListQueueTagsRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */