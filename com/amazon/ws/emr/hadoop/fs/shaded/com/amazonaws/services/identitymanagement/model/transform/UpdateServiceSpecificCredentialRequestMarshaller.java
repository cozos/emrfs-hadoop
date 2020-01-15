package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateServiceSpecificCredentialRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class UpdateServiceSpecificCredentialRequestMarshaller
  implements Marshaller<Request<UpdateServiceSpecificCredentialRequest>, UpdateServiceSpecificCredentialRequest>
{
  public Request<UpdateServiceSpecificCredentialRequest> marshall(UpdateServiceSpecificCredentialRequest updateServiceSpecificCredentialRequest)
  {
    if (updateServiceSpecificCredentialRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<UpdateServiceSpecificCredentialRequest> request = new DefaultRequest(updateServiceSpecificCredentialRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "UpdateServiceSpecificCredential");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (updateServiceSpecificCredentialRequest.getUserName() != null) {
      request.addParameter("UserName", StringUtils.fromString(updateServiceSpecificCredentialRequest.getUserName()));
    }
    if (updateServiceSpecificCredentialRequest.getServiceSpecificCredentialId() != null) {
      request.addParameter("ServiceSpecificCredentialId", StringUtils.fromString(updateServiceSpecificCredentialRequest.getServiceSpecificCredentialId()));
    }
    if (updateServiceSpecificCredentialRequest.getStatus() != null) {
      request.addParameter("Status", StringUtils.fromString(updateServiceSpecificCredentialRequest.getStatus()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateServiceSpecificCredentialRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */