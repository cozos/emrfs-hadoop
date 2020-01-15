package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params;

@Deprecated
public class HttpConnectionParamBean
  extends HttpAbstractParamBean
{
  public HttpConnectionParamBean(HttpParams params)
  {
    super(params);
  }
  
  public void setSoTimeout(int soTimeout)
  {
    HttpConnectionParams.setSoTimeout(params, soTimeout);
  }
  
  public void setTcpNoDelay(boolean tcpNoDelay)
  {
    HttpConnectionParams.setTcpNoDelay(params, tcpNoDelay);
  }
  
  public void setSocketBufferSize(int socketBufferSize)
  {
    HttpConnectionParams.setSocketBufferSize(params, socketBufferSize);
  }
  
  public void setLinger(int linger)
  {
    HttpConnectionParams.setLinger(params, linger);
  }
  
  public void setConnectionTimeout(int connectionTimeout)
  {
    HttpConnectionParams.setConnectionTimeout(params, connectionTimeout);
  }
  
  public void setStaleCheckingEnabled(boolean staleCheckingEnabled)
  {
    HttpConnectionParams.setStaleCheckingEnabled(params, staleCheckingEnabled);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpConnectionParamBean
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */