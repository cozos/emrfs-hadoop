package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateOpenIDConnectProviderRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import java.util.List;

public class CreateOpenIDConnectProviderRequestMarshaller
  implements Marshaller<Request<CreateOpenIDConnectProviderRequest>, CreateOpenIDConnectProviderRequest>
{
  public Request<CreateOpenIDConnectProviderRequest> marshall(CreateOpenIDConnectProviderRequest createOpenIDConnectProviderRequest)
  {
    if (createOpenIDConnectProviderRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<CreateOpenIDConnectProviderRequest> request = new DefaultRequest(createOpenIDConnectProviderRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "CreateOpenIDConnectProvider");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (createOpenIDConnectProviderRequest.getUrl() != null) {
      request.addParameter("Url", StringUtils.fromString(createOpenIDConnectProviderRequest.getUrl()));
    }
    int clientIDListListIndex;
    if ((!createOpenIDConnectProviderRequest.getClientIDList().isEmpty()) || 
      (!((SdkInternalList)createOpenIDConnectProviderRequest.getClientIDList()).isAutoConstruct()))
    {
      SdkInternalList<String> clientIDListList = (SdkInternalList)createOpenIDConnectProviderRequest.getClientIDList();
      clientIDListListIndex = 1;
      for (String clientIDListListValue : clientIDListList)
      {
        if (clientIDListListValue != null) {
          request.addParameter("ClientIDList.member." + clientIDListListIndex, StringUtils.fromString(clientIDListListValue));
        }
        clientIDListListIndex++;
      }
    }
    int thumbprintListListIndex;
    if ((!createOpenIDConnectProviderRequest.getThumbprintList().isEmpty()) || 
      (!((SdkInternalList)createOpenIDConnectProviderRequest.getThumbprintList()).isAutoConstruct()))
    {
      SdkInternalList<String> thumbprintListList = (SdkInternalList)createOpenIDConnectProviderRequest.getThumbprintList();
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CreateOpenIDConnectProviderRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */