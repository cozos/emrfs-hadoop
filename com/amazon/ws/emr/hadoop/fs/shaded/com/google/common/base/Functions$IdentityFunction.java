package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import javax.annotation.Nullable;

 enum Functions$IdentityFunction
  implements Function<Object, Object>
{
  INSTANCE;
  
  private Functions$IdentityFunction() {}
  
  @Nullable
  public Object apply(@Nullable Object o)
  {
    return o;
  }
  
  public String toString()
  {
    return "identity";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Functions.IdentityFunction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */