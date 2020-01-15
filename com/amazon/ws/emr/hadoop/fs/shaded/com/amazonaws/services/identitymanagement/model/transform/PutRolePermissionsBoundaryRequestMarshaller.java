package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.PutRolePermissionsBoundaryRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class PutRolePermissionsBoundaryRequestMarshaller
  implements Marshaller<Request<PutRolePermissionsBoundaryRequest>, PutRolePermissionsBoundaryRequest>
{
  public Request<PutRolePermissionsBoundaryRequest> marshall(PutRolePermissionsBoundaryRequest putRolePermissionsBoundaryRequest)
  {
    if (putRolePermissionsBoundaryRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<PutRolePermissionsBoundaryRequest> request = new DefaultRequest(putRolePermissionsBoundaryRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "PutRolePermissionsBoundary");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (putRolePermissionsBoundaryRequest.getRoleName() != null) {
      request.addParameter("RoleName", StringUtils.fromString(putRolePermissionsBoundaryRequest.getRoleName()));
    }
    if (putRolePermissionsBoundaryRequest.getPermissionsBoundary() != null) {
      request.addParameter("PermissionsBoundary", StringUtils.fromString(putRolePermissionsBoundaryRequest.getPermissionsBoundary()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.PutRolePermissionsBoundaryRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */