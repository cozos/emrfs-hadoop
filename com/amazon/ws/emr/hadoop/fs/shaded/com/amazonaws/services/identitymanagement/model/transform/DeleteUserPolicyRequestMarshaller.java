package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteUserPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class DeleteUserPolicyRequestMarshaller
  implements Marshaller<Request<DeleteUserPolicyRequest>, DeleteUserPolicyRequest>
{
  public Request<DeleteUserPolicyRequest> marshall(DeleteUserPolicyRequest deleteUserPolicyRequest)
  {
    if (deleteUserPolicyRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<DeleteUserPolicyRequest> request = new DefaultRequest(deleteUserPolicyRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "DeleteUserPolicy");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (deleteUserPolicyRequest.getUserName() != null) {
      request.addParameter("UserName", StringUtils.fromString(deleteUserPolicyRequest.getUserName()));
    }
    if (deleteUserPolicyRequest.getPolicyName() != null) {
      request.addParameter("PolicyName", StringUtils.fromString(deleteUserPolicyRequest.getPolicyName()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteUserPolicyRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */