package com.amazon.ws.emr.hadoop.fs.s3.lite.configuration;

public final class S3Configuration
  extends AbstractS3Configuration
{
  private S3Configuration(Builder builder)
  {
    super(builder);
  }
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  public static final class Builder
    extends AbstractS3Configuration.Builder<S3Configuration, Builder>
  {
    S3Configuration newInstance()
    {
      return new S3Configuration(this, null);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.configuration.S3Configuration
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */