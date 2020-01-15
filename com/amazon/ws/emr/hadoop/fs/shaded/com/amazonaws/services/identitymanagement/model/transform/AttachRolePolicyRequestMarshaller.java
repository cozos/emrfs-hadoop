package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AttachRolePolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class AttachRolePolicyRequestMarshaller
  implements Marshaller<Request<AttachRolePolicyRequest>, AttachRolePolicyRequest>
{
  public Request<AttachRolePolicyRequest> marshall(AttachRolePolicyRequest attachRolePolicyRequest)
  {
    if (attachRolePolicyRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<AttachRolePolicyRequest> request = new DefaultRequest(attachRolePolicyRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "AttachRolePolicy");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (attachRolePolicyRequest.getRoleName() != null) {
      request.addParameter("RoleName", StringUtils.fromString(attachRolePolicyRequest.getRoleName()));
    }
    if (attachRolePolicyRequest.getPolicyArn() != null) {
      request.addParameter("PolicyArn", StringUtils.fromString(attachRolePolicyRequest.getPolicyArn()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.AttachRolePolicyRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */