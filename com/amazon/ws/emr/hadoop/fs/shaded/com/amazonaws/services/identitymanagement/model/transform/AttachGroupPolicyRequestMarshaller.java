package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AttachGroupPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class AttachGroupPolicyRequestMarshaller
  implements Marshaller<Request<AttachGroupPolicyRequest>, AttachGroupPolicyRequest>
{
  public Request<AttachGroupPolicyRequest> marshall(AttachGroupPolicyRequest attachGroupPolicyRequest)
  {
    if (attachGroupPolicyRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<AttachGroupPolicyRequest> request = new DefaultRequest(attachGroupPolicyRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "AttachGroupPolicy");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (attachGroupPolicyRequest.getGroupName() != null) {
      request.addParameter("GroupName", StringUtils.fromString(attachGroupPolicyRequest.getGroupName()));
    }
    if (attachGroupPolicyRequest.getPolicyArn() != null) {
      request.addParameter("PolicyArn", StringUtils.fromString(attachGroupPolicyRequest.getPolicyArn()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.AttachGroupPolicyRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */