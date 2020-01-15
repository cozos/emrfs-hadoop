package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.MoreObjects;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Lists;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

@Beta
public final class Resources
{
  public static ByteSource asByteSource(URL url)
  {
    return new UrlByteSource(url, null);
  }
  
  private static final class UrlByteSource
    extends ByteSource
  {
    private final URL url;
    
    private UrlByteSource(URL url)
    {
      this.url = ((URL)Preconditions.checkNotNull(url));
    }
    
    public InputStream openStream()
      throws IOException
    {
      return url.openStream();
    }
    
    public String toString()
    {
      String str = String.valueOf(String.valueOf(url));return 24 + str.length() + "Resources.asByteSource(" + str + ")";
    }
  }
  
  public static CharSource asCharSource(URL url, Charset charset)
  {
    return asByteSource(url).asCharSource(charset);
  }
  
  public static byte[] toByteArray(URL url)
    throws IOException
  {
    return asByteSource(url).read();
  }
  
  public static String toString(URL url, Charset charset)
    throws IOException
  {
    return asCharSource(url, charset).read();
  }
  
  public static <T> T readLines(URL url, Charset charset, LineProcessor<T> callback)
    throws IOException
  {
    return (T)asCharSource(url, charset).readLines(callback);
  }
  
  public static List<String> readLines(URL url, Charset charset)
    throws IOException
  {
    (List)readLines(url, charset, new LineProcessor()
    {
      final List<String> result = Lists.newArrayList();
      
      public boolean processLine(String line)
      {
        result.add(line);
        return true;
      }
      
      public List<String> getResult()
      {
        return result;
      }
    });
  }
  
  public static void copy(URL from, OutputStream to)
    throws IOException
  {
    asByteSource(from).copyTo(to);
  }
  
  public static URL getResource(String resourceName)
  {
    ClassLoader loader = (ClassLoader)MoreObjects.firstNonNull(Thread.currentThread().getContextClassLoader(), Resources.class.getClassLoader());
    
    URL url = loader.getResource(resourceName);
    Preconditions.checkArgument(url != null, "resource %s not found.", new Object[] { resourceName });
    return url;
  }
  
  public static URL getResource(Class<?> contextClass, String resourceName)
  {
    URL url = contextClass.getResource(resourceName);
    Preconditions.checkArgument(url != null, "resource %s relative to %s not found.", new Object[] { resourceName, contextClass.getName() });
    
    return url;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.Resources
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */