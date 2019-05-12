package denisenko.hw13.model;

import java.util.Objects;

public class Code {

    private Long userId;
    private Long goodId;
    private String value;

    public Code(Long userId, Long goodId, String value) {
        this.userId = userId;
        this.goodId = goodId;
        this.value = value;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGoodId() {
        return goodId;
    }

    public void setGoodId(Long goodId) {
        this.goodId = goodId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Code)) return false;
        Code code = (Code) o;
        return Objects.equals(getUserId(), code.getUserId()) &&
                Objects.equals(getGoodId(), code.getGoodId()) &&
                Objects.equals(getValue(), code.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getGoodId(), getValue());
    }

    @Override
    public String toString() {
        return "Code{" +
                "userId=" + userId +
                ", goodId=" + goodId +
                ", value='" + value + '\'' +
                '}';
    }
}
