package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazonaws.services.sqs.model.SetQueueAttributesRequest;
import java.util.Map;
import java.util.Map.Entry;

public class SetQueueAttributesRequestMarshaller
  implements Marshaller<Request<SetQueueAttributesRequest>, SetQueueAttributesRequest>
{
  public Request<SetQueueAttributesRequest> marshall(SetQueueAttributesRequest setQueueAttributesRequest)
  {
    if (setQueueAttributesRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<SetQueueAttributesRequest> request = new DefaultRequest(setQueueAttributesRequest, "AmazonSQS");
    request.addParameter("Action", "SetQueueAttributes");
    request.addParameter("Version", "2012-11-05");
    request.setHttpMethod(HttpMethodName.POST);
    if (setQueueAttributesRequest.getQueueUrl() != null) {
      request.addParameter("QueueUrl", StringUtils.fromString(setQueueAttributesRequest.getQueueUrl()));
    }
    Map<String, String> attributes = setQueueAttributesRequest.getAttributes();
    int attributesListIndex = 1;
    for (Map.Entry<String, String> entry : attributes.entrySet())
    {
      if (entry.getKey() != null) {
        request.addParameter("Attribute." + attributesListIndex + ".Name", StringUtils.fromString((String)entry.getKey()));
      }
      if (entry.getValue() != null) {
        request.addParameter("Attribute." + attributesListIndex + ".Value", StringUtils.fromString((String)entry.getValue()));
      }
      attributesListIndex++;
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.SetQueueAttributesRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */