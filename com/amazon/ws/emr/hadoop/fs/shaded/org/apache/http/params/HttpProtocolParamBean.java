package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpVersion;

@Deprecated
public class HttpProtocolParamBean
  extends HttpAbstractParamBean
{
  public HttpProtocolParamBean(HttpParams params)
  {
    super(params);
  }
  
  public void setHttpElementCharset(String httpElementCharset)
  {
    HttpProtocolParams.setHttpElementCharset(params, httpElementCharset);
  }
  
  public void setContentCharset(String contentCharset)
  {
    HttpProtocolParams.setContentCharset(params, contentCharset);
  }
  
  public void setVersion(HttpVersion version)
  {
    HttpProtocolParams.setVersion(params, version);
  }
  
  public void setUserAgent(String userAgent)
  {
    HttpProtocolParams.setUserAgent(params, userAgent);
  }
  
  public void setUseExpectContinue(boolean useExpectContinue)
  {
    HttpProtocolParams.setUseExpectContinue(params, useExpectContinue);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpProtocolParamBean
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */