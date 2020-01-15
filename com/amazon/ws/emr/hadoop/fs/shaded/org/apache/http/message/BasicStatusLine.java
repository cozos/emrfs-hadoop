package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ProtocolVersion;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.StatusLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.CharArrayBuffer;
import java.io.Serializable;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class BasicStatusLine
  implements StatusLine, Cloneable, Serializable
{
  private static final long serialVersionUID = -2443303766890459269L;
  private final ProtocolVersion protoVersion;
  private final int statusCode;
  private final String reasonPhrase;
  
  public BasicStatusLine(ProtocolVersion version, int statusCode, String reasonPhrase)
  {
    protoVersion = ((ProtocolVersion)Args.notNull(version, "Version"));
    this.statusCode = Args.notNegative(statusCode, "Status code");
    this.reasonPhrase = reasonPhrase;
  }
  
  public int getStatusCode()
  {
    return statusCode;
  }
  
  public ProtocolVersion getProtocolVersion()
  {
    return protoVersion;
  }
  
  public String getReasonPhrase()
  {
    return reasonPhrase;
  }
  
  public String toString()
  {
    return BasicLineFormatter.INSTANCE.formatStatusLine(null, this).toString();
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    return super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.BasicStatusLine
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */