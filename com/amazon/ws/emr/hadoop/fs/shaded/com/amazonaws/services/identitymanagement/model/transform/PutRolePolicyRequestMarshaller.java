package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.PutRolePolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class PutRolePolicyRequestMarshaller
  implements Marshaller<Request<PutRolePolicyRequest>, PutRolePolicyRequest>
{
  public Request<PutRolePolicyRequest> marshall(PutRolePolicyRequest putRolePolicyRequest)
  {
    if (putRolePolicyRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<PutRolePolicyRequest> request = new DefaultRequest(putRolePolicyRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "PutRolePolicy");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (putRolePolicyRequest.getRoleName() != null) {
      request.addParameter("RoleName", StringUtils.fromString(putRolePolicyRequest.getRoleName()));
    }
    if (putRolePolicyRequest.getPolicyName() != null) {
      request.addParameter("PolicyName", StringUtils.fromString(putRolePolicyRequest.getPolicyName()));
    }
    if (putRolePolicyRequest.getPolicyDocument() != null) {
      request.addParameter("PolicyDocument", StringUtils.fromString(putRolePolicyRequest.getPolicyDocument()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.PutRolePolicyRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */