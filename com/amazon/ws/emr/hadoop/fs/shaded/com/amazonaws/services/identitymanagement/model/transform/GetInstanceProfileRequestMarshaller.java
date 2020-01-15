package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetInstanceProfileRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class GetInstanceProfileRequestMarshaller
  implements Marshaller<Request<GetInstanceProfileRequest>, GetInstanceProfileRequest>
{
  public Request<GetInstanceProfileRequest> marshall(GetInstanceProfileRequest getInstanceProfileRequest)
  {
    if (getInstanceProfileRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<GetInstanceProfileRequest> request = new DefaultRequest(getInstanceProfileRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "GetInstanceProfile");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (getInstanceProfileRequest.getInstanceProfileName() != null) {
      request.addParameter("InstanceProfileName", StringUtils.fromString(getInstanceProfileRequest.getInstanceProfileName()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetInstanceProfileRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */