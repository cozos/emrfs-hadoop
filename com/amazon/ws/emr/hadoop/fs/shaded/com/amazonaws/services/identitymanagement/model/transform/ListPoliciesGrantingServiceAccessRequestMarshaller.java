package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListPoliciesGrantingServiceAccessRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import java.util.List;

public class ListPoliciesGrantingServiceAccessRequestMarshaller
  implements Marshaller<Request<ListPoliciesGrantingServiceAccessRequest>, ListPoliciesGrantingServiceAccessRequest>
{
  public Request<ListPoliciesGrantingServiceAccessRequest> marshall(ListPoliciesGrantingServiceAccessRequest listPoliciesGrantingServiceAccessRequest)
  {
    if (listPoliciesGrantingServiceAccessRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<ListPoliciesGrantingServiceAccessRequest> request = new DefaultRequest(listPoliciesGrantingServiceAccessRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "ListPoliciesGrantingServiceAccess");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (listPoliciesGrantingServiceAccessRequest.getMarker() != null) {
      request.addParameter("Marker", StringUtils.fromString(listPoliciesGrantingServiceAccessRequest.getMarker()));
    }
    if (listPoliciesGrantingServiceAccessRequest.getArn() != null) {
      request.addParameter("Arn", StringUtils.fromString(listPoliciesGrantingServiceAccessRequest.getArn()));
    }
    int serviceNamespacesListIndex;
    if ((!listPoliciesGrantingServiceAccessRequest.getServiceNamespaces().isEmpty()) || 
      (!((SdkInternalList)listPoliciesGrantingServiceAccessRequest.getServiceNamespaces()).isAutoConstruct()))
    {
      SdkInternalList<String> serviceNamespacesList = (SdkInternalList)listPoliciesGrantingServiceAccessRequest.getServiceNamespaces();
      serviceNamespacesListIndex = 1;
      for (String serviceNamespacesListValue : serviceNamespacesList)
      {
        if (serviceNamespacesListValue != null) {
          request.addParameter("ServiceNamespaces.member." + serviceNamespacesListIndex, StringUtils.fromString(serviceNamespacesListValue));
        }
        serviceNamespacesListIndex++;
      }
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListPoliciesGrantingServiceAccessRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */