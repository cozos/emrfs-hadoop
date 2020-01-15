package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import java.util.concurrent.Semaphore;

class Striped$PaddedSemaphore
  extends Semaphore
{
  long q1;
  long q2;
  long q3;
  
  Striped$PaddedSemaphore(int permits)
  {
    super(permits, false);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.Striped.PaddedSemaphore
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */