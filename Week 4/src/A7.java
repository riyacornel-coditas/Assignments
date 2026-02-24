interface Hello{
    public void greet();
}
public static void main(String[] args)
{
    Hello obj = new Hello(){
        @Override
        public void greet() {
            System.out.println("Hello........");
        }
    };

    obj.greet();

    int total=0;
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);

    for(Integer _:list)
    {
        total++;
    }

    System.out.println("Total there are "+total+" elements");
}