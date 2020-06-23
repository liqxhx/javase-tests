package string;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * <p> 类描述: TODO
 *
 * @author liqxhx
 * @version TODO
 * @date 2020/01/14 15:57
 * @since 2020/01/14 15:57
 */
public class IDGenerator {
    private final static int ZERO = 0;
    private final static int ONE = 1;
    private final static AtomicInteger COUNTER = new AtomicInteger(ZERO);
    private final static AtomicLong TOTAL_COUNTER = new AtomicLong(ZERO);
    private final static Semaphore MUTEX = new Semaphore(ONE);
    private final static String PTN_TIME_STAMP = "yyyyMMddHHmmss";
    private final static String PTN_ID = "%s%s%05d";
    private static int lastSecond = LocalDateTime.now().getSecond();


    public static String next(String prefix) {
        try {
            MUTEX.acquire();
            LocalDateTime now = LocalDateTime.now();
            int nowSecond = now.getSecond();
            if(nowSecond != lastSecond) {
                lastSecond = nowSecond;
                COUNTER.set(ZERO);
            }
            String timeStampStr = now.format(DateTimeFormatter.ofPattern(PTN_TIME_STAMP));
            if(true) {
                throw new RuntimeException();
            }
            return String.format(PTN_ID, prefix, timeStampStr, COUNTER.incrementAndGet());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            TOTAL_COUNTER.incrementAndGet();
            MUTEX.release();
        }

        return String.format(PTN_ID, prefix, System.currentTimeMillis(), TOTAL_COUNTER.get());
    }

    /**
    * main
    */
    public static void main(String[] args) throws UnknownHostException {
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));

        System.out.println(String.format("%05d", 0));

        System.out.println(LocalDateTime.now().getSecond());

        int i = 10;
        while(i > 0) {
            i--;
            try {
            System.out.println(next("208"));


                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println(InetAddress.getLocalHost().getHostAddress());

        System.out.println("2020011416585320800004".length());

    }
}
