package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteServiceSpecificCredentialRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class DeleteServiceSpecificCredentialRequestMarshaller
  implements Marshaller<Request<DeleteServiceSpecificCredentialRequest>, DeleteServiceSpecificCredentialRequest>
{
  public Request<DeleteServiceSpecificCredentialRequest> marshall(DeleteServiceSpecificCredentialRequest deleteServiceSpecificCredentialRequest)
  {
    if (deleteServiceSpecificCredentialRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<DeleteServiceSpecificCredentialRequest> request = new DefaultRequest(deleteServiceSpecificCredentialRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "DeleteServiceSpecificCredential");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (deleteServiceSpecificCredentialRequest.getUserName() != null) {
      request.addParameter("UserName", StringUtils.fromString(deleteServiceSpecificCredentialRequest.getUserName()));
    }
    if (deleteServiceSpecificCredentialRequest.getServiceSpecificCredentialId() != null) {
      request.addParameter("ServiceSpecificCredentialId", StringUtils.fromString(deleteServiceSpecificCredentialRequest.getServiceSpecificCredentialId()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteServiceSpecificCredentialRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */