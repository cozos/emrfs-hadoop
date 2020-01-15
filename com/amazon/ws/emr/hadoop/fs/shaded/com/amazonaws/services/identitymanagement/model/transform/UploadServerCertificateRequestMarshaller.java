package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UploadServerCertificateRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class UploadServerCertificateRequestMarshaller
  implements Marshaller<Request<UploadServerCertificateRequest>, UploadServerCertificateRequest>
{
  public Request<UploadServerCertificateRequest> marshall(UploadServerCertificateRequest uploadServerCertificateRequest)
  {
    if (uploadServerCertificateRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<UploadServerCertificateRequest> request = new DefaultRequest(uploadServerCertificateRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "UploadServerCertificate");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (uploadServerCertificateRequest.getPath() != null) {
      request.addParameter("Path", StringUtils.fromString(uploadServerCertificateRequest.getPath()));
    }
    if (uploadServerCertificateRequest.getServerCertificateName() != null) {
      request.addParameter("ServerCertificateName", StringUtils.fromString(uploadServerCertificateRequest.getServerCertificateName()));
    }
    if (uploadServerCertificateRequest.getCertificateBody() != null) {
      request.addParameter("CertificateBody", StringUtils.fromString(uploadServerCertificateRequest.getCertificateBody()));
    }
    if (uploadServerCertificateRequest.getPrivateKey() != null) {
      request.addParameter("PrivateKey", StringUtils.fromString(uploadServerCertificateRequest.getPrivateKey()));
    }
    if (uploadServerCertificateRequest.getCertificateChain() != null) {
      request.addParameter("CertificateChain", StringUtils.fromString(uploadServerCertificateRequest.getCertificateChain()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UploadServerCertificateRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */