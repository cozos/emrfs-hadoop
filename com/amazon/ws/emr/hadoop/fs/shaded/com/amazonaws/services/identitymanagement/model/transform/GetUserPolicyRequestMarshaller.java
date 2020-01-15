package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetUserPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class GetUserPolicyRequestMarshaller
  implements Marshaller<Request<GetUserPolicyRequest>, GetUserPolicyRequest>
{
  public Request<GetUserPolicyRequest> marshall(GetUserPolicyRequest getUserPolicyRequest)
  {
    if (getUserPolicyRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<GetUserPolicyRequest> request = new DefaultRequest(getUserPolicyRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "GetUserPolicy");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (getUserPolicyRequest.getUserName() != null) {
      request.addParameter("UserName", StringUtils.fromString(getUserPolicyRequest.getUserName()));
    }
    if (getUserPolicyRequest.getPolicyName() != null) {
      request.addParameter("PolicyName", StringUtils.fromString(getUserPolicyRequest.getPolicyName()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetUserPolicyRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */