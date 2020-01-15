package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.entity;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Header;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpMessage;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpVersion;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ProtocolException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ProtocolVersion;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.entity.ContentLengthStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class StrictContentLengthStrategy
  implements ContentLengthStrategy
{
  public static final StrictContentLengthStrategy INSTANCE = new StrictContentLengthStrategy();
  private final int implicitLen;
  
  public StrictContentLengthStrategy(int implicitLen)
  {
    this.implicitLen = implicitLen;
  }
  
  public StrictContentLengthStrategy()
  {
    this(-1);
  }
  
  public long determineLength(HttpMessage message)
    throws HttpException
  {
    Args.notNull(message, "HTTP message");
    
    Header transferEncodingHeader = message.getFirstHeader("Transfer-Encoding");
    if (transferEncodingHeader != null)
    {
      String s = transferEncodingHeader.getValue();
      if ("chunked".equalsIgnoreCase(s))
      {
        if (message.getProtocolVersion().lessEquals(HttpVersion.HTTP_1_0)) {
          throw new ProtocolException("Chunked transfer encoding not allowed for " + message.getProtocolVersion());
        }
        return -2L;
      }
      if ("identity".equalsIgnoreCase(s)) {
        return -1L;
      }
      throw new ProtocolException("Unsupported transfer encoding: " + s);
    }
    Header contentLengthHeader = message.getFirstHeader("Content-Length");
    if (contentLengthHeader != null)
    {
      String s = contentLengthHeader.getValue();
      try
      {
        long len = Long.parseLong(s);
        if (len < 0L) {
          throw new ProtocolException("Negative content length: " + s);
        }
        return len;
      }
      catch (NumberFormatException e)
      {
        throw new ProtocolException("Invalid content length: " + s);
      }
    }
    return implicitLen;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.entity.StrictContentLengthStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */