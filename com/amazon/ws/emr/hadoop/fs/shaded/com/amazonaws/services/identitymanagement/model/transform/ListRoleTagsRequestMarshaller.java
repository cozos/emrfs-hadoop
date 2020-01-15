package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListRoleTagsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class ListRoleTagsRequestMarshaller
  implements Marshaller<Request<ListRoleTagsRequest>, ListRoleTagsRequest>
{
  public Request<ListRoleTagsRequest> marshall(ListRoleTagsRequest listRoleTagsRequest)
  {
    if (listRoleTagsRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<ListRoleTagsRequest> request = new DefaultRequest(listRoleTagsRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "ListRoleTags");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (listRoleTagsRequest.getRoleName() != null) {
      request.addParameter("RoleName", StringUtils.fromString(listRoleTagsRequest.getRoleName()));
    }
    if (listRoleTagsRequest.getMarker() != null) {
      request.addParameter("Marker", StringUtils.fromString(listRoleTagsRequest.getMarker()));
    }
    if (listRoleTagsRequest.getMaxItems() != null) {
      request.addParameter("MaxItems", StringUtils.fromInteger(listRoleTagsRequest.getMaxItems()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListRoleTagsRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */