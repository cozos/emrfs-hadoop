package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

@GwtCompatible
public final class Suppliers
{
  public static <F, T> Supplier<T> compose(Function<? super F, T> function, Supplier<F> supplier)
  {
    Preconditions.checkNotNull(function);
    Preconditions.checkNotNull(supplier);
    return new SupplierComposition(function, supplier);
  }
  
  private static class SupplierComposition<F, T>
    implements Supplier<T>, Serializable
  {
    final Function<? super F, T> function;
    final Supplier<F> supplier;
    private static final long serialVersionUID = 0L;
    
    SupplierComposition(Function<? super F, T> function, Supplier<F> supplier)
    {
      this.function = function;
      this.supplier = supplier;
    }
    
    public T get()
    {
      return (T)function.apply(supplier.get());
    }
    
    public boolean equals(@Nullable Object obj)
    {
      if ((obj instanceof SupplierComposition))
      {
        SupplierComposition<?, ?> that = (SupplierComposition)obj;
        return (function.equals(function)) && (supplier.equals(supplier));
      }
      return false;
    }
    
    public int hashCode()
    {
      return Objects.hashCode(new Object[] { function, supplier });
    }
    
    public String toString()
    {
      String str1 = String.valueOf(String.valueOf(function));String str2 = String.valueOf(String.valueOf(supplier));return 21 + str1.length() + str2.length() + "Suppliers.compose(" + str1 + ", " + str2 + ")";
    }
  }
  
  public static <T> Supplier<T> memoize(Supplier<T> delegate)
  {
    return (delegate instanceof MemoizingSupplier) ? delegate : new MemoizingSupplier((Supplier)Preconditions.checkNotNull(delegate));
  }
  
  @VisibleForTesting
  static class MemoizingSupplier<T>
    implements Supplier<T>, Serializable
  {
    final Supplier<T> delegate;
    volatile transient boolean initialized;
    transient T value;
    private static final long serialVersionUID = 0L;
    
    MemoizingSupplier(Supplier<T> delegate)
    {
      this.delegate = delegate;
    }
    
    public T get()
    {
      if (!initialized) {
        synchronized (this)
        {
          if (!initialized)
          {
            T t = delegate.get();
            value = t;
            initialized = true;
            return t;
          }
        }
      }
      return (T)value;
    }
    
    public String toString()
    {
      String str = String.valueOf(String.valueOf(delegate));return 19 + str.length() + "Suppliers.memoize(" + str + ")";
    }
  }
  
  public static <T> Supplier<T> memoizeWithExpiration(Supplier<T> delegate, long duration, TimeUnit unit)
  {
    return new ExpiringMemoizingSupplier(delegate, duration, unit);
  }
  
  @VisibleForTesting
  static class ExpiringMemoizingSupplier<T>
    implements Supplier<T>, Serializable
  {
    final Supplier<T> delegate;
    final long durationNanos;
    volatile transient T value;
    volatile transient long expirationNanos;
    private static final long serialVersionUID = 0L;
    
    ExpiringMemoizingSupplier(Supplier<T> delegate, long duration, TimeUnit unit)
    {
      this.delegate = ((Supplier)Preconditions.checkNotNull(delegate));
      durationNanos = unit.toNanos(duration);
      Preconditions.checkArgument(duration > 0L);
    }
    
    public T get()
    {
      long nanos = expirationNanos;
      long now = Platform.systemNanoTime();
      if ((nanos == 0L) || (now - nanos >= 0L)) {
        synchronized (this)
        {
          if (nanos == expirationNanos)
          {
            T t = delegate.get();
            value = t;
            nanos = now + durationNanos;
            
            expirationNanos = (nanos == 0L ? 1L : nanos);
            return t;
          }
        }
      }
      return (T)value;
    }
    
    public String toString()
    {
      String str = String.valueOf(String.valueOf(delegate));long l = durationNanos;return 62 + str.length() + "Suppliers.memoizeWithExpiration(" + str + ", " + l + ", NANOS)";
    }
  }
  
  public static <T> Supplier<T> ofInstance(@Nullable T instance)
  {
    return new SupplierOfInstance(instance);
  }
  
  private static class SupplierOfInstance<T>
    implements Supplier<T>, Serializable
  {
    final T instance;
    private static final long serialVersionUID = 0L;
    
    SupplierOfInstance(@Nullable T instance)
    {
      this.instance = instance;
    }
    
    public T get()
    {
      return (T)instance;
    }
    
    public boolean equals(@Nullable Object obj)
    {
      if ((obj instanceof SupplierOfInstance))
      {
        SupplierOfInstance<?> that = (SupplierOfInstance)obj;
        return Objects.equal(instance, instance);
      }
      return false;
    }
    
    public int hashCode()
    {
      return Objects.hashCode(new Object[] { instance });
    }
    
    public String toString()
    {
      String str = String.valueOf(String.valueOf(instance));return 22 + str.length() + "Suppliers.ofInstance(" + str + ")";
    }
  }
  
  public static <T> Supplier<T> synchronizedSupplier(Supplier<T> delegate)
  {
    return new ThreadSafeSupplier((Supplier)Preconditions.checkNotNull(delegate));
  }
  
  private static class ThreadSafeSupplier<T>
    implements Supplier<T>, Serializable
  {
    final Supplier<T> delegate;
    private static final long serialVersionUID = 0L;
    
    ThreadSafeSupplier(Supplier<T> delegate)
    {
      this.delegate = delegate;
    }
    
    /* Error */
    public T get()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 27	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/base/Suppliers$ThreadSafeSupplier:delegate	Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/base/Supplier;
      //   4: dup
      //   5: astore_1
      //   6: monitorenter
      //   7: aload_0
      //   8: getfield 27	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/base/Suppliers$ThreadSafeSupplier:delegate	Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/base/Supplier;
      //   11: invokeinterface 34 1 0
      //   16: aload_1
      //   17: monitorexit
      //   18: areturn
      //   19: astore_2
      //   20: aload_1
      //   21: monitorexit
      //   22: aload_2
      //   23: athrow
      // Line number table:
      //   Java source line #270	-> byte code offset #0
      //   Java source line #271	-> byte code offset #7
      //   Java source line #272	-> byte code offset #19
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	24	0	this	ThreadSafeSupplier<T>
      //   5	16	1	Ljava/lang/Object;	Object
      //   19	4	2	localObject1	Object
      // Exception table:
      //   from	to	target	type
      //   7	18	19	finally
      //   19	22	19	finally
    }
    
    public String toString()
    {
      String str = String.valueOf(String.valueOf(delegate));return 32 + str.length() + "Suppliers.synchronizedSupplier(" + str + ")";
    }
  }
  
  @Beta
  public static <T> Function<Supplier<T>, T> supplierFunction()
  {
    SupplierFunction<T> sf = SupplierFunctionImpl.INSTANCE;
    return sf;
  }
  
  private static abstract interface SupplierFunction<T>
    extends Function<Supplier<T>, T>
  {}
  
  private static enum SupplierFunctionImpl
    implements Suppliers.SupplierFunction<Object>
  {
    INSTANCE;
    
    private SupplierFunctionImpl() {}
    
    public Object apply(Supplier<Object> input)
    {
      return input.get();
    }
    
    public String toString()
    {
      return "Suppliers.supplierFunction()";
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Suppliers
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */