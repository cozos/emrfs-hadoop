package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListAttachedUserPoliciesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class ListAttachedUserPoliciesRequestMarshaller
  implements Marshaller<Request<ListAttachedUserPoliciesRequest>, ListAttachedUserPoliciesRequest>
{
  public Request<ListAttachedUserPoliciesRequest> marshall(ListAttachedUserPoliciesRequest listAttachedUserPoliciesRequest)
  {
    if (listAttachedUserPoliciesRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<ListAttachedUserPoliciesRequest> request = new DefaultRequest(listAttachedUserPoliciesRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "ListAttachedUserPolicies");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (listAttachedUserPoliciesRequest.getUserName() != null) {
      request.addParameter("UserName", StringUtils.fromString(listAttachedUserPoliciesRequest.getUserName()));
    }
    if (listAttachedUserPoliciesRequest.getPathPrefix() != null) {
      request.addParameter("PathPrefix", StringUtils.fromString(listAttachedUserPoliciesRequest.getPathPrefix()));
    }
    if (listAttachedUserPoliciesRequest.getMarker() != null) {
      request.addParameter("Marker", StringUtils.fromString(listAttachedUserPoliciesRequest.getMarker()));
    }
    if (listAttachedUserPoliciesRequest.getMaxItems() != null) {
      request.addParameter("MaxItems", StringUtils.fromInteger(listAttachedUserPoliciesRequest.getMaxItems()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListAttachedUserPoliciesRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */