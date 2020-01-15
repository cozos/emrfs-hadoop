package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.SdkHttpMetadata;

public class AmazonWebServiceResult<T extends ResponseMetadata>
{
  private T sdkResponseMetadata;
  private SdkHttpMetadata sdkHttpMetadata;
  
  public T getSdkResponseMetadata()
  {
    return sdkResponseMetadata;
  }
  
  public AmazonWebServiceResult<T> setSdkResponseMetadata(T sdkResponseMetadata)
  {
    this.sdkResponseMetadata = sdkResponseMetadata;
    return this;
  }
  
  public SdkHttpMetadata getSdkHttpMetadata()
  {
    return sdkHttpMetadata;
  }
  
  public AmazonWebServiceResult<T> setSdkHttpMetadata(SdkHttpMetadata sdkHttpMetadata)
  {
    this.sdkHttpMetadata = sdkHttpMetadata;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */