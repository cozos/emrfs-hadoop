package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateSSHPublicKeyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class UpdateSSHPublicKeyRequestMarshaller
  implements Marshaller<Request<UpdateSSHPublicKeyRequest>, UpdateSSHPublicKeyRequest>
{
  public Request<UpdateSSHPublicKeyRequest> marshall(UpdateSSHPublicKeyRequest updateSSHPublicKeyRequest)
  {
    if (updateSSHPublicKeyRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<UpdateSSHPublicKeyRequest> request = new DefaultRequest(updateSSHPublicKeyRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "UpdateSSHPublicKey");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (updateSSHPublicKeyRequest.getUserName() != null) {
      request.addParameter("UserName", StringUtils.fromString(updateSSHPublicKeyRequest.getUserName()));
    }
    if (updateSSHPublicKeyRequest.getSSHPublicKeyId() != null) {
      request.addParameter("SSHPublicKeyId", StringUtils.fromString(updateSSHPublicKeyRequest.getSSHPublicKeyId()));
    }
    if (updateSSHPublicKeyRequest.getStatus() != null) {
      request.addParameter("Status", StringUtils.fromString(updateSSHPublicKeyRequest.getStatus()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateSSHPublicKeyRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */