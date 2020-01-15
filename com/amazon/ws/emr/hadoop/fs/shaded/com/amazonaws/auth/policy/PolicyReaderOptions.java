package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy;

public class PolicyReaderOptions
{
  private boolean stripAwsPrincipalIdHyphensEnabled = true;
  
  public boolean isStripAwsPrincipalIdHyphensEnabled()
  {
    return stripAwsPrincipalIdHyphensEnabled;
  }
  
  public void setStripAwsPrincipalIdHyphensEnabled(boolean stripAwsPrincipalIdHyphensEnabled)
  {
    this.stripAwsPrincipalIdHyphensEnabled = stripAwsPrincipalIdHyphensEnabled;
  }
  
  public PolicyReaderOptions withStripAwsPrincipalIdHyphensEnabled(boolean stripAwsPrincipalIdHyphensEnabled)
  {
    setStripAwsPrincipalIdHyphensEnabled(stripAwsPrincipalIdHyphensEnabled);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.PolicyReaderOptions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */