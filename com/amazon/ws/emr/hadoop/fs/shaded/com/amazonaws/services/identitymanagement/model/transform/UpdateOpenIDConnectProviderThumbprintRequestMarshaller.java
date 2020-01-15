package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateOpenIDConnectProviderThumbprintRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import java.util.List;

public class UpdateOpenIDConnectProviderThumbprintRequestMarshaller
  implements Marshaller<Request<UpdateOpenIDConnectProviderThumbprintRequest>, UpdateOpenIDConnectProviderThumbprintRequest>
{
  public Request<UpdateOpenIDConnectProviderThumbprintRequest> marshall(UpdateOpenIDConnectProviderThumbprintRequest updateOpenIDConnectProviderThumbprintRequest)
  {
    if (updateOpenIDConnectProviderThumbprintRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<UpdateOpenIDConnectProviderThumbprintRequest> request = new DefaultRequest(updateOpenIDConnectProviderThumbprintRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "UpdateOpenIDConnectProviderThumbprint");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (updateOpenIDConnectProviderThumbprintRequest.getOpenIDConnectProviderArn() != null) {
      request.addParameter("OpenIDConnectProviderArn", StringUtils.fromString(updateOpenIDConnectProviderThumbprintRequest.getOpenIDConnectProviderArn()));
    }
    int thumbprintListListIndex;
    if ((!updateOpenIDConnectProviderThumbprintRequest.getThumbprintList().isEmpty()) || 
      (!((SdkInternalList)updateOpenIDConnectProviderThumbprintRequest.getThumbprintList()).isAutoConstruct()))
    {
      SdkInternalList<String> thumbprintListList = (SdkInternalList)updateOpenIDConnectProviderThumbprintRequest.getThumbprintList();
      thumbprintListListIndex = 1;
      for (String thumbprintListListValue : thumbprintListList)
      {
        if (thumbprintListListValue != null) {
          request.addParameter("ThumbprintList.member." + thumbprintListListIndex, StringUtils.fromString(thumbprintListListValue));
        }
        thumbprintListListIndex++;
      }
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateOpenIDConnectProviderThumbprintRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */