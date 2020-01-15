package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect;

 enum TypeToken$TypeFilter$2
{
  TypeToken$TypeFilter$2()
  {
    super(paramString, paramInt, null);
  }
  
  public boolean apply(TypeToken<?> type)
  {
    return type.getRawType().isInterface();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.TypeToken.TypeFilter.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */