package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetContextKeysForPrincipalPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import java.util.List;

public class GetContextKeysForPrincipalPolicyRequestMarshaller
  implements Marshaller<Request<GetContextKeysForPrincipalPolicyRequest>, GetContextKeysForPrincipalPolicyRequest>
{
  public Request<GetContextKeysForPrincipalPolicyRequest> marshall(GetContextKeysForPrincipalPolicyRequest getContextKeysForPrincipalPolicyRequest)
  {
    if (getContextKeysForPrincipalPolicyRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<GetContextKeysForPrincipalPolicyRequest> request = new DefaultRequest(getContextKeysForPrincipalPolicyRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "GetContextKeysForPrincipalPolicy");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (getContextKeysForPrincipalPolicyRequest.getPolicySourceArn() != null) {
      request.addParameter("PolicySourceArn", StringUtils.fromString(getContextKeysForPrincipalPolicyRequest.getPolicySourceArn()));
    }
    int policyInputListListIndex;
    if ((!getContextKeysForPrincipalPolicyRequest.getPolicyInputList().isEmpty()) || 
      (!((SdkInternalList)getContextKeysForPrincipalPolicyRequest.getPolicyInputList()).isAutoConstruct()))
    {
      SdkInternalList<String> policyInputListList = (SdkInternalList)getContextKeysForPrincipalPolicyRequest.getPolicyInputList();
      policyInputListListIndex = 1;
      for (String policyInputListListValue : policyInputListList)
      {
        if (policyInputListListValue != null) {
          request.addParameter("PolicyInputList.member." + policyInputListListIndex, StringUtils.fromString(policyInputListListValue));
        }
        policyInputListListIndex++;
      }
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetContextKeysForPrincipalPolicyRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */