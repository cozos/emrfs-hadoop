package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListServerCertificatesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class ListServerCertificatesRequestMarshaller
  implements Marshaller<Request<ListServerCertificatesRequest>, ListServerCertificatesRequest>
{
  public Request<ListServerCertificatesRequest> marshall(ListServerCertificatesRequest listServerCertificatesRequest)
  {
    if (listServerCertificatesRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<ListServerCertificatesRequest> request = new DefaultRequest(listServerCertificatesRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "ListServerCertificates");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (listServerCertificatesRequest.getPathPrefix() != null) {
      request.addParameter("PathPrefix", StringUtils.fromString(listServerCertificatesRequest.getPathPrefix()));
    }
    if (listServerCertificatesRequest.getMarker() != null) {
      request.addParameter("Marker", StringUtils.fromString(listServerCertificatesRequest.getMarker()));
    }
    if (listServerCertificatesRequest.getMaxItems() != null) {
      request.addParameter("MaxItems", StringUtils.fromInteger(listServerCertificatesRequest.getMaxItems()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListServerCertificatesRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */