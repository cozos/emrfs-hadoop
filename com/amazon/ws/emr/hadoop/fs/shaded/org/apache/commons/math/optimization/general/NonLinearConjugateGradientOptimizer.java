package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.general;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FunctionEvaluationException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.UnivariateRealFunction;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.solvers.UnivariateRealSolver;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.DifferentiableMultivariateRealOptimizer;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.OptimizationException;

public class NonLinearConjugateGradientOptimizer
  extends AbstractScalarDifferentiableOptimizer
  implements DifferentiableMultivariateRealOptimizer
{
  private final ConjugateGradientFormula updateFormula;
  private Preconditioner preconditioner;
  private UnivariateRealSolver solver;
  private double initialStep;
  
  public NonLinearConjugateGradientOptimizer(ConjugateGradientFormula updateFormula)
  {
    this.updateFormula = updateFormula;
    preconditioner = null;
    solver = null;
    initialStep = 1.0D;
  }
  
  public void setPreconditioner(Preconditioner preconditioner)
  {
    this.preconditioner = preconditioner;
  }
  
  public void setLineSearchSolver(UnivariateRealSolver lineSearchSolver)
  {
    solver = lineSearchSolver;
  }
  
  public void setInitialStep(double initialStep)
  {
    if (initialStep <= 0.0D) {
      this.initialStep = 1.0D;
    } else {
      this.initialStep = initialStep;
    }
  }
  
  /* Error */
  protected com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.RealPointValuePair doOptimize()
    throws FunctionEvaluationException, OptimizationException, java.lang.IllegalArgumentException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 32	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/general/NonLinearConjugateGradientOptimizer:preconditioner	Lcom/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/general/Preconditioner;
    //   4: ifnonnull +15 -> 19
    //   7: aload_0
    //   8: new 14	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/general/NonLinearConjugateGradientOptimizer$IdentityPreconditioner
    //   11: dup
    //   12: aconst_null
    //   13: invokespecial 58	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/general/NonLinearConjugateGradientOptimizer$IdentityPreconditioner:<init>	(Lcom/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/general/NonLinearConjugateGradientOptimizer$1;)V
    //   16: putfield 32	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/general/NonLinearConjugateGradientOptimizer:preconditioner	Lcom/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/general/Preconditioner;
    //   19: aload_0
    //   20: getfield 34	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/general/NonLinearConjugateGradientOptimizer:solver	Lcom/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/analysis/solvers/UnivariateRealSolver;
    //   23: ifnonnull +14 -> 37
    //   26: aload_0
    //   27: new 60	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/analysis/solvers/BrentSolver
    //   30: dup
    //   31: invokespecial 61	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/analysis/solvers/BrentSolver:<init>	()V
    //   34: putfield 34	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/general/NonLinearConjugateGradientOptimizer:solver	Lcom/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/analysis/solvers/UnivariateRealSolver;
    //   37: aload_0
    //   38: getfield 65	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/general/NonLinearConjugateGradientOptimizer:point	[D
    //   41: arraylength
    //   42: istore_1
    //   43: aload_0
    //   44: aload_0
    //   45: getfield 65	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/general/NonLinearConjugateGradientOptimizer:point	[D
    //   48: invokevirtual 69	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/general/NonLinearConjugateGradientOptimizer:computeObjectiveGradient	([D)[D
    //   51: astore_2
    //   52: aload_0
    //   53: getfield 73	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/general/NonLinearConjugateGradientOptimizer:goal	Lcom/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/GoalType;
    //   56: getstatic 78	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/GoalType:MINIMIZE	Lcom/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/GoalType;
    //   59: if_acmpne +23 -> 82
    //   62: iconst_0
    //   63: istore_3
    //   64: iload_3
    //   65: iload_1
    //   66: if_icmpge +16 -> 82
    //   69: aload_2
    //   70: iload_3
    //   71: aload_2
    //   72: iload_3
    //   73: daload
    //   74: dneg
    //   75: dastore
    //   76: iinc 3 1
    //   79: goto -15 -> 64
    //   82: aload_0
    //   83: getfield 32	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/general/NonLinearConjugateGradientOptimizer:preconditioner	Lcom/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/general/Preconditioner;
    //   86: aload_0
    //   87: getfield 65	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/general/NonLinearConjugateGradientOptimizer:point	[D
    //   90: aload_2
    //   91: invokeinterface 84 3 0
    //   96: astore_3
    //   97: aload_3
    //   98: invokevirtual 89	[D:clone	()Ljava/lang/Object;
    //   101: checkcast 85	[D
    //   104: astore 4
    //   106: dconst_0
    //   107: dstore 5
    //   109: iconst_0
    //   110: istore 7
    //   112: iload 7
    //   114: iload_1
    //   115: if_icmpge +24 -> 139
    //   118: dload 5
    //   120: aload_2
    //   121: iload 7
    //   123: daload
    //   124: aload 4
    //   126: iload 7
    //   128: daload
    //   129: dmul
    //   130: dadd
    //   131: dstore 5
    //   133: iinc 7 1
    //   136: goto -24 -> 112
    //   139: aconst_null
    //   140: astore 7
    //   142: aload_0
    //   143: aload_0
    //   144: getfield 65	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/general/NonLinearConjugateGradientOptimizer:point	[D
    //   147: invokevirtual 93	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/general/NonLinearConjugateGradientOptimizer:computeObjectiveValue	([D)D
    //   150: dstore 8
    //   152: aload 7
    //   154: astore 10
    //   156: new 95	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/RealPointValuePair
    //   159: dup
    //   160: aload_0
    //   161: getfield 65	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/general/NonLinearConjugateGradientOptimizer:point	[D
    //   164: dload 8
    //   166: invokespecial 98	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/RealPointValuePair:<init>	([DD)V
    //   169: astore 7
    //   171: aload 10
    //   173: ifnull +26 -> 199
    //   176: aload_0
    //   177: getfield 102	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/general/NonLinearConjugateGradientOptimizer:checker	Lcom/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/RealConvergenceChecker;
    //   180: aload_0
    //   181: invokevirtual 106	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/general/NonLinearConjugateGradientOptimizer:getIterations	()I
    //   184: aload 10
    //   186: aload 7
    //   188: invokeinterface 112 4 0
    //   193: ifeq +6 -> 199
    //   196: aload 7
    //   198: areturn
    //   199: aload_0
    //   200: invokevirtual 115	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/general/NonLinearConjugateGradientOptimizer:incrementIterationsCounter	()V
    //   203: dconst_0
    //   204: dstore 11
    //   206: aload 4
    //   208: astore 13
    //   210: aload 13
    //   212: arraylength
    //   213: istore 14
    //   215: iconst_0
    //   216: istore 15
    //   218: iload 15
    //   220: iload 14
    //   222: if_icmpge +26 -> 248
    //   225: aload 13
    //   227: iload 15
    //   229: daload
    //   230: dstore 16
    //   232: dload 11
    //   234: dload 16
    //   236: dload 16
    //   238: dmul
    //   239: dadd
    //   240: dstore 11
    //   242: iinc 15 1
    //   245: goto -27 -> 218
    //   248: new 11	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/general/NonLinearConjugateGradientOptimizer$LineSearchFunction
    //   251: dup
    //   252: aload_0
    //   253: aload 4
    //   255: invokespecial 118	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/general/NonLinearConjugateGradientOptimizer$LineSearchFunction:<init>	(Lcom/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/general/NonLinearConjugateGradientOptimizer;[D)V
    //   258: astore 13
    //   260: aload_0
    //   261: getfield 34	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/general/NonLinearConjugateGradientOptimizer:solver	Lcom/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/analysis/solvers/UnivariateRealSolver;
    //   264: aload 13
    //   266: dconst_0
    //   267: aload_0
    //   268: aload 13
    //   270: dconst_0
    //   271: aload_0
    //   272: getfield 36	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/general/NonLinearConjugateGradientOptimizer:initialStep	D
    //   275: invokespecial 122	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/general/NonLinearConjugateGradientOptimizer:findUpperBound	(Lcom/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/analysis/UnivariateRealFunction;DD)D
    //   278: invokeinterface 127 6 0
    //   283: dstore 18
    //   285: iconst_0
    //   286: istore 20
    //   288: iload 20
    //   290: aload_0
    //   291: getfield 65	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/general/NonLinearConjugateGradientOptimizer:point	[D
    //   294: arraylength
    //   295: if_icmpge +27 -> 322
    //   298: aload_0
    //   299: getfield 65	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/general/NonLinearConjugateGradientOptimizer:point	[D
    //   302: iload 20
    //   304: dup2
    //   305: daload
    //   306: dload 18
    //   308: aload 4
    //   310: iload 20
    //   312: daload
    //   313: dmul
    //   314: dadd
    //   315: dastore
    //   316: iinc 20 1
    //   319: goto -31 -> 288
    //   322: aload_0
    //   323: aload_0
    //   324: getfield 65	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/general/NonLinearConjugateGradientOptimizer:point	[D
    //   327: invokevirtual 69	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/general/NonLinearConjugateGradientOptimizer:computeObjectiveGradient	([D)[D
    //   330: astore_2
    //   331: aload_0
    //   332: getfield 73	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/general/NonLinearConjugateGradientOptimizer:goal	Lcom/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/GoalType;
    //   335: getstatic 78	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/GoalType:MINIMIZE	Lcom/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/GoalType;
    //   338: if_acmpne +27 -> 365
    //   341: iconst_0
    //   342: istore 20
    //   344: iload 20
    //   346: iload_1
    //   347: if_icmpge +18 -> 365
    //   350: aload_2
    //   351: iload 20
    //   353: aload_2
    //   354: iload 20
    //   356: daload
    //   357: dneg
    //   358: dastore
    //   359: iinc 20 1
    //   362: goto -18 -> 344
    //   365: dload 5
    //   367: dstore 16
    //   369: aload_0
    //   370: getfield 32	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/general/NonLinearConjugateGradientOptimizer:preconditioner	Lcom/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/general/Preconditioner;
    //   373: aload_0
    //   374: getfield 65	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/general/NonLinearConjugateGradientOptimizer:point	[D
    //   377: aload_2
    //   378: invokeinterface 84 3 0
    //   383: astore 21
    //   385: dconst_0
    //   386: dstore 5
    //   388: iconst_0
    //   389: istore 22
    //   391: iload 22
    //   393: iload_1
    //   394: if_icmpge +24 -> 418
    //   397: dload 5
    //   399: aload_2
    //   400: iload 22
    //   402: daload
    //   403: aload 21
    //   405: iload 22
    //   407: daload
    //   408: dmul
    //   409: dadd
    //   410: dstore 5
    //   412: iinc 22 1
    //   415: goto -24 -> 391
    //   418: aload_0
    //   419: getfield 30	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/general/NonLinearConjugateGradientOptimizer:updateFormula	Lcom/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/general/ConjugateGradientFormula;
    //   422: getstatic 132	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/general/ConjugateGradientFormula:FLETCHER_REEVES	Lcom/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/general/ConjugateGradientFormula;
    //   425: if_acmpne +13 -> 438
    //   428: dload 5
    //   430: dload 16
    //   432: ddiv
    //   433: dstore 23
    //   435: goto +46 -> 481
    //   438: dconst_0
    //   439: dstore 25
    //   441: iconst_0
    //   442: istore 27
    //   444: iload 27
    //   446: aload_2
    //   447: arraylength
    //   448: if_icmpge +23 -> 471
    //   451: dload 25
    //   453: aload_2
    //   454: iload 27
    //   456: daload
    //   457: aload_3
    //   458: iload 27
    //   460: daload
    //   461: dmul
    //   462: dadd
    //   463: dstore 25
    //   465: iinc 27 1
    //   468: goto -24 -> 444
    //   471: dload 5
    //   473: dload 25
    //   475: dsub
    //   476: dload 16
    //   478: ddiv
    //   479: dstore 23
    //   481: aload 21
    //   483: astore_3
    //   484: aload_0
    //   485: invokevirtual 106	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/general/NonLinearConjugateGradientOptimizer:getIterations	()I
    //   488: iload_1
    //   489: irem
    //   490: ifeq +10 -> 500
    //   493: dload 23
    //   495: dconst_0
    //   496: dcmpg
    //   497: ifge +15 -> 512
    //   500: aload_3
    //   501: invokevirtual 89	[D:clone	()Ljava/lang/Object;
    //   504: checkcast 85	[D
    //   507: astore 4
    //   509: goto +36 -> 545
    //   512: iconst_0
    //   513: istore 28
    //   515: iload 28
    //   517: iload_1
    //   518: if_icmpge +27 -> 545
    //   521: aload 4
    //   523: iload 28
    //   525: aload_3
    //   526: iload 28
    //   528: daload
    //   529: dload 23
    //   531: aload 4
    //   533: iload 28
    //   535: daload
    //   536: dmul
    //   537: dadd
    //   538: dastore
    //   539: iinc 28 1
    //   542: goto -27 -> 515
    //   545: goto -403 -> 142
    //   548: astore_1
    //   549: new 51	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/OptimizationException
    //   552: dup
    //   553: aload_1
    //   554: invokespecial 135	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/optimization/OptimizationException:<init>	(Ljava/lang/Throwable;)V
    //   557: athrow
    // Line number table:
    //   Java source line #119	-> byte code offset #0
    //   Java source line #120	-> byte code offset #7
    //   Java source line #122	-> byte code offset #19
    //   Java source line #123	-> byte code offset #26
    //   Java source line #125	-> byte code offset #37
    //   Java source line #126	-> byte code offset #43
    //   Java source line #127	-> byte code offset #52
    //   Java source line #128	-> byte code offset #62
    //   Java source line #129	-> byte code offset #69
    //   Java source line #128	-> byte code offset #76
    //   Java source line #134	-> byte code offset #82
    //   Java source line #135	-> byte code offset #97
    //   Java source line #137	-> byte code offset #106
    //   Java source line #138	-> byte code offset #109
    //   Java source line #139	-> byte code offset #118
    //   Java source line #138	-> byte code offset #133
    //   Java source line #142	-> byte code offset #139
    //   Java source line #145	-> byte code offset #142
    //   Java source line #146	-> byte code offset #152
    //   Java source line #147	-> byte code offset #156
    //   Java source line #148	-> byte code offset #171
    //   Java source line #149	-> byte code offset #176
    //   Java source line #151	-> byte code offset #196
    //   Java source line #155	-> byte code offset #199
    //   Java source line #157	-> byte code offset #203
    //   Java source line #158	-> byte code offset #206
    //   Java source line #159	-> byte code offset #232
    //   Java source line #158	-> byte code offset #242
    //   Java source line #163	-> byte code offset #248
    //   Java source line #164	-> byte code offset #260
    //   Java source line #167	-> byte code offset #285
    //   Java source line #168	-> byte code offset #298
    //   Java source line #167	-> byte code offset #316
    //   Java source line #170	-> byte code offset #322
    //   Java source line #171	-> byte code offset #331
    //   Java source line #172	-> byte code offset #341
    //   Java source line #173	-> byte code offset #350
    //   Java source line #172	-> byte code offset #359
    //   Java source line #178	-> byte code offset #365
    //   Java source line #179	-> byte code offset #369
    //   Java source line #180	-> byte code offset #385
    //   Java source line #181	-> byte code offset #388
    //   Java source line #182	-> byte code offset #397
    //   Java source line #181	-> byte code offset #412
    //   Java source line #186	-> byte code offset #418
    //   Java source line #187	-> byte code offset #428
    //   Java source line #189	-> byte code offset #438
    //   Java source line #190	-> byte code offset #441
    //   Java source line #191	-> byte code offset #451
    //   Java source line #190	-> byte code offset #465
    //   Java source line #193	-> byte code offset #471
    //   Java source line #195	-> byte code offset #481
    //   Java source line #198	-> byte code offset #484
    //   Java source line #200	-> byte code offset #500
    //   Java source line #203	-> byte code offset #512
    //   Java source line #204	-> byte code offset #521
    //   Java source line #203	-> byte code offset #539
    //   Java source line #208	-> byte code offset #545
    //   Java source line #210	-> byte code offset #548
    //   Java source line #211	-> byte code offset #549
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	558	0	this	NonLinearConjugateGradientOptimizer
    //   42	476	1	n	int
    //   548	6	1	ce	com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ConvergenceException
    //   51	403	2	r	double[]
    //   63	14	3	i	int
    //   96	430	3	steepestDescent	double[]
    //   104	428	4	searchDirection	double[]
    //   107	365	5	delta	double
    //   110	24	7	i	int
    //   140	57	7	current	com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.RealPointValuePair
    //   150	15	8	objective	double
    //   154	31	10	previous	com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.RealPointValuePair
    //   204	37	11	dTd	double
    //   208	18	13	arr$	double[]
    //   258	11	13	lsf	UnivariateRealFunction
    //   213	8	14	len$	int
    //   216	27	15	i$	int
    //   230	7	16	di	double
    //   367	110	16	deltaOld	double
    //   283	24	18	step	double
    //   286	31	20	i	int
    //   342	18	20	i	int
    //   383	99	21	newSteepestDescent	double[]
    //   389	24	22	i	int
    //   433	3	23	beta	double
    //   479	51	23	beta	double
    //   439	35	25	deltaMid	double
    //   442	24	27	i	int
    //   513	27	28	i	int
    // Exception table:
    //   from	to	target	type
    //   0	198	548	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/ConvergenceException
    //   199	548	548	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/ConvergenceException
  }
  
  private double findUpperBound(UnivariateRealFunction f, double a, double h)
    throws FunctionEvaluationException, OptimizationException
  {
    double yA = f.value(a);
    double yB = yA;
    for (double step = h; step < Double.MAX_VALUE; step *= Math.max(2.0D, yA / yB))
    {
      double b = a + step;
      yB = f.value(b);
      if (yA * yB <= 0.0D) {
        return b;
      }
    }
    throw new OptimizationException("unable to bracket optimum in line search", new Object[0]);
  }
  
  private static class IdentityPreconditioner
    implements Preconditioner
  {
    public double[] precondition(double[] variables, double[] r)
    {
      return (double[])r.clone();
    }
  }
  
  private class LineSearchFunction
    implements UnivariateRealFunction
  {
    private final double[] searchDirection;
    
    public LineSearchFunction(double[] searchDirection)
    {
      this.searchDirection = searchDirection;
    }
    
    public double value(double x)
      throws FunctionEvaluationException
    {
      double[] shiftedPoint = (double[])point.clone();
      for (int i = 0; i < shiftedPoint.length; i++) {
        shiftedPoint[i] += x * searchDirection[i];
      }
      double[] gradient = computeObjectiveGradient(shiftedPoint);
      
      double dotProduct = 0.0D;
      for (int i = 0; i < gradient.length; i++) {
        dotProduct += gradient[i] * searchDirection[i];
      }
      return dotProduct;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.general.NonLinearConjugateGradientOptimizer
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */