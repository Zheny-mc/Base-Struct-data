package Task10;

class Term implements Comparable<Term>{
    final char name = 'X';
    private double facnor;
    private int power;

    public Term(double facnor, int power) {
        this.facnor = facnor;
        this.power = power;
    }

    public double getPower() {
        return power;
    }

    public boolean IsSumm(Term otherT) {return this.power == otherT.power;}

    public Term multiplyOtherTerm(Term otherT) {
        return new Term((this.facnor * otherT.facnor),(this.power + otherT.power));
    }

    @Override
    public int compareTo(Term o) {
        return Double.compare(this.power, o.power);
    }

    @Override
    public String toString() {
        return String.format("%.2f*%c^%d", facnor, name, power);
    }
}