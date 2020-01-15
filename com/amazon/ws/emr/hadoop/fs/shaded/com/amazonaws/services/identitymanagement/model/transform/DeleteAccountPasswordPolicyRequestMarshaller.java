package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteAccountPasswordPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;

public class DeleteAccountPasswordPolicyRequestMarshaller
  implements Marshaller<Request<DeleteAccountPasswordPolicyRequest>, DeleteAccountPasswordPolicyRequest>
{
  public Request<DeleteAccountPasswordPolicyRequest> marshall(DeleteAccountPasswordPolicyRequest deleteAccountPasswordPolicyRequest)
  {
    if (deleteAccountPasswordPolicyRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<DeleteAccountPasswordPolicyRequest> request = new DefaultRequest(deleteAccountPasswordPolicyRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "DeleteAccountPasswordPolicy");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteAccountPasswordPolicyRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */