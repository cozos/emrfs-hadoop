package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.lang.ref.WeakReference;
import java.util.concurrent.CancellationException;

final class MapMakerInternalMap$CleanupMapTask
  implements Runnable
{
  final WeakReference<MapMakerInternalMap<?, ?>> mapReference;
  
  public MapMakerInternalMap$CleanupMapTask(MapMakerInternalMap<?, ?> map)
  {
    mapReference = new WeakReference(map);
  }
  
  public void run()
  {
    MapMakerInternalMap<?, ?> map = (MapMakerInternalMap)mapReference.get();
    if (map == null) {
      throw new CancellationException();
    }
    for (MapMakerInternalMap.Segment<?, ?> segment : segments) {
      segment.runCleanup();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapMakerInternalMap.CleanupMapTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */