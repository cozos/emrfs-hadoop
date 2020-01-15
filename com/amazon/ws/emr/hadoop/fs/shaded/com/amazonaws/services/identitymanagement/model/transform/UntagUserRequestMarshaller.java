package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UntagUserRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import java.util.List;

public class UntagUserRequestMarshaller
  implements Marshaller<Request<UntagUserRequest>, UntagUserRequest>
{
  public Request<UntagUserRequest> marshall(UntagUserRequest untagUserRequest)
  {
    if (untagUserRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<UntagUserRequest> request = new DefaultRequest(untagUserRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "UntagUser");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (untagUserRequest.getUserName() != null) {
      request.addParameter("UserName", StringUtils.fromString(untagUserRequest.getUserName()));
    }
    int tagKeysListIndex;
    if ((!untagUserRequest.getTagKeys().isEmpty()) || (!((SdkInternalList)untagUserRequest.getTagKeys()).isAutoConstruct()))
    {
      SdkInternalList<String> tagKeysList = (SdkInternalList)untagUserRequest.getTagKeys();
      tagKeysListIndex = 1;
      for (String tagKeysListValue : tagKeysList)
      {
        if (tagKeysListValue != null) {
          request.addParameter("TagKeys.member." + tagKeysListIndex, StringUtils.fromString(tagKeysListValue));
        }
        tagKeysListIndex++;
      }
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UntagUserRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */