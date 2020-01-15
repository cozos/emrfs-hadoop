package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicate;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;

 enum TypeToken$TypeFilter
  implements Predicate<TypeToken<?>>
{
  IGNORE_TYPE_VARIABLE_OR_WILDCARD,  INTERFACE_ONLY;
  
  private TypeToken$TypeFilter() {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.TypeToken.TypeFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */