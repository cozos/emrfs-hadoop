package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListSSHPublicKeysRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class ListSSHPublicKeysRequestMarshaller
  implements Marshaller<Request<ListSSHPublicKeysRequest>, ListSSHPublicKeysRequest>
{
  public Request<ListSSHPublicKeysRequest> marshall(ListSSHPublicKeysRequest listSSHPublicKeysRequest)
  {
    if (listSSHPublicKeysRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<ListSSHPublicKeysRequest> request = new DefaultRequest(listSSHPublicKeysRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "ListSSHPublicKeys");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (listSSHPublicKeysRequest.getUserName() != null) {
      request.addParameter("UserName", StringUtils.fromString(listSSHPublicKeysRequest.getUserName()));
    }
    if (listSSHPublicKeysRequest.getMarker() != null) {
      request.addParameter("Marker", StringUtils.fromString(listSSHPublicKeysRequest.getMarker()));
    }
    if (listSSHPublicKeysRequest.getMaxItems() != null) {
      request.addParameter("MaxItems", StringUtils.fromInteger(listSSHPublicKeysRequest.getMaxItems()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListSSHPublicKeysRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */