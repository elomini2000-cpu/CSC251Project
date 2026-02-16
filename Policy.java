public class Policy {

    // Fields (attributes)
    private int policyNumber;
    private String providerName;
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;
    private double height;
    private double weight;

    // -----------------------------------
    // No-argument constructor
    // -----------------------------------
    public Policy() {
        policyNumber = 0;
        providerName = "None";
        firstName = "None";
        lastName = "None";
        age = 0;
        smokingStatus = "non-smoker";
        height = 0.0;
        weight = 0.0;
    }

    // -----------------------------------
    // Constructor with arguments
    // -----------------------------------
    public Policy(int policyNumber, String providerName,
                  String firstName, String lastName,
                  int age, String smokingStatus,
                  double height, double weight) {

        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus.toLowerCase();
        this.height = height;
        this.weight = weight;
    }

    // -----------------------------------
    // Getters and Setters
    // -----------------------------------

    public int getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSmokingStatus() {
        return smokingStatus;
    }

    public void setSmokingStatus(String smokingStatus) {
        this.smokingStatus = smokingStatus.toLowerCase();
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    // -----------------------------------
    // Calculate BMI
    // -----------------------------------
    public double calculateBMI() {
        if (height <= 0) {
            return 0;
        }
        return Math.round((weight * 703 / (height * height)) * 100.0) / 100.0;
    }

    // -----------------------------------
    // Calculate Policy Price
    // -----------------------------------
    public double calculatePolicyPrice() {

        double price = 600;

        if (age > 50) {
            price += 75;
        }

        if (smokingStatus.equals("smoker")) {
            price += 100;
        }

        double bmi = calculateBMI();

        if (bmi > 35) {
            price += (bmi - 35) * 20;
        }

        return Math.round(price * 100.0) / 100.0;
    }
}