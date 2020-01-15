package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetSAMLProviderRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class GetSAMLProviderRequestMarshaller
  implements Marshaller<Request<GetSAMLProviderRequest>, GetSAMLProviderRequest>
{
  public Request<GetSAMLProviderRequest> marshall(GetSAMLProviderRequest getSAMLProviderRequest)
  {
    if (getSAMLProviderRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<GetSAMLProviderRequest> request = new DefaultRequest(getSAMLProviderRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "GetSAMLProvider");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (getSAMLProviderRequest.getSAMLProviderArn() != null) {
      request.addParameter("SAMLProviderArn", StringUtils.fromString(getSAMLProviderRequest.getSAMLProviderArn()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetSAMLProviderRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */