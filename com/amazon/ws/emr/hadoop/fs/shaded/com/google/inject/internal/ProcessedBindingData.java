package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Lists;
import java.util.List;

class ProcessedBindingData
{
  private final List<CreationListener> creationListeners = .Lists.newArrayList();
  private final List<Runnable> uninitializedBindings = .Lists.newArrayList();
  
  void addCreationListener(CreationListener listener)
  {
    creationListeners.add(listener);
  }
  
  void addUninitializedBinding(Runnable runnable)
  {
    uninitializedBindings.add(runnable);
  }
  
  void initializeBindings()
  {
    for (Runnable initializer : uninitializedBindings) {
      initializer.run();
    }
  }
  
  void runCreationListeners(Errors errors)
  {
    for (CreationListener creationListener : creationListeners) {
      creationListener.notify(errors);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.ProcessedBindingData
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */