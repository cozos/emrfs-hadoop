package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ContextEntry;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.SimulateCustomPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import java.util.List;

public class SimulateCustomPolicyRequestMarshaller
  implements Marshaller<Request<SimulateCustomPolicyRequest>, SimulateCustomPolicyRequest>
{
  public Request<SimulateCustomPolicyRequest> marshall(SimulateCustomPolicyRequest simulateCustomPolicyRequest)
  {
    if (simulateCustomPolicyRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<SimulateCustomPolicyRequest> request = new DefaultRequest(simulateCustomPolicyRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "SimulateCustomPolicy");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    int policyInputListListIndex;
    if ((!simulateCustomPolicyRequest.getPolicyInputList().isEmpty()) || 
      (!((SdkInternalList)simulateCustomPolicyRequest.getPolicyInputList()).isAutoConstruct()))
    {
      SdkInternalList<String> policyInputListList = (SdkInternalList)simulateCustomPolicyRequest.getPolicyInputList();
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
    if ((!simulateCustomPolicyRequest.getActionNames().isEmpty()) || 
      (!((SdkInternalList)simulateCustomPolicyRequest.getActionNames()).isAutoConstruct()))
    {
      SdkInternalList<String> actionNamesList = (SdkInternalList)simulateCustomPolicyRequest.getActionNames();
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
    if ((!simulateCustomPolicyRequest.getResourceArns().isEmpty()) || 
      (!((SdkInternalList)simulateCustomPolicyRequest.getResourceArns()).isAutoConstruct()))
    {
      SdkInternalList<String> resourceArnsList = (SdkInternalList)simulateCustomPolicyRequest.getResourceArns();
      resourceArnsListIndex = 1;
      for (String resourceArnsListValue : resourceArnsList)
      {
        if (resourceArnsListValue != null) {
          request.addParameter("ResourceArns.member." + resourceArnsListIndex, StringUtils.fromString(resourceArnsListValue));
        }
        resourceArnsListIndex++;
      }
    }
    if (simulateCustomPolicyRequest.getResourcePolicy() != null) {
      request.addParameter("ResourcePolicy", StringUtils.fromString(simulateCustomPolicyRequest.getResourcePolicy()));
    }
    if (simulateCustomPolicyRequest.getResourceOwner() != null) {
      request.addParameter("ResourceOwner", StringUtils.fromString(simulateCustomPolicyRequest.getResourceOwner()));
    }
    if (simulateCustomPolicyRequest.getCallerArn() != null) {
      request.addParameter("CallerArn", StringUtils.fromString(simulateCustomPolicyRequest.getCallerArn()));
    }
    int contextEntriesListIndex;
    if ((!simulateCustomPolicyRequest.getContextEntries().isEmpty()) || 
      (!((SdkInternalList)simulateCustomPolicyRequest.getContextEntries()).isAutoConstruct()))
    {
      SdkInternalList<ContextEntry> contextEntriesList = (SdkInternalList)simulateCustomPolicyRequest.getContextEntries();
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
    if (simulateCustomPolicyRequest.getResourceHandlingOption() != null) {
      request.addParameter("ResourceHandlingOption", StringUtils.fromString(simulateCustomPolicyRequest.getResourceHandlingOption()));
    }
    if (simulateCustomPolicyRequest.getMaxItems() != null) {
      request.addParameter("MaxItems", StringUtils.fromInteger(simulateCustomPolicyRequest.getMaxItems()));
    }
    if (simulateCustomPolicyRequest.getMarker() != null) {
      request.addParameter("Marker", StringUtils.fromString(simulateCustomPolicyRequest.getMarker()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.SimulateCustomPolicyRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */