package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeletePolicyVersionRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class DeletePolicyVersionRequestMarshaller
  implements Marshaller<Request<DeletePolicyVersionRequest>, DeletePolicyVersionRequest>
{
  public Request<DeletePolicyVersionRequest> marshall(DeletePolicyVersionRequest deletePolicyVersionRequest)
  {
    if (deletePolicyVersionRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<DeletePolicyVersionRequest> request = new DefaultRequest(deletePolicyVersionRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "DeletePolicyVersion");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (deletePolicyVersionRequest.getPolicyArn() != null) {
      request.addParameter("PolicyArn", StringUtils.fromString(deletePolicyVersionRequest.getPolicyArn()));
    }
    if (deletePolicyVersionRequest.getVersionId() != null) {
      request.addParameter("VersionId", StringUtils.fromString(deletePolicyVersionRequest.getVersionId()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeletePolicyVersionRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */