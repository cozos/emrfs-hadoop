package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.reflect;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.builder.Builder;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

public class TypeUtils$WildcardTypeBuilder
  implements Builder<WildcardType>
{
  private Type[] upperBounds;
  private Type[] lowerBounds;
  
  public WildcardTypeBuilder withUpperBounds(Type... bounds)
  {
    upperBounds = bounds;
    return this;
  }
  
  public WildcardTypeBuilder withLowerBounds(Type... bounds)
  {
    lowerBounds = bounds;
    return this;
  }
  
  public WildcardType build()
  {
    return new TypeUtils.WildcardTypeImpl(upperBounds, lowerBounds, null);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.reflect.TypeUtils.WildcardTypeBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */