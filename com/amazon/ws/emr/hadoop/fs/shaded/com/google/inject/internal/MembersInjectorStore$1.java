package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.TypeLiteral;

class MembersInjectorStore$1
  extends FailableCache<TypeLiteral<?>, MembersInjectorImpl<?>>
{
  MembersInjectorStore$1(MembersInjectorStore paramMembersInjectorStore) {}
  
  protected MembersInjectorImpl<?> create(TypeLiteral<?> type, Errors errors)
    throws ErrorsException
  {
    return MembersInjectorStore.access$000(this$0, type, errors);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.MembersInjectorStore.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */