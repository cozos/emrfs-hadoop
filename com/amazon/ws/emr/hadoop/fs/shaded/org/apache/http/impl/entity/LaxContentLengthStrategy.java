package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.entity;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Header;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HeaderElement;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpMessage;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ParseException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ProtocolException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.entity.ContentLengthStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class LaxContentLengthStrategy
  implements ContentLengthStrategy
{
  public static final LaxContentLengthStrategy INSTANCE = new LaxContentLengthStrategy();
  private final int implicitLen;
  
  public LaxContentLengthStrategy(int implicitLen)
  {
    this.implicitLen = implicitLen;
  }
  
  public LaxContentLengthStrategy()
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
      HeaderElement[] encodings;
      try
      {
        encodings = transferEncodingHeader.getElements();
      }
      catch (ParseException px)
      {
        throw new ProtocolException("Invalid Transfer-Encoding header value: " + transferEncodingHeader, px);
      }
      int len = encodings.length;
      if ("identity".equalsIgnoreCase(transferEncodingHeader.getValue())) {
        return -1L;
      }
      if ((len > 0) && ("chunked".equalsIgnoreCase(encodings[(len - 1)].getName()))) {
        return -2L;
      }
      return -1L;
    }
    Header contentLengthHeader = message.getFirstHeader("Content-Length");
    if (contentLengthHeader != null)
    {
      long contentlen = -1L;
      Header[] headers = message.getHeaders("Content-Length");
      for (int i = headers.length - 1; i >= 0; i--)
      {
        Header header = headers[i];
        try
        {
          contentlen = Long.parseLong(header.getValue());
        }
        catch (NumberFormatException ignore) {}
      }
      if (contentlen >= 0L) {
        return contentlen;
      }
      return -1L;
    }
    return implicitLen;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.entity.LaxContentLengthStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */