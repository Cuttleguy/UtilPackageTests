package UtilPackageTests.extensions.java.lang.Integer;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;
import util.math.Arithmetic;

import java.lang.Integer;

@Extension
public abstract class IntegerExtension implements Arithmetic<Integer> {
  public static Integer add(@This Integer thiz,Integer other) {
    return thiz+other;
  }
  public static Integer subtract(@This Integer thiz,Integer other) {
    return thiz-other;
  }
  public static Integer multiply(@This Integer thiz,Integer other) {
    return thiz*other;
  }
  public static Integer divide(@This Integer thiz,Integer other) {
    return thiz/other;
  }
  public static Integer remainder(@This Integer thiz,Integer other) {
    if(thiz%other==-0)
    {
      return 0;
    }
    return thiz%other;
  }
  public static Integer negate(@This Integer thiz) {
    return -thiz;
  }
  public static Integer IntegerVal(@This Integer thiz) {
    return thiz;
  }

  public static boolean lt(@This Integer thiz, Integer other){return thiz<other;}
  public static boolean le(@This Integer thiz, Integer other){return thiz<=other;}
  public static boolean gt(@This Integer thiz, Integer other){return thiz>other;}
  public static boolean ge(@This Integer thiz, Integer other){return thiz>=other;}
  public static Integer from(@This Integer thiz, Integer value){

    return value;
  }

  public static Integer from(@This Integer thiz, Double value){
    return value.intValue();
  }
  public static Integer sqrt(@This Integer thiz)
  {
    return Double.valueOf(Math.sqrt(thiz)).intValue();
  }
  public static Integer sin(@This Integer thiz, Integer other)
  {
    return Double.valueOf(Math.sin(other.doubleValue())).intValue();
  }
  public static Integer cos(@This Integer thiz, Integer other)
  {
    return Double.valueOf(Math.cos(other.doubleValue())).intValue();
  }
  public static Integer sinh(@This Integer thiz, Integer other)
  {
    return Double.valueOf(Math.sinh(other.doubleValue())).intValue();
  }
  public static Integer cosh(@This Integer thiz, Integer other)
  {
    return Double.valueOf(Math.cosh(other.doubleValue())).intValue();
  }
  public static Integer sec(@This Integer thiz, Integer other)
  {
    return Double.valueOf(1/Math.cos(other.doubleValue())).intValue();
  }
  public static Integer csc(@This Integer thiz, Integer other)
  {
    return Double.valueOf(1/Math.sin(other.doubleValue())).intValue();
  }
  public static Integer tan(@This Integer thiz, Integer other)
  {
    return Double.valueOf(Math.tan(other.doubleValue())).intValue();
  }
  public static Integer tanh(@This Integer thiz, Integer other)
  {
    return Double.valueOf(Math.tanh(other.doubleValue())).intValue();
  }
  public static Integer sech(@This Integer thiz, Integer other)
  {
    return Double.valueOf(1/Math.cosh(other.doubleValue())).intValue();
  }
  public static Integer csch(@This Integer thiz, Integer other)
  {
    return Double.valueOf(1/Math.sinh(other.doubleValue())).intValue();
  }
  public static Integer cot(@This Integer thiz, Integer other)
  {
    return Double.valueOf(1/Math.tan(other.doubleValue())).intValue();
  }
  public static Integer coth(@This Integer thiz, Integer other)
  {
    return Double.valueOf(1/Math.tanh(other.doubleValue())).intValue();
  }

  public static Integer exp(@This Integer thiz, Integer other)
  {
    return Double.valueOf(Math.exp(other.doubleValue())).intValue();
  }
  public static Integer ln(@This Integer thiz, Integer other)
  {
    return Double.valueOf(Math.log(other.doubleValue())).intValue();
  }
  public static Double doubleVal(@This Integer thiz)
  {
    return thiz.doubleValue();
  }
}