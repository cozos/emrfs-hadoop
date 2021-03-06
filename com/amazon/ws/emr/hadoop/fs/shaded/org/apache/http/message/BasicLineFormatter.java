package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.FormattedHeader;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Header;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ProtocolVersion;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.RequestLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.StatusLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.CharArrayBuffer;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class BasicLineFormatter
  implements LineFormatter
{
  @Deprecated
  public static final BasicLineFormatter DEFAULT = new BasicLineFormatter();
  public static final BasicLineFormatter INSTANCE = new BasicLineFormatter();
  
  protected CharArrayBuffer initBuffer(CharArrayBuffer charBuffer)
  {
    CharArrayBuffer buffer = charBuffer;
    if (buffer != null) {
      buffer.clear();
    } else {
      buffer = new CharArrayBuffer(64);
    }
    return buffer;
  }
  
  public static String formatProtocolVersion(ProtocolVersion version, LineFormatter formatter)
  {
    return (formatter != null ? formatter : INSTANCE).appendProtocolVersion(null, version).toString();
  }
  
  public CharArrayBuffer appendProtocolVersion(CharArrayBuffer buffer, ProtocolVersion version)
  {
    Args.notNull(version, "Protocol version");
    
    CharArrayBuffer result = buffer;
    int len = estimateProtocolVersionLen(version);
    if (result == null) {
      result = new CharArrayBuffer(len);
    } else {
      result.ensureCapacity(len);
    }
    result.append(version.getProtocol());
    result.append('/');
    result.append(Integer.toString(version.getMajor()));
    result.append('.');
    result.append(Integer.toString(version.getMinor()));
    
    return result;
  }
  
  protected int estimateProtocolVersionLen(ProtocolVersion version)
  {
    return version.getProtocol().length() + 4;
  }
  
  public static String formatRequestLine(RequestLine reqline, LineFormatter formatter)
  {
    return (formatter != null ? formatter : INSTANCE).formatRequestLine(null, reqline).toString();
  }
  
  public CharArrayBuffer formatRequestLine(CharArrayBuffer buffer, RequestLine reqline)
  {
    Args.notNull(reqline, "Request line");
    CharArrayBuffer result = initBuffer(buffer);
    doFormatRequestLine(result, reqline);
    
    return result;
  }
  
  protected void doFormatRequestLine(CharArrayBuffer buffer, RequestLine reqline)
  {
    String method = reqline.getMethod();
    String uri = reqline.getUri();
    
    int len = method.length() + 1 + uri.length() + 1 + estimateProtocolVersionLen(reqline.getProtocolVersion());
    
    buffer.ensureCapacity(len);
    
    buffer.append(method);
    buffer.append(' ');
    buffer.append(uri);
    buffer.append(' ');
    appendProtocolVersion(buffer, reqline.getProtocolVersion());
  }
  
  public static String formatStatusLine(StatusLine statline, LineFormatter formatter)
  {
    return (formatter != null ? formatter : INSTANCE).formatStatusLine(null, statline).toString();
  }
  
  public CharArrayBuffer formatStatusLine(CharArrayBuffer buffer, StatusLine statline)
  {
    Args.notNull(statline, "Status line");
    CharArrayBuffer result = initBuffer(buffer);
    doFormatStatusLine(result, statline);
    
    return result;
  }
  
  protected void doFormatStatusLine(CharArrayBuffer buffer, StatusLine statline)
  {
    int len = estimateProtocolVersionLen(statline.getProtocolVersion()) + 1 + 3 + 1;
    
    String reason = statline.getReasonPhrase();
    if (reason != null) {
      len += reason.length();
    }
    buffer.ensureCapacity(len);
    
    appendProtocolVersion(buffer, statline.getProtocolVersion());
    buffer.append(' ');
    buffer.append(Integer.toString(statline.getStatusCode()));
    buffer.append(' ');
    if (reason != null) {
      buffer.append(reason);
    }
  }
  
  public static String formatHeader(Header header, LineFormatter formatter)
  {
    return (formatter != null ? formatter : INSTANCE).formatHeader(null, header).toString();
  }
  
  public CharArrayBuffer formatHeader(CharArrayBuffer buffer, Header header)
  {
    Args.notNull(header, "Header");
    CharArrayBuffer result;
    CharArrayBuffer result;
    if ((header instanceof FormattedHeader))
    {
      result = ((FormattedHeader)header).getBuffer();
    }
    else
    {
      result = initBuffer(buffer);
      doFormatHeader(result, header);
    }
    return result;
  }
  
  protected void doFormatHeader(CharArrayBuffer buffer, Header header)
  {
    String name = header.getName();
    String value = header.getValue();
    
    int len = name.length() + 2;
    if (value != null) {
      len += value.length();
    }
    buffer.ensureCapacity(len);
    
    buffer.append(name);
    buffer.append(": ");
    if (value != null)
    {
      buffer.ensureCapacity(buffer.length() + value.length());
      for (int valueIndex = 0; valueIndex < value.length(); valueIndex++)
      {
        char valueChar = value.charAt(valueIndex);
        if ((valueChar == '\r') || (valueChar == '\n') || (valueChar == '\f') || (valueChar == '\013')) {
          valueChar = ' ';
        }
        buffer.append(valueChar);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.BasicLineFormatter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */