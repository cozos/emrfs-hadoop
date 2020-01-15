package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.concurrent.atomic.AtomicReference;

final class Types$2
  extends TypeVisitor
{
  Types$2(AtomicReference paramAtomicReference) {}
  
  void visitTypeVariable(TypeVariable<?> t)
  {
    val$result.set(Types.access$100(t.getBounds()));
  }
  
  void visitWildcardType(WildcardType t)
  {
    val$result.set(Types.access$100(t.getUpperBounds()));
  }
  
  void visitGenericArrayType(GenericArrayType t)
  {
    val$result.set(t.getGenericComponentType());
  }
  
  void visitClass(Class<?> t)
  {
    val$result.set(t.getComponentType());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.Types.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */