package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.UntagResourceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import java.util.List;

public class UntagResourceRequestMarshaller
  implements Marshaller<Request<UntagResourceRequest>, UntagResourceRequest>
{
  public Request<UntagResourceRequest> marshall(UntagResourceRequest untagResourceRequest)
  {
    if (untagResourceRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<UntagResourceRequest> request = new DefaultRequest(untagResourceRequest, "AmazonCloudWatch");
    request.addParameter("Action", "UntagResource");
    request.addParameter("Version", "2010-08-01");
    request.setHttpMethod(HttpMethodName.POST);
    if (untagResourceRequest.getResourceARN() != null) {
      request.addParameter("ResourceARN", StringUtils.fromString(untagResourceRequest.getResourceARN()));
    }
    int tagKeysListIndex;
    if ((!untagResourceRequest.getTagKeys().isEmpty()) || 
      (!((SdkInternalList)untagResourceRequest.getTagKeys()).isAutoConstruct()))
    {
      SdkInternalList<String> tagKeysList = (SdkInternalList)untagResourceRequest.getTagKeys();
      tagKeysListIndex = 1;
      for (String tagKeysListValue : tagKeysList)
      {
        if (tagKeysListValue != null) {
          request.addParameter("TagKeys.member." + tagKeysListIndex, StringUtils.fromString(tagKeysListValue));
        }
        tagKeysListIndex++;
      }
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.UntagResourceRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */