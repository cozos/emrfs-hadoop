package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.config;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Consts;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;

public class ConnectionConfig$Builder
{
  private int bufferSize;
  private int fragmentSizeHint;
  private Charset charset;
  private CodingErrorAction malformedInputAction;
  private CodingErrorAction unmappableInputAction;
  private MessageConstraints messageConstraints;
  
  ConnectionConfig$Builder()
  {
    fragmentSizeHint = -1;
  }
  
  public Builder setBufferSize(int bufferSize)
  {
    this.bufferSize = bufferSize;
    return this;
  }
  
  public Builder setFragmentSizeHint(int fragmentSizeHint)
  {
    this.fragmentSizeHint = fragmentSizeHint;
    return this;
  }
  
  public Builder setCharset(Charset charset)
  {
    this.charset = charset;
    return this;
  }
  
  public Builder setMalformedInputAction(CodingErrorAction malformedInputAction)
  {
    this.malformedInputAction = malformedInputAction;
    if ((malformedInputAction != null) && (charset == null)) {
      charset = Consts.ASCII;
    }
    return this;
  }
  
  public Builder setUnmappableInputAction(CodingErrorAction unmappableInputAction)
  {
    this.unmappableInputAction = unmappableInputAction;
    if ((unmappableInputAction != null) && (charset == null)) {
      charset = Consts.ASCII;
    }
    return this;
  }
  
  public Builder setMessageConstraints(MessageConstraints messageConstraints)
  {
    this.messageConstraints = messageConstraints;
    return this;
  }
  
  public ConnectionConfig build()
  {
    Charset cs = charset;
    if ((cs == null) && ((malformedInputAction != null) || (unmappableInputAction != null))) {
      cs = Consts.ASCII;
    }
    int bufSize = bufferSize > 0 ? bufferSize : 8192;
    int fragmentHintSize = fragmentSizeHint >= 0 ? fragmentSizeHint : bufSize;
    return new ConnectionConfig(bufSize, fragmentHintSize, cs, malformedInputAction, unmappableInputAction, messageConstraints);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.config.ConnectionConfig.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */