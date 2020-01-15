package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;

@SdkProtectedApi
@NotThreadSafe
public class ClientHandlerParams
{
  private AwsSyncClientParams clientParams;
  private boolean disableStrictHostnameVerification = false;
  
  public AwsSyncClientParams getClientParams()
  {
    return clientParams;
  }
  
  public ClientHandlerParams withClientParams(AwsSyncClientParams clientParams)
  {
    this.clientParams = clientParams;
    return this;
  }
  
  public boolean isDisableStrictHostnameVerification()
  {
    return disableStrictHostnameVerification;
  }
  
  public ClientHandlerParams withDisableStrictHostnameVerification(boolean disableStrictHostnameVerification)
  {
    this.disableStrictHostnameVerification = disableStrictHostnameVerification;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.ClientHandlerParams
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */