package lamp;

public class Green implements State {

    private static volatile Green green = null;

    private Green() {
    }

    public static Green getInstance() {
        if (green == null) {
            synchronized (Green.class) {
                if (green == null) {
                    green = new Green();
                }
            }
        }
        return green;
    }

    @Override
    public void getColor() {
        System.out.println("当前颜色为绿色");
    }

    @Override
    public void light() {
        System.out.println("绿灯持续3 秒");
        for (int i = 0; i < 3; i ++) {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "green time :" + (i + 1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
