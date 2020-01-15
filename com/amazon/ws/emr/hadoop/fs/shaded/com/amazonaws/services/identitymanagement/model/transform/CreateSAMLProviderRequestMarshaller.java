package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateSAMLProviderRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class CreateSAMLProviderRequestMarshaller
  implements Marshaller<Request<CreateSAMLProviderRequest>, CreateSAMLProviderRequest>
{
  public Request<CreateSAMLProviderRequest> marshall(CreateSAMLProviderRequest createSAMLProviderRequest)
  {
    if (createSAMLProviderRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<CreateSAMLProviderRequest> request = new DefaultRequest(createSAMLProviderRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "CreateSAMLProvider");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (createSAMLProviderRequest.getSAMLMetadataDocument() != null) {
      request.addParameter("SAMLMetadataDocument", StringUtils.fromString(createSAMLProviderRequest.getSAMLMetadataDocument()));
    }
    if (createSAMLProviderRequest.getName() != null) {
      request.addParameter("Name", StringUtils.fromString(createSAMLProviderRequest.getName()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CreateSAMLProviderRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */