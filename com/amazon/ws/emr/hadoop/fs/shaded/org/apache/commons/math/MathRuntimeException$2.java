package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math;

import java.util.Locale;

final class MathRuntimeException$2
  extends ArrayIndexOutOfBoundsException
{
  private static final long serialVersionUID = -3394748305449283486L;
  
  MathRuntimeException$2(String paramString, Object[] paramArrayOfObject) {}
  
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException.2
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */