package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateRoleDescriptionRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class UpdateRoleDescriptionRequestMarshaller
  implements Marshaller<Request<UpdateRoleDescriptionRequest>, UpdateRoleDescriptionRequest>
{
  public Request<UpdateRoleDescriptionRequest> marshall(UpdateRoleDescriptionRequest updateRoleDescriptionRequest)
  {
    if (updateRoleDescriptionRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<UpdateRoleDescriptionRequest> request = new DefaultRequest(updateRoleDescriptionRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "UpdateRoleDescription");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (updateRoleDescriptionRequest.getRoleName() != null) {
      request.addParameter("RoleName", StringUtils.fromString(updateRoleDescriptionRequest.getRoleName()));
    }
    if (updateRoleDescriptionRequest.getDescription() != null) {
      request.addParameter("Description", StringUtils.fromString(updateRoleDescriptionRequest.getDescription()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateRoleDescriptionRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */