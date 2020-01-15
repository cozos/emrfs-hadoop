package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;

class InstanceProfileCredentialsProvider$2
  implements Runnable
{
  InstanceProfileCredentialsProvider$2(InstanceProfileCredentialsProvider this$0) {}
  
  public void run()
  {
    try
    {
      if (InstanceProfileCredentialsProvider.access$100(this$0)) {
        InstanceProfileCredentialsProvider.access$200(this$0).getCredentials();
      }
    }
    catch (AmazonClientException ace)
    {
      InstanceProfileCredentialsProvider.access$300(this$0, ace);
    }
    catch (RuntimeException re)
    {
      InstanceProfileCredentialsProvider.access$300(this$0, re);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.InstanceProfileCredentialsProvider.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */