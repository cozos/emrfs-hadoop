package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math;

import java.util.Locale;
import java.util.NoSuchElementException;

final class MathRuntimeException$7
  extends NoSuchElementException
{
  private static final long serialVersionUID = 7304273322489425799L;
  
  MathRuntimeException$7(String paramString, Object[] paramArrayOfObject) {}
  
  public String getMessage()
  {
    return MathRuntimeException.access$000(Locale.US, val$pattern, val$arguments);
  }
  
  public String getLocalizedMessage()
  {
    return MathRuntimeException.access$000(Locale.getDefault(), val$pattern, val$arguments);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException.7
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */