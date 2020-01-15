package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

public abstract class SSEResultBase
  implements ServerSideEncryptionResult
{
  private String sseAlgorithm;
  private String sseCustomerAlgorithm;
  private String sseCustomerKeyMD5;
  
  public final String getSSEAlgorithm()
  {
    return sseAlgorithm;
  }
  
  public final void setSSEAlgorithm(String algorithm)
  {
    sseAlgorithm = algorithm;
  }
  
  public final String getSSECustomerAlgorithm()
  {
    return sseCustomerAlgorithm;
  }
  
  public final void setSSECustomerAlgorithm(String algorithm)
  {
    sseCustomerAlgorithm = algorithm;
  }
  
  public final String getSSECustomerKeyMd5()
  {
    return sseCustomerKeyMD5;
  }
  
  public final void setSSECustomerKeyMd5(String md5)
  {
    sseCustomerKeyMD5 = md5;
  }
  
  @Deprecated
  public final String getServerSideEncryption()
  {
    return sseAlgorithm;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.SSEResultBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */