package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true)
public abstract class Optional<T>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  
  public static <T> Optional<T> absent()
  {
    return Absent.withType();
  }
  
  public static <T> Optional<T> of(T reference)
  {
    return new Present(Preconditions.checkNotNull(reference));
  }
  
  public static <T> Optional<T> fromNullable(@Nullable T nullableReference)
  {
    return nullableReference == null ? absent() : new Present(nullableReference);
  }
  
  public abstract boolean isPresent();
  
  public abstract T get();
  
  public abstract T or(T paramT);
  
  public abstract Optional<T> or(Optional<? extends T> paramOptional);
  
  @Beta
  public abstract T or(Supplier<? extends T> paramSupplier);
  
  @Nullable
  public abstract T orNull();
  
  public abstract Set<T> asSet();
  
  public abstract <V> Optional<V> transform(Function<? super T, V> paramFunction);
  
  public abstract boolean equals(@Nullable Object paramObject);
  
  public abstract int hashCode();
  
  public abstract String toString();
  
  @Beta
  public static <T> Iterable<T> presentInstances(Iterable<? extends Optional<? extends T>> optionals)
  {
    Preconditions.checkNotNull(optionals);
    new Iterable()
    {
      public Iterator<T> iterator()
      {
        new AbstractIterator()
        {
          private final Iterator<? extends Optional<? extends T>> iterator = (Iterator)Preconditions.checkNotNull(val$optionals.iterator());
          
          protected T computeNext()
          {
            while (iterator.hasNext())
            {
              Optional<? extends T> optional = (Optional)iterator.next();
              if (optional.isPresent()) {
                return (T)optional.get();
              }
            }
            return (T)endOfData();
          }
        };
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Optional
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */