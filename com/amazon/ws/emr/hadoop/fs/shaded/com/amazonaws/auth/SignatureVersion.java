package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

public enum SignatureVersion
{
  V1("1"),  V2("2");
  
  private String value;
  
  private SignatureVersion(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.SignatureVersion
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */