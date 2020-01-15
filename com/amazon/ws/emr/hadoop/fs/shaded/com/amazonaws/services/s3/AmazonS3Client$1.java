package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

final class AmazonS3Client$1
  extends LinkedHashMap<String, String>
{
  private static final long serialVersionUID = 23453L;
  
  AmazonS3Client$1(int x0, float x1, boolean x2)
  {
    super(x0, x1, x2);
  }
  
  protected boolean removeEldestEntry(Map.Entry<String, String> eldest)
  {
    return size() > 300;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3Client.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */