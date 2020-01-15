package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateAssumeRolePolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class UpdateAssumeRolePolicyRequestMarshaller
  implements Marshaller<Request<UpdateAssumeRolePolicyRequest>, UpdateAssumeRolePolicyRequest>
{
  public Request<UpdateAssumeRolePolicyRequest> marshall(UpdateAssumeRolePolicyRequest updateAssumeRolePolicyRequest)
  {
    if (updateAssumeRolePolicyRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<UpdateAssumeRolePolicyRequest> request = new DefaultRequest(updateAssumeRolePolicyRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "UpdateAssumeRolePolicy");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (updateAssumeRolePolicyRequest.getRoleName() != null) {
      request.addParameter("RoleName", StringUtils.fromString(updateAssumeRolePolicyRequest.getRoleName()));
    }
    if (updateAssumeRolePolicyRequest.getPolicyDocument() != null) {
      request.addParameter("PolicyDocument", StringUtils.fromString(updateAssumeRolePolicyRequest.getPolicyDocument()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateAssumeRolePolicyRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */