package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.eventbus;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.logging.Level;
import java.util.logging.Logger;

final class EventBus$LoggingSubscriberExceptionHandler
  implements SubscriberExceptionHandler
{
  private final Logger logger;
  
  public EventBus$LoggingSubscriberExceptionHandler(String identifier)
  {
    String str1 = String.valueOf(String.valueOf(EventBus.class.getName()));String str2 = String.valueOf(String.valueOf((String)Preconditions.checkNotNull(identifier)));logger = Logger.getLogger(1 + str1.length() + str2.length() + str1 + "." + str2);
  }
  
  public void handleException(Throwable exception, SubscriberExceptionContext context)
  {
    String str1 = String.valueOf(String.valueOf(context.getSubscriber()));String str2 = String.valueOf(String.valueOf(context.getSubscriberMethod()));logger.log(Level.SEVERE, 30 + str1.length() + str2.length() + "Could not dispatch event: " + str1 + " to " + str2, exception.getCause());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.eventbus.EventBus.LoggingSubscriberExceptionHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */