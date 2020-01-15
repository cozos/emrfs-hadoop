package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.DefaultElementVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Element;
import java.util.Iterator;
import java.util.List;

abstract class AbstractProcessor
  extends DefaultElementVisitor<Boolean>
{
  protected Errors errors;
  protected InjectorImpl injector;
  
  protected AbstractProcessor(Errors errors)
  {
    this.errors = errors;
  }
  
  public void process(Iterable<InjectorShell> isolatedInjectorBuilders)
  {
    for (InjectorShell injectorShell : isolatedInjectorBuilders) {
      process(injectorShell.getInjector(), injectorShell.getElements());
    }
  }
  
  public void process(InjectorImpl injector, List<Element> elements)
  {
    Errors errorsAnyElement = errors;
    this.injector = injector;
    try
    {
      for (i = elements.iterator(); i.hasNext();)
      {
        Element element = (Element)i.next();
        errors = errorsAnyElement.withSource(element.getSource());
        Boolean allDone = (Boolean)element.acceptVisitor(this);
        if (allDone.booleanValue()) {
          i.remove();
        }
      }
    }
    finally
    {
      Iterator<Element> i;
      errors = errorsAnyElement;
      this.injector = null;
    }
  }
  
  protected Boolean visitOther(Element element)
  {
    return Boolean.valueOf(false);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.AbstractProcessor
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */