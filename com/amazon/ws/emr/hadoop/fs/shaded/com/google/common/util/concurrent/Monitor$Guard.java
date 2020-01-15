package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.concurrent.GuardedBy;

@Beta
public abstract class Monitor$Guard
{
  final Monitor monitor;
  final Condition condition;
  @GuardedBy("monitor.lock")
  int waiterCount = 0;
  @GuardedBy("monitor.lock")
  Guard next;
  
  protected Monitor$Guard(Monitor monitor)
  {
    this.monitor = ((Monitor)Preconditions.checkNotNull(monitor, "monitor"));
    condition = Monitor.access$000(monitor).newCondition();
  }
  
  public abstract boolean isSatisfied();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.Monitor.Guard
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */