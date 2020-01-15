package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Iterator;
import javax.annotation.Nullable;

@Beta
@GwtCompatible
public abstract class Converter<A, B>
  implements Function<A, B>
{
  private final boolean handleNullAutomatically;
  private transient Converter<B, A> reverse;
  
  protected Converter()
  {
    this(true);
  }
  
  Converter(boolean handleNullAutomatically)
  {
    this.handleNullAutomatically = handleNullAutomatically;
  }
  
  protected abstract B doForward(A paramA);
  
  protected abstract A doBackward(B paramB);
  
  @Nullable
  public final B convert(@Nullable A a)
  {
    return (B)correctedDoForward(a);
  }
  
  @Nullable
  B correctedDoForward(@Nullable A a)
  {
    if (handleNullAutomatically) {
      return a == null ? null : Preconditions.checkNotNull(doForward(a));
    }
    return (B)doForward(a);
  }
  
  @Nullable
  A correctedDoBackward(@Nullable B b)
  {
    if (handleNullAutomatically) {
      return b == null ? null : Preconditions.checkNotNull(doBackward(b));
    }
    return (A)doBackward(b);
  }
  
  public Iterable<B> convertAll(final Iterable<? extends A> fromIterable)
  {
    Preconditions.checkNotNull(fromIterable, "fromIterable");
    new Iterable()
    {
      public Iterator<B> iterator()
      {
        new Iterator()
        {
          private final Iterator<? extends A> fromIterator = val$fromIterable.iterator();
          
          public boolean hasNext()
          {
            return fromIterator.hasNext();
          }
          
          public B next()
          {
            return (B)convert(fromIterator.next());
          }
          
          public void remove()
          {
            fromIterator.remove();
          }
        };
      }
    };
  }
  
  public Converter<B, A> reverse()
  {
    Converter<B, A> result = reverse;
    return result == null ? (reverse = new ReverseConverter(this)) : result;
  }
  
  private static final class ReverseConverter<A, B>
    extends Converter<B, A>
    implements Serializable
  {
    final Converter<A, B> original;
    private static final long serialVersionUID = 0L;
    
    ReverseConverter(Converter<A, B> original)
    {
      this.original = original;
    }
    
    protected A doForward(B b)
    {
      throw new AssertionError();
    }
    
    protected B doBackward(A a)
    {
      throw new AssertionError();
    }
    
    @Nullable
    A correctedDoForward(@Nullable B b)
    {
      return (A)original.correctedDoBackward(b);
    }
    
    @Nullable
    B correctedDoBackward(@Nullable A a)
    {
      return (B)original.correctedDoForward(a);
    }
    
    public Converter<A, B> reverse()
    {
      return original;
    }
    
    public boolean equals(@Nullable Object object)
    {
      if ((object instanceof ReverseConverter))
      {
        ReverseConverter<?, ?> that = (ReverseConverter)object;
        return original.equals(original);
      }
      return false;
    }
    
    public int hashCode()
    {
      return original.hashCode() ^ 0xFFFFFFFF;
    }
    
    public String toString()
    {
      String str = String.valueOf(String.valueOf(original));return 10 + str.length() + str + ".reverse()";
    }
  }
  
  public final <C> Converter<A, C> andThen(Converter<B, C> secondConverter)
  {
    return doAndThen(secondConverter);
  }
  
  <C> Converter<A, C> doAndThen(Converter<B, C> secondConverter)
  {
    return new ConverterComposition(this, (Converter)Preconditions.checkNotNull(secondConverter));
  }
  
  private static final class ConverterComposition<A, B, C>
    extends Converter<A, C>
    implements Serializable
  {
    final Converter<A, B> first;
    final Converter<B, C> second;
    private static final long serialVersionUID = 0L;
    
    ConverterComposition(Converter<A, B> first, Converter<B, C> second)
    {
      this.first = first;
      this.second = second;
    }
    
    protected C doForward(A a)
    {
      throw new AssertionError();
    }
    
    protected A doBackward(C c)
    {
      throw new AssertionError();
    }
    
    @Nullable
    C correctedDoForward(@Nullable A a)
    {
      return (C)second.correctedDoForward(first.correctedDoForward(a));
    }
    
    @Nullable
    A correctedDoBackward(@Nullable C c)
    {
      return (A)first.correctedDoBackward(second.correctedDoBackward(c));
    }
    
    public boolean equals(@Nullable Object object)
    {
      if ((object instanceof ConverterComposition))
      {
        ConverterComposition<?, ?, ?> that = (ConverterComposition)object;
        return (first.equals(first)) && (second.equals(second));
      }
      return false;
    }
    
    public int hashCode()
    {
      return 31 * first.hashCode() + second.hashCode();
    }
    
    public String toString()
    {
      String str1 = String.valueOf(String.valueOf(first));String str2 = String.valueOf(String.valueOf(second));return 10 + str1.length() + str2.length() + str1 + ".andThen(" + str2 + ")";
    }
  }
  
  @Deprecated
  @Nullable
  public final B apply(@Nullable A a)
  {
    return (B)convert(a);
  }
  
  public boolean equals(@Nullable Object object)
  {
    return super.equals(object);
  }
  
  public static <A, B> Converter<A, B> from(Function<? super A, ? extends B> forwardFunction, Function<? super B, ? extends A> backwardFunction)
  {
    return new FunctionBasedConverter(forwardFunction, backwardFunction, null);
  }
  
  private static final class FunctionBasedConverter<A, B>
    extends Converter<A, B>
    implements Serializable
  {
    private final Function<? super A, ? extends B> forwardFunction;
    private final Function<? super B, ? extends A> backwardFunction;
    
    private FunctionBasedConverter(Function<? super A, ? extends B> forwardFunction, Function<? super B, ? extends A> backwardFunction)
    {
      this.forwardFunction = ((Function)Preconditions.checkNotNull(forwardFunction));
      this.backwardFunction = ((Function)Preconditions.checkNotNull(backwardFunction));
    }
    
    protected B doForward(A a)
    {
      return (B)forwardFunction.apply(a);
    }
    
    protected A doBackward(B b)
    {
      return (A)backwardFunction.apply(b);
    }
    
    public boolean equals(@Nullable Object object)
    {
      if ((object instanceof FunctionBasedConverter))
      {
        FunctionBasedConverter<?, ?> that = (FunctionBasedConverter)object;
        return (forwardFunction.equals(forwardFunction)) && (backwardFunction.equals(backwardFunction));
      }
      return false;
    }
    
    public int hashCode()
    {
      return forwardFunction.hashCode() * 31 + backwardFunction.hashCode();
    }
    
    public String toString()
    {
      String str1 = String.valueOf(String.valueOf(forwardFunction));String str2 = String.valueOf(String.valueOf(backwardFunction));return 18 + str1.length() + str2.length() + "Converter.from(" + str1 + ", " + str2 + ")";
    }
  }
  
  public static <T> Converter<T, T> identity()
  {
    return IdentityConverter.INSTANCE;
  }
  
  private static final class IdentityConverter<T>
    extends Converter<T, T>
    implements Serializable
  {
    static final IdentityConverter INSTANCE = new IdentityConverter();
    private static final long serialVersionUID = 0L;
    
    protected T doForward(T t)
    {
      return t;
    }
    
    protected T doBackward(T t)
    {
      return t;
    }
    
    public IdentityConverter<T> reverse()
    {
      return this;
    }
    
    <S> Converter<T, S> doAndThen(Converter<T, S> otherConverter)
    {
      return (Converter)Preconditions.checkNotNull(otherConverter, "otherConverter");
    }
    
    public String toString()
    {
      return "Converter.identity()";
    }
    
    private Object readResolve()
    {
      return INSTANCE;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Converter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */