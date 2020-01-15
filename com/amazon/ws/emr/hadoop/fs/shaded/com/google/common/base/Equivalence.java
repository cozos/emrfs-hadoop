package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class Equivalence<T>
{
  public final boolean equivalent(@Nullable T a, @Nullable T b)
  {
    if (a == b) {
      return true;
    }
    if ((a == null) || (b == null)) {
      return false;
    }
    return doEquivalent(a, b);
  }
  
  protected abstract boolean doEquivalent(T paramT1, T paramT2);
  
  public final int hash(@Nullable T t)
  {
    if (t == null) {
      return 0;
    }
    return doHash(t);
  }
  
  protected abstract int doHash(T paramT);
  
  public final <F> Equivalence<F> onResultOf(Function<F, ? extends T> function)
  {
    return new FunctionalEquivalence(function, this);
  }
  
  public final <S extends T> Wrapper<S> wrap(@Nullable S reference)
  {
    return new Wrapper(this, reference, null);
  }
  
  public static final class Wrapper<T>
    implements Serializable
  {
    private final Equivalence<? super T> equivalence;
    @Nullable
    private final T reference;
    private static final long serialVersionUID = 0L;
    
    private Wrapper(Equivalence<? super T> equivalence, @Nullable T reference)
    {
      this.equivalence = ((Equivalence)Preconditions.checkNotNull(equivalence));
      this.reference = reference;
    }
    
    @Nullable
    public T get()
    {
      return (T)reference;
    }
    
    public boolean equals(@Nullable Object obj)
    {
      if (obj == this) {
        return true;
      }
      if ((obj instanceof Wrapper))
      {
        Wrapper<?> that = (Wrapper)obj;
        if (this.equivalence.equals(equivalence))
        {
          Equivalence<Object> equivalence = this.equivalence;
          return equivalence.equivalent(reference, reference);
        }
      }
      return false;
    }
    
    public int hashCode()
    {
      return equivalence.hash(reference);
    }
    
    public String toString()
    {
      String str1 = String.valueOf(String.valueOf(equivalence));String str2 = String.valueOf(String.valueOf(reference));return 7 + str1.length() + str2.length() + str1 + ".wrap(" + str2 + ")";
    }
  }
  
  @GwtCompatible(serializable=true)
  public final <S extends T> Equivalence<Iterable<S>> pairwise()
  {
    return new PairwiseEquivalence(this);
  }
  
  @Beta
  public final Predicate<T> equivalentTo(@Nullable T target)
  {
    return new EquivalentToPredicate(this, target);
  }
  
  private static final class EquivalentToPredicate<T>
    implements Predicate<T>, Serializable
  {
    private final Equivalence<T> equivalence;
    @Nullable
    private final T target;
    private static final long serialVersionUID = 0L;
    
    EquivalentToPredicate(Equivalence<T> equivalence, @Nullable T target)
    {
      this.equivalence = ((Equivalence)Preconditions.checkNotNull(equivalence));
      this.target = target;
    }
    
    public boolean apply(@Nullable T input)
    {
      return equivalence.equivalent(input, target);
    }
    
    public boolean equals(@Nullable Object obj)
    {
      if (this == obj) {
        return true;
      }
      if ((obj instanceof EquivalentToPredicate))
      {
        EquivalentToPredicate<?> that = (EquivalentToPredicate)obj;
        return (equivalence.equals(equivalence)) && (Objects.equal(target, target));
      }
      return false;
    }
    
    public int hashCode()
    {
      return Objects.hashCode(new Object[] { equivalence, target });
    }
    
    public String toString()
    {
      String str1 = String.valueOf(String.valueOf(equivalence));String str2 = String.valueOf(String.valueOf(target));return 15 + str1.length() + str2.length() + str1 + ".equivalentTo(" + str2 + ")";
    }
  }
  
  public static Equivalence<Object> equals()
  {
    return Equals.INSTANCE;
  }
  
  public static Equivalence<Object> identity()
  {
    return Identity.INSTANCE;
  }
  
  static final class Equals
    extends Equivalence<Object>
    implements Serializable
  {
    static final Equals INSTANCE = new Equals();
    private static final long serialVersionUID = 1L;
    
    protected boolean doEquivalent(Object a, Object b)
    {
      return a.equals(b);
    }
    
    protected int doHash(Object o)
    {
      return o.hashCode();
    }
    
    private Object readResolve()
    {
      return INSTANCE;
    }
  }
  
  static final class Identity
    extends Equivalence<Object>
    implements Serializable
  {
    static final Identity INSTANCE = new Identity();
    private static final long serialVersionUID = 1L;
    
    protected boolean doEquivalent(Object a, Object b)
    {
      return false;
    }
    
    protected int doHash(Object o)
    {
      return System.identityHashCode(o);
    }
    
    private Object readResolve()
    {
      return INSTANCE;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Equivalence
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */