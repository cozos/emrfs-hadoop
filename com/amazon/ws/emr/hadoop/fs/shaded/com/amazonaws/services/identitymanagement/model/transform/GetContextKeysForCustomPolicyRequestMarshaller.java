package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetContextKeysForCustomPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import java.util.List;

public class GetContextKeysForCustomPolicyRequestMarshaller
  implements Marshaller<Request<GetContextKeysForCustomPolicyRequest>, GetContextKeysForCustomPolicyRequest>
{
  public Request<GetContextKeysForCustomPolicyRequest> marshall(GetContextKeysForCustomPolicyRequest getContextKeysForCustomPolicyRequest)
  {
    if (getContextKeysForCustomPolicyRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<GetContextKeysForCustomPolicyRequest> request = new DefaultRequest(getContextKeysForCustomPolicyRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "GetContextKeysForCustomPolicy");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    int policyInputListListIndex;
    if ((!getContextKeysForCustomPolicyRequest.getPolicyInputList().isEmpty()) || 
      (!((SdkInternalList)getContextKeysForCustomPolicyRequest.getPolicyInputList()).isAutoConstruct()))
    {
      SdkInternalList<String> policyInputListList = (SdkInternalList)getContextKeysForCustomPolicyRequest.getPolicyInputList();
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetContextKeysForCustomPolicyRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */