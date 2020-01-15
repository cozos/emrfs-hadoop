package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazonaws.services.sqs.model.GetQueueAttributesRequest;
import java.util.List;

public class GetQueueAttributesRequestMarshaller
  implements Marshaller<Request<GetQueueAttributesRequest>, GetQueueAttributesRequest>
{
  public Request<GetQueueAttributesRequest> marshall(GetQueueAttributesRequest getQueueAttributesRequest)
  {
    if (getQueueAttributesRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<GetQueueAttributesRequest> request = new DefaultRequest(getQueueAttributesRequest, "AmazonSQS");
    request.addParameter("Action", "GetQueueAttributes");
    request.addParameter("Version", "2012-11-05");
    request.setHttpMethod(HttpMethodName.POST);
    if (getQueueAttributesRequest.getQueueUrl() != null) {
      request.addParameter("QueueUrl", StringUtils.fromString(getQueueAttributesRequest.getQueueUrl()));
    }
    int attributeNamesListIndex;
    if ((!getQueueAttributesRequest.getAttributeNames().isEmpty()) || 
      (!((SdkInternalList)getQueueAttributesRequest.getAttributeNames()).isAutoConstruct()))
    {
      SdkInternalList<String> attributeNamesList = (SdkInternalList)getQueueAttributesRequest.getAttributeNames();
      attributeNamesListIndex = 1;
      for (String attributeNamesListValue : attributeNamesList)
      {
        if (attributeNamesListValue != null) {
          request.addParameter("AttributeName." + attributeNamesListIndex, StringUtils.fromString(attributeNamesListValue));
        }
        attributeNamesListIndex++;
      }
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.GetQueueAttributesRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */