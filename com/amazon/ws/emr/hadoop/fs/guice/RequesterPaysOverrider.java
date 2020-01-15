package com.amazon.ws.emr.hadoop.fs.guice;

import com.amazon.ws.emr.hadoop.fs.s3.lite.call.S3Call;
import com.amazon.ws.emr.hadoop.fs.s3.lite.executor.S3CallOverrider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class RequesterPaysOverrider
  implements S3CallOverrider
{
  private static final Logger LOG = LoggerFactory.getLogger(RequesterPaysOverrider.class);
  
  public S3Call override(S3Call call)
  {
    LOG.debug("Overriding requester pays enabled to true for {}", call);
    call.enableRequesterPays();
    return call;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.guice.RequesterPaysOverrider
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */