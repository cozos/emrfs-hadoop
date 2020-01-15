package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.params;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpAbstractParamBean;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;

@Deprecated
public class AuthParamBean
  extends HttpAbstractParamBean
{
  public AuthParamBean(HttpParams params)
  {
    super(params);
  }
  
  public void setCredentialCharset(String charset)
  {
    AuthParams.setCredentialCharset(params, charset);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.params.AuthParamBean
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */