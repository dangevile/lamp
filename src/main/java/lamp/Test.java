package lamp;

public class Test {
    public  static void main (String [] args) {
        Lamp light = new Lamp();
        light.setState(Yellow.getInstance());//set current lamp to yellow
        light.getColor(); //get current lamp color
        light.setState(Red.getInstance());
        light.getColor();


        Thread thread = new Thread(light);
        thread.start();
        light.setState(Green.getInstance());
        light.getColor();
        Thread thread2 = new Thread(light);
        thread2.start();
        try {
            Thread.sleep(10000);
            Lamp.flag = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
