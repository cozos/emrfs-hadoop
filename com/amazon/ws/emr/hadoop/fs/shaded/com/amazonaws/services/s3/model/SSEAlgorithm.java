package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

public enum SSEAlgorithm
{
  AES256("AES256"),  KMS("aws:kms");
  
  private final String algorithm;
  
  public String getAlgorithm()
  {
    return algorithm;
  }
  
  private SSEAlgorithm(String algorithm)
  {
    this.algorithm = algorithm;
  }
  
  public String toString()
  {
    return algorithm;
  }
  
  public static SSEAlgorithm fromString(String algorithm)
  {
    if (algorithm == null) {
      return null;
    }
    for (SSEAlgorithm e : values()) {
      if (e.getAlgorithm().equals(algorithm)) {
        return e;
      }
    }
    throw new IllegalArgumentException("Unsupported algorithm " + algorithm);
  }
  
  public static SSEAlgorithm getDefault()
  {
    return AES256;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SSEAlgorithm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */