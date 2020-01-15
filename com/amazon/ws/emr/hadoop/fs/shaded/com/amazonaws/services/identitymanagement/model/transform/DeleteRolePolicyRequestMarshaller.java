package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteRolePolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class DeleteRolePolicyRequestMarshaller
  implements Marshaller<Request<DeleteRolePolicyRequest>, DeleteRolePolicyRequest>
{
  public Request<DeleteRolePolicyRequest> marshall(DeleteRolePolicyRequest deleteRolePolicyRequest)
  {
    if (deleteRolePolicyRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<DeleteRolePolicyRequest> request = new DefaultRequest(deleteRolePolicyRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "DeleteRolePolicy");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (deleteRolePolicyRequest.getRoleName() != null) {
      request.addParameter("RoleName", StringUtils.fromString(deleteRolePolicyRequest.getRoleName()));
    }
    if (deleteRolePolicyRequest.getPolicyName() != null) {
      request.addParameter("PolicyName", StringUtils.fromString(deleteRolePolicyRequest.getPolicyName()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteRolePolicyRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */