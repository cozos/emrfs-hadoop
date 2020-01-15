package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateServiceLinkedRoleRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class CreateServiceLinkedRoleRequestMarshaller
  implements Marshaller<Request<CreateServiceLinkedRoleRequest>, CreateServiceLinkedRoleRequest>
{
  public Request<CreateServiceLinkedRoleRequest> marshall(CreateServiceLinkedRoleRequest createServiceLinkedRoleRequest)
  {
    if (createServiceLinkedRoleRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<CreateServiceLinkedRoleRequest> request = new DefaultRequest(createServiceLinkedRoleRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "CreateServiceLinkedRole");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (createServiceLinkedRoleRequest.getAWSServiceName() != null) {
      request.addParameter("AWSServiceName", StringUtils.fromString(createServiceLinkedRoleRequest.getAWSServiceName()));
    }
    if (createServiceLinkedRoleRequest.getDescription() != null) {
      request.addParameter("Description", StringUtils.fromString(createServiceLinkedRoleRequest.getDescription()));
    }
    if (createServiceLinkedRoleRequest.getCustomSuffix() != null) {
      request.addParameter("CustomSuffix", StringUtils.fromString(createServiceLinkedRoleRequest.getCustomSuffix()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CreateServiceLinkedRoleRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */