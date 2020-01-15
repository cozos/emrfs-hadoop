package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetAccountAuthorizationDetailsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import java.util.List;

public class GetAccountAuthorizationDetailsRequestMarshaller
  implements Marshaller<Request<GetAccountAuthorizationDetailsRequest>, GetAccountAuthorizationDetailsRequest>
{
  public Request<GetAccountAuthorizationDetailsRequest> marshall(GetAccountAuthorizationDetailsRequest getAccountAuthorizationDetailsRequest)
  {
    if (getAccountAuthorizationDetailsRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<GetAccountAuthorizationDetailsRequest> request = new DefaultRequest(getAccountAuthorizationDetailsRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "GetAccountAuthorizationDetails");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    int filterListIndex;
    if ((!getAccountAuthorizationDetailsRequest.getFilter().isEmpty()) || 
      (!((SdkInternalList)getAccountAuthorizationDetailsRequest.getFilter()).isAutoConstruct()))
    {
      SdkInternalList<String> filterList = (SdkInternalList)getAccountAuthorizationDetailsRequest.getFilter();
      filterListIndex = 1;
      for (String filterListValue : filterList)
      {
        if (filterListValue != null) {
          request.addParameter("Filter.member." + filterListIndex, StringUtils.fromString(filterListValue));
        }
        filterListIndex++;
      }
    }
    if (getAccountAuthorizationDetailsRequest.getMaxItems() != null) {
      request.addParameter("MaxItems", StringUtils.fromInteger(getAccountAuthorizationDetailsRequest.getMaxItems()));
    }
    if (getAccountAuthorizationDetailsRequest.getMarker() != null) {
      request.addParameter("Marker", StringUtils.fromString(getAccountAuthorizationDetailsRequest.getMarker()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetAccountAuthorizationDetailsRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */