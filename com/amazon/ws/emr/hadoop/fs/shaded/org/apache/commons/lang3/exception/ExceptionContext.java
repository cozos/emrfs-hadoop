package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.exception;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.tuple.Pair;
import java.util.List;
import java.util.Set;

public abstract interface ExceptionContext
{
  public abstract ExceptionContext addContextValue(String paramString, Object paramObject);
  
  public abstract ExceptionContext setContextValue(String paramString, Object paramObject);
  
  public abstract List<Object> getContextValues(String paramString);
  
  public abstract Object getFirstContextValue(String paramString);
  
  public abstract Set<String> getContextLabels();
  
  public abstract List<Pair<String, Object>> getContextEntries();
  
  public abstract String getFormattedExceptionMessage(String paramString);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.exception.ExceptionContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */