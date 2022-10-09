public class Complex {
    private double re, im;

    public double getRe() {
        return re;
    }

    public void setRe(double re) {
        this.re = re;
    }

    public double getIm() {
        return im;
    }

    public void setIm(double im) {
        this.im = im;
    }

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public Complex addition(Complex oth) {
        return new Complex(this.re + oth.re, this.im + oth.im);
    }

    public Complex substraction(Complex oth){
        return new Complex(this.re - oth.re, this.im - oth.im);
    }

    public Complex multiplication(Complex oth){
        return new Complex((this.re*oth.re)-(this.im*oth.im),
                (this.re*oth.im) + (this.im*oth.re));
    }

    public Complex conjugate(){
        return new Complex(this.re, -this.im);
    }

    public Complex division(Complex oth){
        double denominator = (oth.re* oth.re) - (oth.im* oth.im);
        Complex numerator = this.multiplication(oth.conjugate());
        return new Complex(numerator.re/denominator, numerator.im/denominator);
    }
}
