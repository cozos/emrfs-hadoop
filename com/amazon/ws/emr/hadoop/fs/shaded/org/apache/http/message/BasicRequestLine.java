package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ProtocolVersion;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.RequestLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.CharArrayBuffer;
import java.io.Serializable;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class BasicRequestLine
  implements RequestLine, Cloneable, Serializable
{
  private static final long serialVersionUID = 2810581718468737193L;
  private final ProtocolVersion protoversion;
  private final String method;
  private final String uri;
  
  public BasicRequestLine(String method, String uri, ProtocolVersion version)
  {
    this.method = ((String)Args.notNull(method, "Method"));
    this.uri = ((String)Args.notNull(uri, "URI"));
    protoversion = ((ProtocolVersion)Args.notNull(version, "Version"));
  }
  
  public String getMethod()
  {
    return method;
  }
  
  public ProtocolVersion getProtocolVersion()
  {
    return protoversion;
  }
  
  public String getUri()
  {
    return uri;
  }
  
  public String toString()
  {
    return BasicLineFormatter.INSTANCE.formatRequestLine(null, this).toString();
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    return super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.BasicRequestLine
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */