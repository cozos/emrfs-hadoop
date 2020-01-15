package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.InternalInjectorCreator;
import java.util.Arrays;

public final class Guice
{
  public static Injector createInjector(Module... modules)
  {
    return createInjector(Arrays.asList(modules));
  }
  
  public static Injector createInjector(Iterable<? extends Module> modules)
  {
    return createInjector(Stage.DEVELOPMENT, modules);
  }
  
  public static Injector createInjector(Stage stage, Module... modules)
  {
    return createInjector(stage, Arrays.asList(modules));
  }
  
  public static Injector createInjector(Stage stage, Iterable<? extends Module> modules)
  {
    return new InternalInjectorCreator().stage(stage).addModules(modules).build();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Guice
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */