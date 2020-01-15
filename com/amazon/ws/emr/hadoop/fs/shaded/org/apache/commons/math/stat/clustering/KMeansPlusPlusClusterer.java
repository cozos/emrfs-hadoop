package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.clustering;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class KMeansPlusPlusClusterer<T extends Clusterable<T>>
{
  private final Random random;
  
  public KMeansPlusPlusClusterer(Random random)
  {
    this.random = random;
  }
  
  public List<Cluster<T>> cluster(Collection<T> points, int k, int maxIterations)
  {
    List<Cluster<T>> clusters = chooseInitialCenters(points, k, random);
    assignPointsToClusters(clusters, points);
    
    int max = maxIterations < 0 ? Integer.MAX_VALUE : maxIterations;
    for (int count = 0; count < max; count++)
    {
      boolean clusteringChanged = false;
      List<Cluster<T>> newClusters = new ArrayList();
      for (Cluster<T> cluster : clusters)
      {
        T newCenter = (Clusterable)cluster.getCenter().centroidOf(cluster.getPoints());
        if (!newCenter.equals(cluster.getCenter())) {
          clusteringChanged = true;
        }
        newClusters.add(new Cluster(newCenter));
      }
      if (!clusteringChanged) {
        return clusters;
      }
      assignPointsToClusters(newClusters, points);
      clusters = newClusters;
    }
    return clusters;
  }
  
  private static <T extends Clusterable<T>> void assignPointsToClusters(Collection<Cluster<T>> clusters, Collection<T> points)
  {
    for (T p : points)
    {
      Cluster<T> cluster = getNearestCluster(clusters, p);
      cluster.addPoint(p);
    }
  }
  
  private static <T extends Clusterable<T>> List<Cluster<T>> chooseInitialCenters(Collection<T> points, int k, Random random)
  {
    List<T> pointSet = new ArrayList(points);
    List<Cluster<T>> resultSet = new ArrayList();
    
    T firstPoint = (Clusterable)pointSet.remove(random.nextInt(pointSet.size()));
    resultSet.add(new Cluster(firstPoint));
    
    double[] dx2 = new double[pointSet.size()];
    while (resultSet.size() < k)
    {
      int sum = 0;
      for (int i = 0; i < pointSet.size(); i++)
      {
        T p = (Clusterable)pointSet.get(i);
        Cluster<T> nearest = getNearestCluster(resultSet, p);
        double d = p.distanceFrom(nearest.getCenter());
        sum = (int)(sum + d * d);
        dx2[i] = sum;
      }
      double r = random.nextDouble() * sum;
      for (int i = 0; i < dx2.length; i++) {
        if (dx2[i] >= r)
        {
          T p = (Clusterable)pointSet.remove(i);
          resultSet.add(new Cluster(p));
          break;
        }
      }
    }
    return resultSet;
  }
  
  private static <T extends Clusterable<T>> Cluster<T> getNearestCluster(Collection<Cluster<T>> clusters, T point)
  {
    double minDistance = Double.MAX_VALUE;
    Cluster<T> minCluster = null;
    for (Cluster<T> c : clusters)
    {
      double distance = point.distanceFrom(c.getCenter());
      if (distance < minDistance)
      {
        minDistance = distance;
        minCluster = c;
      }
    }
    return minCluster;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.clustering.KMeansPlusPlusClusterer
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */