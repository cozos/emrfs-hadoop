package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.SetSecurityTokenServicePreferencesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class SetSecurityTokenServicePreferencesRequestMarshaller
  implements Marshaller<Request<SetSecurityTokenServicePreferencesRequest>, SetSecurityTokenServicePreferencesRequest>
{
  public Request<SetSecurityTokenServicePreferencesRequest> marshall(SetSecurityTokenServicePreferencesRequest setSecurityTokenServicePreferencesRequest)
  {
    if (setSecurityTokenServicePreferencesRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<SetSecurityTokenServicePreferencesRequest> request = new DefaultRequest(setSecurityTokenServicePreferencesRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "SetSecurityTokenServicePreferences");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (setSecurityTokenServicePreferencesRequest.getGlobalEndpointTokenVersion() != null) {
      request.addParameter("GlobalEndpointTokenVersion", 
        StringUtils.fromString(setSecurityTokenServicePreferencesRequest.getGlobalEndpointTokenVersion()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.SetSecurityTokenServicePreferencesRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */