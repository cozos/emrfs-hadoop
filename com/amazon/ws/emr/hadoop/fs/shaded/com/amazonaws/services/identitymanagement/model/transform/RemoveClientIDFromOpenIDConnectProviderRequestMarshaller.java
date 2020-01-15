package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.RemoveClientIDFromOpenIDConnectProviderRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class RemoveClientIDFromOpenIDConnectProviderRequestMarshaller
  implements Marshaller<Request<RemoveClientIDFromOpenIDConnectProviderRequest>, RemoveClientIDFromOpenIDConnectProviderRequest>
{
  public Request<RemoveClientIDFromOpenIDConnectProviderRequest> marshall(RemoveClientIDFromOpenIDConnectProviderRequest removeClientIDFromOpenIDConnectProviderRequest)
  {
    if (removeClientIDFromOpenIDConnectProviderRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<RemoveClientIDFromOpenIDConnectProviderRequest> request = new DefaultRequest(removeClientIDFromOpenIDConnectProviderRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "RemoveClientIDFromOpenIDConnectProvider");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (removeClientIDFromOpenIDConnectProviderRequest.getOpenIDConnectProviderArn() != null) {
      request.addParameter("OpenIDConnectProviderArn", 
        StringUtils.fromString(removeClientIDFromOpenIDConnectProviderRequest.getOpenIDConnectProviderArn()));
    }
    if (removeClientIDFromOpenIDConnectProviderRequest.getClientID() != null) {
      request.addParameter("ClientID", StringUtils.fromString(removeClientIDFromOpenIDConnectProviderRequest.getClientID()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.RemoveClientIDFromOpenIDConnectProviderRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */