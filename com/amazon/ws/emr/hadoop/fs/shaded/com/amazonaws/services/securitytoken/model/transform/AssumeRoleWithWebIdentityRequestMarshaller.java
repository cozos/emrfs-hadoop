package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.AssumeRoleWithWebIdentityRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.PolicyDescriptorType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import java.util.List;

public class AssumeRoleWithWebIdentityRequestMarshaller
  implements Marshaller<Request<AssumeRoleWithWebIdentityRequest>, AssumeRoleWithWebIdentityRequest>
{
  public Request<AssumeRoleWithWebIdentityRequest> marshall(AssumeRoleWithWebIdentityRequest assumeRoleWithWebIdentityRequest)
  {
    if (assumeRoleWithWebIdentityRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<AssumeRoleWithWebIdentityRequest> request = new DefaultRequest(assumeRoleWithWebIdentityRequest, "AWSSecurityTokenService");
    
    request.addParameter("Action", "AssumeRoleWithWebIdentity");
    request.addParameter("Version", "2011-06-15");
    request.setHttpMethod(HttpMethodName.POST);
    if (assumeRoleWithWebIdentityRequest.getRoleArn() != null) {
      request.addParameter("RoleArn", StringUtils.fromString(assumeRoleWithWebIdentityRequest.getRoleArn()));
    }
    if (assumeRoleWithWebIdentityRequest.getRoleSessionName() != null) {
      request.addParameter("RoleSessionName", StringUtils.fromString(assumeRoleWithWebIdentityRequest.getRoleSessionName()));
    }
    if (assumeRoleWithWebIdentityRequest.getWebIdentityToken() != null) {
      request.addParameter("WebIdentityToken", StringUtils.fromString(assumeRoleWithWebIdentityRequest.getWebIdentityToken()));
    }
    if (assumeRoleWithWebIdentityRequest.getProviderId() != null) {
      request.addParameter("ProviderId", StringUtils.fromString(assumeRoleWithWebIdentityRequest.getProviderId()));
    }
    int policyArnsListIndex;
    if (assumeRoleWithWebIdentityRequest.getPolicyArns() != null)
    {
      List<PolicyDescriptorType> policyArnsList = assumeRoleWithWebIdentityRequest.getPolicyArns();
      if (policyArnsList.isEmpty())
      {
        request.addParameter("PolicyArns", "");
      }
      else
      {
        policyArnsListIndex = 1;
        for (PolicyDescriptorType policyArnsListValue : policyArnsList)
        {
          if (policyArnsListValue.getArn() != null) {
            request.addParameter("PolicyArns.member." + policyArnsListIndex + ".arn", StringUtils.fromString(policyArnsListValue.getArn()));
          }
          policyArnsListIndex++;
        }
      }
    }
    if (assumeRoleWithWebIdentityRequest.getPolicy() != null) {
      request.addParameter("Policy", StringUtils.fromString(assumeRoleWithWebIdentityRequest.getPolicy()));
    }
    if (assumeRoleWithWebIdentityRequest.getDurationSeconds() != null) {
      request.addParameter("DurationSeconds", StringUtils.fromInteger(assumeRoleWithWebIdentityRequest.getDurationSeconds()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform.AssumeRoleWithWebIdentityRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */