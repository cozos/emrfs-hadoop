package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.TypeLiteral;

final class Errors$4
  extends Errors.Converter<Key>
{
  Errors$4(Class x0)
  {
    super(x0);
  }
  
  public String toString(Key key)
  {
    if (key.getAnnotationType() != null) {
      return key.getTypeLiteral() + " annotated with " + (key.getAnnotation() != null ? key.getAnnotation() : key.getAnnotationType());
    }
    return key.getTypeLiteral().toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.Errors.4
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */