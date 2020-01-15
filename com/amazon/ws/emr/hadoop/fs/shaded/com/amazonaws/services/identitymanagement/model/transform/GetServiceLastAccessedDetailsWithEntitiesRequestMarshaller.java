package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetServiceLastAccessedDetailsWithEntitiesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class GetServiceLastAccessedDetailsWithEntitiesRequestMarshaller
  implements Marshaller<Request<GetServiceLastAccessedDetailsWithEntitiesRequest>, GetServiceLastAccessedDetailsWithEntitiesRequest>
{
  public Request<GetServiceLastAccessedDetailsWithEntitiesRequest> marshall(GetServiceLastAccessedDetailsWithEntitiesRequest getServiceLastAccessedDetailsWithEntitiesRequest)
  {
    if (getServiceLastAccessedDetailsWithEntitiesRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<GetServiceLastAccessedDetailsWithEntitiesRequest> request = new DefaultRequest(getServiceLastAccessedDetailsWithEntitiesRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "GetServiceLastAccessedDetailsWithEntities");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (getServiceLastAccessedDetailsWithEntitiesRequest.getJobId() != null) {
      request.addParameter("JobId", StringUtils.fromString(getServiceLastAccessedDetailsWithEntitiesRequest.getJobId()));
    }
    if (getServiceLastAccessedDetailsWithEntitiesRequest.getServiceNamespace() != null) {
      request.addParameter("ServiceNamespace", StringUtils.fromString(getServiceLastAccessedDetailsWithEntitiesRequest.getServiceNamespace()));
    }
    if (getServiceLastAccessedDetailsWithEntitiesRequest.getMaxItems() != null) {
      request.addParameter("MaxItems", StringUtils.fromInteger(getServiceLastAccessedDetailsWithEntitiesRequest.getMaxItems()));
    }
    if (getServiceLastAccessedDetailsWithEntitiesRequest.getMarker() != null) {
      request.addParameter("Marker", StringUtils.fromString(getServiceLastAccessedDetailsWithEntitiesRequest.getMarker()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetServiceLastAccessedDetailsWithEntitiesRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */