package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetLoginProfileRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class GetLoginProfileRequestMarshaller
  implements Marshaller<Request<GetLoginProfileRequest>, GetLoginProfileRequest>
{
  public Request<GetLoginProfileRequest> marshall(GetLoginProfileRequest getLoginProfileRequest)
  {
    if (getLoginProfileRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<GetLoginProfileRequest> request = new DefaultRequest(getLoginProfileRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "GetLoginProfile");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (getLoginProfileRequest.getUserName() != null) {
      request.addParameter("UserName", StringUtils.fromString(getLoginProfileRequest.getUserName()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetLoginProfileRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */