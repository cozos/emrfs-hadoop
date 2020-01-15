package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeactivateMFADeviceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class DeactivateMFADeviceRequestMarshaller
  implements Marshaller<Request<DeactivateMFADeviceRequest>, DeactivateMFADeviceRequest>
{
  public Request<DeactivateMFADeviceRequest> marshall(DeactivateMFADeviceRequest deactivateMFADeviceRequest)
  {
    if (deactivateMFADeviceRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<DeactivateMFADeviceRequest> request = new DefaultRequest(deactivateMFADeviceRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "DeactivateMFADevice");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (deactivateMFADeviceRequest.getUserName() != null) {
      request.addParameter("UserName", StringUtils.fromString(deactivateMFADeviceRequest.getUserName()));
    }
    if (deactivateMFADeviceRequest.getSerialNumber() != null) {
      request.addParameter("SerialNumber", StringUtils.fromString(deactivateMFADeviceRequest.getSerialNumber()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeactivateMFADeviceRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */