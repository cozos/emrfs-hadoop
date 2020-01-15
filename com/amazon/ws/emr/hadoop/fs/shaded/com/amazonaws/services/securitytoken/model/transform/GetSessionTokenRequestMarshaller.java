package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.GetSessionTokenRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class GetSessionTokenRequestMarshaller
  implements Marshaller<Request<GetSessionTokenRequest>, GetSessionTokenRequest>
{
  public Request<GetSessionTokenRequest> marshall(GetSessionTokenRequest getSessionTokenRequest)
  {
    if (getSessionTokenRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<GetSessionTokenRequest> request = new DefaultRequest(getSessionTokenRequest, "AWSSecurityTokenService");
    request.addParameter("Action", "GetSessionToken");
    request.addParameter("Version", "2011-06-15");
    request.setHttpMethod(HttpMethodName.POST);
    if (getSessionTokenRequest.getDurationSeconds() != null) {
      request.addParameter("DurationSeconds", StringUtils.fromInteger(getSessionTokenRequest.getDurationSeconds()));
    }
    if (getSessionTokenRequest.getSerialNumber() != null) {
      request.addParameter("SerialNumber", StringUtils.fromString(getSessionTokenRequest.getSerialNumber()));
    }
    if (getSessionTokenRequest.getTokenCode() != null) {
      request.addParameter("TokenCode", StringUtils.fromString(getSessionTokenRequest.getTokenCode()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform.GetSessionTokenRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */