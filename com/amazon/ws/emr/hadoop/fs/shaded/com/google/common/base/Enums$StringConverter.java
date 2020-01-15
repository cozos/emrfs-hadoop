package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import java.io.Serializable;
import javax.annotation.Nullable;

final class Enums$StringConverter<T extends Enum<T>>
  extends Converter<String, T>
  implements Serializable
{
  private final Class<T> enumClass;
  private static final long serialVersionUID = 0L;
  
  Enums$StringConverter(Class<T> enumClass)
  {
    this.enumClass = ((Class)Preconditions.checkNotNull(enumClass));
  }
  
  protected T doForward(String value)
  {
    return Enum.valueOf(enumClass, value);
  }
  
  protected String doBackward(T enumValue)
  {
    return enumValue.name();
  }
  
  public boolean equals(@Nullable Object object)
  {
    if ((object instanceof StringConverter))
    {
      StringConverter<?> that = (StringConverter)object;
      return enumClass.equals(enumClass);
    }
    return false;
  }
  
  public int hashCode()
  {
    return enumClass.hashCode();
  }
  
  public String toString()
  {
    String str = String.valueOf(String.valueOf(enumClass.getName()));return 29 + str.length() + "Enums.stringConverter(" + str + ".class)";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Enums.StringConverter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */