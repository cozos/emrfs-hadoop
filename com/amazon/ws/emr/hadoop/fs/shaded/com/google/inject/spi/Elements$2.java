package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Module;

final class Elements$2
  implements Module
{
  Elements$2(Iterable paramIterable) {}
  
  public void configure(Binder binder)
  {
    for (Element element : val$elements) {
      element.applyTo(binder);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Elements.2
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */