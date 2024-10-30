package UtilPackageTests.extensions.java.lang.Double;

import manifold.ext.rt.api.ComparableUsing;
import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;
import util.math.Arithmetic;

import java.lang.Double;
import java.util.Objects;

@Extension
public abstract class DoubleExtension implements Arithmetic<Double>{


  public static Double add(@This Double thiz,Double other) {
    return thiz+other;
  }
  public static Double subtract(@This Double thiz,Double other) {
    return thiz-other;
  }
  public static Double multiply(@This Double thiz,Double other) {
    return thiz*other;
  }
  public static Double divide(@This Double thiz,Double other) {
    return thiz/other;
  }
  public static Double remainder(@This Double thiz,Double other) {
    if(thiz%other==-0.0)
    {
      return 0.0;
    }
    return thiz%other;
  }
  public static Double negate(@This Double thiz) {
    return -thiz;
  }
  public static Double doubleVal(@This Double thiz) {
    return thiz;
  }

  public static boolean lt(@This Double thiz, Double other){return thiz<other;}
  public static boolean le(@This Double thiz, Double other){return thiz<=other;}
  public static boolean gt(@This Double thiz, Double other){return thiz>other;}
  public static boolean ge(@This Double thiz, Double other){return thiz>=other;}
  public static Double from(@This Double thiz, Double value){

    return value;
  }

  public static Double from(@This Double thiz, Integer value){
    return value.doubleValue();
  }
  public static Double sqrt(@This Double thiz)
  {
    return Math.sqrt(thiz);
  }


//  public static String toString(@This Double thiz)
//  {
//    System.out.println(thiz);
//    return Double.toString(thiz);
//  }
  public static Double sin(@This Double thiz, Double other)
  {
    return Math.sin(other);
  }
  public static Double cos(@This Double thiz, Double other)
  {
    return Math.cos(other);
  }
  public static Double sinh(@This Double thiz, Double other)
  {
    return Math.sinh(other);
  }
  public static Double cosh(@This Double thiz, Double other)
  {
    return Math.cosh(other);
  }
  public static Double sec(@This Double thiz, Double other)
  {
    return 1/Math.cos(other);
  }
  public static Double csc(@This Double thiz, Double other)
  {
    return 1/Math.sin(other);
  }
  public static Double tan(@This Double thiz, Double other)
  {
    return Math.tan(other);
  }
  public static Double tanh(@This Double thiz, Double other)
  {
    return Math.tanh(other);
  }
  public static Double sech(@This Double thiz, Double other)
  {
    return 1/Math.cosh(other);
  }
  public static Double csch(@This Double thiz, Double other)
  {
    return 1/Math.sinh(other);
  }
  public static Double cot(@This Double thiz, Double other)
  {
    return 1/Math.tan(other);
  }
  public static Double coth(@This Double thiz, Double other)
  {
    return 1/Math.tanh(other);
  }

  public static Double exp(@This Double thiz, Double other)
  {
    return Math.exp(other);
  }
  public static Double ln(@This Double thiz, Double other)
  {
    return Math.log(other);
  }
  public static Double gcf(@This Double thiz, Double input,Double other)
  {
    if(Objects.equals(other,0.0))
    {
      return input;
    }
    else
    {

      return thiz.gcf(other,input.remainder(other));
    }

  }
  public static Double lcm( @ This Double thiz,Double input,Double other)
  {
    return input.multiply(other).divide(thiz.gcf(input,other));
  }
  public static Double pow(@This Double thiz, Double input, Integer other)
  {
    return Math.pow(input,other);
  }




}