package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListAttachedRolePoliciesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class ListAttachedRolePoliciesRequestMarshaller
  implements Marshaller<Request<ListAttachedRolePoliciesRequest>, ListAttachedRolePoliciesRequest>
{
  public Request<ListAttachedRolePoliciesRequest> marshall(ListAttachedRolePoliciesRequest listAttachedRolePoliciesRequest)
  {
    if (listAttachedRolePoliciesRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<ListAttachedRolePoliciesRequest> request = new DefaultRequest(listAttachedRolePoliciesRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "ListAttachedRolePolicies");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (listAttachedRolePoliciesRequest.getRoleName() != null) {
      request.addParameter("RoleName", StringUtils.fromString(listAttachedRolePoliciesRequest.getRoleName()));
    }
    if (listAttachedRolePoliciesRequest.getPathPrefix() != null) {
      request.addParameter("PathPrefix", StringUtils.fromString(listAttachedRolePoliciesRequest.getPathPrefix()));
    }
    if (listAttachedRolePoliciesRequest.getMarker() != null) {
      request.addParameter("Marker", StringUtils.fromString(listAttachedRolePoliciesRequest.getMarker()));
    }
    if (listAttachedRolePoliciesRequest.getMaxItems() != null) {
      request.addParameter("MaxItems", StringUtils.fromInteger(listAttachedRolePoliciesRequest.getMaxItems()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListAttachedRolePoliciesRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */