package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListAccessKeysRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class ListAccessKeysRequestMarshaller
  implements Marshaller<Request<ListAccessKeysRequest>, ListAccessKeysRequest>
{
  public Request<ListAccessKeysRequest> marshall(ListAccessKeysRequest listAccessKeysRequest)
  {
    if (listAccessKeysRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<ListAccessKeysRequest> request = new DefaultRequest(listAccessKeysRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "ListAccessKeys");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (listAccessKeysRequest.getUserName() != null) {
      request.addParameter("UserName", StringUtils.fromString(listAccessKeysRequest.getUserName()));
    }
    if (listAccessKeysRequest.getMarker() != null) {
      request.addParameter("Marker", StringUtils.fromString(listAccessKeysRequest.getMarker()));
    }
    if (listAccessKeysRequest.getMaxItems() != null) {
      request.addParameter("MaxItems", StringUtils.fromInteger(listAccessKeysRequest.getMaxItems()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListAccessKeysRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */