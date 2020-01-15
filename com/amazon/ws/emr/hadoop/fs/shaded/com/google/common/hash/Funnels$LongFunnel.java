package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash;

 enum Funnels$LongFunnel
  implements Funnel<Long>
{
  INSTANCE;
  
  private Funnels$LongFunnel() {}
  
  public void funnel(Long from, PrimitiveSink into)
  {
    into.putLong(from.longValue());
  }
  
  public String toString()
  {
    return "Funnels.longFunnel()";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash.Funnels.LongFunnel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */