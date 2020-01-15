package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetServiceLastAccessedDetailsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class GetServiceLastAccessedDetailsRequestMarshaller
  implements Marshaller<Request<GetServiceLastAccessedDetailsRequest>, GetServiceLastAccessedDetailsRequest>
{
  public Request<GetServiceLastAccessedDetailsRequest> marshall(GetServiceLastAccessedDetailsRequest getServiceLastAccessedDetailsRequest)
  {
    if (getServiceLastAccessedDetailsRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<GetServiceLastAccessedDetailsRequest> request = new DefaultRequest(getServiceLastAccessedDetailsRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "GetServiceLastAccessedDetails");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (getServiceLastAccessedDetailsRequest.getJobId() != null) {
      request.addParameter("JobId", StringUtils.fromString(getServiceLastAccessedDetailsRequest.getJobId()));
    }
    if (getServiceLastAccessedDetailsRequest.getMaxItems() != null) {
      request.addParameter("MaxItems", StringUtils.fromInteger(getServiceLastAccessedDetailsRequest.getMaxItems()));
    }
    if (getServiceLastAccessedDetailsRequest.getMarker() != null) {
      request.addParameter("Marker", StringUtils.fromString(getServiceLastAccessedDetailsRequest.getMarker()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetServiceLastAccessedDetailsRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */