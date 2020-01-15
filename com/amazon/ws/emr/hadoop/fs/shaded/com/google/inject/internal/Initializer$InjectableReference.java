package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Stage;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.TypeLiteral;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

class Initializer$InjectableReference<T>
  implements Initializable<T>
{
  private final InjectorImpl injector;
  private final T instance;
  private final Object source;
  private MembersInjectorImpl<T> membersInjector;
  
  public Initializer$InjectableReference(InjectorImpl arg1, T injector, Object instance)
  {
    this.injector = injector;
    this.instance = .Preconditions.checkNotNull(instance, "instance");
    this.source = .Preconditions.checkNotNull(source, "source");
  }
  
  public void validate(Errors errors)
    throws ErrorsException
  {
    TypeLiteral<T> type = TypeLiteral.get(instance.getClass());
    membersInjector = injector.membersInjectorStore.get(type, errors.withSource(source));
  }
  
  public T get(Errors errors)
    throws ErrorsException
  {
    if (Initializer.access$000(this$0).getCount() == 0L) {
      return (T)instance;
    }
    if (Thread.currentThread() != Initializer.access$100(this$0)) {
      try
      {
        Initializer.access$000(this$0).await();
        return (T)instance;
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }
    }
    if (Initializer.access$200(this$0).remove(instance) != null) {
      membersInjector.injectAndNotify(instance, errors.withSource(source), injector.options.stage == Stage.TOOL);
    }
    return (T)instance;
  }
  
  public String toString()
  {
    return instance.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.Initializer.InjectableReference
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */