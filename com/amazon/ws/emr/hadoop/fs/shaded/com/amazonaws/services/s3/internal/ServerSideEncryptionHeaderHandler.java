package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponse;
import java.util.Map;

public class ServerSideEncryptionHeaderHandler<T extends ServerSideEncryptionResult>
  implements HeaderHandler<T>
{
  public void handle(T result, HttpResponse response)
  {
    result.setSSEAlgorithm((String)response.getHeaders().get("x-amz-server-side-encryption"));
    result.setSSECustomerAlgorithm((String)response.getHeaders().get("x-amz-server-side-encryption-customer-algorithm"));
    result.setSSECustomerKeyMd5((String)response.getHeaders().get("x-amz-server-side-encryption-customer-key-MD5"));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.ServerSideEncryptionHeaderHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */