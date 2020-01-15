package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteSSHPublicKeyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class DeleteSSHPublicKeyRequestMarshaller
  implements Marshaller<Request<DeleteSSHPublicKeyRequest>, DeleteSSHPublicKeyRequest>
{
  public Request<DeleteSSHPublicKeyRequest> marshall(DeleteSSHPublicKeyRequest deleteSSHPublicKeyRequest)
  {
    if (deleteSSHPublicKeyRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<DeleteSSHPublicKeyRequest> request = new DefaultRequest(deleteSSHPublicKeyRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "DeleteSSHPublicKey");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (deleteSSHPublicKeyRequest.getUserName() != null) {
      request.addParameter("UserName", StringUtils.fromString(deleteSSHPublicKeyRequest.getUserName()));
    }
    if (deleteSSHPublicKeyRequest.getSSHPublicKeyId() != null) {
      request.addParameter("SSHPublicKeyId", StringUtils.fromString(deleteSSHPublicKeyRequest.getSSHPublicKeyId()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteSSHPublicKeyRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */