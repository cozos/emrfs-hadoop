package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.MembersInjector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;

class MembersInjectorLookup$1
  implements MembersInjector<T>
{
  MembersInjectorLookup$1(MembersInjectorLookup paramMembersInjectorLookup) {}
  
  public void injectMembers(T instance)
  {
    .Preconditions.checkState(MembersInjectorLookup.access$000(this$0) != null, "This MembersInjector cannot be used until the Injector has been created.");
    
    MembersInjectorLookup.access$000(this$0).injectMembers(instance);
  }
  
  public String toString()
  {
    return "MembersInjector<" + MembersInjectorLookup.access$100(this$0) + ">";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.MembersInjectorLookup.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */