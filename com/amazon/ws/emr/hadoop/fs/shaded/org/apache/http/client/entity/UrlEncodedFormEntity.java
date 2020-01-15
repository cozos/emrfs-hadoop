package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.entity;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.NameValuePair;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.utils.URLEncodedUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.entity.ContentType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.entity.StringEntity;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HTTP;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.List;

public class UrlEncodedFormEntity
  extends StringEntity
{
  public UrlEncodedFormEntity(List<? extends NameValuePair> parameters, String charset)
    throws UnsupportedEncodingException
  {
    super(URLEncodedUtils.format(parameters, charset != null ? charset : HTTP.DEF_CONTENT_CHARSET.name()), ContentType.create("application/x-www-form-urlencoded", charset));
  }
  
  public UrlEncodedFormEntity(Iterable<? extends NameValuePair> parameters, Charset charset)
  {
    super(URLEncodedUtils.format(parameters, charset != null ? charset : HTTP.DEF_CONTENT_CHARSET), ContentType.create("application/x-www-form-urlencoded", charset));
  }
  
  public UrlEncodedFormEntity(List<? extends NameValuePair> parameters)
    throws UnsupportedEncodingException
  {
    this(parameters, (Charset)null);
  }
  
  public UrlEncodedFormEntity(Iterable<? extends NameValuePair> parameters)
  {
    this(parameters, null);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.entity.UrlEncodedFormEntity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */