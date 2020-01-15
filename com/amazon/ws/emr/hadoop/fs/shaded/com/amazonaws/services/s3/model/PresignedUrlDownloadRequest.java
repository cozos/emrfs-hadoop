package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.net.URL;

public class PresignedUrlDownloadRequest
  extends AmazonWebServiceRequest
  implements Serializable
{
  private URL presignedUrl;
  private long[] range;
  
  public PresignedUrlDownloadRequest(URL presignedUrl)
  {
    this.presignedUrl = presignedUrl;
  }
  
  public URL getPresignedUrl()
  {
    return presignedUrl;
  }
  
  public void setPresignedUrl(URL presignedUrl)
  {
    this.presignedUrl = presignedUrl;
  }
  
  public PresignedUrlDownloadRequest withPresignedUrl(URL presignedUrl)
  {
    setPresignedUrl(presignedUrl);
    return this;
  }
  
  public long[] getRange()
  {
    return range == null ? null : (long[])range.clone();
  }
  
  public void setRange(long start, long end)
  {
    range = new long[] { start, end };
  }
  
  public PresignedUrlDownloadRequest withRange(long start, long end)
  {
    setRange(start, end);
    return this;
  }
  
  public PresignedUrlDownloadRequest clone()
  {
    PresignedUrlDownloadRequest target = new PresignedUrlDownloadRequest(getPresignedUrl());
    copyBaseTo(target);
    if (getRange() != null) {
      target.setRange(getRange()[0], getRange()[1]);
    }
    return target;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PresignedUrlDownloadRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */