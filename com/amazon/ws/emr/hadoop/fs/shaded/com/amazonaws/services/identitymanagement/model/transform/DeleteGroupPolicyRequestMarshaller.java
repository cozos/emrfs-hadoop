package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteGroupPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class DeleteGroupPolicyRequestMarshaller
  implements Marshaller<Request<DeleteGroupPolicyRequest>, DeleteGroupPolicyRequest>
{
  public Request<DeleteGroupPolicyRequest> marshall(DeleteGroupPolicyRequest deleteGroupPolicyRequest)
  {
    if (deleteGroupPolicyRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<DeleteGroupPolicyRequest> request = new DefaultRequest(deleteGroupPolicyRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "DeleteGroupPolicy");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (deleteGroupPolicyRequest.getGroupName() != null) {
      request.addParameter("GroupName", StringUtils.fromString(deleteGroupPolicyRequest.getGroupName()));
    }
    if (deleteGroupPolicyRequest.getPolicyName() != null) {
      request.addParameter("PolicyName", StringUtils.fromString(deleteGroupPolicyRequest.getPolicyName()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteGroupPolicyRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */