package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UploadSSHPublicKeyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class UploadSSHPublicKeyRequestMarshaller
  implements Marshaller<Request<UploadSSHPublicKeyRequest>, UploadSSHPublicKeyRequest>
{
  public Request<UploadSSHPublicKeyRequest> marshall(UploadSSHPublicKeyRequest uploadSSHPublicKeyRequest)
  {
    if (uploadSSHPublicKeyRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<UploadSSHPublicKeyRequest> request = new DefaultRequest(uploadSSHPublicKeyRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "UploadSSHPublicKey");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (uploadSSHPublicKeyRequest.getUserName() != null) {
      request.addParameter("UserName", StringUtils.fromString(uploadSSHPublicKeyRequest.getUserName()));
    }
    if (uploadSSHPublicKeyRequest.getSSHPublicKeyBody() != null) {
      request.addParameter("SSHPublicKeyBody", StringUtils.fromString(uploadSSHPublicKeyRequest.getSSHPublicKeyBody()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UploadSSHPublicKeyRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */