package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

class InstanceProfileCredentialsProvider$1
  implements ThreadFactory
{
  InstanceProfileCredentialsProvider$1(InstanceProfileCredentialsProvider this$0) {}
  
  public Thread newThread(Runnable r)
  {
    Thread t = Executors.defaultThreadFactory().newThread(r);
    t.setName("instance-profile-credentials-refresh");
    t.setDaemon(true);
    return t;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.InstanceProfileCredentialsProvider.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */