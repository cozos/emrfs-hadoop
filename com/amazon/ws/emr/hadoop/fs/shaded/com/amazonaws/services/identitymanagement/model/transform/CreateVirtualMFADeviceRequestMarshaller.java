package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateVirtualMFADeviceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class CreateVirtualMFADeviceRequestMarshaller
  implements Marshaller<Request<CreateVirtualMFADeviceRequest>, CreateVirtualMFADeviceRequest>
{
  public Request<CreateVirtualMFADeviceRequest> marshall(CreateVirtualMFADeviceRequest createVirtualMFADeviceRequest)
  {
    if (createVirtualMFADeviceRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<CreateVirtualMFADeviceRequest> request = new DefaultRequest(createVirtualMFADeviceRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "CreateVirtualMFADevice");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (createVirtualMFADeviceRequest.getPath() != null) {
      request.addParameter("Path", StringUtils.fromString(createVirtualMFADeviceRequest.getPath()));
    }
    if (createVirtualMFADeviceRequest.getVirtualMFADeviceName() != null) {
      request.addParameter("VirtualMFADeviceName", StringUtils.fromString(createVirtualMFADeviceRequest.getVirtualMFADeviceName()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CreateVirtualMFADeviceRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */