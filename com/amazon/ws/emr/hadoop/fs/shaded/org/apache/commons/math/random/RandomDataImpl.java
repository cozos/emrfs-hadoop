package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.random;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.util.MathUtils;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.Collection;

public class RandomDataImpl
  implements RandomData, Serializable
{
  private static final long serialVersionUID = -626730818244969716L;
  private RandomGenerator rand = null;
  private SecureRandom secRand = null;
  
  public RandomDataImpl() {}
  
  public RandomDataImpl(RandomGenerator rand)
  {
    this.rand = rand;
  }
  
  public String nextHexString(int len)
  {
    if (len <= 0) {
      throw MathRuntimeException.createIllegalArgumentException("length must be positive ({0})", new Object[] { Integer.valueOf(len) });
    }
    RandomGenerator ran = getRan();
    
    StringBuffer outBuffer = new StringBuffer();
    
    byte[] randomBytes = new byte[len / 2 + 1];
    ran.nextBytes(randomBytes);
    for (int i = 0; i < randomBytes.length; i++)
    {
      Integer c = Integer.valueOf(randomBytes[i]);
      
      String hex = Integer.toHexString(c.intValue() + 128);
      if (hex.length() == 1) {
        hex = "0" + hex;
      }
      outBuffer.append(hex);
    }
    return outBuffer.toString().substring(0, len);
  }
  
  public int nextInt(int lower, int upper)
  {
    if (lower >= upper) {
      throw MathRuntimeException.createIllegalArgumentException("upper bound ({0}) must be greater than lower bound ({1})", new Object[] { Integer.valueOf(upper), Integer.valueOf(lower) });
    }
    double r = getRan().nextDouble();
    return (int)(r * upper + (1.0D - r) * lower + r);
  }
  
  public long nextLong(long lower, long upper)
  {
    if (lower >= upper) {
      throw MathRuntimeException.createIllegalArgumentException("upper bound ({0}) must be greater than lower bound ({1})", new Object[] { Long.valueOf(upper), Long.valueOf(lower) });
    }
    double r = getRan().nextDouble();
    return (r * upper + (1.0D - r) * lower + r);
  }
  
  public String nextSecureHexString(int len)
  {
    if (len <= 0) {
      throw MathRuntimeException.createIllegalArgumentException("length must be positive ({0})", new Object[] { Integer.valueOf(len) });
    }
    SecureRandom secRan = getSecRan();
    MessageDigest alg = null;
    try
    {
      alg = MessageDigest.getInstance("SHA-1");
    }
    catch (NoSuchAlgorithmException ex)
    {
      throw MathRuntimeException.createInternalError(ex);
    }
    alg.reset();
    
    int numIter = len / 40 + 1;
    
    StringBuffer outBuffer = new StringBuffer();
    for (int iter = 1; iter < numIter + 1; iter++)
    {
      byte[] randomBytes = new byte[40];
      secRan.nextBytes(randomBytes);
      alg.update(randomBytes);
      
      byte[] hash = alg.digest();
      for (int i = 0; i < hash.length; i++)
      {
        Integer c = Integer.valueOf(hash[i]);
        
        String hex = Integer.toHexString(c.intValue() + 128);
        if (hex.length() == 1) {
          hex = "0" + hex;
        }
        outBuffer.append(hex);
      }
    }
    return outBuffer.toString().substring(0, len);
  }
  
  public int nextSecureInt(int lower, int upper)
  {
    if (lower >= upper) {
      throw MathRuntimeException.createIllegalArgumentException("upper bound ({0}) must be greater than lower bound ({1})", new Object[] { Integer.valueOf(upper), Integer.valueOf(lower) });
    }
    SecureRandom sec = getSecRan();
    return lower + (int)(sec.nextDouble() * (upper - lower + 1));
  }
  
  public long nextSecureLong(long lower, long upper)
  {
    if (lower >= upper) {
      throw MathRuntimeException.createIllegalArgumentException("upper bound ({0}) must be greater than lower bound ({1})", new Object[] { Long.valueOf(upper), Long.valueOf(lower) });
    }
    SecureRandom sec = getSecRan();
    return lower + (sec.nextDouble() * (upper - lower + 1L));
  }
  
  public long nextPoisson(double mean)
  {
    if (mean <= 0.0D) {
      throw MathRuntimeException.createIllegalArgumentException("the Poisson mean must be positive ({0})", new Object[] { Double.valueOf(mean) });
    }
    RandomGenerator generator = getRan();
    
    double pivot = 40.0D;
    if (mean < 40.0D)
    {
      double p = Math.exp(-mean);
      long n = 0L;
      double r = 1.0D;
      double rnd = 1.0D;
      while (n < 1000.0D * mean)
      {
        rnd = generator.nextDouble();
        r *= rnd;
        if (r >= p) {
          n += 1L;
        } else {
          return n;
        }
      }
      return n;
    }
    double lambda = Math.floor(mean);
    double lambdaFractional = mean - lambda;
    double logLambda = Math.log(lambda);
    double logLambdaFactorial = MathUtils.factorialLog((int)lambda);
    long y2 = lambdaFractional < Double.MIN_VALUE ? 0L : nextPoisson(lambdaFractional);
    double delta = Math.sqrt(lambda * Math.log(32.0D * lambda / 3.141592653589793D + 1.0D));
    double halfDelta = delta / 2.0D;
    double twolpd = 2.0D * lambda + delta;
    double a1 = Math.sqrt(3.141592653589793D * twolpd) * Math.exp(0.0D * lambda);
    double a2 = twolpd / delta * Math.exp(-delta * (1.0D + delta) / twolpd);
    double aSum = a1 + a2 + 1.0D;
    double p1 = a1 / aSum;
    double p2 = a2 / aSum;
    double c1 = 1.0D / (8.0D * lambda);
    
    double x = 0.0D;
    double y = 0.0D;
    double v = 0.0D;
    int a = 0;
    double t = 0.0D;
    double qr = 0.0D;
    double qa = 0.0D;
    for (;;)
    {
      double u = nextUniform(0.0D, 1.0D);
      if (u <= p1)
      {
        double n = nextGaussian(0.0D, 1.0D);
        x = n * Math.sqrt(lambda + halfDelta) - 0.5D;
        if ((x > delta) || (x < -lambda)) {
          continue;
        }
        y = x < 0.0D ? Math.floor(x) : Math.ceil(x);
        double e = nextExponential(1.0D);
        v = -e - n * n / 2.0D + c1;
      }
      else
      {
        if (u > p1 + p2)
        {
          y = lambda;
          break;
        }
        x = delta + twolpd / delta * nextExponential(1.0D);
        y = Math.ceil(x);
        v = -nextExponential(1.0D) - delta * (x + 1.0D) / twolpd;
      }
      a = x < 0.0D ? 1 : 0;
      t = y * (y + 1.0D) / (2.0D * lambda);
      if ((v < -t) && (a == 0))
      {
        y = lambda + y;
        break;
      }
      qr = t * ((2.0D * y + 1.0D) / (6.0D * lambda) - 1.0D);
      qa = qr - t * t / (3.0D * (lambda + a * (y + 1.0D)));
      if (v < qa)
      {
        y = lambda + y;
        break;
      }
      if (v <= qr) {
        if (v < y * logLambda - MathUtils.factorialLog((int)(y + lambda)) + logLambdaFactorial)
        {
          y = lambda + y;
          break;
        }
      }
    }
    return y2 + y;
  }
  
  public double nextGaussian(double mu, double sigma)
  {
    if (sigma <= 0.0D) {
      throw MathRuntimeException.createIllegalArgumentException("standard deviation must be positive ({0})", new Object[] { Double.valueOf(sigma) });
    }
    return sigma * getRan().nextGaussian() + mu;
  }
  
  public double nextExponential(double mean)
  {
    if (mean <= 0.0D) {
      throw MathRuntimeException.createIllegalArgumentException("mean must be positive ({0})", new Object[] { Double.valueOf(mean) });
    }
    RandomGenerator generator = getRan();
    double unif = generator.nextDouble();
    while (unif == 0.0D) {
      unif = generator.nextDouble();
    }
    return -mean * Math.log(unif);
  }
  
  public double nextUniform(double lower, double upper)
  {
    if (lower >= upper) {
      throw MathRuntimeException.createIllegalArgumentException("upper bound ({0}) must be greater than lower bound ({1})", new Object[] { Double.valueOf(upper), Double.valueOf(lower) });
    }
    RandomGenerator generator = getRan();
    
    double u = generator.nextDouble();
    while (u <= 0.0D) {
      u = generator.nextDouble();
    }
    return lower + u * (upper - lower);
  }
  
  private RandomGenerator getRan()
  {
    if (rand == null)
    {
      rand = new JDKRandomGenerator();
      rand.setSeed(System.currentTimeMillis());
    }
    return rand;
  }
  
  private SecureRandom getSecRan()
  {
    if (secRand == null)
    {
      secRand = new SecureRandom();
      secRand.setSeed(System.currentTimeMillis());
    }
    return secRand;
  }
  
  public void reSeed(long seed)
  {
    if (rand == null) {
      rand = new JDKRandomGenerator();
    }
    rand.setSeed(seed);
  }
  
  public void reSeedSecure()
  {
    if (secRand == null) {
      secRand = new SecureRandom();
    }
    secRand.setSeed(System.currentTimeMillis());
  }
  
  public void reSeedSecure(long seed)
  {
    if (secRand == null) {
      secRand = new SecureRandom();
    }
    secRand.setSeed(seed);
  }
  
  public void reSeed()
  {
    if (rand == null) {
      rand = new JDKRandomGenerator();
    }
    rand.setSeed(System.currentTimeMillis());
  }
  
  public void setSecureAlgorithm(String algorithm, String provider)
    throws NoSuchAlgorithmException, NoSuchProviderException
  {
    secRand = SecureRandom.getInstance(algorithm, provider);
  }
  
  public int[] nextPermutation(int n, int k)
  {
    if (k > n) {
      throw MathRuntimeException.createIllegalArgumentException("permutation k ({0}) exceeds n ({1})", new Object[] { Integer.valueOf(k), Integer.valueOf(n) });
    }
    if (k == 0) {
      throw MathRuntimeException.createIllegalArgumentException("permutation k ({0}) must be positive", new Object[] { Integer.valueOf(k) });
    }
    int[] index = getNatural(n);
    shuffle(index, n - k);
    int[] result = new int[k];
    for (int i = 0; i < k; i++) {
      result[i] = index[(n - i - 1)];
    }
    return result;
  }
  
  public Object[] nextSample(Collection<?> c, int k)
  {
    int len = c.size();
    if (k > len) {
      throw MathRuntimeException.createIllegalArgumentException("sample size ({0}) exceeds collection size ({1})", new Object[0]);
    }
    if (k <= 0) {
      throw MathRuntimeException.createIllegalArgumentException("sample size must be positive ({0})", new Object[] { Integer.valueOf(k) });
    }
    Object[] objects = c.toArray();
    int[] index = nextPermutation(len, k);
    Object[] result = new Object[k];
    for (int i = 0; i < k; i++) {
      result[i] = objects[index[i]];
    }
    return result;
  }
  
  private void shuffle(int[] list, int end)
  {
    int target = 0;
    for (int i = list.length - 1; i >= end; i--)
    {
      if (i == 0) {
        target = 0;
      } else {
        target = nextInt(0, i);
      }
      int temp = list[target];
      list[target] = list[i];
      list[i] = temp;
    }
  }
  
  private int[] getNatural(int n)
  {
    int[] natural = new int[n];
    for (int i = 0; i < n; i++) {
      natural[i] = i;
    }
    return natural;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.random.RandomDataImpl
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */