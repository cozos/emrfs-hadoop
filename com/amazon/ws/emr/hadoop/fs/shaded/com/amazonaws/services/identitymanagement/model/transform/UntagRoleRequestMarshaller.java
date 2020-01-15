package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UntagRoleRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import java.util.List;

public class UntagRoleRequestMarshaller
  implements Marshaller<Request<UntagRoleRequest>, UntagRoleRequest>
{
  public Request<UntagRoleRequest> marshall(UntagRoleRequest untagRoleRequest)
  {
    if (untagRoleRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<UntagRoleRequest> request = new DefaultRequest(untagRoleRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "UntagRole");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (untagRoleRequest.getRoleName() != null) {
      request.addParameter("RoleName", StringUtils.fromString(untagRoleRequest.getRoleName()));
    }
    int tagKeysListIndex;
    if ((!untagRoleRequest.getTagKeys().isEmpty()) || (!((SdkInternalList)untagRoleRequest.getTagKeys()).isAutoConstruct()))
    {
      SdkInternalList<String> tagKeysList = (SdkInternalList)untagRoleRequest.getTagKeys();
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UntagRoleRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */