package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.util.HashSet;
import java.util.Set;

@Deprecated
public final class DefaultedHttpParams
  extends AbstractHttpParams
{
  private final HttpParams local;
  private final HttpParams defaults;
  
  public DefaultedHttpParams(HttpParams local, HttpParams defaults)
  {
    this.local = ((HttpParams)Args.notNull(local, "Local HTTP parameters"));
    this.defaults = defaults;
  }
  
  public HttpParams copy()
  {
    HttpParams clone = local.copy();
    return new DefaultedHttpParams(clone, defaults);
  }
  
  public Object getParameter(String name)
  {
    Object obj = local.getParameter(name);
    if ((obj == null) && (defaults != null)) {
      obj = defaults.getParameter(name);
    }
    return obj;
  }
  
  public boolean removeParameter(String name)
  {
    return local.removeParameter(name);
  }
  
  public HttpParams setParameter(String name, Object value)
  {
    return local.setParameter(name, value);
  }
  
  public HttpParams getDefaults()
  {
    return defaults;
  }
  
  public Set<String> getNames()
  {
    Set<String> combined = new HashSet(getNames(defaults));
    combined.addAll(getNames(local));
    return combined;
  }
  
  public Set<String> getDefaultNames()
  {
    return new HashSet(getNames(defaults));
  }
  
  public Set<String> getLocalNames()
  {
    return new HashSet(getNames(local));
  }
  
  private Set<String> getNames(HttpParams params)
  {
    if ((params instanceof HttpParamsNames)) {
      return ((HttpParamsNames)params).getNames();
    }
    throw new UnsupportedOperationException("HttpParams instance does not implement HttpParamsNames");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.DefaultedHttpParams
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */