package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetSSHPublicKeyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class GetSSHPublicKeyRequestMarshaller
  implements Marshaller<Request<GetSSHPublicKeyRequest>, GetSSHPublicKeyRequest>
{
  public Request<GetSSHPublicKeyRequest> marshall(GetSSHPublicKeyRequest getSSHPublicKeyRequest)
  {
    if (getSSHPublicKeyRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<GetSSHPublicKeyRequest> request = new DefaultRequest(getSSHPublicKeyRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "GetSSHPublicKey");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (getSSHPublicKeyRequest.getUserName() != null) {
      request.addParameter("UserName", StringUtils.fromString(getSSHPublicKeyRequest.getUserName()));
    }
    if (getSSHPublicKeyRequest.getSSHPublicKeyId() != null) {
      request.addParameter("SSHPublicKeyId", StringUtils.fromString(getSSHPublicKeyRequest.getSSHPublicKeyId()));
    }
    if (getSSHPublicKeyRequest.getEncoding() != null) {
      request.addParameter("Encoding", StringUtils.fromString(getSSHPublicKeyRequest.getEncoding()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetSSHPublicKeyRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */