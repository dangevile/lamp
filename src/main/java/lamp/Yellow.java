package lamp;

public class Yellow implements State {

    private static volatile Yellow yellow = null;

    private Yellow() {
    }

    public static Yellow getInstance() {
        if (yellow == null) {
            synchronized (Yellow.class) {
                if (yellow == null) {
                    yellow = new Yellow();
                }
            }
        }
        return yellow;
    }

    @Override
    public void getColor() {
        System.out.println("当前颜色为黄色");
    }

    @Override
    public void light() {
        System.out.println("黄灯持续2秒");
        for (int i = 0 ; i < 2 ; i ++) {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "yellow time :" + (i + 1) );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
