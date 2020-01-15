package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListEntitiesForPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class ListEntitiesForPolicyRequestMarshaller
  implements Marshaller<Request<ListEntitiesForPolicyRequest>, ListEntitiesForPolicyRequest>
{
  public Request<ListEntitiesForPolicyRequest> marshall(ListEntitiesForPolicyRequest listEntitiesForPolicyRequest)
  {
    if (listEntitiesForPolicyRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<ListEntitiesForPolicyRequest> request = new DefaultRequest(listEntitiesForPolicyRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "ListEntitiesForPolicy");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (listEntitiesForPolicyRequest.getPolicyArn() != null) {
      request.addParameter("PolicyArn", StringUtils.fromString(listEntitiesForPolicyRequest.getPolicyArn()));
    }
    if (listEntitiesForPolicyRequest.getEntityFilter() != null) {
      request.addParameter("EntityFilter", StringUtils.fromString(listEntitiesForPolicyRequest.getEntityFilter()));
    }
    if (listEntitiesForPolicyRequest.getPathPrefix() != null) {
      request.addParameter("PathPrefix", StringUtils.fromString(listEntitiesForPolicyRequest.getPathPrefix()));
    }
    if (listEntitiesForPolicyRequest.getPolicyUsageFilter() != null) {
      request.addParameter("PolicyUsageFilter", StringUtils.fromString(listEntitiesForPolicyRequest.getPolicyUsageFilter()));
    }
    if (listEntitiesForPolicyRequest.getMarker() != null) {
      request.addParameter("Marker", StringUtils.fromString(listEntitiesForPolicyRequest.getMarker()));
    }
    if (listEntitiesForPolicyRequest.getMaxItems() != null) {
      request.addParameter("MaxItems", StringUtils.fromInteger(listEntitiesForPolicyRequest.getMaxItems()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListEntitiesForPolicyRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */