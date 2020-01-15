package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateServerCertificateRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class UpdateServerCertificateRequestMarshaller
  implements Marshaller<Request<UpdateServerCertificateRequest>, UpdateServerCertificateRequest>
{
  public Request<UpdateServerCertificateRequest> marshall(UpdateServerCertificateRequest updateServerCertificateRequest)
  {
    if (updateServerCertificateRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<UpdateServerCertificateRequest> request = new DefaultRequest(updateServerCertificateRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "UpdateServerCertificate");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (updateServerCertificateRequest.getServerCertificateName() != null) {
      request.addParameter("ServerCertificateName", StringUtils.fromString(updateServerCertificateRequest.getServerCertificateName()));
    }
    if (updateServerCertificateRequest.getNewPath() != null) {
      request.addParameter("NewPath", StringUtils.fromString(updateServerCertificateRequest.getNewPath()));
    }
    if (updateServerCertificateRequest.getNewServerCertificateName() != null) {
      request.addParameter("NewServerCertificateName", StringUtils.fromString(updateServerCertificateRequest.getNewServerCertificateName()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateServerCertificateRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */