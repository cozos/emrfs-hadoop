package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Module;
import java.util.Set;

final class Modules$2
  implements Module
{
  Modules$2(Set paramSet) {}
  
  public void configure(Binder binder)
  {
    binder = binder.skipSources(new Class[] { getClass() });
    for (Module module : val$modulesSet) {
      binder.install(module);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.util.Modules.2
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */