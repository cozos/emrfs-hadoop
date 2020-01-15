package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListUserPoliciesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class ListUserPoliciesRequestMarshaller
  implements Marshaller<Request<ListUserPoliciesRequest>, ListUserPoliciesRequest>
{
  public Request<ListUserPoliciesRequest> marshall(ListUserPoliciesRequest listUserPoliciesRequest)
  {
    if (listUserPoliciesRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<ListUserPoliciesRequest> request = new DefaultRequest(listUserPoliciesRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "ListUserPolicies");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (listUserPoliciesRequest.getUserName() != null) {
      request.addParameter("UserName", StringUtils.fromString(listUserPoliciesRequest.getUserName()));
    }
    if (listUserPoliciesRequest.getMarker() != null) {
      request.addParameter("Marker", StringUtils.fromString(listUserPoliciesRequest.getMarker()));
    }
    if (listUserPoliciesRequest.getMaxItems() != null) {
      request.addParameter("MaxItems", StringUtils.fromInteger(listUserPoliciesRequest.getMaxItems()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListUserPoliciesRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */