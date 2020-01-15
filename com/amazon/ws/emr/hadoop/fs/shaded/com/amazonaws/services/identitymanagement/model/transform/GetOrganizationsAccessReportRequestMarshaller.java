package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetOrganizationsAccessReportRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class GetOrganizationsAccessReportRequestMarshaller
  implements Marshaller<Request<GetOrganizationsAccessReportRequest>, GetOrganizationsAccessReportRequest>
{
  public Request<GetOrganizationsAccessReportRequest> marshall(GetOrganizationsAccessReportRequest getOrganizationsAccessReportRequest)
  {
    if (getOrganizationsAccessReportRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<GetOrganizationsAccessReportRequest> request = new DefaultRequest(getOrganizationsAccessReportRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "GetOrganizationsAccessReport");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (getOrganizationsAccessReportRequest.getJobId() != null) {
      request.addParameter("JobId", StringUtils.fromString(getOrganizationsAccessReportRequest.getJobId()));
    }
    if (getOrganizationsAccessReportRequest.getMaxItems() != null) {
      request.addParameter("MaxItems", StringUtils.fromInteger(getOrganizationsAccessReportRequest.getMaxItems()));
    }
    if (getOrganizationsAccessReportRequest.getMarker() != null) {
      request.addParameter("Marker", StringUtils.fromString(getOrganizationsAccessReportRequest.getMarker()));
    }
    if (getOrganizationsAccessReportRequest.getSortKey() != null) {
      request.addParameter("SortKey", StringUtils.fromString(getOrganizationsAccessReportRequest.getSortKey()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetOrganizationsAccessReportRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */