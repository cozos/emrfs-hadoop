package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer;

import java.net.URL;

public abstract interface PresignedUrlDownload
  extends AbortableTransfer
{
  public abstract URL getPresignedUrl();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.PresignedUrlDownload
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */