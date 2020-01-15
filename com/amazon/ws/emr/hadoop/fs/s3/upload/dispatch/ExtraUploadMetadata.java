package com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch;

import com.amazon.ws.emr.hadoop.fs.consistency.concurrent.ConcurrencyToken;

public final class ExtraUploadMetadata
{
  public ExtraUploadMetadata(ConcurrencyToken concurrencyToken)
  {
    this.concurrencyToken = concurrencyToken;
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof ExtraUploadMetadata)) {
      return false;
    }
    ExtraUploadMetadata other = (ExtraUploadMetadata)o;Object this$concurrencyToken = getConcurrencyToken();Object other$concurrencyToken = other.getConcurrencyToken();return this$concurrencyToken == null ? other$concurrencyToken == null : this$concurrencyToken.equals(other$concurrencyToken);
  }
  
  public int hashCode()
  {
    int PRIME = 59;int result = 1;Object $concurrencyToken = getConcurrencyToken();result = result * 59 + ($concurrencyToken == null ? 43 : $concurrencyToken.hashCode());return result;
  }
  
  public String toString()
  {
    return "ExtraUploadMetadata(concurrencyToken=" + getConcurrencyToken() + ")";
  }
  
  private static final ExtraUploadMetadata EMPTY = new ExtraUploadMetadata();
  private final ConcurrencyToken concurrencyToken;
  
  public ConcurrencyToken getConcurrencyToken()
  {
    return concurrencyToken;
  }
  
  private ExtraUploadMetadata()
  {
    concurrencyToken = null;
  }
  
  public static ExtraUploadMetadata empty()
  {
    return EMPTY;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.ExtraUploadMetadata
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */