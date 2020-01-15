package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DetachGroupPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class DetachGroupPolicyRequestMarshaller
  implements Marshaller<Request<DetachGroupPolicyRequest>, DetachGroupPolicyRequest>
{
  public Request<DetachGroupPolicyRequest> marshall(DetachGroupPolicyRequest detachGroupPolicyRequest)
  {
    if (detachGroupPolicyRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<DetachGroupPolicyRequest> request = new DefaultRequest(detachGroupPolicyRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "DetachGroupPolicy");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (detachGroupPolicyRequest.getGroupName() != null) {
      request.addParameter("GroupName", StringUtils.fromString(detachGroupPolicyRequest.getGroupName()));
    }
    if (detachGroupPolicyRequest.getPolicyArn() != null) {
      request.addParameter("PolicyArn", StringUtils.fromString(detachGroupPolicyRequest.getPolicyArn()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DetachGroupPolicyRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */