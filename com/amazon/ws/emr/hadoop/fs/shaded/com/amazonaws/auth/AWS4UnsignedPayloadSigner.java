package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SignableRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkTestInternalApi;
import com.amazonaws.auth.AWSCredentials;
import java.net.URI;
import java.util.Map;

public class AWS4UnsignedPayloadSigner
  extends AWS4Signer
{
  public AWS4UnsignedPayloadSigner() {}
  
  @SdkTestInternalApi
  public AWS4UnsignedPayloadSigner(SdkClock clock)
  {
    super(clock);
  }
  
  public void sign(SignableRequest<?> request, AWSCredentials credentials)
  {
    request.getHeaders().put("x-amz-content-sha256", "required");
    super.sign(request, credentials);
  }
  
  protected String calculateContentHash(SignableRequest<?> request)
  {
    if ("https".equals(request.getEndpoint().getScheme())) {
      return "UNSIGNED-PAYLOAD";
    }
    return super.calculateContentHash(request);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.AWS4UnsignedPayloadSigner
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */