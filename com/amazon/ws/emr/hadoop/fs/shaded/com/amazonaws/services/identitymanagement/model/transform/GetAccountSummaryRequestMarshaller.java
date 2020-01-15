package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetAccountSummaryRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;

public class GetAccountSummaryRequestMarshaller
  implements Marshaller<Request<GetAccountSummaryRequest>, GetAccountSummaryRequest>
{
  public Request<GetAccountSummaryRequest> marshall(GetAccountSummaryRequest getAccountSummaryRequest)
  {
    if (getAccountSummaryRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<GetAccountSummaryRequest> request = new DefaultRequest(getAccountSummaryRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "GetAccountSummary");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetAccountSummaryRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */