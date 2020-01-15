package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.entity;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Consts;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Header;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HeaderElement;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntity;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.NameValuePair;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ParseException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.BasicHeaderValueFormatter;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.BasicHeaderValueParser;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.BasicNameValuePair;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.ParserCursor;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.CharArrayBuffer;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.TextUtils;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public final class ContentType
  implements Serializable
{
  private static final long serialVersionUID = -7768694718232371896L;
  public static final ContentType APPLICATION_ATOM_XML = create("application/atom+xml", Consts.ISO_8859_1);
  public static final ContentType APPLICATION_FORM_URLENCODED = create("application/x-www-form-urlencoded", Consts.ISO_8859_1);
  public static final ContentType APPLICATION_JSON = create("application/json", Consts.UTF_8);
  public static final ContentType APPLICATION_OCTET_STREAM = create("application/octet-stream", (Charset)null);
  public static final ContentType APPLICATION_SVG_XML = create("application/svg+xml", Consts.ISO_8859_1);
  public static final ContentType APPLICATION_XHTML_XML = create("application/xhtml+xml", Consts.ISO_8859_1);
  public static final ContentType APPLICATION_XML = create("application/xml", Consts.ISO_8859_1);
  public static final ContentType IMAGE_BMP = create("image/bmp");
  public static final ContentType IMAGE_GIF = create("image/gif");
  public static final ContentType IMAGE_JPEG = create("image/jpeg");
  public static final ContentType IMAGE_PNG = create("image/png");
  public static final ContentType IMAGE_SVG = create("image/svg+xml");
  public static final ContentType IMAGE_TIFF = create("image/tiff");
  public static final ContentType IMAGE_WEBP = create("image/webp");
  public static final ContentType MULTIPART_FORM_DATA = create("multipart/form-data", Consts.ISO_8859_1);
  public static final ContentType TEXT_HTML = create("text/html", Consts.ISO_8859_1);
  public static final ContentType TEXT_PLAIN = create("text/plain", Consts.ISO_8859_1);
  public static final ContentType TEXT_XML = create("text/xml", Consts.ISO_8859_1);
  public static final ContentType WILDCARD = create("*/*", (Charset)null);
  private static final Map<String, ContentType> CONTENT_TYPE_MAP;
  
  static
  {
    ContentType[] contentTypes = { APPLICATION_ATOM_XML, APPLICATION_FORM_URLENCODED, APPLICATION_JSON, APPLICATION_SVG_XML, APPLICATION_XHTML_XML, APPLICATION_XML, IMAGE_BMP, IMAGE_GIF, IMAGE_JPEG, IMAGE_PNG, IMAGE_SVG, IMAGE_TIFF, IMAGE_WEBP, MULTIPART_FORM_DATA, TEXT_HTML, TEXT_PLAIN, TEXT_XML };
    
    HashMap<String, ContentType> map = new HashMap();
    for (ContentType contentType : contentTypes) {
      map.put(contentType.getMimeType(), contentType);
    }
    CONTENT_TYPE_MAP = Collections.unmodifiableMap(map);
  }
  
  public static final ContentType DEFAULT_TEXT = TEXT_PLAIN;
  public static final ContentType DEFAULT_BINARY = APPLICATION_OCTET_STREAM;
  private final String mimeType;
  private final Charset charset;
  private final NameValuePair[] params;
  
  ContentType(String mimeType, Charset charset)
  {
    this.mimeType = mimeType;
    this.charset = charset;
    params = null;
  }
  
  ContentType(String mimeType, Charset charset, NameValuePair[] params)
  {
    this.mimeType = mimeType;
    this.charset = charset;
    this.params = params;
  }
  
  public String getMimeType()
  {
    return mimeType;
  }
  
  public Charset getCharset()
  {
    return charset;
  }
  
  public String getParameter(String name)
  {
    Args.notEmpty(name, "Parameter name");
    if (params == null) {
      return null;
    }
    for (NameValuePair param : params) {
      if (param.getName().equalsIgnoreCase(name)) {
        return param.getValue();
      }
    }
    return null;
  }
  
  public String toString()
  {
    CharArrayBuffer buf = new CharArrayBuffer(64);
    buf.append(mimeType);
    if (params != null)
    {
      buf.append("; ");
      BasicHeaderValueFormatter.INSTANCE.formatParameters(buf, params, false);
    }
    else if (charset != null)
    {
      buf.append("; charset=");
      buf.append(charset.name());
    }
    return buf.toString();
  }
  
  private static boolean valid(String s)
  {
    for (int i = 0; i < s.length(); i++)
    {
      char ch = s.charAt(i);
      if ((ch == '"') || (ch == ',') || (ch == ';')) {
        return false;
      }
    }
    return true;
  }
  
  public static ContentType create(String mimeType, Charset charset)
  {
    String normalizedMimeType = ((String)Args.notBlank(mimeType, "MIME type")).toLowerCase(Locale.ROOT);
    Args.check(valid(normalizedMimeType), "MIME type may not contain reserved characters");
    return new ContentType(normalizedMimeType, charset);
  }
  
  public static ContentType create(String mimeType)
  {
    return create(mimeType, (Charset)null);
  }
  
  public static ContentType create(String mimeType, String charset)
    throws UnsupportedCharsetException
  {
    return create(mimeType, !TextUtils.isBlank(charset) ? Charset.forName(charset) : null);
  }
  
  private static ContentType create(HeaderElement helem, boolean strict)
  {
    return create(helem.getName(), helem.getParameters(), strict);
  }
  
  private static ContentType create(String mimeType, NameValuePair[] params, boolean strict)
  {
    Charset charset = null;
    for (NameValuePair param : params) {
      if (param.getName().equalsIgnoreCase("charset"))
      {
        String s = param.getValue();
        if (TextUtils.isBlank(s)) {
          break;
        }
        try
        {
          charset = Charset.forName(s);
        }
        catch (UnsupportedCharsetException ex)
        {
          if (strict) {
            throw ex;
          }
        }
      }
    }
    return new ContentType(mimeType, charset, (params != null) && (params.length > 0) ? params : null);
  }
  
  public static ContentType create(String mimeType, NameValuePair... params)
    throws UnsupportedCharsetException
  {
    String type = ((String)Args.notBlank(mimeType, "MIME type")).toLowerCase(Locale.ROOT);
    Args.check(valid(type), "MIME type may not contain reserved characters");
    return create(mimeType, params, true);
  }
  
  public static ContentType parse(String s)
    throws ParseException, UnsupportedCharsetException
  {
    Args.notNull(s, "Content type");
    CharArrayBuffer buf = new CharArrayBuffer(s.length());
    buf.append(s);
    ParserCursor cursor = new ParserCursor(0, s.length());
    HeaderElement[] elements = BasicHeaderValueParser.INSTANCE.parseElements(buf, cursor);
    if (elements.length > 0) {
      return create(elements[0], true);
    }
    throw new ParseException("Invalid content type: " + s);
  }
  
  public static ContentType get(HttpEntity entity)
    throws ParseException, UnsupportedCharsetException
  {
    if (entity == null) {
      return null;
    }
    Header header = entity.getContentType();
    if (header != null)
    {
      HeaderElement[] elements = header.getElements();
      if (elements.length > 0) {
        return create(elements[0], true);
      }
    }
    return null;
  }
  
  public static ContentType getLenient(HttpEntity entity)
  {
    if (entity == null) {
      return null;
    }
    Header header = entity.getContentType();
    if (header != null) {
      try
      {
        HeaderElement[] elements = header.getElements();
        if (elements.length > 0) {
          return create(elements[0], false);
        }
      }
      catch (ParseException ex)
      {
        return null;
      }
    }
    return null;
  }
  
  public static ContentType getOrDefault(HttpEntity entity)
    throws ParseException, UnsupportedCharsetException
  {
    ContentType contentType = get(entity);
    return contentType != null ? contentType : DEFAULT_TEXT;
  }
  
  public static ContentType getLenientOrDefault(HttpEntity entity)
    throws ParseException, UnsupportedCharsetException
  {
    ContentType contentType = get(entity);
    return contentType != null ? contentType : DEFAULT_TEXT;
  }
  
  public static ContentType getByMimeType(String mimeType)
  {
    if (mimeType == null) {
      return null;
    }
    return (ContentType)CONTENT_TYPE_MAP.get(mimeType);
  }
  
  public ContentType withCharset(Charset charset)
  {
    return create(getMimeType(), charset);
  }
  
  public ContentType withCharset(String charset)
  {
    return create(getMimeType(), charset);
  }
  
  public ContentType withParameters(NameValuePair... params)
    throws UnsupportedCharsetException
  {
    if (params.length == 0) {
      return this;
    }
    Map<String, String> paramMap = new LinkedHashMap();
    if (this.params != null) {
      for (NameValuePair param : this.params) {
        paramMap.put(param.getName(), param.getValue());
      }
    }
    for (NameValuePair param : params) {
      paramMap.put(param.getName(), param.getValue());
    }
    List<NameValuePair> newParams = new ArrayList(paramMap.size() + 1);
    if ((charset != null) && (!paramMap.containsKey("charset"))) {
      newParams.add(new BasicNameValuePair("charset", charset.name()));
    }
    for (Map.Entry<String, String> entry : paramMap.entrySet()) {
      newParams.add(new BasicNameValuePair((String)entry.getKey(), (String)entry.getValue()));
    }
    return create(getMimeType(), (NameValuePair[])newParams.toArray(new NameValuePair[newParams.size()]), true);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.entity.ContentType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */