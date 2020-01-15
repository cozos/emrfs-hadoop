package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.util;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Consts;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@Contract(threading=ThreadingBehavior.SAFE)
public final class PublicSuffixMatcherLoader
{
  private static volatile PublicSuffixMatcher DEFAULT_INSTANCE;
  
  private static PublicSuffixMatcher load(InputStream in)
    throws IOException
  {
    List<PublicSuffixList> lists = new PublicSuffixListParser().parseByType(new InputStreamReader(in, Consts.UTF_8));
    
    return new PublicSuffixMatcher(lists);
  }
  
  public static PublicSuffixMatcher load(URL url)
    throws IOException
  {
    Args.notNull(url, "URL");
    InputStream in = url.openStream();
    try
    {
      return load(in);
    }
    finally
    {
      in.close();
    }
  }
  
  public static PublicSuffixMatcher load(File file)
    throws IOException
  {
    Args.notNull(file, "File");
    InputStream in = new FileInputStream(file);
    try
    {
      return load(in);
    }
    finally
    {
      in.close();
    }
  }
  
  public static PublicSuffixMatcher getDefault()
  {
    if (DEFAULT_INSTANCE == null) {
      synchronized (PublicSuffixMatcherLoader.class)
      {
        if (DEFAULT_INSTANCE == null)
        {
          URL url = PublicSuffixMatcherLoader.class.getResource("/mozilla/public-suffix-list.txt");
          if (url != null) {
            try
            {
              DEFAULT_INSTANCE = load(url);
            }
            catch (IOException ex)
            {
              Log log = LogFactory.getLog(PublicSuffixMatcherLoader.class);
              if (log.isWarnEnabled()) {
                log.warn("Failure loading public suffix list from default resource", ex);
              }
            }
          } else {
            DEFAULT_INSTANCE = new PublicSuffixMatcher(Arrays.asList(new String[] { "com" }), null);
          }
        }
      }
    }
    return DEFAULT_INSTANCE;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.util.PublicSuffixMatcherLoader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */