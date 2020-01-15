package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListInstanceProfilesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class ListInstanceProfilesRequestMarshaller
  implements Marshaller<Request<ListInstanceProfilesRequest>, ListInstanceProfilesRequest>
{
  public Request<ListInstanceProfilesRequest> marshall(ListInstanceProfilesRequest listInstanceProfilesRequest)
  {
    if (listInstanceProfilesRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<ListInstanceProfilesRequest> request = new DefaultRequest(listInstanceProfilesRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "ListInstanceProfiles");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (listInstanceProfilesRequest.getPathPrefix() != null) {
      request.addParameter("PathPrefix", StringUtils.fromString(listInstanceProfilesRequest.getPathPrefix()));
    }
    if (listInstanceProfilesRequest.getMarker() != null) {
      request.addParameter("Marker", StringUtils.fromString(listInstanceProfilesRequest.getMarker()));
    }
    if (listInstanceProfilesRequest.getMaxItems() != null) {
      request.addParameter("MaxItems", StringUtils.fromInteger(listInstanceProfilesRequest.getMaxItems()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListInstanceProfilesRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */