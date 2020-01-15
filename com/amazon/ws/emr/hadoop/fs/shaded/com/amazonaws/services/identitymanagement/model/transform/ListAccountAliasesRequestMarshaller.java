package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListAccountAliasesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class ListAccountAliasesRequestMarshaller
  implements Marshaller<Request<ListAccountAliasesRequest>, ListAccountAliasesRequest>
{
  public Request<ListAccountAliasesRequest> marshall(ListAccountAliasesRequest listAccountAliasesRequest)
  {
    if (listAccountAliasesRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<ListAccountAliasesRequest> request = new DefaultRequest(listAccountAliasesRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "ListAccountAliases");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (listAccountAliasesRequest.getMarker() != null) {
      request.addParameter("Marker", StringUtils.fromString(listAccountAliasesRequest.getMarker()));
    }
    if (listAccountAliasesRequest.getMaxItems() != null) {
      request.addParameter("MaxItems", StringUtils.fromInteger(listAccountAliasesRequest.getMaxItems()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListAccountAliasesRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */