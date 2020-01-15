package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.AssumeRoleRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.PolicyDescriptorType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import java.util.List;

public class AssumeRoleRequestMarshaller
  implements Marshaller<Request<AssumeRoleRequest>, AssumeRoleRequest>
{
  public Request<AssumeRoleRequest> marshall(AssumeRoleRequest assumeRoleRequest)
  {
    if (assumeRoleRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<AssumeRoleRequest> request = new DefaultRequest(assumeRoleRequest, "AWSSecurityTokenService");
    request.addParameter("Action", "AssumeRole");
    request.addParameter("Version", "2011-06-15");
    request.setHttpMethod(HttpMethodName.POST);
    if (assumeRoleRequest.getRoleArn() != null) {
      request.addParameter("RoleArn", StringUtils.fromString(assumeRoleRequest.getRoleArn()));
    }
    if (assumeRoleRequest.getRoleSessionName() != null) {
      request.addParameter("RoleSessionName", StringUtils.fromString(assumeRoleRequest.getRoleSessionName()));
    }
    int policyArnsListIndex;
    if (assumeRoleRequest.getPolicyArns() != null)
    {
      List<PolicyDescriptorType> policyArnsList = assumeRoleRequest.getPolicyArns();
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
    if (assumeRoleRequest.getPolicy() != null) {
      request.addParameter("Policy", StringUtils.fromString(assumeRoleRequest.getPolicy()));
    }
    if (assumeRoleRequest.getDurationSeconds() != null) {
      request.addParameter("DurationSeconds", StringUtils.fromInteger(assumeRoleRequest.getDurationSeconds()));
    }
    if (assumeRoleRequest.getExternalId() != null) {
      request.addParameter("ExternalId", StringUtils.fromString(assumeRoleRequest.getExternalId()));
    }
    if (assumeRoleRequest.getSerialNumber() != null) {
      request.addParameter("SerialNumber", StringUtils.fromString(assumeRoleRequest.getSerialNumber()));
    }
    if (assumeRoleRequest.getTokenCode() != null) {
      request.addParameter("TokenCode", StringUtils.fromString(assumeRoleRequest.getTokenCode()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform.AssumeRoleRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */