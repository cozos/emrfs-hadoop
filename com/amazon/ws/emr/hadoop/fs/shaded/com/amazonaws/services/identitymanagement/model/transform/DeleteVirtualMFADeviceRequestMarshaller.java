package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteVirtualMFADeviceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class DeleteVirtualMFADeviceRequestMarshaller
  implements Marshaller<Request<DeleteVirtualMFADeviceRequest>, DeleteVirtualMFADeviceRequest>
{
  public Request<DeleteVirtualMFADeviceRequest> marshall(DeleteVirtualMFADeviceRequest deleteVirtualMFADeviceRequest)
  {
    if (deleteVirtualMFADeviceRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<DeleteVirtualMFADeviceRequest> request = new DefaultRequest(deleteVirtualMFADeviceRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "DeleteVirtualMFADevice");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (deleteVirtualMFADeviceRequest.getSerialNumber() != null) {
      request.addParameter("SerialNumber", StringUtils.fromString(deleteVirtualMFADeviceRequest.getSerialNumber()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteVirtualMFADeviceRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */