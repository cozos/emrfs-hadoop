package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.AssumeRoleWithSAMLRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.PolicyDescriptorType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import java.util.List;

public class AssumeRoleWithSAMLRequestMarshaller
  implements Marshaller<Request<AssumeRoleWithSAMLRequest>, AssumeRoleWithSAMLRequest>
{
  public Request<AssumeRoleWithSAMLRequest> marshall(AssumeRoleWithSAMLRequest assumeRoleWithSAMLRequest)
  {
    if (assumeRoleWithSAMLRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<AssumeRoleWithSAMLRequest> request = new DefaultRequest(assumeRoleWithSAMLRequest, "AWSSecurityTokenService");
    request.addParameter("Action", "AssumeRoleWithSAML");
    request.addParameter("Version", "2011-06-15");
    request.setHttpMethod(HttpMethodName.POST);
    if (assumeRoleWithSAMLRequest.getRoleArn() != null) {
      request.addParameter("RoleArn", StringUtils.fromString(assumeRoleWithSAMLRequest.getRoleArn()));
    }
    if (assumeRoleWithSAMLRequest.getPrincipalArn() != null) {
      request.addParameter("PrincipalArn", StringUtils.fromString(assumeRoleWithSAMLRequest.getPrincipalArn()));
    }
    if (assumeRoleWithSAMLRequest.getSAMLAssertion() != null) {
      request.addParameter("SAMLAssertion", StringUtils.fromString(assumeRoleWithSAMLRequest.getSAMLAssertion()));
    }
    int policyArnsListIndex;
    if (assumeRoleWithSAMLRequest.getPolicyArns() != null)
    {
      List<PolicyDescriptorType> policyArnsList = assumeRoleWithSAMLRequest.getPolicyArns();
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
    if (assumeRoleWithSAMLRequest.getPolicy() != null) {
      request.addParameter("Policy", StringUtils.fromString(assumeRoleWithSAMLRequest.getPolicy()));
    }
    if (assumeRoleWithSAMLRequest.getDurationSeconds() != null) {
      request.addParameter("DurationSeconds", StringUtils.fromInteger(assumeRoleWithSAMLRequest.getDurationSeconds()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform.AssumeRoleWithSAMLRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */