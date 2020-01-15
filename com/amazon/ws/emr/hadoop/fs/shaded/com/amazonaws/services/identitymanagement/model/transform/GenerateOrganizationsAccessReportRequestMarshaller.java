package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GenerateOrganizationsAccessReportRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class GenerateOrganizationsAccessReportRequestMarshaller
  implements Marshaller<Request<GenerateOrganizationsAccessReportRequest>, GenerateOrganizationsAccessReportRequest>
{
  public Request<GenerateOrganizationsAccessReportRequest> marshall(GenerateOrganizationsAccessReportRequest generateOrganizationsAccessReportRequest)
  {
    if (generateOrganizationsAccessReportRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<GenerateOrganizationsAccessReportRequest> request = new DefaultRequest(generateOrganizationsAccessReportRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "GenerateOrganizationsAccessReport");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (generateOrganizationsAccessReportRequest.getEntityPath() != null) {
      request.addParameter("EntityPath", StringUtils.fromString(generateOrganizationsAccessReportRequest.getEntityPath()));
    }
    if (generateOrganizationsAccessReportRequest.getOrganizationsPolicyId() != null) {
      request.addParameter("OrganizationsPolicyId", StringUtils.fromString(generateOrganizationsAccessReportRequest.getOrganizationsPolicyId()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GenerateOrganizationsAccessReportRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */