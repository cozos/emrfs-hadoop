package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListGroupsForUserRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class ListGroupsForUserRequestMarshaller
  implements Marshaller<Request<ListGroupsForUserRequest>, ListGroupsForUserRequest>
{
  public Request<ListGroupsForUserRequest> marshall(ListGroupsForUserRequest listGroupsForUserRequest)
  {
    if (listGroupsForUserRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<ListGroupsForUserRequest> request = new DefaultRequest(listGroupsForUserRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "ListGroupsForUser");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (listGroupsForUserRequest.getUserName() != null) {
      request.addParameter("UserName", StringUtils.fromString(listGroupsForUserRequest.getUserName()));
    }
    if (listGroupsForUserRequest.getMarker() != null) {
      request.addParameter("Marker", StringUtils.fromString(listGroupsForUserRequest.getMarker()));
    }
    if (listGroupsForUserRequest.getMaxItems() != null) {
      request.addParameter("MaxItems", StringUtils.fromInteger(listGroupsForUserRequest.getMaxItems()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListGroupsForUserRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */