package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.lang.ref.WeakReference;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentMap;

class $MapMaker$StrategyImpl$1
  extends TimerTask
{
  $MapMaker$StrategyImpl$1(.MapMaker.StrategyImpl paramStrategyImpl, WeakReference paramWeakReference1, WeakReference paramWeakReference2) {}
  
  public void run()
  {
    K key = val$keyReference.get();
    if (key != null) {
      this$0.map.remove(key, val$valueReference.get());
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..MapMaker.StrategyImpl.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */