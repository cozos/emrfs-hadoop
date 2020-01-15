package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.config;

public class SignerConfigJsonHelper
  implements Builder<SignerConfig>
{
  private String signerType;
  
  public SignerConfigJsonHelper() {}
  
  public SignerConfigJsonHelper(String signerType)
  {
    this.signerType = signerType;
  }
  
  public String getSignerType()
  {
    return signerType;
  }
  
  public void setSignerType(String signerType)
  {
    this.signerType = signerType;
  }
  
  public SignerConfig build()
  {
    return new SignerConfig(signerType);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.config.SignerConfigJsonHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */