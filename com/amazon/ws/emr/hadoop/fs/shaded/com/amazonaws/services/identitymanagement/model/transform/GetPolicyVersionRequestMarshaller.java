package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetPolicyVersionRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class GetPolicyVersionRequestMarshaller
  implements Marshaller<Request<GetPolicyVersionRequest>, GetPolicyVersionRequest>
{
  public Request<GetPolicyVersionRequest> marshall(GetPolicyVersionRequest getPolicyVersionRequest)
  {
    if (getPolicyVersionRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<GetPolicyVersionRequest> request = new DefaultRequest(getPolicyVersionRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "GetPolicyVersion");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (getPolicyVersionRequest.getPolicyArn() != null) {
      request.addParameter("PolicyArn", StringUtils.fromString(getPolicyVersionRequest.getPolicyArn()));
    }
    if (getPolicyVersionRequest.getVersionId() != null) {
      request.addParameter("VersionId", StringUtils.fromString(getPolicyVersionRequest.getVersionId()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetPolicyVersionRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */