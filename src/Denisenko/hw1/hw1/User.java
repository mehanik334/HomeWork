package denisenko.hw1.hw1;

public class User implements Cloneable {

    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {

        User deepClone = (User) super.clone();
        return deepClone;
    }

    @Override
    public String toString() {
        return super.toString() + "name: " + getName() + " password: " + getPassword();
    }
}
