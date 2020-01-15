package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

public abstract interface ServerSideEncryptionResult
{
  public abstract String getSSEAlgorithm();
  
  public abstract void setSSEAlgorithm(String paramString);
  
  public abstract String getSSECustomerAlgorithm();
  
  public abstract void setSSECustomerAlgorithm(String paramString);
  
  public abstract String getSSECustomerKeyMd5();
  
  public abstract void setSSECustomerKeyMd5(String paramString);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.ServerSideEncryptionResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */