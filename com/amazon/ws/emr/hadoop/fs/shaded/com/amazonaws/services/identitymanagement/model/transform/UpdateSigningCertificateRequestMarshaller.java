package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateSigningCertificateRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class UpdateSigningCertificateRequestMarshaller
  implements Marshaller<Request<UpdateSigningCertificateRequest>, UpdateSigningCertificateRequest>
{
  public Request<UpdateSigningCertificateRequest> marshall(UpdateSigningCertificateRequest updateSigningCertificateRequest)
  {
    if (updateSigningCertificateRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<UpdateSigningCertificateRequest> request = new DefaultRequest(updateSigningCertificateRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "UpdateSigningCertificate");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (updateSigningCertificateRequest.getUserName() != null) {
      request.addParameter("UserName", StringUtils.fromString(updateSigningCertificateRequest.getUserName()));
    }
    if (updateSigningCertificateRequest.getCertificateId() != null) {
      request.addParameter("CertificateId", StringUtils.fromString(updateSigningCertificateRequest.getCertificateId()));
    }
    if (updateSigningCertificateRequest.getStatus() != null) {
      request.addParameter("Status", StringUtils.fromString(updateSigningCertificateRequest.getStatus()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateSigningCertificateRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */