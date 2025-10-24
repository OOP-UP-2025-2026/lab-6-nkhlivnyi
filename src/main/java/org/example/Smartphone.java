package ua.opnu;

public class Smartphone {

    private double latitude;
    private double longitude;
    private String phoneNumber;

    public Smartphone(String phoneNumber, double latitude, double longitude) {
        this.phoneNumber = phoneNumber;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Методи, які реалізують GPS
    public double[] getCoordinates() {
        return new double[]{latitude, longitude};
    }

    // Методи, які реалізують Cellular
    public void makeCall(String targetNumber) {
        System.out.println("Дзвінок з " + phoneNumber + " до " + targetNumber);
    }

    public void receiveCall(String caller) {
        System.out.println("Вхідний дзвінок від " + caller);
    }

    public void setCoordinates(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "phone='" + phoneNumber + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    public static void main(String[] args) {
        Smartphone phone = new Smartphone("+380501234567", 50.4501, 30.5234);
        System.out.println(phone);

        phone.makeCall("+380971234567");
        phone.receiveCall("+380661234567");

        phone.setCoordinates(49.8397, 24.0297);
        double[] coords = phone.getCoordinates();
        System.out.println("Нові координати: широта=" + coords[0] + ", довгота=" + coords[1]);
    }
}
