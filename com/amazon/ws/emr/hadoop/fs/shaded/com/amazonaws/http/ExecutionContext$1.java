package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.Signer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.auth.SignerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.auth.SignerProviderContext;

class ExecutionContext$1
  extends SignerProvider
{
  ExecutionContext$1(ExecutionContext this$0) {}
  
  public Signer getSigner(SignerProviderContext context)
  {
    return this$0.getSignerByURI(context.getUri());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.ExecutionContext.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */