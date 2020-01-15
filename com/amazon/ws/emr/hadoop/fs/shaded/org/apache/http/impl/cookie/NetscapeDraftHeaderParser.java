package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HeaderElement;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.NameValuePair;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ParseException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.BasicHeaderElement;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.BasicNameValuePair;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.ParserCursor;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.TokenParser;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.CharArrayBuffer;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class NetscapeDraftHeaderParser
{
  public static final NetscapeDraftHeaderParser DEFAULT = new NetscapeDraftHeaderParser();
  private static final char PARAM_DELIMITER = ';';
  private static final BitSet TOKEN_DELIMS = TokenParser.INIT_BITSET(new int[] { 61, 59 });
  private static final BitSet VALUE_DELIMS = TokenParser.INIT_BITSET(new int[] { 59 });
  private final TokenParser tokenParser;
  
  public NetscapeDraftHeaderParser()
  {
    tokenParser = TokenParser.INSTANCE;
  }
  
  public HeaderElement parseHeader(CharArrayBuffer buffer, ParserCursor cursor)
    throws ParseException
  {
    Args.notNull(buffer, "Char array buffer");
    Args.notNull(cursor, "Parser cursor");
    NameValuePair nvp = parseNameValuePair(buffer, cursor);
    List<NameValuePair> params = new ArrayList();
    while (!cursor.atEnd())
    {
      NameValuePair param = parseNameValuePair(buffer, cursor);
      params.add(param);
    }
    return new BasicHeaderElement(nvp.getName(), nvp.getValue(), (NameValuePair[])params.toArray(new NameValuePair[params.size()]));
  }
  
  private NameValuePair parseNameValuePair(CharArrayBuffer buffer, ParserCursor cursor)
  {
    String name = tokenParser.parseToken(buffer, cursor, TOKEN_DELIMS);
    if (cursor.atEnd()) {
      return new BasicNameValuePair(name, null);
    }
    int delim = buffer.charAt(cursor.getPos());
    cursor.updatePos(cursor.getPos() + 1);
    if (delim != 61) {
      return new BasicNameValuePair(name, null);
    }
    String value = tokenParser.parseToken(buffer, cursor, VALUE_DELIMS);
    if (!cursor.atEnd()) {
      cursor.updatePos(cursor.getPos() + 1);
    }
    return new BasicNameValuePair(name, value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie.NetscapeDraftHeaderParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */