package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListMFADevicesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class ListMFADevicesRequestMarshaller
  implements Marshaller<Request<ListMFADevicesRequest>, ListMFADevicesRequest>
{
  public Request<ListMFADevicesRequest> marshall(ListMFADevicesRequest listMFADevicesRequest)
  {
    if (listMFADevicesRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<ListMFADevicesRequest> request = new DefaultRequest(listMFADevicesRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "ListMFADevices");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (listMFADevicesRequest.getUserName() != null) {
      request.addParameter("UserName", StringUtils.fromString(listMFADevicesRequest.getUserName()));
    }
    if (listMFADevicesRequest.getMarker() != null) {
      request.addParameter("Marker", StringUtils.fromString(listMFADevicesRequest.getMarker()));
    }
    if (listMFADevicesRequest.getMaxItems() != null) {
      request.addParameter("MaxItems", StringUtils.fromInteger(listMFADevicesRequest.getMaxItems()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListMFADevicesRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */