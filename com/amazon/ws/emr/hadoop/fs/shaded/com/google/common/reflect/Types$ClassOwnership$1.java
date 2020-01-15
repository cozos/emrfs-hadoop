package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect;

import javax.annotation.Nullable;

 enum Types$ClassOwnership$1
{
  Types$ClassOwnership$1()
  {
    super(paramString, paramInt, null);
  }
  
  @Nullable
  Class<?> getOwnerType(Class<?> rawType)
  {
    return rawType.getEnclosingClass();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.Types.ClassOwnership.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */