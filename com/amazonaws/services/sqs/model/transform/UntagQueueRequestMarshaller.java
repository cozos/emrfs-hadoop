package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazonaws.services.sqs.model.UntagQueueRequest;
import java.util.List;

public class UntagQueueRequestMarshaller
  implements Marshaller<Request<UntagQueueRequest>, UntagQueueRequest>
{
  public Request<UntagQueueRequest> marshall(UntagQueueRequest untagQueueRequest)
  {
    if (untagQueueRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<UntagQueueRequest> request = new DefaultRequest(untagQueueRequest, "AmazonSQS");
    request.addParameter("Action", "UntagQueue");
    request.addParameter("Version", "2012-11-05");
    request.setHttpMethod(HttpMethodName.POST);
    if (untagQueueRequest.getQueueUrl() != null) {
      request.addParameter("QueueUrl", StringUtils.fromString(untagQueueRequest.getQueueUrl()));
    }
    int tagKeysListIndex;
    if ((!untagQueueRequest.getTagKeys().isEmpty()) || (!((SdkInternalList)untagQueueRequest.getTagKeys()).isAutoConstruct()))
    {
      SdkInternalList<String> tagKeysList = (SdkInternalList)untagQueueRequest.getTagKeys();
      tagKeysListIndex = 1;
      for (String tagKeysListValue : tagKeysList)
      {
        if (tagKeysListValue != null) {
          request.addParameter("TagKey." + tagKeysListIndex, StringUtils.fromString(tagKeysListValue));
        }
        tagKeysListIndex++;
      }
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.UntagQueueRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */