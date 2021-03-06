package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.util;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

public final class MathUtils
{
  public static final double EPSILON = 1.1102230246251565E-16D;
  public static final double SAFE_MIN = 2.2250738585072014E-308D;
  public static final double TWO_PI = 6.283185307179586D;
  private static final byte NB = -1;
  private static final short NS = -1;
  private static final byte PB = 1;
  private static final short PS = 1;
  private static final byte ZB = 0;
  private static final short ZS = 0;
  private static final int NAN_GAP = 4194304;
  private static final long SGN_MASK = Long.MIN_VALUE;
  private static final long[] FACTORIALS = { 1L, 1L, 2L, 6L, 24L, 120L, 720L, 5040L, 40320L, 362880L, 3628800L, 39916800L, 479001600L, 6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L, 2432902008176640000L };
  
  public static int addAndCheck(int x, int y)
  {
    long s = x + y;
    if ((s < -2147483648L) || (s > 2147483647L)) {
      throw new ArithmeticException("overflow: add");
    }
    return (int)s;
  }
  
  public static long addAndCheck(long a, long b)
  {
    return addAndCheck(a, b, "overflow: add");
  }
  
  private static long addAndCheck(long a, long b, String msg)
  {
    long ret;
    if (a > b)
    {
      ret = addAndCheck(b, a, msg);
    }
    else
    {
      long ret;
      if (a < 0L)
      {
        if (b < 0L)
        {
          long ret;
          if (Long.MIN_VALUE - b <= a) {
            ret = a + b;
          } else {
            throw new ArithmeticException(msg);
          }
        }
        else
        {
          ret = a + b;
        }
      }
      else
      {
        long ret;
        if (a <= Long.MAX_VALUE - b) {
          ret = a + b;
        } else {
          throw new ArithmeticException(msg);
        }
      }
    }
    long ret;
    return ret;
  }
  
  public static long binomialCoefficient(int n, int k)
  {
    checkBinomial(n, k);
    if ((n == k) || (k == 0)) {
      return 1L;
    }
    if ((k == 1) || (k == n - 1)) {
      return n;
    }
    if (k > n / 2) {
      return binomialCoefficient(n, n - k);
    }
    long result = 1L;
    if (n <= 61)
    {
      int i = n - k + 1;
      for (int j = 1; j <= k; j++)
      {
        result = result * i / j;
        i++;
      }
    }
    else if (n <= 66)
    {
      int i = n - k + 1;
      for (int j = 1; j <= k; j++)
      {
        long d = gcd(i, j);
        result = result / (j / d) * (i / d);
        i++;
      }
    }
    else
    {
      int i = n - k + 1;
      for (int j = 1; j <= k; j++)
      {
        long d = gcd(i, j);
        result = mulAndCheck(result / (j / d), i / d);
        i++;
      }
    }
    return result;
  }
  
  public static double binomialCoefficientDouble(int n, int k)
  {
    checkBinomial(n, k);
    if ((n == k) || (k == 0)) {
      return 1.0D;
    }
    if ((k == 1) || (k == n - 1)) {
      return n;
    }
    if (k > n / 2) {
      return binomialCoefficientDouble(n, n - k);
    }
    if (n < 67) {
      return binomialCoefficient(n, k);
    }
    double result = 1.0D;
    for (int i = 1; i <= k; i++) {
      result *= (n - k + i) / i;
    }
    return Math.floor(result + 0.5D);
  }
  
  public static double binomialCoefficientLog(int n, int k)
  {
    checkBinomial(n, k);
    if ((n == k) || (k == 0)) {
      return 0.0D;
    }
    if ((k == 1) || (k == n - 1)) {
      return Math.log(n);
    }
    if (n < 67) {
      return Math.log(binomialCoefficient(n, k));
    }
    if (n < 1030) {
      return Math.log(binomialCoefficientDouble(n, k));
    }
    if (k > n / 2) {
      return binomialCoefficientLog(n, n - k);
    }
    double logSum = 0.0D;
    for (int i = n - k + 1; i <= n; i++) {
      logSum += Math.log(i);
    }
    for (int i = 2; i <= k; i++) {
      logSum -= Math.log(i);
    }
    return logSum;
  }
  
  private static void checkBinomial(int n, int k)
    throws IllegalArgumentException
  {
    if (n < k) {
      throw MathRuntimeException.createIllegalArgumentException("must have n >= k for binomial coefficient (n,k), got n = {0}, k = {1}", new Object[] { Integer.valueOf(n), Integer.valueOf(k) });
    }
    if (n < 0) {
      throw MathRuntimeException.createIllegalArgumentException("must have n >= 0 for binomial coefficient (n,k), got n = {0}", new Object[] { Integer.valueOf(n) });
    }
  }
  
  public static int compareTo(double x, double y, double eps)
  {
    if (equals(x, y, eps)) {
      return 0;
    }
    if (x < y) {
      return -1;
    }
    return 1;
  }
  
  public static double cosh(double x)
  {
    return (Math.exp(x) + Math.exp(-x)) / 2.0D;
  }
  
  public static boolean equals(double x, double y)
  {
    return ((Double.isNaN(x)) && (Double.isNaN(y))) || (x == y);
  }
  
  public static boolean equals(double x, double y, double eps)
  {
    return (equals(x, y)) || (Math.abs(y - x) <= eps);
  }
  
  public static boolean equals(double x, double y, int maxUlps)
  {
    assert ((maxUlps > 0) && (maxUlps < 4194304));
    
    long xInt = Double.doubleToLongBits(x);
    long yInt = Double.doubleToLongBits(y);
    if (xInt < 0L) {
      xInt = Long.MIN_VALUE - xInt;
    }
    if (yInt < 0L) {
      yInt = Long.MIN_VALUE - yInt;
    }
    return Math.abs(xInt - yInt) <= maxUlps;
  }
  
  public static boolean equals(double[] x, double[] y)
  {
    if ((x == null) || (y == null)) {
      return ((x == null ? 1 : 0) ^ (y == null ? 1 : 0)) == 0;
    }
    if (x.length != y.length) {
      return false;
    }
    for (int i = 0; i < x.length; i++) {
      if (!equals(x[i], y[i])) {
        return false;
      }
    }
    return true;
  }
  
  public static long factorial(int n)
  {
    if (n < 0) {
      throw MathRuntimeException.createIllegalArgumentException("must have n >= 0 for n!, got n = {0}", new Object[] { Integer.valueOf(n) });
    }
    if (n > 20) {
      throw new ArithmeticException("factorial value is too large to fit in a long");
    }
    return FACTORIALS[n];
  }
  
  public static double factorialDouble(int n)
  {
    if (n < 0) {
      throw MathRuntimeException.createIllegalArgumentException("must have n >= 0 for n!, got n = {0}", new Object[] { Integer.valueOf(n) });
    }
    if (n < 21) {
      return factorial(n);
    }
    return Math.floor(Math.exp(factorialLog(n)) + 0.5D);
  }
  
  public static double factorialLog(int n)
  {
    if (n < 0) {
      throw MathRuntimeException.createIllegalArgumentException("must have n >= 0 for n!, got n = {0}", new Object[] { Integer.valueOf(n) });
    }
    if (n < 21) {
      return Math.log(factorial(n));
    }
    double logSum = 0.0D;
    for (int i = 2; i <= n; i++) {
      logSum += Math.log(i);
    }
    return logSum;
  }
  
  public static int gcd(int p, int q)
  {
    int u = p;
    int v = q;
    if ((u == 0) || (v == 0))
    {
      if ((u == Integer.MIN_VALUE) || (v == Integer.MIN_VALUE)) {
        throw MathRuntimeException.createArithmeticException("overflow: gcd({0}, {1}) is 2^31", new Object[] { Integer.valueOf(p), Integer.valueOf(q) });
      }
      return Math.abs(u) + Math.abs(v);
    }
    if (u > 0) {
      u = -u;
    }
    if (v > 0) {
      v = -v;
    }
    int k = 0;
    while (((u & 0x1) == 0) && ((v & 0x1) == 0) && (k < 31))
    {
      u /= 2;
      v /= 2;
      k++;
    }
    if (k == 31) {
      throw MathRuntimeException.createArithmeticException("overflow: gcd({0}, {1}) is 2^31", new Object[] { Integer.valueOf(p), Integer.valueOf(q) });
    }
    int t = (u & 0x1) == 1 ? v : -(u / 2);
    do
    {
      while ((t & 0x1) == 0) {
        t /= 2;
      }
      if (t > 0) {
        u = -t;
      } else {
        v = t;
      }
      t = (v - u) / 2;
    } while (t != 0);
    return -u * (1 << k);
  }
  
  public static long gcd(long p, long q)
  {
    long u = p;
    long v = q;
    if ((u == 0L) || (v == 0L))
    {
      if ((u == Long.MIN_VALUE) || (v == Long.MIN_VALUE)) {
        throw MathRuntimeException.createArithmeticException("overflow: gcd({0}, {1}) is 2^63", new Object[] { Long.valueOf(p), Long.valueOf(q) });
      }
      return Math.abs(u) + Math.abs(v);
    }
    if (u > 0L) {
      u = -u;
    }
    if (v > 0L) {
      v = -v;
    }
    int k = 0;
    while (((u & 1L) == 0L) && ((v & 1L) == 0L) && (k < 63))
    {
      u /= 2L;
      v /= 2L;
      k++;
    }
    if (k == 63) {
      throw MathRuntimeException.createArithmeticException("overflow: gcd({0}, {1}) is 2^63", new Object[] { Long.valueOf(p), Long.valueOf(q) });
    }
    long t = (u & 1L) == 1L ? v : -(u / 2L);
    do
    {
      while ((t & 1L) == 0L) {
        t /= 2L;
      }
      if (t > 0L) {
        u = -t;
      } else {
        v = t;
      }
      t = (v - u) / 2L;
    } while (t != 0L);
    return -u * (1L << k);
  }
  
  public static int hash(double value)
  {
    return new Double(value).hashCode();
  }
  
  public static int hash(double[] value)
  {
    return Arrays.hashCode(value);
  }
  
  public static byte indicator(byte x)
  {
    return x >= 0 ? 1 : -1;
  }
  
  public static double indicator(double x)
  {
    if (Double.isNaN(x)) {
      return NaN.0D;
    }
    return x >= 0.0D ? 1.0D : -1.0D;
  }
  
  public static float indicator(float x)
  {
    if (Float.isNaN(x)) {
      return NaN.0F;
    }
    return x >= 0.0F ? 1.0F : -1.0F;
  }
  
  public static int indicator(int x)
  {
    return x >= 0 ? 1 : -1;
  }
  
  public static long indicator(long x)
  {
    return x >= 0L ? 1L : -1L;
  }
  
  public static short indicator(short x)
  {
    return x >= 0 ? 1 : -1;
  }
  
  public static int lcm(int a, int b)
  {
    if ((a == 0) || (b == 0)) {
      return 0;
    }
    int lcm = Math.abs(mulAndCheck(a / gcd(a, b), b));
    if (lcm == Integer.MIN_VALUE) {
      throw MathRuntimeException.createArithmeticException("overflow: lcm({0}, {1}) is 2^31", new Object[] { Integer.valueOf(a), Integer.valueOf(b) });
    }
    return lcm;
  }
  
  public static long lcm(long a, long b)
  {
    if ((a == 0L) || (b == 0L)) {
      return 0L;
    }
    long lcm = Math.abs(mulAndCheck(a / gcd(a, b), b));
    if (lcm == Long.MIN_VALUE) {
      throw MathRuntimeException.createArithmeticException("overflow: lcm({0}, {1}) is 2^63", new Object[] { Long.valueOf(a), Long.valueOf(b) });
    }
    return lcm;
  }
  
  public static double log(double base, double x)
  {
    return Math.log(x) / Math.log(base);
  }
  
  public static int mulAndCheck(int x, int y)
  {
    long m = x * y;
    if ((m < -2147483648L) || (m > 2147483647L)) {
      throw new ArithmeticException("overflow: mul");
    }
    return (int)m;
  }
  
  public static long mulAndCheck(long a, long b)
  {
    String msg = "overflow: multiply";
    long ret;
    long ret;
    if (a > b)
    {
      ret = mulAndCheck(b, a);
    }
    else
    {
      long ret;
      if (a < 0L)
      {
        if (b < 0L)
        {
          long ret;
          if (a >= Long.MAX_VALUE / b) {
            ret = a * b;
          } else {
            throw new ArithmeticException(msg);
          }
        }
        else if (b > 0L)
        {
          long ret;
          if (Long.MIN_VALUE / b <= a) {
            ret = a * b;
          } else {
            throw new ArithmeticException(msg);
          }
        }
        else
        {
          ret = 0L;
        }
      }
      else if (a > 0L)
      {
        long ret;
        if (a <= Long.MAX_VALUE / b) {
          ret = a * b;
        } else {
          throw new ArithmeticException(msg);
        }
      }
      else
      {
        ret = 0L;
      }
    }
    return ret;
  }
  
  public static double nextAfter(double d, double direction)
  {
    if ((Double.isNaN(d)) || (Double.isInfinite(d))) {
      return d;
    }
    if (d == 0.0D) {
      return direction < 0.0D ? -4.9E-324D : Double.MIN_VALUE;
    }
    long bits = Double.doubleToLongBits(d);
    long sign = bits & 0x8000000000000000;
    long exponent = bits & 0x7FF0000000000000;
    long mantissa = bits & 0xFFFFFFFFFFFFF;
    if (d * (direction - d) >= 0.0D)
    {
      if (mantissa == 4503599627370495L) {
        return Double.longBitsToDouble(sign | exponent + 4503599627370496L);
      }
      return Double.longBitsToDouble(sign | exponent | mantissa + 1L);
    }
    if (mantissa == 0L) {
      return Double.longBitsToDouble(sign | exponent - 4503599627370496L | 0xFFFFFFFFFFFFF);
    }
    return Double.longBitsToDouble(sign | exponent | mantissa - 1L);
  }
  
  public static double scalb(double d, int scaleFactor)
  {
    if ((d == 0.0D) || (Double.isNaN(d)) || (Double.isInfinite(d))) {
      return d;
    }
    long bits = Double.doubleToLongBits(d);
    long exponent = bits & 0x7FF0000000000000;
    long rest = bits & 0x800FFFFFFFFFFFFF;
    
    long newBits = rest | exponent + (scaleFactor << 52);
    return Double.longBitsToDouble(newBits);
  }
  
  public static double normalizeAngle(double a, double center)
  {
    return a - 6.283185307179586D * Math.floor((a + 3.141592653589793D - center) / 6.283185307179586D);
  }
  
  public static double[] normalizeArray(double[] values, double normalizedSum)
    throws ArithmeticException, IllegalArgumentException
  {
    if (Double.isInfinite(normalizedSum)) {
      throw MathRuntimeException.createIllegalArgumentException("Cannot normalize to an infinite value", new Object[0]);
    }
    if (Double.isNaN(normalizedSum)) {
      throw MathRuntimeException.createIllegalArgumentException("Cannot normalize to NaN", new Object[0]);
    }
    double sum = 0.0D;
    int len = values.length;
    double[] out = new double[len];
    for (int i = 0; i < len; i++)
    {
      if (Double.isInfinite(values[i])) {
        throw MathRuntimeException.createArithmeticException("Array contains an infinite element, {0} at index {1}", new Object[] { Double.valueOf(values[i]), Integer.valueOf(i) });
      }
      if (!Double.isNaN(values[i])) {
        sum += values[i];
      }
    }
    if (sum == 0.0D) {
      throw MathRuntimeException.createArithmeticException("Array sums to zero", new Object[0]);
    }
    for (int i = 0; i < len; i++) {
      if (Double.isNaN(values[i])) {
        out[i] = NaN.0D;
      } else {
        out[i] = (values[i] * normalizedSum / sum);
      }
    }
    return out;
  }
  
  public static double round(double x, int scale)
  {
    return round(x, scale, 4);
  }
  
  public static double round(double x, int scale, int roundingMethod)
  {
    try
    {
      return new BigDecimal(Double.toString(x)).setScale(scale, roundingMethod).doubleValue();
    }
    catch (NumberFormatException ex)
    {
      if (Double.isInfinite(x)) {
        return x;
      }
    }
    return NaN.0D;
  }
  
  public static float round(float x, int scale)
  {
    return round(x, scale, 4);
  }
  
  public static float round(float x, int scale, int roundingMethod)
  {
    float sign = indicator(x);
    float factor = (float)Math.pow(10.0D, scale) * sign;
    return (float)roundUnscaled(x * factor, sign, roundingMethod) / factor;
  }
  
  private static double roundUnscaled(double unscaled, double sign, int roundingMethod)
  {
    switch (roundingMethod)
    {
    case 2: 
      if (sign == -1.0D) {
        unscaled = Math.floor(nextAfter(unscaled, Double.NEGATIVE_INFINITY));
      } else {
        unscaled = Math.ceil(nextAfter(unscaled, Double.POSITIVE_INFINITY));
      }
      break;
    case 1: 
      unscaled = Math.floor(nextAfter(unscaled, Double.NEGATIVE_INFINITY));
      break;
    case 3: 
      if (sign == -1.0D) {
        unscaled = Math.ceil(nextAfter(unscaled, Double.POSITIVE_INFINITY));
      } else {
        unscaled = Math.floor(nextAfter(unscaled, Double.NEGATIVE_INFINITY));
      }
      break;
    case 5: 
      unscaled = nextAfter(unscaled, Double.NEGATIVE_INFINITY);
      double fraction = unscaled - Math.floor(unscaled);
      if (fraction > 0.5D) {
        unscaled = Math.ceil(unscaled);
      } else {
        unscaled = Math.floor(unscaled);
      }
      break;
    case 6: 
      double fraction = unscaled - Math.floor(unscaled);
      if (fraction > 0.5D) {
        unscaled = Math.ceil(unscaled);
      } else if (fraction < 0.5D) {
        unscaled = Math.floor(unscaled);
      } else if (Math.floor(unscaled) / 2.0D == Math.floor(Math.floor(unscaled) / 2.0D)) {
        unscaled = Math.floor(unscaled);
      } else {
        unscaled = Math.ceil(unscaled);
      }
      break;
    case 4: 
      unscaled = nextAfter(unscaled, Double.POSITIVE_INFINITY);
      double fraction = unscaled - Math.floor(unscaled);
      if (fraction >= 0.5D) {
        unscaled = Math.ceil(unscaled);
      } else {
        unscaled = Math.floor(unscaled);
      }
      break;
    case 7: 
      if (unscaled != Math.floor(unscaled)) {
        throw new ArithmeticException("Inexact result from rounding");
      }
      break;
    case 0: 
      unscaled = Math.ceil(nextAfter(unscaled, Double.POSITIVE_INFINITY));
      break;
    default: 
      throw MathRuntimeException.createIllegalArgumentException("invalid rounding method {0}, valid methods: {1} ({2}), {3} ({4}), {5} ({6}), {7} ({8}), {9} ({10}), {11} ({12}), {13} ({14}), {15} ({16})", new Object[] { Integer.valueOf(roundingMethod), "ROUND_CEILING", Integer.valueOf(2), "ROUND_DOWN", Integer.valueOf(1), "ROUND_FLOOR", Integer.valueOf(3), "ROUND_HALF_DOWN", Integer.valueOf(5), "ROUND_HALF_EVEN", Integer.valueOf(6), "ROUND_HALF_UP", Integer.valueOf(4), "ROUND_UNNECESSARY", Integer.valueOf(7), "ROUND_UP", Integer.valueOf(0) });
    }
    return unscaled;
  }
  
  public static byte sign(byte x)
  {
    return x > 0 ? 1 : x == 0 ? 0 : -1;
  }
  
  public static double sign(double x)
  {
    if (Double.isNaN(x)) {
      return NaN.0D;
    }
    return x > 0.0D ? 1.0D : x == 0.0D ? 0.0D : -1.0D;
  }
  
  public static float sign(float x)
  {
    if (Float.isNaN(x)) {
      return NaN.0F;
    }
    return x > 0.0F ? 1.0F : x == 0.0F ? 0.0F : -1.0F;
  }
  
  public static int sign(int x)
  {
    return x > 0 ? 1 : x == 0 ? 0 : -1;
  }
  
  public static long sign(long x)
  {
    return x > 0L ? 1L : x == 0L ? 0L : -1L;
  }
  
  public static short sign(short x)
  {
    return x > 0 ? 1 : x == 0 ? 0 : -1;
  }
  
  public static double sinh(double x)
  {
    return (Math.exp(x) - Math.exp(-x)) / 2.0D;
  }
  
  public static int subAndCheck(int x, int y)
  {
    long s = x - y;
    if ((s < -2147483648L) || (s > 2147483647L)) {
      throw new ArithmeticException("overflow: subtract");
    }
    return (int)s;
  }
  
  public static long subAndCheck(long a, long b)
  {
    String msg = "overflow: subtract";
    long ret;
    if (b == Long.MIN_VALUE)
    {
      long ret;
      if (a < 0L) {
        ret = a - b;
      } else {
        throw new ArithmeticException(msg);
      }
    }
    else
    {
      ret = addAndCheck(a, -b, msg);
    }
    return ret;
  }
  
  public static int pow(int k, int e)
    throws IllegalArgumentException
  {
    if (e < 0) {
      throw MathRuntimeException.createIllegalArgumentException("cannot raise an integral value to a negative power ({0}^{1})", new Object[] { Integer.valueOf(k), Integer.valueOf(e) });
    }
    int result = 1;
    int k2p = k;
    while (e != 0)
    {
      if ((e & 0x1) != 0) {
        result *= k2p;
      }
      k2p *= k2p;
      e >>= 1;
    }
    return result;
  }
  
  public static int pow(int k, long e)
    throws IllegalArgumentException
  {
    if (e < 0L) {
      throw MathRuntimeException.createIllegalArgumentException("cannot raise an integral value to a negative power ({0}^{1})", new Object[] { Integer.valueOf(k), Long.valueOf(e) });
    }
    int result = 1;
    int k2p = k;
    while (e != 0L)
    {
      if ((e & 1L) != 0L) {
        result *= k2p;
      }
      k2p *= k2p;
      e >>= 1;
    }
    return result;
  }
  
  public static long pow(long k, int e)
    throws IllegalArgumentException
  {
    if (e < 0) {
      throw MathRuntimeException.createIllegalArgumentException("cannot raise an integral value to a negative power ({0}^{1})", new Object[] { Long.valueOf(k), Integer.valueOf(e) });
    }
    long result = 1L;
    long k2p = k;
    while (e != 0)
    {
      if ((e & 0x1) != 0) {
        result *= k2p;
      }
      k2p *= k2p;
      e >>= 1;
    }
    return result;
  }
  
  public static long pow(long k, long e)
    throws IllegalArgumentException
  {
    if (e < 0L) {
      throw MathRuntimeException.createIllegalArgumentException("cannot raise an integral value to a negative power ({0}^{1})", new Object[] { Long.valueOf(k), Long.valueOf(e) });
    }
    long result = 1L;
    long k2p = k;
    while (e != 0L)
    {
      if ((e & 1L) != 0L) {
        result *= k2p;
      }
      k2p *= k2p;
      e >>= 1;
    }
    return result;
  }
  
  public static BigInteger pow(BigInteger k, int e)
    throws IllegalArgumentException
  {
    if (e < 0) {
      throw MathRuntimeException.createIllegalArgumentException("cannot raise an integral value to a negative power ({0}^{1})", new Object[] { k, Integer.valueOf(e) });
    }
    return k.pow(e);
  }
  
  public static BigInteger pow(BigInteger k, long e)
    throws IllegalArgumentException
  {
    if (e < 0L) {
      throw MathRuntimeException.createIllegalArgumentException("cannot raise an integral value to a negative power ({0}^{1})", new Object[] { k, Long.valueOf(e) });
    }
    BigInteger result = BigInteger.ONE;
    BigInteger k2p = k;
    while (e != 0L)
    {
      if ((e & 1L) != 0L) {
        result = result.multiply(k2p);
      }
      k2p = k2p.multiply(k2p);
      e >>= 1;
    }
    return result;
  }
  
  public static BigInteger pow(BigInteger k, BigInteger e)
    throws IllegalArgumentException
  {
    if (e.compareTo(BigInteger.ZERO) < 0) {
      throw MathRuntimeException.createIllegalArgumentException("cannot raise an integral value to a negative power ({0}^{1})", new Object[] { k, e });
    }
    BigInteger result = BigInteger.ONE;
    BigInteger k2p = k;
    while (!BigInteger.ZERO.equals(e))
    {
      if (e.testBit(0)) {
        result = result.multiply(k2p);
      }
      k2p = k2p.multiply(k2p);
      e = e.shiftRight(1);
    }
    return result;
  }
  
  public static double distance1(double[] p1, double[] p2)
  {
    double sum = 0.0D;
    for (int i = 0; i < p1.length; i++) {
      sum += Math.abs(p1[i] - p2[i]);
    }
    return sum;
  }
  
  public static int distance1(int[] p1, int[] p2)
  {
    int sum = 0;
    for (int i = 0; i < p1.length; i++) {
      sum += Math.abs(p1[i] - p2[i]);
    }
    return sum;
  }
  
  public static double distance(double[] p1, double[] p2)
  {
    double sum = 0.0D;
    for (int i = 0; i < p1.length; i++)
    {
      double dp = p1[i] - p2[i];
      sum += dp * dp;
    }
    return Math.sqrt(sum);
  }
  
  public static double distance(int[] p1, int[] p2)
  {
    double sum = 0.0D;
    for (int i = 0; i < p1.length; i++)
    {
      double dp = p1[i] - p2[i];
      sum += dp * dp;
    }
    return Math.sqrt(sum);
  }
  
  public static double distanceInf(double[] p1, double[] p2)
  {
    double max = 0.0D;
    for (int i = 0; i < p1.length; i++) {
      max = Math.max(max, Math.abs(p1[i] - p2[i]));
    }
    return max;
  }
  
  public static int distanceInf(int[] p1, int[] p2)
  {
    int max = 0;
    for (int i = 0; i < p1.length; i++) {
      max = Math.max(max, Math.abs(p1[i] - p2[i]));
    }
    return max;
  }
  
  public static void checkOrder(double[] val, int dir, boolean strict)
  {
    double previous = val[0];
    
    int max = val.length;
    for (int i = 1; i < max; i++)
    {
      if (dir > 0)
      {
        if (strict)
        {
          if (val[i] <= previous) {
            throw MathRuntimeException.createIllegalArgumentException("points {0} and {1} are not strictly increasing ({2} >= {3})", new Object[] { Integer.valueOf(i - 1), Integer.valueOf(i), Double.valueOf(previous), Double.valueOf(val[i]) });
          }
        }
        else if (val[i] < previous) {
          throw MathRuntimeException.createIllegalArgumentException("points {0} and {1} are not increasing ({2} > {3})", new Object[] { Integer.valueOf(i - 1), Integer.valueOf(i), Double.valueOf(previous), Double.valueOf(val[i]) });
        }
      }
      else if (strict)
      {
        if (val[i] >= previous) {
          throw MathRuntimeException.createIllegalArgumentException("points {0} and {1} are not strictly decreasing ({2} <= {3})", new Object[] { Integer.valueOf(i - 1), Integer.valueOf(i), Double.valueOf(previous), Double.valueOf(val[i]) });
        }
      }
      else if (val[i] > previous) {
        throw MathRuntimeException.createIllegalArgumentException("points {0} and {1} are not decreasing ({2} < {3})", new Object[] { Integer.valueOf(i - 1), Integer.valueOf(i), Double.valueOf(previous), Double.valueOf(val[i]) });
      }
      previous = val[i];
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.util.MathUtils
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */