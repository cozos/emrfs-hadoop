package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateUserRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class UpdateUserRequestMarshaller
  implements Marshaller<Request<UpdateUserRequest>, UpdateUserRequest>
{
  public Request<UpdateUserRequest> marshall(UpdateUserRequest updateUserRequest)
  {
    if (updateUserRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<UpdateUserRequest> request = new DefaultRequest(updateUserRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "UpdateUser");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (updateUserRequest.getUserName() != null) {
      request.addParameter("UserName", StringUtils.fromString(updateUserRequest.getUserName()));
    }
    if (updateUserRequest.getNewPath() != null) {
      request.addParameter("NewPath", StringUtils.fromString(updateUserRequest.getNewPath()));
    }
    if (updateUserRequest.getNewUserName() != null) {
      request.addParameter("NewUserName", StringUtils.fromString(updateUserRequest.getNewUserName()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateUserRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */