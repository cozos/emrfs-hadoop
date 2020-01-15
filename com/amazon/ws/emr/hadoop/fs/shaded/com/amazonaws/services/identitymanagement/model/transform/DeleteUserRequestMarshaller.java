package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteUserRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class DeleteUserRequestMarshaller
  implements Marshaller<Request<DeleteUserRequest>, DeleteUserRequest>
{
  public Request<DeleteUserRequest> marshall(DeleteUserRequest deleteUserRequest)
  {
    if (deleteUserRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<DeleteUserRequest> request = new DefaultRequest(deleteUserRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "DeleteUser");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (deleteUserRequest.getUserName() != null) {
      request.addParameter("UserName", StringUtils.fromString(deleteUserRequest.getUserName()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteUserRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */