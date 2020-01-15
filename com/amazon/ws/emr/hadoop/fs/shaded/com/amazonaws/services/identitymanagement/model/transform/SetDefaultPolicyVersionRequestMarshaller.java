package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.SetDefaultPolicyVersionRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class SetDefaultPolicyVersionRequestMarshaller
  implements Marshaller<Request<SetDefaultPolicyVersionRequest>, SetDefaultPolicyVersionRequest>
{
  public Request<SetDefaultPolicyVersionRequest> marshall(SetDefaultPolicyVersionRequest setDefaultPolicyVersionRequest)
  {
    if (setDefaultPolicyVersionRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<SetDefaultPolicyVersionRequest> request = new DefaultRequest(setDefaultPolicyVersionRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "SetDefaultPolicyVersion");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (setDefaultPolicyVersionRequest.getPolicyArn() != null) {
      request.addParameter("PolicyArn", StringUtils.fromString(setDefaultPolicyVersionRequest.getPolicyArn()));
    }
    if (setDefaultPolicyVersionRequest.getVersionId() != null) {
      request.addParameter("VersionId", StringUtils.fromString(setDefaultPolicyVersionRequest.getVersionId()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.SetDefaultPolicyVersionRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */