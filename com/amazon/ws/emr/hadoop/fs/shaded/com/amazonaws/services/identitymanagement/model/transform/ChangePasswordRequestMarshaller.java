package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ChangePasswordRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class ChangePasswordRequestMarshaller
  implements Marshaller<Request<ChangePasswordRequest>, ChangePasswordRequest>
{
  public Request<ChangePasswordRequest> marshall(ChangePasswordRequest changePasswordRequest)
  {
    if (changePasswordRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<ChangePasswordRequest> request = new DefaultRequest(changePasswordRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "ChangePassword");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (changePasswordRequest.getOldPassword() != null) {
      request.addParameter("OldPassword", StringUtils.fromString(changePasswordRequest.getOldPassword()));
    }
    if (changePasswordRequest.getNewPassword() != null) {
      request.addParameter("NewPassword", StringUtils.fromString(changePasswordRequest.getNewPassword()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ChangePasswordRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */