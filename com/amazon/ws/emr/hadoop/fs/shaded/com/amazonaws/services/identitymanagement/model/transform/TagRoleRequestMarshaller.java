package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.Tag;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.TagRoleRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import java.util.List;

public class TagRoleRequestMarshaller
  implements Marshaller<Request<TagRoleRequest>, TagRoleRequest>
{
  public Request<TagRoleRequest> marshall(TagRoleRequest tagRoleRequest)
  {
    if (tagRoleRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<TagRoleRequest> request = new DefaultRequest(tagRoleRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "TagRole");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (tagRoleRequest.getRoleName() != null) {
      request.addParameter("RoleName", StringUtils.fromString(tagRoleRequest.getRoleName()));
    }
    int tagsListIndex;
    if ((!tagRoleRequest.getTags().isEmpty()) || (!((SdkInternalList)tagRoleRequest.getTags()).isAutoConstruct()))
    {
      SdkInternalList<Tag> tagsList = (SdkInternalList)tagRoleRequest.getTags();
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.TagRoleRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */