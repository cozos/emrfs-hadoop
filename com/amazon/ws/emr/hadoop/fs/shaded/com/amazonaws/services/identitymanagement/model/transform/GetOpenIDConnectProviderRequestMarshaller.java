package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetOpenIDConnectProviderRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class GetOpenIDConnectProviderRequestMarshaller
  implements Marshaller<Request<GetOpenIDConnectProviderRequest>, GetOpenIDConnectProviderRequest>
{
  public Request<GetOpenIDConnectProviderRequest> marshall(GetOpenIDConnectProviderRequest getOpenIDConnectProviderRequest)
  {
    if (getOpenIDConnectProviderRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<GetOpenIDConnectProviderRequest> request = new DefaultRequest(getOpenIDConnectProviderRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "GetOpenIDConnectProvider");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (getOpenIDConnectProviderRequest.getOpenIDConnectProviderArn() != null) {
      request.addParameter("OpenIDConnectProviderArn", StringUtils.fromString(getOpenIDConnectProviderRequest.getOpenIDConnectProviderArn()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetOpenIDConnectProviderRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */