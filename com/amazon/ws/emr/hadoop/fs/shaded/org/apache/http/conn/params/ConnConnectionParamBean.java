package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.params;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpAbstractParamBean;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;

@Deprecated
public class ConnConnectionParamBean
  extends HttpAbstractParamBean
{
  public ConnConnectionParamBean(HttpParams params)
  {
    super(params);
  }
  
  @Deprecated
  public void setMaxStatusLineGarbage(int maxStatusLineGarbage)
  {
    params.setIntParameter("http.connection.max-status-line-garbage", maxStatusLineGarbage);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.params.ConnConnectionParamBean
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */