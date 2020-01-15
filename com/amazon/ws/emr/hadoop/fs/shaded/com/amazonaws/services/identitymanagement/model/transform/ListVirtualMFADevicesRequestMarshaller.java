package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListVirtualMFADevicesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class ListVirtualMFADevicesRequestMarshaller
  implements Marshaller<Request<ListVirtualMFADevicesRequest>, ListVirtualMFADevicesRequest>
{
  public Request<ListVirtualMFADevicesRequest> marshall(ListVirtualMFADevicesRequest listVirtualMFADevicesRequest)
  {
    if (listVirtualMFADevicesRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<ListVirtualMFADevicesRequest> request = new DefaultRequest(listVirtualMFADevicesRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "ListVirtualMFADevices");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (listVirtualMFADevicesRequest.getAssignmentStatus() != null) {
      request.addParameter("AssignmentStatus", StringUtils.fromString(listVirtualMFADevicesRequest.getAssignmentStatus()));
    }
    if (listVirtualMFADevicesRequest.getMarker() != null) {
      request.addParameter("Marker", StringUtils.fromString(listVirtualMFADevicesRequest.getMarker()));
    }
    if (listVirtualMFADevicesRequest.getMaxItems() != null) {
      request.addParameter("MaxItems", StringUtils.fromInteger(listVirtualMFADevicesRequest.getMaxItems()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListVirtualMFADevicesRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */