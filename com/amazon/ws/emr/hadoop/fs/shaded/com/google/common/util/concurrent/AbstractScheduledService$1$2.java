package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Supplier;

class AbstractScheduledService$1$2
  implements Supplier<String>
{
  AbstractScheduledService$1$2(AbstractScheduledService.1 param1) {}
  
  public String get()
  {
    String str1 = String.valueOf(String.valueOf(this$1.this$0.serviceName()));String str2 = String.valueOf(String.valueOf(this$1.state()));return 1 + str1.length() + str2.length() + str1 + " " + str2;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.AbstractScheduledService.1.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */