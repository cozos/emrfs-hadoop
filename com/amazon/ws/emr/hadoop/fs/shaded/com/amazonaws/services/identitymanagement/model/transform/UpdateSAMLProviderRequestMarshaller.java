package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateSAMLProviderRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class UpdateSAMLProviderRequestMarshaller
  implements Marshaller<Request<UpdateSAMLProviderRequest>, UpdateSAMLProviderRequest>
{
  public Request<UpdateSAMLProviderRequest> marshall(UpdateSAMLProviderRequest updateSAMLProviderRequest)
  {
    if (updateSAMLProviderRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<UpdateSAMLProviderRequest> request = new DefaultRequest(updateSAMLProviderRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "UpdateSAMLProvider");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (updateSAMLProviderRequest.getSAMLMetadataDocument() != null) {
      request.addParameter("SAMLMetadataDocument", StringUtils.fromString(updateSAMLProviderRequest.getSAMLMetadataDocument()));
    }
    if (updateSAMLProviderRequest.getSAMLProviderArn() != null) {
      request.addParameter("SAMLProviderArn", StringUtils.fromString(updateSAMLProviderRequest.getSAMLProviderArn()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateSAMLProviderRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */