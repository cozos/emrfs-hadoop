package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params;

@Deprecated
public abstract interface HttpParams
{
  public abstract Object getParameter(String paramString);
  
  public abstract HttpParams setParameter(String paramString, Object paramObject);
  
  public abstract HttpParams copy();
  
  public abstract boolean removeParameter(String paramString);
  
  public abstract long getLongParameter(String paramString, long paramLong);
  
  public abstract HttpParams setLongParameter(String paramString, long paramLong);
  
  public abstract int getIntParameter(String paramString, int paramInt);
  
  public abstract HttpParams setIntParameter(String paramString, int paramInt);
  
  public abstract double getDoubleParameter(String paramString, double paramDouble);
  
  public abstract HttpParams setDoubleParameter(String paramString, double paramDouble);
  
  public abstract boolean getBooleanParameter(String paramString, boolean paramBoolean);
  
  public abstract HttpParams setBooleanParameter(String paramString, boolean paramBoolean);
  
  public abstract boolean isParameterTrue(String paramString);
  
  public abstract boolean isParameterFalse(String paramString);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */