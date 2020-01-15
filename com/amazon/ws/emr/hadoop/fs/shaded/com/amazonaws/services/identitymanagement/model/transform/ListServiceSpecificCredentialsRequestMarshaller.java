package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListServiceSpecificCredentialsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class ListServiceSpecificCredentialsRequestMarshaller
  implements Marshaller<Request<ListServiceSpecificCredentialsRequest>, ListServiceSpecificCredentialsRequest>
{
  public Request<ListServiceSpecificCredentialsRequest> marshall(ListServiceSpecificCredentialsRequest listServiceSpecificCredentialsRequest)
  {
    if (listServiceSpecificCredentialsRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<ListServiceSpecificCredentialsRequest> request = new DefaultRequest(listServiceSpecificCredentialsRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "ListServiceSpecificCredentials");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (listServiceSpecificCredentialsRequest.getUserName() != null) {
      request.addParameter("UserName", StringUtils.fromString(listServiceSpecificCredentialsRequest.getUserName()));
    }
    if (listServiceSpecificCredentialsRequest.getServiceName() != null) {
      request.addParameter("ServiceName", StringUtils.fromString(listServiceSpecificCredentialsRequest.getServiceName()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListServiceSpecificCredentialsRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */