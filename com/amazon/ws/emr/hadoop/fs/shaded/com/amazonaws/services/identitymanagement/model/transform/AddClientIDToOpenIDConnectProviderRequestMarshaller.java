package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AddClientIDToOpenIDConnectProviderRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class AddClientIDToOpenIDConnectProviderRequestMarshaller
  implements Marshaller<Request<AddClientIDToOpenIDConnectProviderRequest>, AddClientIDToOpenIDConnectProviderRequest>
{
  public Request<AddClientIDToOpenIDConnectProviderRequest> marshall(AddClientIDToOpenIDConnectProviderRequest addClientIDToOpenIDConnectProviderRequest)
  {
    if (addClientIDToOpenIDConnectProviderRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<AddClientIDToOpenIDConnectProviderRequest> request = new DefaultRequest(addClientIDToOpenIDConnectProviderRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "AddClientIDToOpenIDConnectProvider");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (addClientIDToOpenIDConnectProviderRequest.getOpenIDConnectProviderArn() != null) {
      request.addParameter("OpenIDConnectProviderArn", StringUtils.fromString(addClientIDToOpenIDConnectProviderRequest.getOpenIDConnectProviderArn()));
    }
    if (addClientIDToOpenIDConnectProviderRequest.getClientID() != null) {
      request.addParameter("ClientID", StringUtils.fromString(addClientIDToOpenIDConnectProviderRequest.getClientID()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.AddClientIDToOpenIDConnectProviderRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */