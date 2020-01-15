package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteRolePermissionsBoundaryRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class DeleteRolePermissionsBoundaryRequestMarshaller
  implements Marshaller<Request<DeleteRolePermissionsBoundaryRequest>, DeleteRolePermissionsBoundaryRequest>
{
  public Request<DeleteRolePermissionsBoundaryRequest> marshall(DeleteRolePermissionsBoundaryRequest deleteRolePermissionsBoundaryRequest)
  {
    if (deleteRolePermissionsBoundaryRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<DeleteRolePermissionsBoundaryRequest> request = new DefaultRequest(deleteRolePermissionsBoundaryRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "DeleteRolePermissionsBoundary");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (deleteRolePermissionsBoundaryRequest.getRoleName() != null) {
      request.addParameter("RoleName", StringUtils.fromString(deleteRolePermissionsBoundaryRequest.getRoleName()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteRolePermissionsBoundaryRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */