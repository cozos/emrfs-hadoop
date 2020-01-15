package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Optional;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableCollection;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableList.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Lists;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Ordering;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Queues;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Sets;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

@Beta
public final class Futures
{
  public static <V, X extends Exception> CheckedFuture<V, X> makeChecked(ListenableFuture<V> future, Function<? super Exception, X> mapper)
  {
    return new MappingCheckedFuture((ListenableFuture)Preconditions.checkNotNull(future), mapper);
  }
  
  private static abstract class ImmediateFuture<V>
    implements ListenableFuture<V>
  {
    private static final Logger log = Logger.getLogger(ImmediateFuture.class.getName());
    
    public void addListener(Runnable listener, Executor executor)
    {
      Preconditions.checkNotNull(listener, "Runnable was null.");
      Preconditions.checkNotNull(executor, "Executor was null.");
      try
      {
        executor.execute(listener);
      }
      catch (RuntimeException e)
      {
        String str1 = String.valueOf(String.valueOf(listener));String str2 = String.valueOf(String.valueOf(executor));log.log(Level.SEVERE, 57 + str1.length() + str2.length() + "RuntimeException while executing runnable " + str1 + " with executor " + str2, e);
      }
    }
    
    public boolean cancel(boolean mayInterruptIfRunning)
    {
      return false;
    }
    
    public abstract V get()
      throws ExecutionException;
    
    public V get(long timeout, TimeUnit unit)
      throws ExecutionException
    {
      Preconditions.checkNotNull(unit);
      return (V)get();
    }
    
    public boolean isCancelled()
    {
      return false;
    }
    
    public boolean isDone()
    {
      return true;
    }
  }
  
  private static class ImmediateSuccessfulFuture<V>
    extends Futures.ImmediateFuture<V>
  {
    @Nullable
    private final V value;
    
    ImmediateSuccessfulFuture(@Nullable V value)
    {
      super();
      this.value = value;
    }
    
    public V get()
    {
      return (V)value;
    }
  }
  
  private static class ImmediateSuccessfulCheckedFuture<V, X extends Exception>
    extends Futures.ImmediateFuture<V>
    implements CheckedFuture<V, X>
  {
    @Nullable
    private final V value;
    
    ImmediateSuccessfulCheckedFuture(@Nullable V value)
    {
      super();
      this.value = value;
    }
    
    public V get()
    {
      return (V)value;
    }
    
    public V checkedGet()
    {
      return (V)value;
    }
    
    public V checkedGet(long timeout, TimeUnit unit)
    {
      Preconditions.checkNotNull(unit);
      return (V)value;
    }
  }
  
  private static class ImmediateFailedFuture<V>
    extends Futures.ImmediateFuture<V>
  {
    private final Throwable thrown;
    
    ImmediateFailedFuture(Throwable thrown)
    {
      super();
      this.thrown = thrown;
    }
    
    public V get()
      throws ExecutionException
    {
      throw new ExecutionException(thrown);
    }
  }
  
  private static class ImmediateCancelledFuture<V>
    extends Futures.ImmediateFuture<V>
  {
    private final CancellationException thrown;
    
    ImmediateCancelledFuture()
    {
      super();
      thrown = new CancellationException("Immediate cancelled future.");
    }
    
    public boolean isCancelled()
    {
      return true;
    }
    
    public V get()
    {
      throw AbstractFuture.cancellationExceptionWithCause("Task was cancelled.", thrown);
    }
  }
  
  private static class ImmediateFailedCheckedFuture<V, X extends Exception>
    extends Futures.ImmediateFuture<V>
    implements CheckedFuture<V, X>
  {
    private final X thrown;
    
    ImmediateFailedCheckedFuture(X thrown)
    {
      super();
      this.thrown = thrown;
    }
    
    public V get()
      throws ExecutionException
    {
      throw new ExecutionException(thrown);
    }
    
    public V checkedGet()
      throws Exception
    {
      throw thrown;
    }
    
    public V checkedGet(long timeout, TimeUnit unit)
      throws Exception
    {
      Preconditions.checkNotNull(unit);
      throw thrown;
    }
  }
  
  public static <V> ListenableFuture<V> immediateFuture(@Nullable V value)
  {
    return new ImmediateSuccessfulFuture(value);
  }
  
  public static <V, X extends Exception> CheckedFuture<V, X> immediateCheckedFuture(@Nullable V value)
  {
    return new ImmediateSuccessfulCheckedFuture(value);
  }
  
  public static <V> ListenableFuture<V> immediateFailedFuture(Throwable throwable)
  {
    Preconditions.checkNotNull(throwable);
    return new ImmediateFailedFuture(throwable);
  }
  
  public static <V> ListenableFuture<V> immediateCancelledFuture()
  {
    return new ImmediateCancelledFuture();
  }
  
  public static <V, X extends Exception> CheckedFuture<V, X> immediateFailedCheckedFuture(X exception)
  {
    Preconditions.checkNotNull(exception);
    return new ImmediateFailedCheckedFuture(exception);
  }
  
  public static <V> ListenableFuture<V> withFallback(ListenableFuture<? extends V> input, FutureFallback<? extends V> fallback)
  {
    return withFallback(input, fallback, MoreExecutors.directExecutor());
  }
  
  public static <V> ListenableFuture<V> withFallback(ListenableFuture<? extends V> input, FutureFallback<? extends V> fallback, Executor executor)
  {
    Preconditions.checkNotNull(fallback);
    return new FallbackFuture(input, fallback, executor);
  }
  
  private static class FallbackFuture<V>
    extends AbstractFuture<V>
  {
    private volatile ListenableFuture<? extends V> running;
    
    FallbackFuture(ListenableFuture<? extends V> input, final FutureFallback<? extends V> fallback, Executor executor)
    {
      running = input;
      Futures.addCallback(running, new FutureCallback()
      {
        public void onSuccess(V value)
        {
          set(value);
        }
        
        public void onFailure(Throwable t)
        {
          if (isCancelled()) {
            return;
          }
          try
          {
            running = fallback.create(t);
            if (isCancelled())
            {
              running.cancel(wasInterrupted());
              return;
            }
            Futures.addCallback(running, new FutureCallback()
            {
              public void onSuccess(V value)
              {
                set(value);
              }
              
              public void onFailure(Throwable t)
              {
                if (running.isCancelled()) {
                  cancel(false);
                } else {
                  setException(t);
                }
              }
            }, MoreExecutors.directExecutor());
          }
          catch (Throwable e)
          {
            setException(e);
          }
        }
      }, executor);
    }
    
    public boolean cancel(boolean mayInterruptIfRunning)
    {
      if (super.cancel(mayInterruptIfRunning))
      {
        running.cancel(mayInterruptIfRunning);
        return true;
      }
      return false;
    }
  }
  
  public static <I, O> ListenableFuture<O> transform(ListenableFuture<I> input, AsyncFunction<? super I, ? extends O> function)
  {
    ChainingListenableFuture<I, O> output = new ChainingListenableFuture(function, input, null);
    
    input.addListener(output, MoreExecutors.directExecutor());
    return output;
  }
  
  public static <I, O> ListenableFuture<O> transform(ListenableFuture<I> input, AsyncFunction<? super I, ? extends O> function, Executor executor)
  {
    Preconditions.checkNotNull(executor);
    ChainingListenableFuture<I, O> output = new ChainingListenableFuture(function, input, null);
    
    input.addListener(rejectionPropagatingRunnable(output, output, executor), MoreExecutors.directExecutor());
    return output;
  }
  
  private static Runnable rejectionPropagatingRunnable(final AbstractFuture<?> outputFuture, final Runnable delegateTask, Executor delegateExecutor)
  {
    new Runnable()
    {
      public void run()
      {
        final AtomicBoolean thrownFromDelegate = new AtomicBoolean(true);
        try
        {
          val$delegateExecutor.execute(new Runnable()
          {
            public void run()
            {
              thrownFromDelegate.set(false);
              val$delegateTask.run();
            }
          });
        }
        catch (RejectedExecutionException e)
        {
          if (thrownFromDelegate.get()) {
            outputFuture.setException(e);
          }
        }
      }
    };
  }
  
  public static <I, O> ListenableFuture<O> transform(ListenableFuture<I> input, Function<? super I, ? extends O> function)
  {
    Preconditions.checkNotNull(function);
    ChainingListenableFuture<I, O> output = new ChainingListenableFuture(asAsyncFunction(function), input, null);
    
    input.addListener(output, MoreExecutors.directExecutor());
    return output;
  }
  
  public static <I, O> ListenableFuture<O> transform(ListenableFuture<I> input, Function<? super I, ? extends O> function, Executor executor)
  {
    Preconditions.checkNotNull(function);
    return transform(input, asAsyncFunction(function), executor);
  }
  
  private static <I, O> AsyncFunction<I, O> asAsyncFunction(Function<? super I, ? extends O> function)
  {
    new AsyncFunction()
    {
      public ListenableFuture<O> apply(I input)
      {
        O output = val$function.apply(input);
        return Futures.immediateFuture(output);
      }
    };
  }
  
  public static <I, O> Future<O> lazyTransform(Future<I> input, final Function<? super I, ? extends O> function)
  {
    Preconditions.checkNotNull(input);
    Preconditions.checkNotNull(function);
    new Future()
    {
      public boolean cancel(boolean mayInterruptIfRunning)
      {
        return val$input.cancel(mayInterruptIfRunning);
      }
      
      public boolean isCancelled()
      {
        return val$input.isCancelled();
      }
      
      public boolean isDone()
      {
        return val$input.isDone();
      }
      
      public O get()
        throws InterruptedException, ExecutionException
      {
        return (O)applyTransformation(val$input.get());
      }
      
      public O get(long timeout, TimeUnit unit)
        throws InterruptedException, ExecutionException, TimeoutException
      {
        return (O)applyTransformation(val$input.get(timeout, unit));
      }
      
      private O applyTransformation(I input)
        throws ExecutionException
      {
        try
        {
          return (O)function.apply(input);
        }
        catch (Throwable t)
        {
          throw new ExecutionException(t);
        }
      }
    };
  }
  
  private static class ChainingListenableFuture<I, O>
    extends AbstractFuture<O>
    implements Runnable
  {
    private AsyncFunction<? super I, ? extends O> function;
    private ListenableFuture<? extends I> inputFuture;
    private volatile ListenableFuture<? extends O> outputFuture;
    
    private ChainingListenableFuture(AsyncFunction<? super I, ? extends O> function, ListenableFuture<? extends I> inputFuture)
    {
      this.function = ((AsyncFunction)Preconditions.checkNotNull(function));
      this.inputFuture = ((ListenableFuture)Preconditions.checkNotNull(inputFuture));
    }
    
    public boolean cancel(boolean mayInterruptIfRunning)
    {
      if (super.cancel(mayInterruptIfRunning))
      {
        cancel(inputFuture, mayInterruptIfRunning);
        cancel(outputFuture, mayInterruptIfRunning);
        return true;
      }
      return false;
    }
    
    private void cancel(@Nullable Future<?> future, boolean mayInterruptIfRunning)
    {
      if (future != null) {
        future.cancel(mayInterruptIfRunning);
      }
    }
    
    public void run()
    {
      try
      {
        I sourceResult;
        try
        {
          sourceResult = Uninterruptibles.getUninterruptibly(inputFuture);
        }
        catch (CancellationException e)
        {
          cancel(false); return;
        }
        catch (ExecutionException e)
        {
          setException(e.getCause()); return;
        }
        final ListenableFuture<? extends O> outputFuture = this.outputFuture = (ListenableFuture)Preconditions.checkNotNull(function.apply(sourceResult), "AsyncFunction may not return null.");
        if (isCancelled())
        {
          outputFuture.cancel(wasInterrupted());
          this.outputFuture = null;
        }
        else
        {
          outputFuture.addListener(new Runnable()
          {
            public void run()
            {
              try
              {
                set(Uninterruptibles.getUninterruptibly(outputFuture));
              }
              catch (CancellationException e)
              {
                cancel(false);
              }
              catch (ExecutionException e)
              {
                setException(e.getCause());
              }
              finally
              {
                outputFuture = null;
              }
            }
          }, MoreExecutors.directExecutor());
        }
      }
      catch (UndeclaredThrowableException e)
      {
        setException(e.getCause());
      }
      catch (Throwable t)
      {
        setException(t);
      }
      finally
      {
        function = null;
        inputFuture = null;
      }
    }
  }
  
  public static <V> ListenableFuture<V> dereference(ListenableFuture<? extends ListenableFuture<? extends V>> nested)
  {
    return transform(nested, DEREFERENCER);
  }
  
  private static final AsyncFunction<ListenableFuture<Object>, Object> DEREFERENCER = new AsyncFunction()
  {
    public ListenableFuture<Object> apply(ListenableFuture<Object> input)
    {
      return input;
    }
  };
  
  @Beta
  public static <V> ListenableFuture<List<V>> allAsList(ListenableFuture<? extends V>... futures)
  {
    return listFuture(ImmutableList.copyOf(futures), true, MoreExecutors.directExecutor());
  }
  
  @Beta
  public static <V> ListenableFuture<List<V>> allAsList(Iterable<? extends ListenableFuture<? extends V>> futures)
  {
    return listFuture(ImmutableList.copyOf(futures), true, MoreExecutors.directExecutor());
  }
  
  private static final class WrappedCombiner<T>
    implements Callable<T>
  {
    final Callable<T> delegate;
    Futures.CombinerFuture<T> outputFuture;
    
    WrappedCombiner(Callable<T> delegate)
    {
      this.delegate = ((Callable)Preconditions.checkNotNull(delegate));
    }
    
    public T call()
      throws Exception
    {
      try
      {
        return (T)delegate.call();
      }
      catch (ExecutionException e)
      {
        outputFuture.setException(e.getCause());
      }
      catch (CancellationException e)
      {
        outputFuture.cancel(false);
      }
      return null;
    }
  }
  
  private static final class CombinerFuture<V>
    extends ListenableFutureTask<V>
  {
    ImmutableList<ListenableFuture<?>> futures;
    
    CombinerFuture(Callable<V> callable, ImmutableList<ListenableFuture<?>> futures)
    {
      super();
      this.futures = futures;
    }
    
    public boolean cancel(boolean mayInterruptIfRunning)
    {
      ImmutableList<ListenableFuture<?>> futures = this.futures;
      if (super.cancel(mayInterruptIfRunning))
      {
        for (ListenableFuture<?> future : futures) {
          future.cancel(mayInterruptIfRunning);
        }
        return true;
      }
      return false;
    }
    
    protected void done()
    {
      super.done();
      futures = null;
    }
    
    protected void setException(Throwable t)
    {
      super.setException(t);
    }
  }
  
  public static <V> ListenableFuture<V> nonCancellationPropagating(ListenableFuture<V> future)
  {
    return new NonCancellationPropagatingFuture(future);
  }
  
  private static class NonCancellationPropagatingFuture<V>
    extends AbstractFuture<V>
  {
    NonCancellationPropagatingFuture(final ListenableFuture<V> delegate)
    {
      Preconditions.checkNotNull(delegate);
      Futures.addCallback(delegate, new FutureCallback()
      {
        public void onSuccess(V result)
        {
          set(result);
        }
        
        public void onFailure(Throwable t)
        {
          if (delegate.isCancelled()) {
            cancel(false);
          } else {
            setException(t);
          }
        }
      }, MoreExecutors.directExecutor());
    }
  }
  
  @Beta
  public static <V> ListenableFuture<List<V>> successfulAsList(ListenableFuture<? extends V>... futures)
  {
    return listFuture(ImmutableList.copyOf(futures), false, MoreExecutors.directExecutor());
  }
  
  @Beta
  public static <V> ListenableFuture<List<V>> successfulAsList(Iterable<? extends ListenableFuture<? extends V>> futures)
  {
    return listFuture(ImmutableList.copyOf(futures), false, MoreExecutors.directExecutor());
  }
  
  @Beta
  public static <T> ImmutableList<ListenableFuture<T>> inCompletionOrder(Iterable<? extends ListenableFuture<? extends T>> futures)
  {
    ConcurrentLinkedQueue<AsyncSettableFuture<T>> delegates = Queues.newConcurrentLinkedQueue();
    
    ImmutableList.Builder<ListenableFuture<T>> listBuilder = ImmutableList.builder();
    
    SerializingExecutor executor = new SerializingExecutor(MoreExecutors.directExecutor());
    for (final ListenableFuture<? extends T> future : futures)
    {
      AsyncSettableFuture<T> delegate = AsyncSettableFuture.create();
      
      delegates.add(delegate);
      future.addListener(new Runnable()
      {
        public void run()
        {
          ((AsyncSettableFuture)val$delegates.remove()).setFuture(future);
        }
      }, executor);
      
      listBuilder.add(delegate);
    }
    return listBuilder.build();
  }
  
  public static <V> void addCallback(ListenableFuture<V> future, FutureCallback<? super V> callback)
  {
    addCallback(future, callback, MoreExecutors.directExecutor());
  }
  
  public static <V> void addCallback(ListenableFuture<V> future, final FutureCallback<? super V> callback, Executor executor)
  {
    Preconditions.checkNotNull(callback);
    Runnable callbackListener = new Runnable()
    {
      public void run()
      {
        V value;
        try
        {
          value = Uninterruptibles.getUninterruptibly(val$future);
        }
        catch (ExecutionException e)
        {
          callback.onFailure(e.getCause());
          return;
        }
        catch (RuntimeException e)
        {
          callback.onFailure(e);
          return;
        }
        catch (Error e)
        {
          callback.onFailure(e);
          return;
        }
        callback.onSuccess(value);
      }
    };
    future.addListener(callbackListener, executor);
  }
  
  public static <V, X extends Exception> V get(Future<V> future, Class<X> exceptionClass)
    throws Exception
  {
    Preconditions.checkNotNull(future);
    Preconditions.checkArgument(!RuntimeException.class.isAssignableFrom(exceptionClass), "Futures.get exception type (%s) must not be a RuntimeException", new Object[] { exceptionClass });
    try
    {
      return (V)future.get();
    }
    catch (InterruptedException e)
    {
      Thread.currentThread().interrupt();
      throw newWithCause(exceptionClass, e);
    }
    catch (ExecutionException e)
    {
      wrapAndThrowExceptionOrError(e.getCause(), exceptionClass);
      throw new AssertionError();
    }
  }
  
  public static <V, X extends Exception> V get(Future<V> future, long timeout, TimeUnit unit, Class<X> exceptionClass)
    throws Exception
  {
    Preconditions.checkNotNull(future);
    Preconditions.checkNotNull(unit);
    Preconditions.checkArgument(!RuntimeException.class.isAssignableFrom(exceptionClass), "Futures.get exception type (%s) must not be a RuntimeException", new Object[] { exceptionClass });
    try
    {
      return (V)future.get(timeout, unit);
    }
    catch (InterruptedException e)
    {
      Thread.currentThread().interrupt();
      throw newWithCause(exceptionClass, e);
    }
    catch (TimeoutException e)
    {
      throw newWithCause(exceptionClass, e);
    }
    catch (ExecutionException e)
    {
      wrapAndThrowExceptionOrError(e.getCause(), exceptionClass);
      throw new AssertionError();
    }
  }
  
  private static <X extends Exception> void wrapAndThrowExceptionOrError(Throwable cause, Class<X> exceptionClass)
    throws Exception
  {
    if ((cause instanceof Error)) {
      throw new ExecutionError((Error)cause);
    }
    if ((cause instanceof RuntimeException)) {
      throw new UncheckedExecutionException(cause);
    }
    throw newWithCause(exceptionClass, cause);
  }
  
  public static <V> V getUnchecked(Future<V> future)
  {
    Preconditions.checkNotNull(future);
    try
    {
      return (V)Uninterruptibles.getUninterruptibly(future);
    }
    catch (ExecutionException e)
    {
      wrapAndThrowUnchecked(e.getCause());
      throw new AssertionError();
    }
  }
  
  private static void wrapAndThrowUnchecked(Throwable cause)
  {
    if ((cause instanceof Error)) {
      throw new ExecutionError((Error)cause);
    }
    throw new UncheckedExecutionException(cause);
  }
  
  private static <X extends Exception> X newWithCause(Class<X> exceptionClass, Throwable cause)
  {
    List<Constructor<X>> constructors = Arrays.asList(exceptionClass.getConstructors());
    for (Constructor<X> constructor : preferringStrings(constructors))
    {
      X instance = (Exception)newFromConstructor(constructor, cause);
      if (instance != null)
      {
        if (instance.getCause() == null) {
          instance.initCause(cause);
        }
        return instance;
      }
    }
    ??? = String.valueOf(String.valueOf(exceptionClass));throw new IllegalArgumentException(82 + ???.length() + "No appropriate constructor for exception of type " + ??? + " in response to chained exception", cause);
  }
  
  private static <X extends Exception> List<Constructor<X>> preferringStrings(List<Constructor<X>> constructors)
  {
    return WITH_STRING_PARAM_FIRST.sortedCopy(constructors);
  }
  
  private static final Ordering<Constructor<?>> WITH_STRING_PARAM_FIRST = Ordering.natural().onResultOf(new Function()
  {
    public Boolean apply(Constructor<?> input)
    {
      return Boolean.valueOf(Arrays.asList(input.getParameterTypes()).contains(String.class));
    }
  }).reverse();
  
  @Nullable
  private static <X> X newFromConstructor(Constructor<X> constructor, Throwable cause)
  {
    Class<?>[] paramTypes = constructor.getParameterTypes();
    Object[] params = new Object[paramTypes.length];
    for (int i = 0; i < paramTypes.length; i++)
    {
      Class<?> paramType = paramTypes[i];
      if (paramType.equals(String.class)) {
        params[i] = cause.toString();
      } else if (paramType.equals(Throwable.class)) {
        params[i] = cause;
      } else {
        return null;
      }
    }
    try
    {
      return (X)constructor.newInstance(params);
    }
    catch (IllegalArgumentException e)
    {
      return null;
    }
    catch (InstantiationException e)
    {
      return null;
    }
    catch (IllegalAccessException e)
    {
      return null;
    }
    catch (InvocationTargetException e) {}
    return null;
  }
  
  private static abstract interface FutureCombiner<V, C>
  {
    public abstract C combine(List<Optional<V>> paramList);
  }
  
  private static class CombinedFuture<V, C>
    extends AbstractFuture<C>
  {
    private static final Logger logger = Logger.getLogger(CombinedFuture.class.getName());
    ImmutableCollection<? extends ListenableFuture<? extends V>> futures;
    final boolean allMustSucceed;
    final AtomicInteger remaining;
    Futures.FutureCombiner<V, C> combiner;
    List<Optional<V>> values;
    final Object seenExceptionsLock = new Object();
    Set<Throwable> seenExceptions;
    
    CombinedFuture(ImmutableCollection<? extends ListenableFuture<? extends V>> futures, boolean allMustSucceed, Executor listenerExecutor, Futures.FutureCombiner<V, C> combiner)
    {
      this.futures = futures;
      this.allMustSucceed = allMustSucceed;
      remaining = new AtomicInteger(futures.size());
      this.combiner = combiner;
      values = Lists.newArrayListWithCapacity(futures.size());
      init(listenerExecutor);
    }
    
    protected void init(Executor listenerExecutor)
    {
      addListener(new Runnable()
      {
        public void run()
        {
          if (isCancelled()) {
            for (ListenableFuture<?> future : futures) {
              future.cancel(wasInterrupted());
            }
          }
          futures = null;
          
          values = null;
          
          combiner = null;
        }
      }, MoreExecutors.directExecutor());
      if (futures.isEmpty())
      {
        set(combiner.combine(ImmutableList.of()));
        return;
      }
      for (int i = 0; i < futures.size(); i++) {
        values.add(null);
      }
      int i = 0;
      for (final ListenableFuture<? extends V> listenable : futures)
      {
        final int index = i++;
        listenable.addListener(new Runnable()
        {
          public void run()
          {
            Futures.CombinedFuture.this.setOneValue(index, listenable);
          }
        }, listenerExecutor);
      }
    }
    
    private void setExceptionAndMaybeLog(Throwable throwable)
    {
      boolean visibleFromOutputFuture = false;
      boolean firstTimeSeeingThisException = true;
      if (allMustSucceed)
      {
        visibleFromOutputFuture = super.setException(throwable);
        synchronized (seenExceptionsLock)
        {
          if (seenExceptions == null) {
            seenExceptions = Sets.newHashSet();
          }
          firstTimeSeeingThisException = seenExceptions.add(throwable);
        }
      }
      if (((throwable instanceof Error)) || ((allMustSucceed) && (!visibleFromOutputFuture) && (firstTimeSeeingThisException))) {
        logger.log(Level.SEVERE, "input future failed.", throwable);
      }
    }
    
    private void setOneValue(int index, Future<? extends V> future)
    {
      List<Optional<V>> localValues = values;
      if ((isDone()) || (localValues == null)) {
        Preconditions.checkState((allMustSucceed) || (isCancelled()), "Future was done before all dependencies completed");
      }
      try
      {
        Preconditions.checkState(future.isDone(), "Tried to set value from future which is not done");
        
        V returnValue = Uninterruptibles.getUninterruptibly(future);
        if (localValues != null) {
          localValues.set(index, Optional.fromNullable(returnValue));
        }
      }
      catch (CancellationException e)
      {
        int newRemaining;
        Futures.FutureCombiner<V, C> localCombiner;
        if (allMustSucceed) {
          cancel(false);
        }
      }
      catch (ExecutionException e)
      {
        int newRemaining;
        Futures.FutureCombiner<V, C> localCombiner;
        setExceptionAndMaybeLog(e.getCause());
      }
      catch (Throwable t)
      {
        int newRemaining;
        Futures.FutureCombiner<V, C> localCombiner;
        setExceptionAndMaybeLog(t);
      }
      finally
      {
        int newRemaining;
        Futures.FutureCombiner<V, C> localCombiner;
        int newRemaining = remaining.decrementAndGet();
        Preconditions.checkState(newRemaining >= 0, "Less than 0 remaining futures");
        if (newRemaining == 0)
        {
          Futures.FutureCombiner<V, C> localCombiner = combiner;
          if ((localCombiner != null) && (localValues != null)) {
            set(localCombiner.combine(localValues));
          } else {
            Preconditions.checkState(isDone());
          }
        }
      }
    }
  }
  
  private static <V> ListenableFuture<List<V>> listFuture(ImmutableList<ListenableFuture<? extends V>> futures, boolean allMustSucceed, Executor listenerExecutor)
  {
    new CombinedFuture(futures, allMustSucceed, listenerExecutor, new FutureCombiner()
    {
      public List<V> combine(List<Optional<V>> values)
      {
        List<V> result = Lists.newArrayList();
        for (Optional<V> element : values) {
          result.add(element != null ? element.orNull() : null);
        }
        return Collections.unmodifiableList(result);
      }
    });
  }
  
  private static class MappingCheckedFuture<V, X extends Exception>
    extends AbstractCheckedFuture<V, X>
  {
    final Function<? super Exception, X> mapper;
    
    MappingCheckedFuture(ListenableFuture<V> delegate, Function<? super Exception, X> mapper)
    {
      super();
      
      this.mapper = ((Function)Preconditions.checkNotNull(mapper));
    }
    
    protected X mapException(Exception e)
    {
      return (Exception)mapper.apply(e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.Futures
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */