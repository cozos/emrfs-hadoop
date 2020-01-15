package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Throwables;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.concurrent.GuardedBy;

@Beta
public final class Monitor
{
  private final boolean fair;
  private final ReentrantLock lock;
  
  @Beta
  public static abstract class Guard
  {
    final Monitor monitor;
    final Condition condition;
    @GuardedBy("monitor.lock")
    int waiterCount = 0;
    @GuardedBy("monitor.lock")
    Guard next;
    
    protected Guard(Monitor monitor)
    {
      this.monitor = ((Monitor)Preconditions.checkNotNull(monitor, "monitor"));
      condition = lock.newCondition();
    }
    
    public abstract boolean isSatisfied();
  }
  
  @GuardedBy("lock")
  private Guard activeGuards = null;
  
  public Monitor()
  {
    this(false);
  }
  
  public Monitor(boolean fair)
  {
    this.fair = fair;
    lock = new ReentrantLock(fair);
  }
  
  public void enter()
  {
    lock.lock();
  }
  
  public void enterInterruptibly()
    throws InterruptedException
  {
    lock.lockInterruptibly();
  }
  
  public boolean enter(long time, TimeUnit unit)
  {
    long timeoutNanos = unit.toNanos(time);
    ReentrantLock lock = this.lock;
    if ((!fair) && (lock.tryLock())) {
      return true;
    }
    long deadline = System.nanoTime() + timeoutNanos;
    boolean interrupted = Thread.interrupted();
    try
    {
      return lock.tryLock(timeoutNanos, TimeUnit.NANOSECONDS);
    }
    catch (InterruptedException interrupt)
    {
      for (;;)
      {
        interrupted = true;
        timeoutNanos = deadline - System.nanoTime();
      }
    }
    finally
    {
      if (interrupted) {
        Thread.currentThread().interrupt();
      }
    }
  }
  
  public boolean enterInterruptibly(long time, TimeUnit unit)
    throws InterruptedException
  {
    return lock.tryLock(time, unit);
  }
  
  public boolean tryEnter()
  {
    return lock.tryLock();
  }
  
  public void enterWhen(Guard guard)
    throws InterruptedException
  {
    if (monitor != this) {
      throw new IllegalMonitorStateException();
    }
    ReentrantLock lock = this.lock;
    boolean signalBeforeWaiting = lock.isHeldByCurrentThread();
    lock.lockInterruptibly();
    
    boolean satisfied = false;
    try
    {
      if (!guard.isSatisfied()) {
        await(guard, signalBeforeWaiting);
      }
      satisfied = true;
    }
    finally
    {
      if (!satisfied) {
        leave();
      }
    }
  }
  
  public void enterWhenUninterruptibly(Guard guard)
  {
    if (monitor != this) {
      throw new IllegalMonitorStateException();
    }
    ReentrantLock lock = this.lock;
    boolean signalBeforeWaiting = lock.isHeldByCurrentThread();
    lock.lock();
    
    boolean satisfied = false;
    try
    {
      if (!guard.isSatisfied()) {
        awaitUninterruptibly(guard, signalBeforeWaiting);
      }
      satisfied = true;
    }
    finally
    {
      if (!satisfied) {
        leave();
      }
    }
  }
  
  public boolean enterWhen(Guard guard, long time, TimeUnit unit)
    throws InterruptedException
  {
    long timeoutNanos = unit.toNanos(time);
    if (monitor != this) {
      throw new IllegalMonitorStateException();
    }
    ReentrantLock lock = this.lock;
    boolean reentrant = lock.isHeldByCurrentThread();
    if ((fair) || (!lock.tryLock()))
    {
      long deadline = System.nanoTime() + timeoutNanos;
      if (!lock.tryLock(time, unit)) {
        return false;
      }
      timeoutNanos = deadline - System.nanoTime();
    }
    boolean satisfied = false;
    boolean threw = true;
    try
    {
      satisfied = (guard.isSatisfied()) || (awaitNanos(guard, timeoutNanos, reentrant));
      threw = false;
      return satisfied;
    }
    finally
    {
      if (!satisfied) {
        try
        {
          if ((threw) && (!reentrant)) {
            signalNextWaiter();
          }
        }
        finally
        {
          lock.unlock();
        }
      }
    }
  }
  
  /* Error */
  public boolean enterWhenUninterruptibly(Guard guard, long time, TimeUnit unit)
  {
    // Byte code:
    //   0: aload 4
    //   2: lload_2
    //   3: invokevirtual 51	java/util/concurrent/TimeUnit:toNanos	(J)J
    //   6: lstore 5
    //   8: aload_1
    //   9: getfield 93	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/Monitor$Guard:monitor	Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/Monitor;
    //   12: aload_0
    //   13: if_acmpeq +11 -> 24
    //   16: new 95	java/lang/IllegalMonitorStateException
    //   19: dup
    //   20: invokespecial 96	java/lang/IllegalMonitorStateException:<init>	()V
    //   23: athrow
    //   24: aload_0
    //   25: getfield 35	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/Monitor:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   28: astore 7
    //   30: invokestatic 61	java/lang/System:nanoTime	()J
    //   33: lload 5
    //   35: ladd
    //   36: lstore 8
    //   38: aload 7
    //   40: invokevirtual 99	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   43: istore 10
    //   45: invokestatic 66	java/lang/Thread:interrupted	()Z
    //   48: istore 11
    //   50: aload_0
    //   51: getfield 30	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/Monitor:fair	Z
    //   54: ifne +11 -> 65
    //   57: aload 7
    //   59: invokevirtual 55	java/util/concurrent/locks/ReentrantLock:tryLock	()Z
    //   62: ifne +61 -> 123
    //   65: iconst_0
    //   66: istore 12
    //   68: aload 7
    //   70: lload 5
    //   72: getstatic 70	java/util/concurrent/TimeUnit:NANOSECONDS	Ljava/util/concurrent/TimeUnit;
    //   75: invokevirtual 72	java/util/concurrent/locks/ReentrantLock:tryLock	(JLjava/util/concurrent/TimeUnit;)Z
    //   78: istore 12
    //   80: iload 12
    //   82: ifne +20 -> 102
    //   85: iconst_0
    //   86: istore 13
    //   88: iload 11
    //   90: ifeq +9 -> 99
    //   93: invokestatic 76	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   96: invokevirtual 79	java/lang/Thread:interrupt	()V
    //   99: iload 13
    //   101: ireturn
    //   102: goto +8 -> 110
    //   105: astore 13
    //   107: iconst_1
    //   108: istore 11
    //   110: lload 8
    //   112: invokestatic 61	java/lang/System:nanoTime	()J
    //   115: lsub
    //   116: lstore 5
    //   118: iload 12
    //   120: ifeq -52 -> 68
    //   123: iconst_0
    //   124: istore 12
    //   126: aload_1
    //   127: invokevirtual 102	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/Monitor$Guard:isSatisfied	()Z
    //   130: ifne +15 -> 145
    //   133: aload_0
    //   134: aload_1
    //   135: lload 5
    //   137: iload 10
    //   139: invokespecial 121	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/Monitor:awaitNanos	(Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/Monitor$Guard;JZ)Z
    //   142: ifeq +7 -> 149
    //   145: iconst_1
    //   146: goto +4 -> 150
    //   149: iconst_0
    //   150: dup
    //   151: istore 12
    //   153: istore 13
    //   155: iload 12
    //   157: ifne +8 -> 165
    //   160: aload 7
    //   162: invokevirtual 127	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   165: iload 11
    //   167: ifeq +9 -> 176
    //   170: invokestatic 76	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   173: invokevirtual 79	java/lang/Thread:interrupt	()V
    //   176: iload 13
    //   178: ireturn
    //   179: astore 13
    //   181: iconst_1
    //   182: istore 11
    //   184: iconst_0
    //   185: istore 10
    //   187: lload 8
    //   189: invokestatic 61	java/lang/System:nanoTime	()J
    //   192: lsub
    //   193: lstore 5
    //   195: goto -69 -> 126
    //   198: astore 14
    //   200: iload 12
    //   202: ifne +8 -> 210
    //   205: aload 7
    //   207: invokevirtual 127	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   210: aload 14
    //   212: athrow
    //   213: astore 15
    //   215: iload 11
    //   217: ifeq +9 -> 226
    //   220: invokestatic 76	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   223: invokevirtual 79	java/lang/Thread:interrupt	()V
    //   226: aload 15
    //   228: athrow
    // Line number table:
    //   Java source line #513	-> byte code offset #0
    //   Java source line #514	-> byte code offset #8
    //   Java source line #515	-> byte code offset #16
    //   Java source line #517	-> byte code offset #24
    //   Java source line #518	-> byte code offset #30
    //   Java source line #519	-> byte code offset #38
    //   Java source line #520	-> byte code offset #45
    //   Java source line #522	-> byte code offset #50
    //   Java source line #523	-> byte code offset #65
    //   Java source line #526	-> byte code offset #68
    //   Java source line #527	-> byte code offset #80
    //   Java source line #528	-> byte code offset #85
    //   Java source line #555	-> byte code offset #88
    //   Java source line #556	-> byte code offset #93
    //   Java source line #532	-> byte code offset #102
    //   Java source line #530	-> byte code offset #105
    //   Java source line #531	-> byte code offset #107
    //   Java source line #533	-> byte code offset #110
    //   Java source line #534	-> byte code offset #118
    //   Java source line #537	-> byte code offset #123
    //   Java source line #541	-> byte code offset #126
    //   Java source line #550	-> byte code offset #155
    //   Java source line #551	-> byte code offset #160
    //   Java source line #555	-> byte code offset #165
    //   Java source line #556	-> byte code offset #170
    //   Java source line #543	-> byte code offset #179
    //   Java source line #544	-> byte code offset #181
    //   Java source line #545	-> byte code offset #184
    //   Java source line #546	-> byte code offset #187
    //   Java source line #547	-> byte code offset #195
    //   Java source line #550	-> byte code offset #198
    //   Java source line #551	-> byte code offset #205
    //   Java source line #555	-> byte code offset #213
    //   Java source line #556	-> byte code offset #220
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	this	Monitor
    //   0	229	1	guard	Guard
    //   0	229	2	time	long
    //   0	229	4	unit	TimeUnit
    //   6	188	5	timeoutNanos	long
    //   28	178	7	lock	ReentrantLock
    //   36	152	8	deadline	long
    //   43	143	10	signalBeforeWaiting	boolean
    //   48	168	11	interrupted	boolean
    //   66	53	12	locked	boolean
    //   124	77	12	satisfied	boolean
    //   86	14	13	bool1	boolean
    //   105	72	13	interrupt	InterruptedException
    //   153	24	13	bool2	boolean
    //   179	3	13	interrupt	InterruptedException
    //   198	13	14	localObject1	Object
    //   213	14	15	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   68	88	105	java/lang/InterruptedException
    //   126	155	179	java/lang/InterruptedException
    //   126	155	198	finally
    //   179	200	198	finally
    //   50	88	213	finally
    //   102	165	213	finally
    //   179	215	213	finally
  }
  
  public boolean enterIf(Guard guard)
  {
    if (monitor != this) {
      throw new IllegalMonitorStateException();
    }
    ReentrantLock lock = this.lock;
    lock.lock();
    
    boolean satisfied = false;
    try
    {
      return satisfied = guard.isSatisfied();
    }
    finally
    {
      if (!satisfied) {
        lock.unlock();
      }
    }
  }
  
  public boolean enterIfInterruptibly(Guard guard)
    throws InterruptedException
  {
    if (monitor != this) {
      throw new IllegalMonitorStateException();
    }
    ReentrantLock lock = this.lock;
    lock.lockInterruptibly();
    
    boolean satisfied = false;
    try
    {
      return satisfied = guard.isSatisfied();
    }
    finally
    {
      if (!satisfied) {
        lock.unlock();
      }
    }
  }
  
  public boolean enterIf(Guard guard, long time, TimeUnit unit)
  {
    if (monitor != this) {
      throw new IllegalMonitorStateException();
    }
    if (!enter(time, unit)) {
      return false;
    }
    boolean satisfied = false;
    try
    {
      return satisfied = guard.isSatisfied();
    }
    finally
    {
      if (!satisfied) {
        lock.unlock();
      }
    }
  }
  
  public boolean enterIfInterruptibly(Guard guard, long time, TimeUnit unit)
    throws InterruptedException
  {
    if (monitor != this) {
      throw new IllegalMonitorStateException();
    }
    ReentrantLock lock = this.lock;
    if (!lock.tryLock(time, unit)) {
      return false;
    }
    boolean satisfied = false;
    try
    {
      return satisfied = guard.isSatisfied();
    }
    finally
    {
      if (!satisfied) {
        lock.unlock();
      }
    }
  }
  
  public boolean tryEnterIf(Guard guard)
  {
    if (monitor != this) {
      throw new IllegalMonitorStateException();
    }
    ReentrantLock lock = this.lock;
    if (!lock.tryLock()) {
      return false;
    }
    boolean satisfied = false;
    try
    {
      return satisfied = guard.isSatisfied();
    }
    finally
    {
      if (!satisfied) {
        lock.unlock();
      }
    }
  }
  
  public void waitFor(Guard guard)
    throws InterruptedException
  {
    if (!(monitor == this & lock.isHeldByCurrentThread())) {
      throw new IllegalMonitorStateException();
    }
    if (!guard.isSatisfied()) {
      await(guard, true);
    }
  }
  
  public void waitForUninterruptibly(Guard guard)
  {
    if (!(monitor == this & lock.isHeldByCurrentThread())) {
      throw new IllegalMonitorStateException();
    }
    if (!guard.isSatisfied()) {
      awaitUninterruptibly(guard, true);
    }
  }
  
  public boolean waitFor(Guard guard, long time, TimeUnit unit)
    throws InterruptedException
  {
    long timeoutNanos = unit.toNanos(time);
    if (!(monitor == this & lock.isHeldByCurrentThread())) {
      throw new IllegalMonitorStateException();
    }
    return (guard.isSatisfied()) || (awaitNanos(guard, timeoutNanos, true));
  }
  
  public boolean waitForUninterruptibly(Guard guard, long time, TimeUnit unit)
  {
    long timeoutNanos = unit.toNanos(time);
    if (!(monitor == this & lock.isHeldByCurrentThread())) {
      throw new IllegalMonitorStateException();
    }
    if (guard.isSatisfied()) {
      return true;
    }
    boolean signalBeforeWaiting = true;
    long deadline = System.nanoTime() + timeoutNanos;
    boolean interrupted = Thread.interrupted();
    try
    {
      return awaitNanos(guard, timeoutNanos, signalBeforeWaiting);
    }
    catch (InterruptedException interrupt)
    {
      for (;;)
      {
        interrupted = true;
        if (guard.isSatisfied()) {
          return true;
        }
        signalBeforeWaiting = false;
        timeoutNanos = deadline - System.nanoTime();
      }
    }
    finally
    {
      if (interrupted) {
        Thread.currentThread().interrupt();
      }
    }
  }
  
  public void leave()
  {
    ReentrantLock lock = this.lock;
    try
    {
      if (lock.getHoldCount() == 1) {
        signalNextWaiter();
      }
    }
    finally
    {
      lock.unlock();
    }
  }
  
  public boolean isFair()
  {
    return fair;
  }
  
  public boolean isOccupied()
  {
    return lock.isLocked();
  }
  
  public boolean isOccupiedByCurrentThread()
  {
    return lock.isHeldByCurrentThread();
  }
  
  public int getOccupiedDepth()
  {
    return lock.getHoldCount();
  }
  
  public int getQueueLength()
  {
    return lock.getQueueLength();
  }
  
  public boolean hasQueuedThreads()
  {
    return lock.hasQueuedThreads();
  }
  
  public boolean hasQueuedThread(Thread thread)
  {
    return lock.hasQueuedThread(thread);
  }
  
  public boolean hasWaiters(Guard guard)
  {
    return getWaitQueueLength(guard) > 0;
  }
  
  public int getWaitQueueLength(Guard guard)
  {
    if (monitor != this) {
      throw new IllegalMonitorStateException();
    }
    lock.lock();
    try
    {
      return waiterCount;
    }
    finally
    {
      lock.unlock();
    }
  }
  
  @GuardedBy("lock")
  private void signalNextWaiter()
  {
    for (Guard guard = activeGuards; guard != null; guard = next) {
      if (isSatisfied(guard))
      {
        condition.signal();
        break;
      }
    }
  }
  
  @GuardedBy("lock")
  private boolean isSatisfied(Guard guard)
  {
    try
    {
      return guard.isSatisfied();
    }
    catch (Throwable throwable)
    {
      signalAllWaiters();
      throw Throwables.propagate(throwable);
    }
  }
  
  @GuardedBy("lock")
  private void signalAllWaiters()
  {
    for (Guard guard = activeGuards; guard != null; guard = next) {
      condition.signalAll();
    }
  }
  
  @GuardedBy("lock")
  private void beginWaitingFor(Guard guard)
  {
    int waiters = waiterCount++;
    if (waiters == 0)
    {
      next = activeGuards;
      activeGuards = guard;
    }
  }
  
  @GuardedBy("lock")
  private void endWaitingFor(Guard guard)
  {
    int waiters = --waiterCount;
    if (waiters == 0)
    {
      Guard p = activeGuards;
      for (Guard pred = null;; p = next)
      {
        if (p == guard)
        {
          if (pred == null) {
            activeGuards = next;
          } else {
            next = next;
          }
          next = null;
          break;
        }
        pred = p;
      }
    }
  }
  
  @GuardedBy("lock")
  private void await(Guard guard, boolean signalBeforeWaiting)
    throws InterruptedException
  {
    if (signalBeforeWaiting) {
      signalNextWaiter();
    }
    beginWaitingFor(guard);
    try
    {
      do
      {
        condition.await();
      } while (!guard.isSatisfied());
    }
    finally
    {
      endWaitingFor(guard);
    }
  }
  
  @GuardedBy("lock")
  private void awaitUninterruptibly(Guard guard, boolean signalBeforeWaiting)
  {
    if (signalBeforeWaiting) {
      signalNextWaiter();
    }
    beginWaitingFor(guard);
    try
    {
      do
      {
        condition.awaitUninterruptibly();
      } while (!guard.isSatisfied());
    }
    finally
    {
      endWaitingFor(guard);
    }
  }
  
  @GuardedBy("lock")
  private boolean awaitNanos(Guard guard, long nanos, boolean signalBeforeWaiting)
    throws InterruptedException
  {
    if (signalBeforeWaiting) {
      signalNextWaiter();
    }
    beginWaitingFor(guard);
    try
    {
      boolean bool;
      do
      {
        if (nanos < 0L) {
          return false;
        }
        nanos = condition.awaitNanos(nanos);
      } while (!guard.isSatisfied());
      return true;
    }
    finally
    {
      endWaitingFor(guard);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.Monitor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */