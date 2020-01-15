package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateRoleRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.Tag;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import java.util.List;

public class CreateRoleRequestMarshaller
  implements Marshaller<Request<CreateRoleRequest>, CreateRoleRequest>
{
  public Request<CreateRoleRequest> marshall(CreateRoleRequest createRoleRequest)
  {
    if (createRoleRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<CreateRoleRequest> request = new DefaultRequest(createRoleRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "CreateRole");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (createRoleRequest.getPath() != null) {
      request.addParameter("Path", StringUtils.fromString(createRoleRequest.getPath()));
    }
    if (createRoleRequest.getRoleName() != null) {
      request.addParameter("RoleName", StringUtils.fromString(createRoleRequest.getRoleName()));
    }
    if (createRoleRequest.getAssumeRolePolicyDocument() != null) {
      request.addParameter("AssumeRolePolicyDocument", StringUtils.fromString(createRoleRequest.getAssumeRolePolicyDocument()));
    }
    if (createRoleRequest.getDescription() != null) {
      request.addParameter("Description", StringUtils.fromString(createRoleRequest.getDescription()));
    }
    if (createRoleRequest.getMaxSessionDuration() != null) {
      request.addParameter("MaxSessionDuration", StringUtils.fromInteger(createRoleRequest.getMaxSessionDuration()));
    }
    if (createRoleRequest.getPermissionsBoundary() != null) {
      request.addParameter("PermissionsBoundary", StringUtils.fromString(createRoleRequest.getPermissionsBoundary()));
    }
    int tagsListIndex;
    if ((!createRoleRequest.getTags().isEmpty()) || (!((SdkInternalList)createRoleRequest.getTags()).isAutoConstruct()))
    {
      SdkInternalList<Tag> tagsList = (SdkInternalList)createRoleRequest.getTags();
      tagsListIndex = 1;
      for (Tag tagsListValue : tagsList)
      {
        if (tagsListValue.getKey() != null) {
          request.addParameter("Tags.member." + tagsListIndex + ".Key", StringUtils.fromString(tagsListValue.getKey()));
        }
        if (tagsListValue.getValue() != null) {
          request.addParameter("Tags.member." + tagsListIndex + ".Value", StringUtils.fromString(tagsListValue.getValue()));
        }
        tagsListIndex++;
      }
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CreateRoleRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */