package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateRoleRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class UpdateRoleRequestMarshaller
  implements Marshaller<Request<UpdateRoleRequest>, UpdateRoleRequest>
{
  public Request<UpdateRoleRequest> marshall(UpdateRoleRequest updateRoleRequest)
  {
    if (updateRoleRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<UpdateRoleRequest> request = new DefaultRequest(updateRoleRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "UpdateRole");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (updateRoleRequest.getRoleName() != null) {
      request.addParameter("RoleName", StringUtils.fromString(updateRoleRequest.getRoleName()));
    }
    if (updateRoleRequest.getDescription() != null) {
      request.addParameter("Description", StringUtils.fromString(updateRoleRequest.getDescription()));
    }
    if (updateRoleRequest.getMaxSessionDuration() != null) {
      request.addParameter("MaxSessionDuration", StringUtils.fromInteger(updateRoleRequest.getMaxSessionDuration()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateRoleRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */