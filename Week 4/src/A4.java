
    sealed class Animal permits Dog,Cat{
        public void print()
        {
            System.out.println("I am an Animal");
        }
    }

    non-sealed class Dog extends Animal
    {
        @Override
        public void print() {

            System.out.println("Im  A Dog");
        }
    }

    non-sealed class Cat extends Animal{
        @Override
        public void print() {

            System.out.println("Im  A Cat");
        }
    }

    public class A4{
    public static void main(String[] args)
    {
        Animal obj1 = new Dog();
        Animal obj2 = new Cat();

        obj1.print();
        obj2.print();
    }
    }

