package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteAccountAliasRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class DeleteAccountAliasRequestMarshaller
  implements Marshaller<Request<DeleteAccountAliasRequest>, DeleteAccountAliasRequest>
{
  public Request<DeleteAccountAliasRequest> marshall(DeleteAccountAliasRequest deleteAccountAliasRequest)
  {
    if (deleteAccountAliasRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<DeleteAccountAliasRequest> request = new DefaultRequest(deleteAccountAliasRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "DeleteAccountAlias");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (deleteAccountAliasRequest.getAccountAlias() != null) {
      request.addParameter("AccountAlias", StringUtils.fromString(deleteAccountAliasRequest.getAccountAlias()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteAccountAliasRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */