package denisenko.hw2;


/*
2.4
 */
public final class ImmutableMan {

    private String name;
    private int age;

    public ImmutableMan(String name, int age) {

        this.name = name;
        this.age = age;
    }

    public ImmutableMan setName (String name){

        ImmutableMan newName = new ImmutableMan(name,this.age);
        return newName;
    }

    public ImmutableMan setAge(int age) {

        ImmutableMan newAge = new ImmutableMan(this.name,age);
        return newAge;
    }
}
