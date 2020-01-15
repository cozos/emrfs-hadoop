package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateLoginProfileRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class UpdateLoginProfileRequestMarshaller
  implements Marshaller<Request<UpdateLoginProfileRequest>, UpdateLoginProfileRequest>
{
  public Request<UpdateLoginProfileRequest> marshall(UpdateLoginProfileRequest updateLoginProfileRequest)
  {
    if (updateLoginProfileRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<UpdateLoginProfileRequest> request = new DefaultRequest(updateLoginProfileRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "UpdateLoginProfile");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (updateLoginProfileRequest.getUserName() != null) {
      request.addParameter("UserName", StringUtils.fromString(updateLoginProfileRequest.getUserName()));
    }
    if (updateLoginProfileRequest.getPassword() != null) {
      request.addParameter("Password", StringUtils.fromString(updateLoginProfileRequest.getPassword()));
    }
    if (updateLoginProfileRequest.getPasswordResetRequired() != null) {
      request.addParameter("PasswordResetRequired", StringUtils.fromBoolean(updateLoginProfileRequest.getPasswordResetRequired()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateLoginProfileRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */