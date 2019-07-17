package lamp;

public class Lamp implements Light {
    public static boolean flag = true;//可以在其他线程修改flag值来终止这个线程运行,可以不要
    private  State red = Red.getInstance();
    private  State green = Green.getInstance();
    private  State yellow = Yellow.getInstance();
    private  State state = Red.getInstance();

    @Override
    public void getColor() {
        this.state.getColor();
    }

    void setState(State state) {
        this.state = state;
    }

    @Override
    public void run() {//灯颜色顺序为绿黄红
        if(this.state instanceof Green) {
            while (flag) {
                this.state = green;
                this.state.light();
                this.state = yellow;
                this.state.light();
                this.state = red;
                this.state.light();
            }
        } else if (this.state instanceof Red) {
            while (flag) {
                this.state = red;
                this.state.light();
                this.state = green;
                this.state.light();
                this.state = yellow;
                this.state.light();
            }
        } else if (this.state instanceof Yellow){
            while (flag) {
                this.state = yellow;
                this.state.light();
                this.state = red;
                this.state.light();
                this.state = green;
                this.state.light();
            }
        } else {
            System.out.println("error");
        }
    }
}
