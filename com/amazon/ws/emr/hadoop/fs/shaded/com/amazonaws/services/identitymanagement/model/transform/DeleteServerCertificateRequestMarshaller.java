package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteServerCertificateRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class DeleteServerCertificateRequestMarshaller
  implements Marshaller<Request<DeleteServerCertificateRequest>, DeleteServerCertificateRequest>
{
  public Request<DeleteServerCertificateRequest> marshall(DeleteServerCertificateRequest deleteServerCertificateRequest)
  {
    if (deleteServerCertificateRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<DeleteServerCertificateRequest> request = new DefaultRequest(deleteServerCertificateRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "DeleteServerCertificate");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (deleteServerCertificateRequest.getServerCertificateName() != null) {
      request.addParameter("ServerCertificateName", StringUtils.fromString(deleteServerCertificateRequest.getServerCertificateName()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteServerCertificateRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */