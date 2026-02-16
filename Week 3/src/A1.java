import java.util.*;
class A1 extends Thread{
    String name;
    int c=0;
    static boolean racewon=false;
    int steps;

    public A1(String name, int steps){
        this.name=name;
        this.steps=steps;
    }
    public void run()
    {
        while(!racewon && c<steps)
        {
            c++;
            System.out.println(name+" at step "+c);

            if(c==steps && !racewon)
            {
                racewon=true;
                System.out.println(name + " wins race");
            }

            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(name+ " has been interrupted");
            }
        }

    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the max no. of steps");
        int steps=sc.nextInt();

        A1 t1 = new A1("Runner 1", steps);
        A1 t2 = new A1("Runner 2", steps);
        A1 t3 = new A1("Runner 3", steps);

        t1.start();
        t2.start();
        t3.start();
    }

}

