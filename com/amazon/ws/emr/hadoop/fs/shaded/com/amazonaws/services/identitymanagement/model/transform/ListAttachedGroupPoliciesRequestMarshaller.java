package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListAttachedGroupPoliciesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class ListAttachedGroupPoliciesRequestMarshaller
  implements Marshaller<Request<ListAttachedGroupPoliciesRequest>, ListAttachedGroupPoliciesRequest>
{
  public Request<ListAttachedGroupPoliciesRequest> marshall(ListAttachedGroupPoliciesRequest listAttachedGroupPoliciesRequest)
  {
    if (listAttachedGroupPoliciesRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<ListAttachedGroupPoliciesRequest> request = new DefaultRequest(listAttachedGroupPoliciesRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "ListAttachedGroupPolicies");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (listAttachedGroupPoliciesRequest.getGroupName() != null) {
      request.addParameter("GroupName", StringUtils.fromString(listAttachedGroupPoliciesRequest.getGroupName()));
    }
    if (listAttachedGroupPoliciesRequest.getPathPrefix() != null) {
      request.addParameter("PathPrefix", StringUtils.fromString(listAttachedGroupPoliciesRequest.getPathPrefix()));
    }
    if (listAttachedGroupPoliciesRequest.getMarker() != null) {
      request.addParameter("Marker", StringUtils.fromString(listAttachedGroupPoliciesRequest.getMarker()));
    }
    if (listAttachedGroupPoliciesRequest.getMaxItems() != null) {
      request.addParameter("MaxItems", StringUtils.fromInteger(listAttachedGroupPoliciesRequest.getMaxItems()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListAttachedGroupPoliciesRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */