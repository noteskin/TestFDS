public class WaitTime {

     static void SleepTime(int t){
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 默认等待时间500
     */
     static void SleepTime(){
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
