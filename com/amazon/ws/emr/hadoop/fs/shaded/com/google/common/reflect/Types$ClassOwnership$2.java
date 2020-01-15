package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect;

import javax.annotation.Nullable;

 enum Types$ClassOwnership$2
{
  Types$ClassOwnership$2()
  {
    super(paramString, paramInt, null);
  }
  
  @Nullable
  Class<?> getOwnerType(Class<?> rawType)
  {
    if (rawType.isLocalClass()) {
      return null;
    }
    return rawType.getEnclosingClass();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.Types.ClassOwnership.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */