package timingtest;
import afu.org.checkerframework.checker.igj.qual.I;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();
        int base = 1000;
        int M = 10000;
        for (int i = 0; i < 8; i++) {
            if(i > 0){
                base *= 2;
            }
            AList<Integer> test = new AList<>();
            for (int j = 0; j < base; j++) {
                test.addLast(1);
            }

            Stopwatch sw = new Stopwatch();
            for (int j = 0; j < M; j++) {
                test.getLast();
            }
            double timeInSeconds = sw.elapsedTime();
            Ns.addLast(base);
            times.addLast(timeInSeconds);
            opCounts.addLast(M);
        }
        printTimingTable(Ns, times, opCounts);


    }

}
