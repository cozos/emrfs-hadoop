package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteInstanceProfileRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class DeleteInstanceProfileRequestMarshaller
  implements Marshaller<Request<DeleteInstanceProfileRequest>, DeleteInstanceProfileRequest>
{
  public Request<DeleteInstanceProfileRequest> marshall(DeleteInstanceProfileRequest deleteInstanceProfileRequest)
  {
    if (deleteInstanceProfileRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<DeleteInstanceProfileRequest> request = new DefaultRequest(deleteInstanceProfileRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "DeleteInstanceProfile");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (deleteInstanceProfileRequest.getInstanceProfileName() != null) {
      request.addParameter("InstanceProfileName", StringUtils.fromString(deleteInstanceProfileRequest.getInstanceProfileName()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteInstanceProfileRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */