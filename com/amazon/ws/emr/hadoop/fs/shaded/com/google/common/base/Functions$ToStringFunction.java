package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

 enum Functions$ToStringFunction
  implements Function<Object, String>
{
  INSTANCE;
  
  private Functions$ToStringFunction() {}
  
  public String apply(Object o)
  {
    Preconditions.checkNotNull(o);
    return o.toString();
  }
  
  public String toString()
  {
    return "toString";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Functions.ToStringFunction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */