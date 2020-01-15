package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UploadSigningCertificateRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class UploadSigningCertificateRequestMarshaller
  implements Marshaller<Request<UploadSigningCertificateRequest>, UploadSigningCertificateRequest>
{
  public Request<UploadSigningCertificateRequest> marshall(UploadSigningCertificateRequest uploadSigningCertificateRequest)
  {
    if (uploadSigningCertificateRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<UploadSigningCertificateRequest> request = new DefaultRequest(uploadSigningCertificateRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "UploadSigningCertificate");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (uploadSigningCertificateRequest.getUserName() != null) {
      request.addParameter("UserName", StringUtils.fromString(uploadSigningCertificateRequest.getUserName()));
    }
    if (uploadSigningCertificateRequest.getCertificateBody() != null) {
      request.addParameter("CertificateBody", StringUtils.fromString(uploadSigningCertificateRequest.getCertificateBody()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UploadSigningCertificateRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */