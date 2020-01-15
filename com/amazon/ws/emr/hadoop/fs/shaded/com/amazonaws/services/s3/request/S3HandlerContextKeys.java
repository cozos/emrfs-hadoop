package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.request;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.HandlerContextKey;

public class S3HandlerContextKeys
{
  public static final HandlerContextKey<Boolean> IS_CHUNKED_ENCODING_DISABLED = new HandlerContextKey("IsChunkedEncodingDisabled");
  public static final HandlerContextKey<Boolean> IS_PAYLOAD_SIGNING_ENABLED = new HandlerContextKey("IsPayloadSigningEnabled");
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.request.S3HandlerContextKeys
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */