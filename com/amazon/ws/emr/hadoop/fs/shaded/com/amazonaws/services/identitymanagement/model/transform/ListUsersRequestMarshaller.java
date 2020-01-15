package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListUsersRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class ListUsersRequestMarshaller
  implements Marshaller<Request<ListUsersRequest>, ListUsersRequest>
{
  public Request<ListUsersRequest> marshall(ListUsersRequest listUsersRequest)
  {
    if (listUsersRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<ListUsersRequest> request = new DefaultRequest(listUsersRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "ListUsers");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (listUsersRequest.getPathPrefix() != null) {
      request.addParameter("PathPrefix", StringUtils.fromString(listUsersRequest.getPathPrefix()));
    }
    if (listUsersRequest.getMarker() != null) {
      request.addParameter("Marker", StringUtils.fromString(listUsersRequest.getMarker()));
    }
    if (listUsersRequest.getMaxItems() != null) {
      request.addParameter("MaxItems", StringUtils.fromInteger(listUsersRequest.getMaxItems()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListUsersRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */