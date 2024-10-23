package UtilPackageTests.extensions.java.lang.Double;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;
import util.math.Arithmetic;

import java.lang.Double;

@Extension
public abstract class DoubleExtension implements Arithmetic<Double> {
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
  public static Double exp(@This Double thiz)
  {
    return Math.exp(thiz);
  }
  public static Double ln(@This Double thiz)
  {
    return Math.log(thiz);
  }
  public static boolean lt(@This Double thiz, Double other){return thiz<other;}
  public static boolean le(@This Double thiz, Double other){return thiz<=other;}
  public static boolean gt(@This Double thiz, Double other){return thiz>other;}
  public static boolean ge(@This Double thiz, Double other){return thiz>=other;}


}