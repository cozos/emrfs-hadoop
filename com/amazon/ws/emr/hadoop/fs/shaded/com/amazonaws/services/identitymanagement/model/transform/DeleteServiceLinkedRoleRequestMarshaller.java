package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteServiceLinkedRoleRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class DeleteServiceLinkedRoleRequestMarshaller
  implements Marshaller<Request<DeleteServiceLinkedRoleRequest>, DeleteServiceLinkedRoleRequest>
{
  public Request<DeleteServiceLinkedRoleRequest> marshall(DeleteServiceLinkedRoleRequest deleteServiceLinkedRoleRequest)
  {
    if (deleteServiceLinkedRoleRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<DeleteServiceLinkedRoleRequest> request = new DefaultRequest(deleteServiceLinkedRoleRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "DeleteServiceLinkedRole");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (deleteServiceLinkedRoleRequest.getRoleName() != null) {
      request.addParameter("RoleName", StringUtils.fromString(deleteServiceLinkedRoleRequest.getRoleName()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteServiceLinkedRoleRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */