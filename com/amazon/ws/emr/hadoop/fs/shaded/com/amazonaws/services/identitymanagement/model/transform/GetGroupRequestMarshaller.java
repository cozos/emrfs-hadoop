package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetGroupRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class GetGroupRequestMarshaller
  implements Marshaller<Request<GetGroupRequest>, GetGroupRequest>
{
  public Request<GetGroupRequest> marshall(GetGroupRequest getGroupRequest)
  {
    if (getGroupRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<GetGroupRequest> request = new DefaultRequest(getGroupRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "GetGroup");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (getGroupRequest.getGroupName() != null) {
      request.addParameter("GroupName", StringUtils.fromString(getGroupRequest.getGroupName()));
    }
    if (getGroupRequest.getMarker() != null) {
      request.addParameter("Marker", StringUtils.fromString(getGroupRequest.getMarker()));
    }
    if (getGroupRequest.getMaxItems() != null) {
      request.addParameter("MaxItems", StringUtils.fromInteger(getGroupRequest.getMaxItems()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetGroupRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */