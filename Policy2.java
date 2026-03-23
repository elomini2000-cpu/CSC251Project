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

    /**
     * No-argument constructor that sets default values.
     */
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

    /**
     * Constructor that accepts arguments for each field.
     * @param policyNumber the policy number
     * @param providerName the provider name
     * @param firstName the policyholder's first name
     * @param lastName the policyholder's last name
     * @param age the policyholder's age
     * @param smokingStatus the policyholder's smoking status (smoker or non-smoker)
     * @param height the policyholder's height in inches
     * @param weight the policyholder's weight in pounds
     */
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

    /**
     * Gets the policy number.
     * @return the policy number
     */
    public int getPolicyNumber() {
        return policyNumber;
    }

    /**
     * Sets the policy number.
     * @param policyNumber the policy number
     */
    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }

    /**
     * Gets the provider name.
     * @return the provider name
     */
    public String getProviderName() {
        return providerName;
    }

    /**
     * Sets the provider name.
     * @param providerName the provider name
     */
    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    /**
     * Gets the policyholder's first name.
     * @return the policyholder's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the policyholder's first name.
     * @param firstName the policyholder's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the policyholder's last name.
     * @return the policyholder's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the policyholder's last name.
     * @param lastName the policyholder's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the policyholder's age.
     * @return the policyholder's age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the policyholder's age.
     * @param age the policyholder's age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets the policyholder's smoking status.
     * @return the policyholder's smoking status
     */
    public String getSmokingStatus() {
        return smokingStatus;
    }

    /**
     * Sets the policyholder's smoking status.
     * @param smokingStatus the policyholder's smoking status
     */
    public void setSmokingStatus(String smokingStatus) {
        this.smokingStatus = smokingStatus.toLowerCase();
    }

    /**
     * Gets the policyholder's height.
     * @return the policyholder's height in inches
     */
    public double getHeight() {
        return height;
    }

    /**
     * Sets the policyholder's height.
     * @param height the policyholder's height in inches
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Gets the policyholder's weight.
     * @return the policyholder's weight in pounds
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Sets the policyholder's weight.
     * @param weight the policyholder's weight in pounds
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Calculates the policyholder's BMI.
     * @return the BMI value
     */
    public double calculateBMI() {
        if (height <= 0) {
            return 0;
        }
        return Math.round((weight * 703 / (height * height)) * 100.0) / 100.0;
    }

    /**
     * Calculates the price of the policy.
     * @return the price of the policy
     */
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