package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.HandlerContextKey;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AWSRequestMetrics;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.json.Jackson;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@NotThreadSafe
public class DefaultRequest<T>
  implements Request<T>
{
  private String resourcePath;
  private Map<String, List<String>> parameters = new LinkedHashMap();
  private Map<String, String> headers = new TreeMap(String.CASE_INSENSITIVE_ORDER);
  private URI endpoint;
  private String serviceName;
  private final AmazonWebServiceRequest originalRequest;
  private HttpMethodName httpMethod = HttpMethodName.POST;
  private InputStream content;
  private int timeOffset;
  private AWSRequestMetrics metrics;
  private final Map<HandlerContextKey<?>, Object> handlerContext = new HashMap();
  
  public DefaultRequest(AmazonWebServiceRequest originalRequest, String serviceName)
  {
    this.serviceName = serviceName;
    
    this.originalRequest = (originalRequest == null ? AmazonWebServiceRequest.NOOP : originalRequest);
    
    handlerContext.putAll(this.originalRequest.getHandlerContext());
  }
  
  public DefaultRequest(String serviceName)
  {
    this(null, serviceName);
  }
  
  public AmazonWebServiceRequest getOriginalRequest()
  {
    return originalRequest;
  }
  
  public void addHeader(String name, String value)
  {
    headers.put(name, value);
  }
  
  public Map<String, String> getHeaders()
  {
    return headers;
  }
  
  public void setResourcePath(String resourcePath)
  {
    this.resourcePath = resourcePath;
  }
  
  public String getResourcePath()
  {
    return resourcePath;
  }
  
  public void addParameter(String name, String value)
  {
    List<String> paramList = (List)parameters.get(name);
    if (paramList == null)
    {
      paramList = new ArrayList();
      parameters.put(name, paramList);
    }
    paramList.add(value);
  }
  
  public void addParameters(String name, List<String> values)
  {
    if (values == null) {
      return;
    }
    for (String value : values) {
      addParameter(name, value);
    }
  }
  
  public Map<String, List<String>> getParameters()
  {
    return parameters;
  }
  
  public Request<T> withParameter(String name, String value)
  {
    addParameter(name, value);
    return this;
  }
  
  public HttpMethodName getHttpMethod()
  {
    return httpMethod;
  }
  
  public void setHttpMethod(HttpMethodName httpMethod)
  {
    this.httpMethod = httpMethod;
  }
  
  public void setEndpoint(URI endpoint)
  {
    this.endpoint = endpoint;
  }
  
  public URI getEndpoint()
  {
    return endpoint;
  }
  
  public String getServiceName()
  {
    return serviceName;
  }
  
  public InputStream getContent()
  {
    return content;
  }
  
  public void setContent(InputStream content)
  {
    this.content = content;
  }
  
  public void setHeaders(Map<String, String> headers)
  {
    this.headers.clear();
    this.headers.putAll(headers);
  }
  
  public void setParameters(Map<String, List<String>> parameters)
  {
    this.parameters.clear();
    this.parameters.putAll(parameters);
  }
  
  public int getTimeOffset()
  {
    return timeOffset;
  }
  
  public void setTimeOffset(int timeOffset)
  {
    this.timeOffset = timeOffset;
  }
  
  public Request<T> withTimeOffset(int timeOffset)
  {
    setTimeOffset(timeOffset);
    return this;
  }
  
  public String toString()
  {
    StringBuilder builder = new StringBuilder();
    builder.append(getHttpMethod()).append(" ");
    builder.append(getEndpoint()).append(" ");
    String resourcePath = getResourcePath();
    if (resourcePath == null)
    {
      builder.append("/");
    }
    else
    {
      if (!resourcePath.startsWith("/")) {
        builder.append("/");
      }
      builder.append(resourcePath);
    }
    builder.append(" ");
    if (!getParameters().isEmpty()) {
      builder.append("Parameters: (").append(Jackson.toJsonString(parameters));
    }
    if (!getHeaders().isEmpty())
    {
      builder.append("Headers: (");
      for (String key : getHeaders().keySet())
      {
        String value = (String)getHeaders().get(key);
        builder.append(key).append(": ").append(value).append(", ");
      }
      builder.append(") ");
    }
    return builder.toString();
  }
  
  public AWSRequestMetrics getAWSRequestMetrics()
  {
    return metrics;
  }
  
  public void setAWSRequestMetrics(AWSRequestMetrics metrics)
  {
    if (this.metrics == null) {
      this.metrics = metrics;
    } else {
      throw new IllegalStateException("AWSRequestMetrics has already been set on this request");
    }
  }
  
  public <X> void addHandlerContext(HandlerContextKey<X> key, X value)
  {
    handlerContext.put(key, value);
  }
  
  public <X> X getHandlerContext(HandlerContextKey<X> key)
  {
    return (X)handlerContext.get(key);
  }
  
  public InputStream getContentUnwrapped()
  {
    InputStream is = getContent();
    if (is == null) {
      return null;
    }
    while ((is instanceof ProgressInputStream))
    {
      ProgressInputStream pris = (ProgressInputStream)is;
      is = pris.getWrappedInputStream();
    }
    return is;
  }
  
  public ReadLimitInfo getReadLimitInfo()
  {
    return originalRequest;
  }
  
  public Object getOriginalRequestObject()
  {
    return originalRequest;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */