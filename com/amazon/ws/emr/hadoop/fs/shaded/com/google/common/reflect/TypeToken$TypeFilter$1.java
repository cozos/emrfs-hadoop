package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect;

import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;

 enum TypeToken$TypeFilter$1
{
  TypeToken$TypeFilter$1()
  {
    super(paramString, paramInt, null);
  }
  
  public boolean apply(TypeToken<?> type)
  {
    return (!(TypeToken.access$400(type) instanceof TypeVariable)) && (!(TypeToken.access$400(type) instanceof WildcardType));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.TypeToken.TypeFilter.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */