package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazonaws.services.sqs.model.CreateQueueRequest;
import java.util.Map;
import java.util.Map.Entry;

public class CreateQueueRequestMarshaller
  implements Marshaller<Request<CreateQueueRequest>, CreateQueueRequest>
{
  public Request<CreateQueueRequest> marshall(CreateQueueRequest createQueueRequest)
  {
    if (createQueueRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<CreateQueueRequest> request = new DefaultRequest(createQueueRequest, "AmazonSQS");
    request.addParameter("Action", "CreateQueue");
    request.addParameter("Version", "2012-11-05");
    request.setHttpMethod(HttpMethodName.POST);
    if (createQueueRequest.getQueueName() != null) {
      request.addParameter("QueueName", StringUtils.fromString(createQueueRequest.getQueueName()));
    }
    Map<String, String> attributes = createQueueRequest.getAttributes();
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
    Object tags = createQueueRequest.getTags();
    int tagsListIndex = 1;
    for (Map.Entry<String, String> entry : ((Map)tags).entrySet())
    {
      if (entry.getKey() != null) {
        request.addParameter("Tag." + tagsListIndex + ".Key", StringUtils.fromString((String)entry.getKey()));
      }
      if (entry.getValue() != null) {
        request.addParameter("Tag." + tagsListIndex + ".Value", StringUtils.fromString((String)entry.getValue()));
      }
      tagsListIndex++;
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.CreateQueueRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */