//package util.math;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class PrimeNumberGenerator {
//    public static List<Integer> generatePrimeNumbers(int limit)
//    {
//        List<Integer> primes=new ArrayList<>();
//        for (int i = 2; i < limit+1; i++) {
//            boolean wasPrime=true;
//            for(Integer prime:primes)
//            {
//                wasPrime&=i%prime!=0;
//                if(!wasPrime)
//                {
//                    break;
//                }
//            }
//            if(wasPrime)
//            {
//                primes.add(i);
//            }
//        }
//        return primes;
//    }
//}