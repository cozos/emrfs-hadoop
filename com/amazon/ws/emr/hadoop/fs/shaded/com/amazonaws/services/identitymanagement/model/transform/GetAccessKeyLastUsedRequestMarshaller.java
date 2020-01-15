package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetAccessKeyLastUsedRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class GetAccessKeyLastUsedRequestMarshaller
  implements Marshaller<Request<GetAccessKeyLastUsedRequest>, GetAccessKeyLastUsedRequest>
{
  public Request<GetAccessKeyLastUsedRequest> marshall(GetAccessKeyLastUsedRequest getAccessKeyLastUsedRequest)
  {
    if (getAccessKeyLastUsedRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<GetAccessKeyLastUsedRequest> request = new DefaultRequest(getAccessKeyLastUsedRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "GetAccessKeyLastUsed");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (getAccessKeyLastUsedRequest.getAccessKeyId() != null) {
      request.addParameter("AccessKeyId", StringUtils.fromString(getAccessKeyLastUsedRequest.getAccessKeyId()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetAccessKeyLastUsedRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */