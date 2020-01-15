package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.RemoveUserFromGroupRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class RemoveUserFromGroupRequestMarshaller
  implements Marshaller<Request<RemoveUserFromGroupRequest>, RemoveUserFromGroupRequest>
{
  public Request<RemoveUserFromGroupRequest> marshall(RemoveUserFromGroupRequest removeUserFromGroupRequest)
  {
    if (removeUserFromGroupRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<RemoveUserFromGroupRequest> request = new DefaultRequest(removeUserFromGroupRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "RemoveUserFromGroup");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (removeUserFromGroupRequest.getGroupName() != null) {
      request.addParameter("GroupName", StringUtils.fromString(removeUserFromGroupRequest.getGroupName()));
    }
    if (removeUserFromGroupRequest.getUserName() != null) {
      request.addParameter("UserName", StringUtils.fromString(removeUserFromGroupRequest.getUserName()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.RemoveUserFromGroupRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */