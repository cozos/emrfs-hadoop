package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateLoginProfileRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class CreateLoginProfileRequestMarshaller
  implements Marshaller<Request<CreateLoginProfileRequest>, CreateLoginProfileRequest>
{
  public Request<CreateLoginProfileRequest> marshall(CreateLoginProfileRequest createLoginProfileRequest)
  {
    if (createLoginProfileRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<CreateLoginProfileRequest> request = new DefaultRequest(createLoginProfileRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "CreateLoginProfile");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (createLoginProfileRequest.getUserName() != null) {
      request.addParameter("UserName", StringUtils.fromString(createLoginProfileRequest.getUserName()));
    }
    if (createLoginProfileRequest.getPassword() != null) {
      request.addParameter("Password", StringUtils.fromString(createLoginProfileRequest.getPassword()));
    }
    if (createLoginProfileRequest.getPasswordResetRequired() != null) {
      request.addParameter("PasswordResetRequired", StringUtils.fromBoolean(createLoginProfileRequest.getPasswordResetRequired()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CreateLoginProfileRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */