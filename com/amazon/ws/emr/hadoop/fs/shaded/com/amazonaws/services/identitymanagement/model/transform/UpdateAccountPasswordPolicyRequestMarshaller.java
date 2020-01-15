package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateAccountPasswordPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class UpdateAccountPasswordPolicyRequestMarshaller
  implements Marshaller<Request<UpdateAccountPasswordPolicyRequest>, UpdateAccountPasswordPolicyRequest>
{
  public Request<UpdateAccountPasswordPolicyRequest> marshall(UpdateAccountPasswordPolicyRequest updateAccountPasswordPolicyRequest)
  {
    if (updateAccountPasswordPolicyRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<UpdateAccountPasswordPolicyRequest> request = new DefaultRequest(updateAccountPasswordPolicyRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "UpdateAccountPasswordPolicy");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (updateAccountPasswordPolicyRequest.getMinimumPasswordLength() != null) {
      request.addParameter("MinimumPasswordLength", StringUtils.fromInteger(updateAccountPasswordPolicyRequest.getMinimumPasswordLength()));
    }
    if (updateAccountPasswordPolicyRequest.getRequireSymbols() != null) {
      request.addParameter("RequireSymbols", StringUtils.fromBoolean(updateAccountPasswordPolicyRequest.getRequireSymbols()));
    }
    if (updateAccountPasswordPolicyRequest.getRequireNumbers() != null) {
      request.addParameter("RequireNumbers", StringUtils.fromBoolean(updateAccountPasswordPolicyRequest.getRequireNumbers()));
    }
    if (updateAccountPasswordPolicyRequest.getRequireUppercaseCharacters() != null) {
      request.addParameter("RequireUppercaseCharacters", StringUtils.fromBoolean(updateAccountPasswordPolicyRequest.getRequireUppercaseCharacters()));
    }
    if (updateAccountPasswordPolicyRequest.getRequireLowercaseCharacters() != null) {
      request.addParameter("RequireLowercaseCharacters", StringUtils.fromBoolean(updateAccountPasswordPolicyRequest.getRequireLowercaseCharacters()));
    }
    if (updateAccountPasswordPolicyRequest.getAllowUsersToChangePassword() != null) {
      request.addParameter("AllowUsersToChangePassword", StringUtils.fromBoolean(updateAccountPasswordPolicyRequest.getAllowUsersToChangePassword()));
    }
    if (updateAccountPasswordPolicyRequest.getMaxPasswordAge() != null) {
      request.addParameter("MaxPasswordAge", StringUtils.fromInteger(updateAccountPasswordPolicyRequest.getMaxPasswordAge()));
    }
    if (updateAccountPasswordPolicyRequest.getPasswordReusePrevention() != null) {
      request.addParameter("PasswordReusePrevention", StringUtils.fromInteger(updateAccountPasswordPolicyRequest.getPasswordReusePrevention()));
    }
    if (updateAccountPasswordPolicyRequest.getHardExpiry() != null) {
      request.addParameter("HardExpiry", StringUtils.fromBoolean(updateAccountPasswordPolicyRequest.getHardExpiry()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateAccountPasswordPolicyRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */