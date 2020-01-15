package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListPoliciesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class ListPoliciesRequestMarshaller
  implements Marshaller<Request<ListPoliciesRequest>, ListPoliciesRequest>
{
  public Request<ListPoliciesRequest> marshall(ListPoliciesRequest listPoliciesRequest)
  {
    if (listPoliciesRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<ListPoliciesRequest> request = new DefaultRequest(listPoliciesRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "ListPolicies");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (listPoliciesRequest.getScope() != null) {
      request.addParameter("Scope", StringUtils.fromString(listPoliciesRequest.getScope()));
    }
    if (listPoliciesRequest.getOnlyAttached() != null) {
      request.addParameter("OnlyAttached", StringUtils.fromBoolean(listPoliciesRequest.getOnlyAttached()));
    }
    if (listPoliciesRequest.getPathPrefix() != null) {
      request.addParameter("PathPrefix", StringUtils.fromString(listPoliciesRequest.getPathPrefix()));
    }
    if (listPoliciesRequest.getPolicyUsageFilter() != null) {
      request.addParameter("PolicyUsageFilter", StringUtils.fromString(listPoliciesRequest.getPolicyUsageFilter()));
    }
    if (listPoliciesRequest.getMarker() != null) {
      request.addParameter("Marker", StringUtils.fromString(listPoliciesRequest.getMarker()));
    }
    if (listPoliciesRequest.getMaxItems() != null) {
      request.addParameter("MaxItems", StringUtils.fromInteger(listPoliciesRequest.getMaxItems()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListPoliciesRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */