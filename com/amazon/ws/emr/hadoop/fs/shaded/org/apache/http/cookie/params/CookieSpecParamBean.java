package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.params;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpAbstractParamBean;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import java.util.Collection;

@Deprecated
public class CookieSpecParamBean
  extends HttpAbstractParamBean
{
  public CookieSpecParamBean(HttpParams params)
  {
    super(params);
  }
  
  public void setDatePatterns(Collection<String> patterns)
  {
    params.setParameter("http.protocol.cookie-datepatterns", patterns);
  }
  
  public void setSingleHeader(boolean singleHeader)
  {
    params.setBooleanParameter("http.protocol.single-cookie-header", singleHeader);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.params.CookieSpecParamBean
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */