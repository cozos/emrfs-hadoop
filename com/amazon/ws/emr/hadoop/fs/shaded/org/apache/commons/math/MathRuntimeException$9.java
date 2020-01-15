package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math;

import java.text.ParseException;
import java.util.Locale;

final class MathRuntimeException$9
  extends ParseException
{
  private static final long serialVersionUID = -1103502177342465975L;
  
  MathRuntimeException$9(String x0, int x1, String paramString1, Object[] paramArrayOfObject)
  {
    super(x0, x1);
  }
  
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException.9
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */