package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.GetFederationTokenRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.PolicyDescriptorType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import java.util.List;

public class GetFederationTokenRequestMarshaller
  implements Marshaller<Request<GetFederationTokenRequest>, GetFederationTokenRequest>
{
  public Request<GetFederationTokenRequest> marshall(GetFederationTokenRequest getFederationTokenRequest)
  {
    if (getFederationTokenRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<GetFederationTokenRequest> request = new DefaultRequest(getFederationTokenRequest, "AWSSecurityTokenService");
    request.addParameter("Action", "GetFederationToken");
    request.addParameter("Version", "2011-06-15");
    request.setHttpMethod(HttpMethodName.POST);
    if (getFederationTokenRequest.getName() != null) {
      request.addParameter("Name", StringUtils.fromString(getFederationTokenRequest.getName()));
    }
    if (getFederationTokenRequest.getPolicy() != null) {
      request.addParameter("Policy", StringUtils.fromString(getFederationTokenRequest.getPolicy()));
    }
    int policyArnsListIndex;
    if (getFederationTokenRequest.getPolicyArns() != null)
    {
      List<PolicyDescriptorType> policyArnsList = getFederationTokenRequest.getPolicyArns();
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
    if (getFederationTokenRequest.getDurationSeconds() != null) {
      request.addParameter("DurationSeconds", StringUtils.fromInteger(getFederationTokenRequest.getDurationSeconds()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform.GetFederationTokenRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */