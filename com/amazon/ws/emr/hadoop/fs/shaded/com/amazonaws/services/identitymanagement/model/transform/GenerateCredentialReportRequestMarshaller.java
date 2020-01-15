package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GenerateCredentialReportRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;

public class GenerateCredentialReportRequestMarshaller
  implements Marshaller<Request<GenerateCredentialReportRequest>, GenerateCredentialReportRequest>
{
  public Request<GenerateCredentialReportRequest> marshall(GenerateCredentialReportRequest generateCredentialReportRequest)
  {
    if (generateCredentialReportRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<GenerateCredentialReportRequest> request = new DefaultRequest(generateCredentialReportRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "GenerateCredentialReport");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GenerateCredentialReportRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */