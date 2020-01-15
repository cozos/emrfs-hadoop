package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math;

import java.util.Locale;

final class MathRuntimeException$10
  extends RuntimeException
{
  private static final long serialVersionUID = -201865440834027016L;
  
  public String getMessage()
  {
    return MathRuntimeException.access$000(Locale.US, "internal error, please fill a bug report at {0}", new Object[] { "https://issues.apache.org/jira/browse/MATH" });
  }
  
  public String getLocalizedMessage()
  {
    return MathRuntimeException.access$000(Locale.getDefault(), "internal error, please fill a bug report at {0}", new Object[] { "https://issues.apache.org/jira/browse/MATH" });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException.10
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */