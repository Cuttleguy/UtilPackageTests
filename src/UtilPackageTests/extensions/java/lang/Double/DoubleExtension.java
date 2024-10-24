package UtilPackageTests.extensions.java.lang.Double;

import manifold.ext.rt.api.ComparableUsing;
import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;
import util.math.Arithmetic;

import java.lang.Double;

@Extension
public abstract class DoubleExtension implements Arithmetic<Double>{
  public static void helloWorld(@This Double thiz) {
    System.out.println("hello world!");
  }


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
    return thiz%other;
  }
  public static Double negate(@This Double thiz) {
    return -thiz;
  }
  public static Double doubleVal(@This Double thiz) {
    return -thiz;
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
  public static Double exp(@This Double thiz, Double other)
  {
    return Math.exp(other);
  }
  public static Double ln(@This Double thiz, Double other)
  {
    return Math.log(other);
  }




}