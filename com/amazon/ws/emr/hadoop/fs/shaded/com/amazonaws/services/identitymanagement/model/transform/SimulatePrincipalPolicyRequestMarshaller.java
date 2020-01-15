package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ContextEntry;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.SimulatePrincipalPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import java.util.List;

public class SimulatePrincipalPolicyRequestMarshaller
  implements Marshaller<Request<SimulatePrincipalPolicyRequest>, SimulatePrincipalPolicyRequest>
{
  public Request<SimulatePrincipalPolicyRequest> marshall(SimulatePrincipalPolicyRequest simulatePrincipalPolicyRequest)
  {
    if (simulatePrincipalPolicyRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<SimulatePrincipalPolicyRequest> request = new DefaultRequest(simulatePrincipalPolicyRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "SimulatePrincipalPolicy");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (simulatePrincipalPolicyRequest.getPolicySourceArn() != null) {
      request.addParameter("PolicySourceArn", StringUtils.fromString(simulatePrincipalPolicyRequest.getPolicySourceArn()));
    }
    int policyInputListListIndex;
    if ((!simulatePrincipalPolicyRequest.getPolicyInputList().isEmpty()) || 
      (!((SdkInternalList)simulatePrincipalPolicyRequest.getPolicyInputList()).isAutoConstruct()))
    {
      SdkInternalList<String> policyInputListList = (SdkInternalList)simulatePrincipalPolicyRequest.getPolicyInputList();
      policyInputListListIndex = 1;
      for (String policyInputListListValue : policyInputListList)
      {
        if (policyInputListListValue != null) {
          request.addParameter("PolicyInputList.member." + policyInputListListIndex, StringUtils.fromString(policyInputListListValue));
        }
        policyInputListListIndex++;
      }
    }
    int actionNamesListIndex;
    if ((!simulatePrincipalPolicyRequest.getActionNames().isEmpty()) || 
      (!((SdkInternalList)simulatePrincipalPolicyRequest.getActionNames()).isAutoConstruct()))
    {
      SdkInternalList<String> actionNamesList = (SdkInternalList)simulatePrincipalPolicyRequest.getActionNames();
      actionNamesListIndex = 1;
      for (String actionNamesListValue : actionNamesList)
      {
        if (actionNamesListValue != null) {
          request.addParameter("ActionNames.member." + actionNamesListIndex, StringUtils.fromString(actionNamesListValue));
        }
        actionNamesListIndex++;
      }
    }
    int resourceArnsListIndex;
    if ((!simulatePrincipalPolicyRequest.getResourceArns().isEmpty()) || 
      (!((SdkInternalList)simulatePrincipalPolicyRequest.getResourceArns()).isAutoConstruct()))
    {
      SdkInternalList<String> resourceArnsList = (SdkInternalList)simulatePrincipalPolicyRequest.getResourceArns();
      resourceArnsListIndex = 1;
      for (String resourceArnsListValue : resourceArnsList)
      {
        if (resourceArnsListValue != null) {
          request.addParameter("ResourceArns.member." + resourceArnsListIndex, StringUtils.fromString(resourceArnsListValue));
        }
        resourceArnsListIndex++;
      }
    }
    if (simulatePrincipalPolicyRequest.getResourcePolicy() != null) {
      request.addParameter("ResourcePolicy", StringUtils.fromString(simulatePrincipalPolicyRequest.getResourcePolicy()));
    }
    if (simulatePrincipalPolicyRequest.getResourceOwner() != null) {
      request.addParameter("ResourceOwner", StringUtils.fromString(simulatePrincipalPolicyRequest.getResourceOwner()));
    }
    if (simulatePrincipalPolicyRequest.getCallerArn() != null) {
      request.addParameter("CallerArn", StringUtils.fromString(simulatePrincipalPolicyRequest.getCallerArn()));
    }
    int contextEntriesListIndex;
    if ((!simulatePrincipalPolicyRequest.getContextEntries().isEmpty()) || 
      (!((SdkInternalList)simulatePrincipalPolicyRequest.getContextEntries()).isAutoConstruct()))
    {
      SdkInternalList<ContextEntry> contextEntriesList = (SdkInternalList)simulatePrincipalPolicyRequest.getContextEntries();
      contextEntriesListIndex = 1;
      for (ContextEntry contextEntriesListValue : contextEntriesList)
      {
        if (contextEntriesListValue.getContextKeyName() != null) {
          request.addParameter("ContextEntries.member." + contextEntriesListIndex + ".ContextKeyName", 
            StringUtils.fromString(contextEntriesListValue.getContextKeyName()));
        }
        int contextKeyValuesListIndex;
        if ((!contextEntriesListValue.getContextKeyValues().isEmpty()) || 
          (!((SdkInternalList)contextEntriesListValue.getContextKeyValues()).isAutoConstruct()))
        {
          SdkInternalList<String> contextKeyValuesList = (SdkInternalList)contextEntriesListValue.getContextKeyValues();
          contextKeyValuesListIndex = 1;
          for (String contextKeyValuesListValue : contextKeyValuesList)
          {
            if (contextKeyValuesListValue != null) {
              request.addParameter("ContextEntries.member." + contextEntriesListIndex + ".ContextKeyValues.member." + contextKeyValuesListIndex, 
                StringUtils.fromString(contextKeyValuesListValue));
            }
            contextKeyValuesListIndex++;
          }
        }
        if (contextEntriesListValue.getContextKeyType() != null) {
          request.addParameter("ContextEntries.member." + contextEntriesListIndex + ".ContextKeyType", 
            StringUtils.fromString(contextEntriesListValue.getContextKeyType()));
        }
        contextEntriesListIndex++;
      }
    }
    if (simulatePrincipalPolicyRequest.getResourceHandlingOption() != null) {
      request.addParameter("ResourceHandlingOption", StringUtils.fromString(simulatePrincipalPolicyRequest.getResourceHandlingOption()));
    }
    if (simulatePrincipalPolicyRequest.getMaxItems() != null) {
      request.addParameter("MaxItems", StringUtils.fromInteger(simulatePrincipalPolicyRequest.getMaxItems()));
    }
    if (simulatePrincipalPolicyRequest.getMarker() != null) {
      request.addParameter("Marker", StringUtils.fromString(simulatePrincipalPolicyRequest.getMarker()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.SimulatePrincipalPolicyRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */