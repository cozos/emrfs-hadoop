package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListener;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.HandlerContextKey;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.StaticCredentialsProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.RequestMetricCollector;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@NotThreadSafe
public abstract class AmazonWebServiceRequest
  implements Cloneable, ReadLimitInfo, HandlerContextAware
{
  public static final AmazonWebServiceRequest NOOP = new AmazonWebServiceRequest() {};
  private ProgressListener progressListener = ProgressListener.NOOP;
  private final RequestClientOptions requestClientOptions = new RequestClientOptions();
  private RequestMetricCollector requestMetricCollector;
  private AWSCredentialsProvider credentialsProvider;
  private Map<String, String> customRequestHeaders;
  private Map<String, List<String>> customQueryParameters;
  private transient Map<HandlerContextKey<?>, Object> handlerContext = new HashMap();
  private AmazonWebServiceRequest cloneSource;
  private Integer sdkRequestTimeout = null;
  private Integer sdkClientExecutionTimeout = null;
  
  @Deprecated
  public void setRequestCredentials(AWSCredentials credentials)
  {
    credentialsProvider = (credentials == null ? null : new StaticCredentialsProvider(credentials));
  }
  
  @Deprecated
  public AWSCredentials getRequestCredentials()
  {
    return credentialsProvider == null ? null : credentialsProvider.getCredentials();
  }
  
  public void setRequestCredentialsProvider(AWSCredentialsProvider credentialsProvider)
  {
    this.credentialsProvider = credentialsProvider;
  }
  
  public AWSCredentialsProvider getRequestCredentialsProvider()
  {
    return credentialsProvider;
  }
  
  public <T extends AmazonWebServiceRequest> T withRequestCredentialsProvider(AWSCredentialsProvider credentialsProvider)
  {
    setRequestCredentialsProvider(credentialsProvider);
    
    T t = this;
    return t;
  }
  
  public RequestClientOptions getRequestClientOptions()
  {
    return requestClientOptions;
  }
  
  public RequestMetricCollector getRequestMetricCollector()
  {
    return requestMetricCollector;
  }
  
  public void setRequestMetricCollector(RequestMetricCollector requestMetricCollector)
  {
    this.requestMetricCollector = requestMetricCollector;
  }
  
  public <T extends AmazonWebServiceRequest> T withRequestMetricCollector(RequestMetricCollector metricCollector)
  {
    setRequestMetricCollector(metricCollector);
    
    T t = this;
    return t;
  }
  
  public void setGeneralProgressListener(ProgressListener progressListener)
  {
    this.progressListener = (progressListener == null ? ProgressListener.NOOP : progressListener);
  }
  
  public ProgressListener getGeneralProgressListener()
  {
    return progressListener;
  }
  
  public <T extends AmazonWebServiceRequest> T withGeneralProgressListener(ProgressListener progressListener)
  {
    setGeneralProgressListener(progressListener);
    
    T t = this;
    return t;
  }
  
  public Map<String, String> getCustomRequestHeaders()
  {
    if (customRequestHeaders == null) {
      return null;
    }
    return Collections.unmodifiableMap(customRequestHeaders);
  }
  
  public String putCustomRequestHeader(String name, String value)
  {
    if (customRequestHeaders == null) {
      customRequestHeaders = new HashMap();
    }
    return (String)customRequestHeaders.put(name, value);
  }
  
  public Map<String, List<String>> getCustomQueryParameters()
  {
    if (customQueryParameters == null) {
      return null;
    }
    return Collections.unmodifiableMap(customQueryParameters);
  }
  
  public void putCustomQueryParameter(String name, String value)
  {
    if (customQueryParameters == null) {
      customQueryParameters = new HashMap();
    }
    List<String> paramList = (List)customQueryParameters.get(name);
    if (paramList == null)
    {
      paramList = new LinkedList();
      customQueryParameters.put(name, paramList);
    }
    paramList.add(value);
  }
  
  public final int getReadLimit()
  {
    return requestClientOptions.getReadLimit();
  }
  
  protected final <T extends AmazonWebServiceRequest> T copyBaseTo(T target)
  {
    if (customRequestHeaders != null) {
      for (Map.Entry<String, String> e : customRequestHeaders.entrySet()) {
        target.putCustomRequestHeader((String)e.getKey(), (String)e.getValue());
      }
    }
    if (customQueryParameters != null) {
      for (??? = customQueryParameters.entrySet().iterator(); ???.hasNext();)
      {
        e = (Map.Entry)???.next();
        if (e.getValue() != null) {
          for (String value : (List)e.getValue()) {
            target.putCustomQueryParameter((String)e.getKey(), value);
          }
        }
      }
    }
    Map.Entry<String, List<String>> e;
    target.setRequestCredentialsProvider(credentialsProvider);
    target.setGeneralProgressListener(progressListener);
    target.setRequestMetricCollector(requestMetricCollector);
    requestClientOptions.copyTo(target.getRequestClientOptions());
    return target;
  }
  
  public AmazonWebServiceRequest getCloneSource()
  {
    return cloneSource;
  }
  
  public AmazonWebServiceRequest getCloneRoot()
  {
    AmazonWebServiceRequest cloneRoot = cloneSource;
    if (cloneRoot != null) {
      while (cloneRoot.getCloneSource() != null) {
        cloneRoot = cloneRoot.getCloneSource();
      }
    }
    return cloneRoot;
  }
  
  private void setCloneSource(AmazonWebServiceRequest cloneSource)
  {
    this.cloneSource = cloneSource;
  }
  
  public Integer getSdkRequestTimeout()
  {
    return sdkRequestTimeout;
  }
  
  public void setSdkRequestTimeout(int sdkRequestTimeout)
  {
    this.sdkRequestTimeout = Integer.valueOf(sdkRequestTimeout);
  }
  
  public <T extends AmazonWebServiceRequest> T withSdkRequestTimeout(int sdkRequestTimeout)
  {
    setSdkRequestTimeout(sdkRequestTimeout);
    
    T t = this;
    return t;
  }
  
  public Integer getSdkClientExecutionTimeout()
  {
    return sdkClientExecutionTimeout;
  }
  
  public void setSdkClientExecutionTimeout(int sdkClientExecutionTimeout)
  {
    this.sdkClientExecutionTimeout = Integer.valueOf(sdkClientExecutionTimeout);
  }
  
  public <T extends AmazonWebServiceRequest> T withSdkClientExecutionTimeout(int sdkClientExecutionTimeout)
  {
    setSdkClientExecutionTimeout(sdkClientExecutionTimeout);
    
    T t = this;
    return t;
  }
  
  public <X> void addHandlerContext(HandlerContextKey<X> key, X value)
  {
    handlerContext.put(key, value);
  }
  
  public <X> X getHandlerContext(HandlerContextKey<X> key)
  {
    return (X)handlerContext.get(key);
  }
  
  @SdkInternalApi
  Map<HandlerContextKey<?>, Object> getHandlerContext()
  {
    return Collections.unmodifiableMap(handlerContext);
  }
  
  public AmazonWebServiceRequest clone()
  {
    try
    {
      AmazonWebServiceRequest cloned = (AmazonWebServiceRequest)super.clone();
      cloned.setCloneSource(this);
      
      handlerContext = new HashMap(handlerContext);
      
      return cloned;
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */