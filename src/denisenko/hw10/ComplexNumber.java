package denisenko.hw10;

public class ComplexNumber {

    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    @Override
    public int hashCode() {

        if ((re == 0) && (im == 0)) {
            return 0;
        }

        int res = (int) (31 + (re * im) * 2 / 3);
        return res;

    }


    @Override
    public boolean equals(Object obj) {
        ComplexNumber cn = (ComplexNumber) obj;
        if(cn == null || cn.getClass()!=this.getClass()){
            return false;
        }
        boolean equalsIm = cn.getIm() == this.im;
        boolean equlasRe = cn.getRe() == this.re;
        return equalsIm && equlasRe;
    }
}
