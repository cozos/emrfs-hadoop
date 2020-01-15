package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.PutUserPermissionsBoundaryRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class PutUserPermissionsBoundaryRequestMarshaller
  implements Marshaller<Request<PutUserPermissionsBoundaryRequest>, PutUserPermissionsBoundaryRequest>
{
  public Request<PutUserPermissionsBoundaryRequest> marshall(PutUserPermissionsBoundaryRequest putUserPermissionsBoundaryRequest)
  {
    if (putUserPermissionsBoundaryRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<PutUserPermissionsBoundaryRequest> request = new DefaultRequest(putUserPermissionsBoundaryRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "PutUserPermissionsBoundary");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (putUserPermissionsBoundaryRequest.getUserName() != null) {
      request.addParameter("UserName", StringUtils.fromString(putUserPermissionsBoundaryRequest.getUserName()));
    }
    if (putUserPermissionsBoundaryRequest.getPermissionsBoundary() != null) {
      request.addParameter("PermissionsBoundary", StringUtils.fromString(putUserPermissionsBoundaryRequest.getPermissionsBoundary()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.PutUserPermissionsBoundaryRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */