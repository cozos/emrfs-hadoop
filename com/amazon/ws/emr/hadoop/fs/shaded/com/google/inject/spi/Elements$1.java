package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binding;

final class Elements$1
  extends DefaultBindingTargetVisitor<Object, Object>
{
  public Object visit(InstanceBinding<?> binding)
  {
    return binding.getInstance();
  }
  
  protected Object visitOther(Binding<?> binding)
  {
    throw new IllegalArgumentException();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Elements.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */