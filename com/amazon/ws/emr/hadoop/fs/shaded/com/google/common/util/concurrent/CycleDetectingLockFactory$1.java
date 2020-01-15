package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Lists;
import java.util.ArrayList;

final class CycleDetectingLockFactory$1
  extends ThreadLocal<ArrayList<CycleDetectingLockFactory.LockGraphNode>>
{
  protected ArrayList<CycleDetectingLockFactory.LockGraphNode> initialValue()
  {
    return Lists.newArrayListWithCapacity(3);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.CycleDetectingLockFactory.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */