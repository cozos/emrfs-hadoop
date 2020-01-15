package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import java.util.Map.Entry;

class ServiceManager$ServiceManagerState$4
  implements Function<Map.Entry<Service, Long>, Long>
{
  ServiceManager$ServiceManagerState$4(ServiceManager.ServiceManagerState paramServiceManagerState) {}
  
  public Long apply(Map.Entry<Service, Long> input)
  {
    return (Long)input.getValue();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.ServiceManager.ServiceManagerState.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */