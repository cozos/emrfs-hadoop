package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetServiceLinkedRoleDeletionStatusRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class GetServiceLinkedRoleDeletionStatusRequestMarshaller
  implements Marshaller<Request<GetServiceLinkedRoleDeletionStatusRequest>, GetServiceLinkedRoleDeletionStatusRequest>
{
  public Request<GetServiceLinkedRoleDeletionStatusRequest> marshall(GetServiceLinkedRoleDeletionStatusRequest getServiceLinkedRoleDeletionStatusRequest)
  {
    if (getServiceLinkedRoleDeletionStatusRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<GetServiceLinkedRoleDeletionStatusRequest> request = new DefaultRequest(getServiceLinkedRoleDeletionStatusRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "GetServiceLinkedRoleDeletionStatus");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (getServiceLinkedRoleDeletionStatusRequest.getDeletionTaskId() != null) {
      request.addParameter("DeletionTaskId", StringUtils.fromString(getServiceLinkedRoleDeletionStatusRequest.getDeletionTaskId()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetServiceLinkedRoleDeletionStatusRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */