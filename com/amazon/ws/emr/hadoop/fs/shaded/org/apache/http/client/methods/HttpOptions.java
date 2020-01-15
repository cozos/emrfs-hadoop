package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Header;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HeaderElement;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HeaderIterator;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.net.URI;
import java.util.HashSet;
import java.util.Set;

public class HttpOptions
  extends HttpRequestBase
{
  public static final String METHOD_NAME = "OPTIONS";
  
  public HttpOptions() {}
  
  public HttpOptions(URI uri)
  {
    setURI(uri);
  }
  
  public HttpOptions(String uri)
  {
    setURI(URI.create(uri));
  }
  
  public String getMethod()
  {
    return "OPTIONS";
  }
  
  public Set<String> getAllowedMethods(HttpResponse response)
  {
    Args.notNull(response, "HTTP response");
    
    HeaderIterator it = response.headerIterator("Allow");
    Set<String> methods = new HashSet();
    while (it.hasNext())
    {
      Header header = it.nextHeader();
      HeaderElement[] elements = header.getElements();
      for (HeaderElement element : elements) {
        methods.add(element.getName());
      }
    }
    return methods;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpOptions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */