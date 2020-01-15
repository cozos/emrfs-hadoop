package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.EnableMFADeviceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class EnableMFADeviceRequestMarshaller
  implements Marshaller<Request<EnableMFADeviceRequest>, EnableMFADeviceRequest>
{
  public Request<EnableMFADeviceRequest> marshall(EnableMFADeviceRequest enableMFADeviceRequest)
  {
    if (enableMFADeviceRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<EnableMFADeviceRequest> request = new DefaultRequest(enableMFADeviceRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "EnableMFADevice");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (enableMFADeviceRequest.getUserName() != null) {
      request.addParameter("UserName", StringUtils.fromString(enableMFADeviceRequest.getUserName()));
    }
    if (enableMFADeviceRequest.getSerialNumber() != null) {
      request.addParameter("SerialNumber", StringUtils.fromString(enableMFADeviceRequest.getSerialNumber()));
    }
    if (enableMFADeviceRequest.getAuthenticationCode1() != null) {
      request.addParameter("AuthenticationCode1", StringUtils.fromString(enableMFADeviceRequest.getAuthenticationCode1()));
    }
    if (enableMFADeviceRequest.getAuthenticationCode2() != null) {
      request.addParameter("AuthenticationCode2", StringUtils.fromString(enableMFADeviceRequest.getAuthenticationCode2()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.EnableMFADeviceRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */