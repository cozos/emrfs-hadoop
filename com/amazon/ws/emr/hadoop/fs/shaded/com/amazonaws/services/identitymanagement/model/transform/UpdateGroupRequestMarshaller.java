package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateGroupRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class UpdateGroupRequestMarshaller
  implements Marshaller<Request<UpdateGroupRequest>, UpdateGroupRequest>
{
  public Request<UpdateGroupRequest> marshall(UpdateGroupRequest updateGroupRequest)
  {
    if (updateGroupRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<UpdateGroupRequest> request = new DefaultRequest(updateGroupRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "UpdateGroup");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (updateGroupRequest.getGroupName() != null) {
      request.addParameter("GroupName", StringUtils.fromString(updateGroupRequest.getGroupName()));
    }
    if (updateGroupRequest.getNewPath() != null) {
      request.addParameter("NewPath", StringUtils.fromString(updateGroupRequest.getNewPath()));
    }
    if (updateGroupRequest.getNewGroupName() != null) {
      request.addParameter("NewGroupName", StringUtils.fromString(updateGroupRequest.getNewGroupName()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateGroupRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */