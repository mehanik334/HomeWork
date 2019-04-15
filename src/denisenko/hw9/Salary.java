package denisenko.hw9;

public class Salary extends Message<Integer> {

    private Integer bonus;

    public Salary(String from, String to, Integer context) {
        super(from, to, context);
    }

    public Salary(String from, String to, Integer context, Integer bonus) {
        super(from, to, context);
        this.bonus = bonus;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }
}
