package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListGroupPoliciesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class ListGroupPoliciesRequestMarshaller
  implements Marshaller<Request<ListGroupPoliciesRequest>, ListGroupPoliciesRequest>
{
  public Request<ListGroupPoliciesRequest> marshall(ListGroupPoliciesRequest listGroupPoliciesRequest)
  {
    if (listGroupPoliciesRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<ListGroupPoliciesRequest> request = new DefaultRequest(listGroupPoliciesRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "ListGroupPolicies");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (listGroupPoliciesRequest.getGroupName() != null) {
      request.addParameter("GroupName", StringUtils.fromString(listGroupPoliciesRequest.getGroupName()));
    }
    if (listGroupPoliciesRequest.getMarker() != null) {
      request.addParameter("Marker", StringUtils.fromString(listGroupPoliciesRequest.getMarker()));
    }
    if (listGroupPoliciesRequest.getMaxItems() != null) {
      request.addParameter("MaxItems", StringUtils.fromInteger(listGroupPoliciesRequest.getMaxItems()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListGroupPoliciesRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */