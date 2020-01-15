package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateUserRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.Tag;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import java.util.List;

public class CreateUserRequestMarshaller
  implements Marshaller<Request<CreateUserRequest>, CreateUserRequest>
{
  public Request<CreateUserRequest> marshall(CreateUserRequest createUserRequest)
  {
    if (createUserRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<CreateUserRequest> request = new DefaultRequest(createUserRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "CreateUser");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (createUserRequest.getPath() != null) {
      request.addParameter("Path", StringUtils.fromString(createUserRequest.getPath()));
    }
    if (createUserRequest.getUserName() != null) {
      request.addParameter("UserName", StringUtils.fromString(createUserRequest.getUserName()));
    }
    if (createUserRequest.getPermissionsBoundary() != null) {
      request.addParameter("PermissionsBoundary", StringUtils.fromString(createUserRequest.getPermissionsBoundary()));
    }
    int tagsListIndex;
    if ((!createUserRequest.getTags().isEmpty()) || (!((SdkInternalList)createUserRequest.getTags()).isAutoConstruct()))
    {
      SdkInternalList<Tag> tagsList = (SdkInternalList)createUserRequest.getTags();
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CreateUserRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */