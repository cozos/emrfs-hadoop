package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.util.PublicSuffixList;
import java.io.IOException;
import java.io.Reader;

@Deprecated
@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class PublicSuffixListParser
{
  private final PublicSuffixFilter filter;
  private final com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.util.PublicSuffixListParser parser;
  
  PublicSuffixListParser(PublicSuffixFilter filter)
  {
    this.filter = filter;
    parser = new com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.util.PublicSuffixListParser();
  }
  
  public void parse(Reader reader)
    throws IOException
  {
    PublicSuffixList suffixList = parser.parse(reader);
    filter.setPublicSuffixes(suffixList.getRules());
    filter.setExceptions(suffixList.getExceptions());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie.PublicSuffixListParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */