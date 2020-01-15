package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.ListTagsForResourceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class ListTagsForResourceRequestMarshaller
  implements Marshaller<Request<ListTagsForResourceRequest>, ListTagsForResourceRequest>
{
  public Request<ListTagsForResourceRequest> marshall(ListTagsForResourceRequest listTagsForResourceRequest)
  {
    if (listTagsForResourceRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<ListTagsForResourceRequest> request = new DefaultRequest(listTagsForResourceRequest, "AmazonCloudWatch");
    request.addParameter("Action", "ListTagsForResource");
    request.addParameter("Version", "2010-08-01");
    request.setHttpMethod(HttpMethodName.POST);
    if (listTagsForResourceRequest.getResourceARN() != null) {
      request.addParameter("ResourceARN", StringUtils.fromString(listTagsForResourceRequest.getResourceARN()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.ListTagsForResourceRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */