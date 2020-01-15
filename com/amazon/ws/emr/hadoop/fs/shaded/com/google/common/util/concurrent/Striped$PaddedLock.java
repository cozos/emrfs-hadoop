package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import java.util.concurrent.locks.ReentrantLock;

class Striped$PaddedLock
  extends ReentrantLock
{
  long q1;
  long q2;
  long q3;
  
  Striped$PaddedLock()
  {
    super(false);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.Striped.PaddedLock
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */