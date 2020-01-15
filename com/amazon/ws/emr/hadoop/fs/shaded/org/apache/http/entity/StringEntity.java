package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.entity;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HTTP;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

public class StringEntity
  extends AbstractHttpEntity
  implements Cloneable
{
  protected final byte[] content;
  
  public StringEntity(String string, ContentType contentType)
    throws UnsupportedCharsetException
  {
    Args.notNull(string, "Source string");
    Charset charset = contentType != null ? contentType.getCharset() : null;
    if (charset == null) {
      charset = HTTP.DEF_CONTENT_CHARSET;
    }
    content = string.getBytes(charset);
    if (contentType != null) {
      setContentType(contentType.toString());
    }
  }
  
  @Deprecated
  public StringEntity(String string, String mimeType, String charset)
    throws UnsupportedEncodingException
  {
    Args.notNull(string, "Source string");
    String mt = mimeType != null ? mimeType : "text/plain";
    String cs = charset != null ? charset : "ISO-8859-1";
    content = string.getBytes(cs);
    setContentType(mt + "; charset=" + cs);
  }
  
  public StringEntity(String string, String charset)
    throws UnsupportedCharsetException
  {
    this(string, ContentType.create(ContentType.TEXT_PLAIN.getMimeType(), charset));
  }
  
  public StringEntity(String string, Charset charset)
  {
    this(string, ContentType.create(ContentType.TEXT_PLAIN.getMimeType(), charset));
  }
  
  public StringEntity(String string)
    throws UnsupportedEncodingException
  {
    this(string, ContentType.DEFAULT_TEXT);
  }
  
  public boolean isRepeatable()
  {
    return true;
  }
  
  public long getContentLength()
  {
    return content.length;
  }
  
  public InputStream getContent()
    throws IOException
  {
    return new ByteArrayInputStream(content);
  }
  
  public void writeTo(OutputStream outstream)
    throws IOException
  {
    Args.notNull(outstream, "Output stream");
    outstream.write(content);
    outstream.flush();
  }
  
  public boolean isStreaming()
  {
    return false;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    return super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.entity.StringEntity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */