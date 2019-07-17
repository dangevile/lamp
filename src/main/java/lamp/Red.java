package lamp;

public class Red implements State {

    private static volatile Red red = null;

    private Red() {
    }

    public static Red getInstance() {
        if (red == null) {
            synchronized (Red.class) {
                if (red == null) {
                    red = new Red();
                }
            }
        }
        return red;
    }

    @Override
    public void getColor() {
        System.out.println("当前颜色为红色");
    }

    @Override
    public void light() {
        try {
            System.out.println("红灯持续2秒");
            for (int i = 0 ; i < 2 ; i ++) {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "red time :" + (i + 1));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
