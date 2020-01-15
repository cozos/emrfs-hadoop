package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Supplier;

class AbstractIdleService$1
  implements Supplier<String>
{
  AbstractIdleService$1(AbstractIdleService paramAbstractIdleService) {}
  
  public String get()
  {
    String str1 = String.valueOf(String.valueOf(this$0.serviceName()));String str2 = String.valueOf(String.valueOf(this$0.state()));return 1 + str1.length() + str2.length() + str1 + " " + str2;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.AbstractIdleService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */