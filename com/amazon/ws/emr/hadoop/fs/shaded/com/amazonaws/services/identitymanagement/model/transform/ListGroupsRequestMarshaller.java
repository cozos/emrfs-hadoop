package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListGroupsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class ListGroupsRequestMarshaller
  implements Marshaller<Request<ListGroupsRequest>, ListGroupsRequest>
{
  public Request<ListGroupsRequest> marshall(ListGroupsRequest listGroupsRequest)
  {
    if (listGroupsRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<ListGroupsRequest> request = new DefaultRequest(listGroupsRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "ListGroups");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (listGroupsRequest.getPathPrefix() != null) {
      request.addParameter("PathPrefix", StringUtils.fromString(listGroupsRequest.getPathPrefix()));
    }
    if (listGroupsRequest.getMarker() != null) {
      request.addParameter("Marker", StringUtils.fromString(listGroupsRequest.getMarker()));
    }
    if (listGroupsRequest.getMaxItems() != null) {
      request.addParameter("MaxItems", StringUtils.fromInteger(listGroupsRequest.getMaxItems()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListGroupsRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */