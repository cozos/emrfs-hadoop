package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.GetAccessKeyInfoRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class GetAccessKeyInfoRequestMarshaller
  implements Marshaller<Request<GetAccessKeyInfoRequest>, GetAccessKeyInfoRequest>
{
  public Request<GetAccessKeyInfoRequest> marshall(GetAccessKeyInfoRequest getAccessKeyInfoRequest)
  {
    if (getAccessKeyInfoRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<GetAccessKeyInfoRequest> request = new DefaultRequest(getAccessKeyInfoRequest, "AWSSecurityTokenService");
    request.addParameter("Action", "GetAccessKeyInfo");
    request.addParameter("Version", "2011-06-15");
    request.setHttpMethod(HttpMethodName.POST);
    if (getAccessKeyInfoRequest.getAccessKeyId() != null) {
      request.addParameter("AccessKeyId", StringUtils.fromString(getAccessKeyInfoRequest.getAccessKeyId()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform.GetAccessKeyInfoRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */