package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateAccountAliasRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class CreateAccountAliasRequestMarshaller
  implements Marshaller<Request<CreateAccountAliasRequest>, CreateAccountAliasRequest>
{
  public Request<CreateAccountAliasRequest> marshall(CreateAccountAliasRequest createAccountAliasRequest)
  {
    if (createAccountAliasRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<CreateAccountAliasRequest> request = new DefaultRequest(createAccountAliasRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "CreateAccountAlias");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (createAccountAliasRequest.getAccountAlias() != null) {
      request.addParameter("AccountAlias", StringUtils.fromString(createAccountAliasRequest.getAccountAlias()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CreateAccountAliasRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */