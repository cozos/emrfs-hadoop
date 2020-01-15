package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetRolePolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class GetRolePolicyRequestMarshaller
  implements Marshaller<Request<GetRolePolicyRequest>, GetRolePolicyRequest>
{
  public Request<GetRolePolicyRequest> marshall(GetRolePolicyRequest getRolePolicyRequest)
  {
    if (getRolePolicyRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<GetRolePolicyRequest> request = new DefaultRequest(getRolePolicyRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "GetRolePolicy");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (getRolePolicyRequest.getRoleName() != null) {
      request.addParameter("RoleName", StringUtils.fromString(getRolePolicyRequest.getRoleName()));
    }
    if (getRolePolicyRequest.getPolicyName() != null) {
      request.addParameter("PolicyName", StringUtils.fromString(getRolePolicyRequest.getPolicyName()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetRolePolicyRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */