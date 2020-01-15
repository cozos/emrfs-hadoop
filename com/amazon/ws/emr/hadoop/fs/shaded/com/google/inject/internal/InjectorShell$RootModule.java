package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Module;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Scopes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Stage;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.binder.AnnotatedBindingBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..SourceProvider;

class InjectorShell$RootModule
  implements Module
{
  final Stage stage;
  
  private InjectorShell$RootModule(Stage stage)
  {
    this.stage = ((Stage).Preconditions.checkNotNull(stage, "stage"));
  }
  
  public void configure(Binder binder)
  {
    binder = binder.withSource(.SourceProvider.UNKNOWN_SOURCE);
    binder.bind(Stage.class).toInstance(stage);
    binder.bindScope(com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Singleton.class, Scopes.SINGLETON);
    binder.bindScope(javax.inject.Singleton.class, Scopes.SINGLETON);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.InjectorShell.RootModule
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */