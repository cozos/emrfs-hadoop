package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AddUserToGroupRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class AddUserToGroupRequestMarshaller
  implements Marshaller<Request<AddUserToGroupRequest>, AddUserToGroupRequest>
{
  public Request<AddUserToGroupRequest> marshall(AddUserToGroupRequest addUserToGroupRequest)
  {
    if (addUserToGroupRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<AddUserToGroupRequest> request = new DefaultRequest(addUserToGroupRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "AddUserToGroup");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (addUserToGroupRequest.getGroupName() != null) {
      request.addParameter("GroupName", StringUtils.fromString(addUserToGroupRequest.getGroupName()));
    }
    if (addUserToGroupRequest.getUserName() != null) {
      request.addParameter("UserName", StringUtils.fromString(addUserToGroupRequest.getUserName()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.AddUserToGroupRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */