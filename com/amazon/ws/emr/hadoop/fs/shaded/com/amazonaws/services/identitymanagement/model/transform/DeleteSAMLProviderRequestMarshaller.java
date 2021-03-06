package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteSAMLProviderRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class DeleteSAMLProviderRequestMarshaller
  implements Marshaller<Request<DeleteSAMLProviderRequest>, DeleteSAMLProviderRequest>
{
  public Request<DeleteSAMLProviderRequest> marshall(DeleteSAMLProviderRequest deleteSAMLProviderRequest)
  {
    if (deleteSAMLProviderRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<DeleteSAMLProviderRequest> request = new DefaultRequest(deleteSAMLProviderRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "DeleteSAMLProvider");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (deleteSAMLProviderRequest.getSAMLProviderArn() != null) {
      request.addParameter("SAMLProviderArn", StringUtils.fromString(deleteSAMLProviderRequest.getSAMLProviderArn()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteSAMLProviderRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */