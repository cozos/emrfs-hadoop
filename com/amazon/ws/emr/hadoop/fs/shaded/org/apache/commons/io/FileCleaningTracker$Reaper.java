package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io;

import java.lang.ref.ReferenceQueue;
import java.util.Collection;
import java.util.List;

final class FileCleaningTracker$Reaper
  extends Thread
{
  FileCleaningTracker$Reaper(FileCleaningTracker paramFileCleaningTracker)
  {
    super("File Reaper");
    setPriority(10);
    setDaemon(true);
  }
  
  public void run()
  {
    while ((!this$0.exitWhenFinished) || (this$0.trackers.size() > 0)) {
      try
      {
        FileCleaningTracker.Tracker tracker = (FileCleaningTracker.Tracker)this$0.q.remove();
        this$0.trackers.remove(tracker);
        if (!tracker.delete()) {
          this$0.deleteFailures.add(tracker.getPath());
        }
        tracker.clear();
      }
      catch (InterruptedException e) {}
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.FileCleaningTracker.Reaper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */