package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListSAMLProvidersRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;

public class ListSAMLProvidersRequestMarshaller
  implements Marshaller<Request<ListSAMLProvidersRequest>, ListSAMLProvidersRequest>
{
  public Request<ListSAMLProvidersRequest> marshall(ListSAMLProvidersRequest listSAMLProvidersRequest)
  {
    if (listSAMLProvidersRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<ListSAMLProvidersRequest> request = new DefaultRequest(listSAMLProvidersRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "ListSAMLProviders");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListSAMLProvidersRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */