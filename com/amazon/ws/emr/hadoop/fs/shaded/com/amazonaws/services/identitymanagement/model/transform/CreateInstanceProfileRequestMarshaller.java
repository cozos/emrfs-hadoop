package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateInstanceProfileRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class CreateInstanceProfileRequestMarshaller
  implements Marshaller<Request<CreateInstanceProfileRequest>, CreateInstanceProfileRequest>
{
  public Request<CreateInstanceProfileRequest> marshall(CreateInstanceProfileRequest createInstanceProfileRequest)
  {
    if (createInstanceProfileRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<CreateInstanceProfileRequest> request = new DefaultRequest(createInstanceProfileRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "CreateInstanceProfile");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (createInstanceProfileRequest.getInstanceProfileName() != null) {
      request.addParameter("InstanceProfileName", StringUtils.fromString(createInstanceProfileRequest.getInstanceProfileName()));
    }
    if (createInstanceProfileRequest.getPath() != null) {
      request.addParameter("Path", StringUtils.fromString(createInstanceProfileRequest.getPath()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CreateInstanceProfileRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */