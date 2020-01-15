package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteSigningCertificateRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class DeleteSigningCertificateRequestMarshaller
  implements Marshaller<Request<DeleteSigningCertificateRequest>, DeleteSigningCertificateRequest>
{
  public Request<DeleteSigningCertificateRequest> marshall(DeleteSigningCertificateRequest deleteSigningCertificateRequest)
  {
    if (deleteSigningCertificateRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<DeleteSigningCertificateRequest> request = new DefaultRequest(deleteSigningCertificateRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "DeleteSigningCertificate");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (deleteSigningCertificateRequest.getUserName() != null) {
      request.addParameter("UserName", StringUtils.fromString(deleteSigningCertificateRequest.getUserName()));
    }
    if (deleteSigningCertificateRequest.getCertificateId() != null) {
      request.addParameter("CertificateId", StringUtils.fromString(deleteSigningCertificateRequest.getCertificateId()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteSigningCertificateRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */