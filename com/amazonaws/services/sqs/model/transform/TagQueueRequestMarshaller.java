package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazonaws.services.sqs.model.TagQueueRequest;
import java.util.Map;
import java.util.Map.Entry;

public class TagQueueRequestMarshaller
  implements Marshaller<Request<TagQueueRequest>, TagQueueRequest>
{
  public Request<TagQueueRequest> marshall(TagQueueRequest tagQueueRequest)
  {
    if (tagQueueRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<TagQueueRequest> request = new DefaultRequest(tagQueueRequest, "AmazonSQS");
    request.addParameter("Action", "TagQueue");
    request.addParameter("Version", "2012-11-05");
    request.setHttpMethod(HttpMethodName.POST);
    if (tagQueueRequest.getQueueUrl() != null) {
      request.addParameter("QueueUrl", StringUtils.fromString(tagQueueRequest.getQueueUrl()));
    }
    Map<String, String> tags = tagQueueRequest.getTags();
    int tagsListIndex = 1;
    for (Map.Entry<String, String> entry : tags.entrySet())
    {
      if (entry.getKey() != null) {
        request.addParameter("Tags." + tagsListIndex + ".Key", StringUtils.fromString((String)entry.getKey()));
      }
      if (entry.getValue() != null) {
        request.addParameter("Tags." + tagsListIndex + ".Value", StringUtils.fromString((String)entry.getValue()));
      }
      tagsListIndex++;
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.TagQueueRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */