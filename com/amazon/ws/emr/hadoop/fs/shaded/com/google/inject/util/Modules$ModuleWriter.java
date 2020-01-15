package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.DefaultElementVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Element;

class Modules$ModuleWriter
  extends DefaultElementVisitor<Void>
{
  protected final Binder binder;
  
  Modules$ModuleWriter(Binder binder)
  {
    this.binder = binder;
  }
  
  protected Void visitOther(Element element)
  {
    element.applyTo(binder);
    return null;
  }
  
  void writeAll(Iterable<? extends Element> elements)
  {
    for (Element element : elements) {
      element.acceptVisitor(this);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.util.Modules.ModuleWriter
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */