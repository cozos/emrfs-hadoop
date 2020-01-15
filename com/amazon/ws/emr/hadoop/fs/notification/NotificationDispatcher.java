package com.amazon.ws.emr.hadoop.fs.notification;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.hadoop.fs.Path;

public class NotificationDispatcher
{
  private final List<Notifier> notifiers;
  
  public NotificationDispatcher()
  {
    notifiers = new ArrayList();
  }
  
  public void addNotifier(Notifier notifier)
  {
    if (notifier != null) {
      notifiers.add(notifier);
    }
  }
  
  public void addNotifiers(Collection<Notifier> notifiers)
  {
    if (notifiers != null) {
      this.notifiers.addAll(notifiers);
    }
  }
  
  public void inconsistency(Notifier.Api api, Path arg, List<Path> inconsistentPaths)
  {
    inconsistency(api, arg, null, inconsistentPaths);
  }
  
  public void inconsistency(Notifier.Api api, Path arg1, Path arg2, List<Path> inconsistentPaths)
  {
    for (Notifier notifier : notifiers) {
      notifier.inconsistency(api, arg1, arg2, inconsistentPaths);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.notification.NotificationDispatcher
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */