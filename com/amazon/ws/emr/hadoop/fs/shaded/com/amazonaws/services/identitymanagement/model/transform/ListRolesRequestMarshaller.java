package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListRolesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class ListRolesRequestMarshaller
  implements Marshaller<Request<ListRolesRequest>, ListRolesRequest>
{
  public Request<ListRolesRequest> marshall(ListRolesRequest listRolesRequest)
  {
    if (listRolesRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<ListRolesRequest> request = new DefaultRequest(listRolesRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "ListRoles");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (listRolesRequest.getPathPrefix() != null) {
      request.addParameter("PathPrefix", StringUtils.fromString(listRolesRequest.getPathPrefix()));
    }
    if (listRolesRequest.getMarker() != null) {
      request.addParameter("Marker", StringUtils.fromString(listRolesRequest.getMarker()));
    }
    if (listRolesRequest.getMaxItems() != null) {
      request.addParameter("MaxItems", StringUtils.fromInteger(listRolesRequest.getMaxItems()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListRolesRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */