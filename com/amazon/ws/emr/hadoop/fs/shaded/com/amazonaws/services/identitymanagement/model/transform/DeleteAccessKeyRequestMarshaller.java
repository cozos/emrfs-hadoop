package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteAccessKeyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class DeleteAccessKeyRequestMarshaller
  implements Marshaller<Request<DeleteAccessKeyRequest>, DeleteAccessKeyRequest>
{
  public Request<DeleteAccessKeyRequest> marshall(DeleteAccessKeyRequest deleteAccessKeyRequest)
  {
    if (deleteAccessKeyRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<DeleteAccessKeyRequest> request = new DefaultRequest(deleteAccessKeyRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "DeleteAccessKey");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (deleteAccessKeyRequest.getUserName() != null) {
      request.addParameter("UserName", StringUtils.fromString(deleteAccessKeyRequest.getUserName()));
    }
    if (deleteAccessKeyRequest.getAccessKeyId() != null) {
      request.addParameter("AccessKeyId", StringUtils.fromString(deleteAccessKeyRequest.getAccessKeyId()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteAccessKeyRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */