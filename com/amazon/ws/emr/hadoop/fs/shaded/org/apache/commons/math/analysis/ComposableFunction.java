package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FunctionEvaluationException;

public abstract class ComposableFunction
  implements UnivariateRealFunction
{
  public static final ComposableFunction ZERO = new ComposableFunction()
  {
    public double value(double d)
    {
      return 0.0D;
    }
  };
  public static final ComposableFunction ONE = new ComposableFunction()
  {
    public double value(double d)
    {
      return 1.0D;
    }
  };
  public static final ComposableFunction IDENTITY = new ComposableFunction()
  {
    public double value(double d)
    {
      return d;
    }
  };
  public static final ComposableFunction ABS = new ComposableFunction()
  {
    public double value(double d)
    {
      return Math.abs(d);
    }
  };
  public static final ComposableFunction NEGATE = new ComposableFunction()
  {
    public double value(double d)
    {
      return -d;
    }
  };
  public static final ComposableFunction INVERT = new ComposableFunction()
  {
    public double value(double d)
    {
      return 1.0D / d;
    }
  };
  public static final ComposableFunction SIN = new ComposableFunction()
  {
    public double value(double d)
    {
      return Math.sin(d);
    }
  };
  public static final ComposableFunction SQRT = new ComposableFunction()
  {
    public double value(double d)
    {
      return Math.sqrt(d);
    }
  };
  public static final ComposableFunction SINH = new ComposableFunction()
  {
    public double value(double d)
    {
      return Math.sinh(d);
    }
  };
  public static final ComposableFunction EXP = new ComposableFunction()
  {
    public double value(double d)
    {
      return Math.exp(d);
    }
  };
  public static final ComposableFunction EXPM1 = new ComposableFunction()
  {
    public double value(double d)
    {
      return Math.expm1(d);
    }
  };
  public static final ComposableFunction ASIN = new ComposableFunction()
  {
    public double value(double d)
    {
      return Math.asin(d);
    }
  };
  public static final ComposableFunction ATAN = new ComposableFunction()
  {
    public double value(double d)
    {
      return Math.atan(d);
    }
  };
  public static final ComposableFunction TAN = new ComposableFunction()
  {
    public double value(double d)
    {
      return Math.tan(d);
    }
  };
  public static final ComposableFunction TANH = new ComposableFunction()
  {
    public double value(double d)
    {
      return Math.tanh(d);
    }
  };
  public static final ComposableFunction CBRT = new ComposableFunction()
  {
    public double value(double d)
    {
      return Math.cbrt(d);
    }
  };
  public static final ComposableFunction CEIL = new ComposableFunction()
  {
    public double value(double d)
    {
      return Math.ceil(d);
    }
  };
  public static final ComposableFunction FLOOR = new ComposableFunction()
  {
    public double value(double d)
    {
      return Math.floor(d);
    }
  };
  public static final ComposableFunction LOG = new ComposableFunction()
  {
    public double value(double d)
    {
      return Math.log(d);
    }
  };
  public static final ComposableFunction LOG10 = new ComposableFunction()
  {
    public double value(double d)
    {
      return Math.log10(d);
    }
  };
  public static final ComposableFunction LOG1P = new ComposableFunction()
  {
    public double value(double d)
    {
      return Math.log1p(d);
    }
  };
  public static final ComposableFunction COS = new ComposableFunction()
  {
    public double value(double d)
    {
      return Math.cos(d);
    }
  };
  public static final ComposableFunction ACOS = new ComposableFunction()
  {
    public double value(double d)
    {
      return Math.acos(d);
    }
  };
  public static final ComposableFunction COSH = new ComposableFunction()
  {
    public double value(double d)
    {
      return Math.cosh(d);
    }
  };
  public static final ComposableFunction RINT = new ComposableFunction()
  {
    public double value(double d)
    {
      return Math.rint(d);
    }
  };
  public static final ComposableFunction SIGNUM = new ComposableFunction()
  {
    public double value(double d)
    {
      return Math.signum(d);
    }
  };
  public static final ComposableFunction ULP = new ComposableFunction()
  {
    public double value(double d)
    {
      return Math.ulp(d);
    }
  };
  
  public ComposableFunction of(final UnivariateRealFunction f)
  {
    new ComposableFunction()
    {
      public double value(double x)
        throws FunctionEvaluationException
      {
        return ComposableFunction.this.value(f.value(x));
      }
    };
  }
  
  public ComposableFunction postCompose(final UnivariateRealFunction f)
  {
    new ComposableFunction()
    {
      public double value(double x)
        throws FunctionEvaluationException
      {
        return f.value(ComposableFunction.this.value(x));
      }
    };
  }
  
  public ComposableFunction combine(final UnivariateRealFunction f, final BivariateRealFunction combiner)
  {
    new ComposableFunction()
    {
      public double value(double x)
        throws FunctionEvaluationException
      {
        return combiner.value(ComposableFunction.this.value(x), f.value(x));
      }
    };
  }
  
  public ComposableFunction add(final UnivariateRealFunction f)
  {
    new ComposableFunction()
    {
      public double value(double x)
        throws FunctionEvaluationException
      {
        return ComposableFunction.this.value(x) + f.value(x);
      }
    };
  }
  
  public ComposableFunction add(final double a)
  {
    new ComposableFunction()
    {
      public double value(double x)
        throws FunctionEvaluationException
      {
        return ComposableFunction.this.value(x) + a;
      }
    };
  }
  
  public ComposableFunction subtract(final UnivariateRealFunction f)
  {
    new ComposableFunction()
    {
      public double value(double x)
        throws FunctionEvaluationException
      {
        return ComposableFunction.this.value(x) - f.value(x);
      }
    };
  }
  
  public ComposableFunction multiply(final UnivariateRealFunction f)
  {
    new ComposableFunction()
    {
      public double value(double x)
        throws FunctionEvaluationException
      {
        return ComposableFunction.this.value(x) * f.value(x);
      }
    };
  }
  
  public ComposableFunction multiply(final double scaleFactor)
  {
    new ComposableFunction()
    {
      public double value(double x)
        throws FunctionEvaluationException
      {
        return ComposableFunction.this.value(x) * scaleFactor;
      }
    };
  }
  
  public ComposableFunction divide(final UnivariateRealFunction f)
  {
    new ComposableFunction()
    {
      public double value(double x)
        throws FunctionEvaluationException
      {
        return ComposableFunction.this.value(x) / f.value(x);
      }
    };
  }
  
  public MultivariateRealFunction asCollector(BivariateRealFunction combiner, final double initialValue)
  {
    new MultivariateRealFunction()
    {
      public double value(double[] point)
        throws FunctionEvaluationException, IllegalArgumentException
      {
        double result = initialValue;
        for (double entry : point) {
          result = val$combiner.value(result, value(entry));
        }
        return result;
      }
    };
  }
  
  public MultivariateRealFunction asCollector(BivariateRealFunction combiner)
  {
    return asCollector(combiner, 0.0D);
  }
  
  public MultivariateRealFunction asCollector(double initialValue)
  {
    return asCollector(BinaryFunction.ADD, initialValue);
  }
  
  public MultivariateRealFunction asCollector()
  {
    return asCollector(BinaryFunction.ADD, 0.0D);
  }
  
  public abstract double value(double paramDouble)
    throws FunctionEvaluationException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.ComposableFunction
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */