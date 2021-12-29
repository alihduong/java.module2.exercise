public class Students extends Human{
    private double average;

    public Students(String name, int age, String gender, String address, double average) {
        super(name, age, gender, address);
        this.average = average;
    }

    public Students(double average) {
        this.average = average;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
