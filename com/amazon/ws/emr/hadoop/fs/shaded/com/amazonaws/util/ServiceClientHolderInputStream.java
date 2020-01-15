package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceClient;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkFilterInputStream;
import java.io.InputStream;

public class ServiceClientHolderInputStream
  extends SdkFilterInputStream
{
  private AmazonWebServiceClient client;
  
  public ServiceClientHolderInputStream(InputStream in, AmazonWebServiceClient client)
  {
    super(in);
    this.client = client;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ServiceClientHolderInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */