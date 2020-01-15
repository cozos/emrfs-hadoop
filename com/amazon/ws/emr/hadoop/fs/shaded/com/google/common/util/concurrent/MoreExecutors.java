package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Supplier;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Throwables;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Lists;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Queues;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class MoreExecutors
{
  @Beta
  public static ExecutorService getExitingExecutorService(ThreadPoolExecutor executor, long terminationTimeout, TimeUnit timeUnit)
  {
    return new Application().getExitingExecutorService(executor, terminationTimeout, timeUnit);
  }
  
  @Beta
  public static ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor executor, long terminationTimeout, TimeUnit timeUnit)
  {
    return new Application().getExitingScheduledExecutorService(executor, terminationTimeout, timeUnit);
  }
  
  @Beta
  public static void addDelayedShutdownHook(ExecutorService service, long terminationTimeout, TimeUnit timeUnit)
  {
    new Application().addDelayedShutdownHook(service, terminationTimeout, timeUnit);
  }
  
  @Beta
  public static ExecutorService getExitingExecutorService(ThreadPoolExecutor executor)
  {
    return new Application().getExitingExecutorService(executor);
  }
  
  @Beta
  public static ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor executor)
  {
    return new Application().getExitingScheduledExecutorService(executor);
  }
  
  @VisibleForTesting
  static class Application
  {
    final ExecutorService getExitingExecutorService(ThreadPoolExecutor executor, long terminationTimeout, TimeUnit timeUnit)
    {
      MoreExecutors.useDaemonThreadFactory(executor);
      ExecutorService service = Executors.unconfigurableExecutorService(executor);
      addDelayedShutdownHook(service, terminationTimeout, timeUnit);
      return service;
    }
    
    final ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor executor, long terminationTimeout, TimeUnit timeUnit)
    {
      MoreExecutors.useDaemonThreadFactory(executor);
      ScheduledExecutorService service = Executors.unconfigurableScheduledExecutorService(executor);
      addDelayedShutdownHook(service, terminationTimeout, timeUnit);
      return service;
    }
    
    final void addDelayedShutdownHook(final ExecutorService service, final long terminationTimeout, TimeUnit timeUnit)
    {
      Preconditions.checkNotNull(service);
      Preconditions.checkNotNull(timeUnit);
      String str = String.valueOf(String.valueOf(service));addShutdownHook(MoreExecutors.newThread(24 + str.length() + "DelayedShutdownHook-for-" + str, new Runnable()
      {
        public void run()
        {
          try
          {
            service.shutdown();
            service.awaitTermination(terminationTimeout, val$timeUnit);
          }
          catch (InterruptedException ignored) {}
        }
      }));
    }
    
    final ExecutorService getExitingExecutorService(ThreadPoolExecutor executor)
    {
      return getExitingExecutorService(executor, 120L, TimeUnit.SECONDS);
    }
    
    final ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor executor)
    {
      return getExitingScheduledExecutorService(executor, 120L, TimeUnit.SECONDS);
    }
    
    @VisibleForTesting
    void addShutdownHook(Thread hook)
    {
      Runtime.getRuntime().addShutdownHook(hook);
    }
  }
  
  private static void useDaemonThreadFactory(ThreadPoolExecutor executor)
  {
    executor.setThreadFactory(new ThreadFactoryBuilder().setDaemon(true).setThreadFactory(executor.getThreadFactory()).build());
  }
  
  @Deprecated
  public static ListeningExecutorService sameThreadExecutor()
  {
    return new DirectExecutorService(null);
  }
  
  private static class DirectExecutorService
    extends AbstractListeningExecutorService
  {
    private final Lock lock = new ReentrantLock();
    private final Condition termination = lock.newCondition();
    private int runningTasks = 0;
    private boolean shutdown = false;
    
    public void execute(Runnable command)
    {
      startTask();
      try
      {
        command.run();
      }
      finally
      {
        endTask();
      }
    }
    
    public boolean isShutdown()
    {
      lock.lock();
      try
      {
        return shutdown;
      }
      finally
      {
        lock.unlock();
      }
    }
    
    public void shutdown()
    {
      lock.lock();
      try
      {
        shutdown = true;
      }
      finally
      {
        lock.unlock();
      }
    }
    
    public List<Runnable> shutdownNow()
    {
      shutdown();
      return Collections.emptyList();
    }
    
    public boolean isTerminated()
    {
      lock.lock();
      try
      {
        return (shutdown) && (runningTasks == 0);
      }
      finally
      {
        lock.unlock();
      }
    }
    
    /* Error */
    public boolean awaitTermination(long timeout, TimeUnit unit)
      throws InterruptedException
    {
      // Byte code:
      //   0: aload_3
      //   1: lload_1
      //   2: invokevirtual 85	java/util/concurrent/TimeUnit:toNanos	(J)J
      //   5: lstore 4
      //   7: aload_0
      //   8: getfield 27	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/MoreExecutors$DirectExecutorService:lock	Ljava/util/concurrent/locks/Lock;
      //   11: invokeinterface 62 1 0
      //   16: aload_0
      //   17: invokevirtual 87	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/MoreExecutors$DirectExecutorService:isTerminated	()Z
      //   20: ifeq +18 -> 38
      //   23: iconst_1
      //   24: istore 6
      //   26: aload_0
      //   27: getfield 27	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/MoreExecutors$DirectExecutorService:lock	Ljava/util/concurrent/locks/Lock;
      //   30: invokeinterface 65 1 0
      //   35: iload 6
      //   37: ireturn
      //   38: lload 4
      //   40: lconst_0
      //   41: lcmp
      //   42: ifgt +18 -> 60
      //   45: iconst_0
      //   46: istore 6
      //   48: aload_0
      //   49: getfield 27	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/MoreExecutors$DirectExecutorService:lock	Ljava/util/concurrent/locks/Lock;
      //   52: invokeinterface 65 1 0
      //   57: iload 6
      //   59: ireturn
      //   60: aload_0
      //   61: getfield 35	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/MoreExecutors$DirectExecutorService:termination	Ljava/util/concurrent/locks/Condition;
      //   64: lload 4
      //   66: invokeinterface 92 3 0
      //   71: lstore 4
      //   73: goto -57 -> 16
      //   76: astore 7
      //   78: aload_0
      //   79: getfield 27	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/MoreExecutors$DirectExecutorService:lock	Ljava/util/concurrent/locks/Lock;
      //   82: invokeinterface 65 1 0
      //   87: aload 7
      //   89: athrow
      // Line number table:
      //   Java source line #345	-> byte code offset #0
      //   Java source line #346	-> byte code offset #7
      //   Java source line #349	-> byte code offset #16
      //   Java source line #350	-> byte code offset #23
      //   Java source line #358	-> byte code offset #26
      //   Java source line #351	-> byte code offset #38
      //   Java source line #352	-> byte code offset #45
      //   Java source line #358	-> byte code offset #48
      //   Java source line #354	-> byte code offset #60
      //   Java source line #358	-> byte code offset #76
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	90	0	this	DirectExecutorService
      //   0	90	1	timeout	long
      //   0	90	3	unit	TimeUnit
      //   5	67	4	nanos	long
      //   24	34	6	bool	boolean
      //   76	12	7	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   16	26	76	finally
      //   38	48	76	finally
      //   60	78	76	finally
    }
    
    private void startTask()
    {
      lock.lock();
      try
      {
        if (isShutdown()) {
          throw new RejectedExecutionException("Executor already shutdown");
        }
        runningTasks += 1;
      }
      finally
      {
        lock.unlock();
      }
    }
    
    private void endTask()
    {
      lock.lock();
      try
      {
        runningTasks -= 1;
        if (isTerminated()) {
          termination.signalAll();
        }
      }
      finally
      {
        lock.unlock();
      }
    }
  }
  
  public static ListeningExecutorService newDirectExecutorService()
  {
    return new DirectExecutorService(null);
  }
  
  public static Executor directExecutor()
  {
    return DirectExecutor.INSTANCE;
  }
  
  private static enum DirectExecutor
    implements Executor
  {
    INSTANCE;
    
    private DirectExecutor() {}
    
    public void execute(Runnable command)
    {
      command.run();
    }
  }
  
  public static ListeningExecutorService listeningDecorator(ExecutorService delegate)
  {
    return (delegate instanceof ScheduledExecutorService) ? new ScheduledListeningDecorator((ScheduledExecutorService)delegate) : (delegate instanceof ListeningExecutorService) ? (ListeningExecutorService)delegate : new ListeningDecorator(delegate);
  }
  
  public static ListeningScheduledExecutorService listeningDecorator(ScheduledExecutorService delegate)
  {
    return (delegate instanceof ListeningScheduledExecutorService) ? (ListeningScheduledExecutorService)delegate : new ScheduledListeningDecorator(delegate);
  }
  
  private static class ListeningDecorator
    extends AbstractListeningExecutorService
  {
    private final ExecutorService delegate;
    
    ListeningDecorator(ExecutorService delegate)
    {
      this.delegate = ((ExecutorService)Preconditions.checkNotNull(delegate));
    }
    
    public boolean awaitTermination(long timeout, TimeUnit unit)
      throws InterruptedException
    {
      return delegate.awaitTermination(timeout, unit);
    }
    
    public boolean isShutdown()
    {
      return delegate.isShutdown();
    }
    
    public boolean isTerminated()
    {
      return delegate.isTerminated();
    }
    
    public void shutdown()
    {
      delegate.shutdown();
    }
    
    public List<Runnable> shutdownNow()
    {
      return delegate.shutdownNow();
    }
    
    public void execute(Runnable command)
    {
      delegate.execute(command);
    }
  }
  
  private static class ScheduledListeningDecorator
    extends MoreExecutors.ListeningDecorator
    implements ListeningScheduledExecutorService
  {
    final ScheduledExecutorService delegate;
    
    ScheduledListeningDecorator(ScheduledExecutorService delegate)
    {
      super();
      this.delegate = ((ScheduledExecutorService)Preconditions.checkNotNull(delegate));
    }
    
    public ListenableScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit)
    {
      ListenableFutureTask<Void> task = ListenableFutureTask.create(command, null);
      
      ScheduledFuture<?> scheduled = delegate.schedule(task, delay, unit);
      return new ListenableScheduledTask(task, scheduled);
    }
    
    public <V> ListenableScheduledFuture<V> schedule(Callable<V> callable, long delay, TimeUnit unit)
    {
      ListenableFutureTask<V> task = ListenableFutureTask.create(callable);
      ScheduledFuture<?> scheduled = delegate.schedule(task, delay, unit);
      return new ListenableScheduledTask(task, scheduled);
    }
    
    public ListenableScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit)
    {
      NeverSuccessfulListenableFutureTask task = new NeverSuccessfulListenableFutureTask(command);
      
      ScheduledFuture<?> scheduled = delegate.scheduleAtFixedRate(task, initialDelay, period, unit);
      
      return new ListenableScheduledTask(task, scheduled);
    }
    
    public ListenableScheduledFuture<?> scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit)
    {
      NeverSuccessfulListenableFutureTask task = new NeverSuccessfulListenableFutureTask(command);
      
      ScheduledFuture<?> scheduled = delegate.scheduleWithFixedDelay(task, initialDelay, delay, unit);
      
      return new ListenableScheduledTask(task, scheduled);
    }
    
    private static final class ListenableScheduledTask<V>
      extends ForwardingListenableFuture.SimpleForwardingListenableFuture<V>
      implements ListenableScheduledFuture<V>
    {
      private final ScheduledFuture<?> scheduledDelegate;
      
      public ListenableScheduledTask(ListenableFuture<V> listenableDelegate, ScheduledFuture<?> scheduledDelegate)
      {
        super();
        this.scheduledDelegate = scheduledDelegate;
      }
      
      public boolean cancel(boolean mayInterruptIfRunning)
      {
        boolean cancelled = super.cancel(mayInterruptIfRunning);
        if (cancelled) {
          scheduledDelegate.cancel(mayInterruptIfRunning);
        }
        return cancelled;
      }
      
      public long getDelay(TimeUnit unit)
      {
        return scheduledDelegate.getDelay(unit);
      }
      
      public int compareTo(Delayed other)
      {
        return scheduledDelegate.compareTo(other);
      }
    }
    
    private static final class NeverSuccessfulListenableFutureTask
      extends AbstractFuture<Void>
      implements Runnable
    {
      private final Runnable delegate;
      
      public NeverSuccessfulListenableFutureTask(Runnable delegate)
      {
        this.delegate = ((Runnable)Preconditions.checkNotNull(delegate));
      }
      
      public void run()
      {
        try
        {
          delegate.run();
        }
        catch (Throwable t)
        {
          setException(t);
          throw Throwables.propagate(t);
        }
      }
    }
  }
  
  static <T> T invokeAnyImpl(ListeningExecutorService executorService, Collection<? extends Callable<T>> tasks, boolean timed, long nanos)
    throws InterruptedException, ExecutionException, TimeoutException
  {
    Preconditions.checkNotNull(executorService);
    int ntasks = tasks.size();
    Preconditions.checkArgument(ntasks > 0);
    List<Future<T>> futures = Lists.newArrayListWithCapacity(ntasks);
    BlockingQueue<Future<T>> futureQueue = Queues.newLinkedBlockingQueue();
    try
    {
      ExecutionException ee = null;
      long lastTime = timed ? System.nanoTime() : 0L;
      Iterator<? extends Callable<T>> it = tasks.iterator();
      
      futures.add(submitAndAddQueueListener(executorService, (Callable)it.next(), futureQueue));
      ntasks--;
      int active = 1;
      for (;;)
      {
        Future<T> f = (Future)futureQueue.poll();
        if (f == null) {
          if (ntasks > 0)
          {
            ntasks--;
            futures.add(submitAndAddQueueListener(executorService, (Callable)it.next(), futureQueue));
            active++;
          }
          else
          {
            if (active == 0) {
              break;
            }
            if (timed)
            {
              f = (Future)futureQueue.poll(nanos, TimeUnit.NANOSECONDS);
              if (f == null) {
                throw new TimeoutException();
              }
              long now = System.nanoTime();
              nanos -= now - lastTime;
              lastTime = now;
            }
            else
            {
              f = (Future)futureQueue.take();
            }
          }
        }
        if (f != null)
        {
          active--;
          try
          {
            Iterator i$;
            Future<T> f;
            return (T)f.get();
          }
          catch (ExecutionException eex)
          {
            ee = eex;
          }
          catch (RuntimeException rex)
          {
            ee = new ExecutionException(rex);
          }
        }
      }
      if (ee == null) {
        ee = new ExecutionException(null);
      }
      throw ee;
    }
    finally
    {
      for (Future<T> f : futures) {
        f.cancel(true);
      }
    }
  }
  
  private static <T> ListenableFuture<T> submitAndAddQueueListener(ListeningExecutorService executorService, Callable<T> task, BlockingQueue<Future<T>> queue)
  {
    final ListenableFuture<T> future = executorService.submit(task);
    future.addListener(new Runnable()
    {
      public void run()
      {
        val$queue.add(future);
      }
    }, directExecutor());
    
    return future;
  }
  
  @Beta
  public static ThreadFactory platformThreadFactory()
  {
    if (!isAppEngine()) {
      return Executors.defaultThreadFactory();
    }
    try
    {
      return (ThreadFactory)Class.forName("com.google.appengine.api.ThreadManager").getMethod("currentRequestThreadFactory", new Class[0]).invoke(null, new Object[0]);
    }
    catch (IllegalAccessException e)
    {
      throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e);
    }
    catch (ClassNotFoundException e)
    {
      throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e);
    }
    catch (NoSuchMethodException e)
    {
      throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e);
    }
    catch (InvocationTargetException e)
    {
      throw Throwables.propagate(e.getCause());
    }
  }
  
  private static boolean isAppEngine()
  {
    if (System.getProperty("com.google.appengine.runtime.environment") == null) {
      return false;
    }
    try
    {
      return Class.forName("com.google.apphosting.api.ApiProxy").getMethod("getCurrentEnvironment", new Class[0]).invoke(null, new Object[0]) != null;
    }
    catch (ClassNotFoundException e)
    {
      return false;
    }
    catch (InvocationTargetException e)
    {
      return false;
    }
    catch (IllegalAccessException e)
    {
      return false;
    }
    catch (NoSuchMethodException e) {}
    return false;
  }
  
  static Thread newThread(String name, Runnable runnable)
  {
    Preconditions.checkNotNull(name);
    Preconditions.checkNotNull(runnable);
    Thread result = platformThreadFactory().newThread(runnable);
    try
    {
      result.setName(name);
    }
    catch (SecurityException e) {}
    return result;
  }
  
  static Executor renamingDecorator(Executor executor, final Supplier<String> nameSupplier)
  {
    Preconditions.checkNotNull(executor);
    Preconditions.checkNotNull(nameSupplier);
    if (isAppEngine()) {
      return executor;
    }
    new Executor()
    {
      public void execute(Runnable command)
      {
        val$executor.execute(Callables.threadRenaming(command, nameSupplier));
      }
    };
  }
  
  static ExecutorService renamingDecorator(ExecutorService service, final Supplier<String> nameSupplier)
  {
    Preconditions.checkNotNull(service);
    Preconditions.checkNotNull(nameSupplier);
    if (isAppEngine()) {
      return service;
    }
    new WrappingExecutorService(service)
    {
      protected <T> Callable<T> wrapTask(Callable<T> callable)
      {
        return Callables.threadRenaming(callable, nameSupplier);
      }
      
      protected Runnable wrapTask(Runnable command)
      {
        return Callables.threadRenaming(command, nameSupplier);
      }
    };
  }
  
  static ScheduledExecutorService renamingDecorator(ScheduledExecutorService service, final Supplier<String> nameSupplier)
  {
    Preconditions.checkNotNull(service);
    Preconditions.checkNotNull(nameSupplier);
    if (isAppEngine()) {
      return service;
    }
    new WrappingScheduledExecutorService(service)
    {
      protected <T> Callable<T> wrapTask(Callable<T> callable)
      {
        return Callables.threadRenaming(callable, nameSupplier);
      }
      
      protected Runnable wrapTask(Runnable command)
      {
        return Callables.threadRenaming(command, nameSupplier);
      }
    };
  }
  
  @Beta
  public static boolean shutdownAndAwaitTermination(ExecutorService service, long timeout, TimeUnit unit)
  {
    Preconditions.checkNotNull(unit);
    
    service.shutdown();
    try
    {
      long halfTimeoutNanos = TimeUnit.NANOSECONDS.convert(timeout, unit) / 2L;
      if (!service.awaitTermination(halfTimeoutNanos, TimeUnit.NANOSECONDS))
      {
        service.shutdownNow();
        
        service.awaitTermination(halfTimeoutNanos, TimeUnit.NANOSECONDS);
      }
    }
    catch (InterruptedException ie)
    {
      Thread.currentThread().interrupt();
      
      service.shutdownNow();
    }
    return service.isTerminated();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.MoreExecutors
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */