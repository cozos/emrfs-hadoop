package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteOpenIDConnectProviderRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class DeleteOpenIDConnectProviderRequestMarshaller
  implements Marshaller<Request<DeleteOpenIDConnectProviderRequest>, DeleteOpenIDConnectProviderRequest>
{
  public Request<DeleteOpenIDConnectProviderRequest> marshall(DeleteOpenIDConnectProviderRequest deleteOpenIDConnectProviderRequest)
  {
    if (deleteOpenIDConnectProviderRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<DeleteOpenIDConnectProviderRequest> request = new DefaultRequest(deleteOpenIDConnectProviderRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "DeleteOpenIDConnectProvider");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (deleteOpenIDConnectProviderRequest.getOpenIDConnectProviderArn() != null) {
      request.addParameter("OpenIDConnectProviderArn", StringUtils.fromString(deleteOpenIDConnectProviderRequest.getOpenIDConnectProviderArn()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteOpenIDConnectProviderRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */