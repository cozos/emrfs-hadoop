package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateAccessKeyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class UpdateAccessKeyRequestMarshaller
  implements Marshaller<Request<UpdateAccessKeyRequest>, UpdateAccessKeyRequest>
{
  public Request<UpdateAccessKeyRequest> marshall(UpdateAccessKeyRequest updateAccessKeyRequest)
  {
    if (updateAccessKeyRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<UpdateAccessKeyRequest> request = new DefaultRequest(updateAccessKeyRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "UpdateAccessKey");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (updateAccessKeyRequest.getUserName() != null) {
      request.addParameter("UserName", StringUtils.fromString(updateAccessKeyRequest.getUserName()));
    }
    if (updateAccessKeyRequest.getAccessKeyId() != null) {
      request.addParameter("AccessKeyId", StringUtils.fromString(updateAccessKeyRequest.getAccessKeyId()));
    }
    if (updateAccessKeyRequest.getStatus() != null) {
      request.addParameter("Status", StringUtils.fromString(updateAccessKeyRequest.getStatus()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateAccessKeyRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */