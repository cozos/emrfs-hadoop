package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListOpenIDConnectProvidersRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;

public class ListOpenIDConnectProvidersRequestMarshaller
  implements Marshaller<Request<ListOpenIDConnectProvidersRequest>, ListOpenIDConnectProvidersRequest>
{
  public Request<ListOpenIDConnectProvidersRequest> marshall(ListOpenIDConnectProvidersRequest listOpenIDConnectProvidersRequest)
  {
    if (listOpenIDConnectProvidersRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<ListOpenIDConnectProvidersRequest> request = new DefaultRequest(listOpenIDConnectProvidersRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "ListOpenIDConnectProviders");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListOpenIDConnectProvidersRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */