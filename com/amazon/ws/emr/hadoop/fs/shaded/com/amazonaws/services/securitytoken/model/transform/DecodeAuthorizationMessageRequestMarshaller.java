package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.DecodeAuthorizationMessageRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class DecodeAuthorizationMessageRequestMarshaller
  implements Marshaller<Request<DecodeAuthorizationMessageRequest>, DecodeAuthorizationMessageRequest>
{
  public Request<DecodeAuthorizationMessageRequest> marshall(DecodeAuthorizationMessageRequest decodeAuthorizationMessageRequest)
  {
    if (decodeAuthorizationMessageRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<DecodeAuthorizationMessageRequest> request = new DefaultRequest(decodeAuthorizationMessageRequest, "AWSSecurityTokenService");
    
    request.addParameter("Action", "DecodeAuthorizationMessage");
    request.addParameter("Version", "2011-06-15");
    request.setHttpMethod(HttpMethodName.POST);
    if (decodeAuthorizationMessageRequest.getEncodedMessage() != null) {
      request.addParameter("EncodedMessage", StringUtils.fromString(decodeAuthorizationMessageRequest.getEncodedMessage()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform.DecodeAuthorizationMessageRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */