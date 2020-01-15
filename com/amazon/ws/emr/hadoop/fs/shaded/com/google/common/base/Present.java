package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import java.util.Collections;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
final class Present<T>
  extends Optional<T>
{
  private final T reference;
  private static final long serialVersionUID = 0L;
  
  Present(T reference)
  {
    this.reference = reference;
  }
  
  public boolean isPresent()
  {
    return true;
  }
  
  public T get()
  {
    return (T)reference;
  }
  
  public T or(T defaultValue)
  {
    Preconditions.checkNotNull(defaultValue, "use Optional.orNull() instead of Optional.or(null)");
    return (T)reference;
  }
  
  public Optional<T> or(Optional<? extends T> secondChoice)
  {
    Preconditions.checkNotNull(secondChoice);
    return this;
  }
  
  public T or(Supplier<? extends T> supplier)
  {
    Preconditions.checkNotNull(supplier);
    return (T)reference;
  }
  
  public T orNull()
  {
    return (T)reference;
  }
  
  public Set<T> asSet()
  {
    return Collections.singleton(reference);
  }
  
  public <V> Optional<V> transform(Function<? super T, V> function)
  {
    return new Present(Preconditions.checkNotNull(function.apply(reference), "the Function passed to Optional.transform() must not return null."));
  }
  
  public boolean equals(@Nullable Object object)
  {
    if ((object instanceof Present))
    {
      Present<?> other = (Present)object;
      return reference.equals(reference);
    }
    return false;
  }
  
  public int hashCode()
  {
    return 1502476572 + reference.hashCode();
  }
  
  public String toString()
  {
    String str = String.valueOf(String.valueOf(reference));return 13 + str.length() + "Optional.of(" + str + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Present
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */