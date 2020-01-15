package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.Tag;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.TagUserRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import java.util.List;

public class TagUserRequestMarshaller
  implements Marshaller<Request<TagUserRequest>, TagUserRequest>
{
  public Request<TagUserRequest> marshall(TagUserRequest tagUserRequest)
  {
    if (tagUserRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<TagUserRequest> request = new DefaultRequest(tagUserRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "TagUser");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (tagUserRequest.getUserName() != null) {
      request.addParameter("UserName", StringUtils.fromString(tagUserRequest.getUserName()));
    }
    int tagsListIndex;
    if ((!tagUserRequest.getTags().isEmpty()) || (!((SdkInternalList)tagUserRequest.getTags()).isAutoConstruct()))
    {
      SdkInternalList<Tag> tagsList = (SdkInternalList)tagUserRequest.getTags();
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.TagUserRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */