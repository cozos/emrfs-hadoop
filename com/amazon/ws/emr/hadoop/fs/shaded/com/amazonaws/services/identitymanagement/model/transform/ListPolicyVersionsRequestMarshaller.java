package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListPolicyVersionsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class ListPolicyVersionsRequestMarshaller
  implements Marshaller<Request<ListPolicyVersionsRequest>, ListPolicyVersionsRequest>
{
  public Request<ListPolicyVersionsRequest> marshall(ListPolicyVersionsRequest listPolicyVersionsRequest)
  {
    if (listPolicyVersionsRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<ListPolicyVersionsRequest> request = new DefaultRequest(listPolicyVersionsRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "ListPolicyVersions");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (listPolicyVersionsRequest.getPolicyArn() != null) {
      request.addParameter("PolicyArn", StringUtils.fromString(listPolicyVersionsRequest.getPolicyArn()));
    }
    if (listPolicyVersionsRequest.getMarker() != null) {
      request.addParameter("Marker", StringUtils.fromString(listPolicyVersionsRequest.getMarker()));
    }
    if (listPolicyVersionsRequest.getMaxItems() != null) {
      request.addParameter("MaxItems", StringUtils.fromInteger(listPolicyVersionsRequest.getMaxItems()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListPolicyVersionsRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */