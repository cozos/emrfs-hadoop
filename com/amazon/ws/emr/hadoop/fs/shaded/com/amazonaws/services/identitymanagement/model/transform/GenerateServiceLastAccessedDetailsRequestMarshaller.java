package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GenerateServiceLastAccessedDetailsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class GenerateServiceLastAccessedDetailsRequestMarshaller
  implements Marshaller<Request<GenerateServiceLastAccessedDetailsRequest>, GenerateServiceLastAccessedDetailsRequest>
{
  public Request<GenerateServiceLastAccessedDetailsRequest> marshall(GenerateServiceLastAccessedDetailsRequest generateServiceLastAccessedDetailsRequest)
  {
    if (generateServiceLastAccessedDetailsRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<GenerateServiceLastAccessedDetailsRequest> request = new DefaultRequest(generateServiceLastAccessedDetailsRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "GenerateServiceLastAccessedDetails");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (generateServiceLastAccessedDetailsRequest.getArn() != null) {
      request.addParameter("Arn", StringUtils.fromString(generateServiceLastAccessedDetailsRequest.getArn()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GenerateServiceLastAccessedDetailsRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */