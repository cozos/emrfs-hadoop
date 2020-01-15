package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import java.util.Collections;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
final class Absent<T>
  extends Optional<T>
{
  static final Absent<Object> INSTANCE = new Absent();
  private static final long serialVersionUID = 0L;
  
  static <T> Optional<T> withType()
  {
    return INSTANCE;
  }
  
  public boolean isPresent()
  {
    return false;
  }
  
  public T get()
  {
    throw new IllegalStateException("Optional.get() cannot be called on an absent value");
  }
  
  public T or(T defaultValue)
  {
    return (T)Preconditions.checkNotNull(defaultValue, "use Optional.orNull() instead of Optional.or(null)");
  }
  
  public Optional<T> or(Optional<? extends T> secondChoice)
  {
    return (Optional)Preconditions.checkNotNull(secondChoice);
  }
  
  public T or(Supplier<? extends T> supplier)
  {
    return (T)Preconditions.checkNotNull(supplier.get(), "use Optional.orNull() instead of a Supplier that returns null");
  }
  
  @Nullable
  public T orNull()
  {
    return null;
  }
  
  public Set<T> asSet()
  {
    return Collections.emptySet();
  }
  
  public <V> Optional<V> transform(Function<? super T, V> function)
  {
    Preconditions.checkNotNull(function);
    return Optional.absent();
  }
  
  public boolean equals(@Nullable Object object)
  {
    return object == this;
  }
  
  public int hashCode()
  {
    return 1502476572;
  }
  
  public String toString()
  {
    return "Optional.absent()";
  }
  
  private Object readResolve()
  {
    return INSTANCE;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Absent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */