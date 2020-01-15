package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AddRoleToInstanceProfileRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class AddRoleToInstanceProfileRequestMarshaller
  implements Marshaller<Request<AddRoleToInstanceProfileRequest>, AddRoleToInstanceProfileRequest>
{
  public Request<AddRoleToInstanceProfileRequest> marshall(AddRoleToInstanceProfileRequest addRoleToInstanceProfileRequest)
  {
    if (addRoleToInstanceProfileRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<AddRoleToInstanceProfileRequest> request = new DefaultRequest(addRoleToInstanceProfileRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "AddRoleToInstanceProfile");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (addRoleToInstanceProfileRequest.getInstanceProfileName() != null) {
      request.addParameter("InstanceProfileName", StringUtils.fromString(addRoleToInstanceProfileRequest.getInstanceProfileName()));
    }
    if (addRoleToInstanceProfileRequest.getRoleName() != null) {
      request.addParameter("RoleName", StringUtils.fromString(addRoleToInstanceProfileRequest.getRoleName()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.AddRoleToInstanceProfileRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */