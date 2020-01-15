package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.PutUserPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class PutUserPolicyRequestMarshaller
  implements Marshaller<Request<PutUserPolicyRequest>, PutUserPolicyRequest>
{
  public Request<PutUserPolicyRequest> marshall(PutUserPolicyRequest putUserPolicyRequest)
  {
    if (putUserPolicyRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<PutUserPolicyRequest> request = new DefaultRequest(putUserPolicyRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "PutUserPolicy");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (putUserPolicyRequest.getUserName() != null) {
      request.addParameter("UserName", StringUtils.fromString(putUserPolicyRequest.getUserName()));
    }
    if (putUserPolicyRequest.getPolicyName() != null) {
      request.addParameter("PolicyName", StringUtils.fromString(putUserPolicyRequest.getPolicyName()));
    }
    if (putUserPolicyRequest.getPolicyDocument() != null) {
      request.addParameter("PolicyDocument", StringUtils.fromString(putUserPolicyRequest.getPolicyDocument()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.PutUserPolicyRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */