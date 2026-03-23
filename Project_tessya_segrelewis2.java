import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class PolicyDemo {

    public static void main(String[] args) throws IOException {

        // ArrayList to store Policy objects
        ArrayList<Policy> policies = new ArrayList<Policy>();

        // Read policy information from the text file
        File file = new File("PolicyInformation.txt");
        Scanner inputFile = new Scanner(file);

        while (inputFile.hasNext()) {
            int policyNumber = Integer.parseInt(inputFile.nextLine().trim());
            String providerName = inputFile.nextLine().trim();
            String firstName = inputFile.nextLine().trim();
            String lastName = inputFile.nextLine().trim();
            int age = Integer.parseInt(inputFile.nextLine().trim());
            String smokingStatus = inputFile.nextLine().trim();
            double height = Double.parseDouble(inputFile.nextLine().trim());
            double weight = Double.parseDouble(inputFile.nextLine().trim());

            // Create a Policy object and add it to the ArrayList
            Policy policy = new Policy(policyNumber, providerName,
                                       firstName, lastName,
                                       age, smokingStatus,
                                       height, weight);
            policies.add(policy);

            // Skip the blank line between records (if there is one)
            if (inputFile.hasNext()) {
                inputFile.nextLine();
            }
        }

        inputFile.close();

        // Counters for smokers and non-smokers
        int smokerCount = 0;
        int nonSmokerCount = 0;

        // Display information for each Policy object
        for (Policy policy : policies) {
            System.out.println("Policy Number: " + policy.getPolicyNumber());
            System.out.println("Provider Name: " + policy.getProviderName());
            System.out.println("Policyholder's First Name: " + policy.getFirstName());
            System.out.println("Policyholder's Last Name: " + policy.getLastName());
            System.out.println("Policyholder's Age: " + policy.getAge());
            System.out.println("Policyholder's Smoking Status: " + policy.getSmokingStatus());
            System.out.println("Policyholder's Height: " + policy.getHeight() + " inches");
            System.out.println("Policyholder's Weight: " + policy.getWeight() + " pounds");
            System.out.printf("Policyholder's BMI: %.2f\n", policy.calculateBMI());
            System.out.printf("Policy Price: $%.2f\n", policy.calculatePolicyPrice());
            System.out.println();

            // Count smokers and non-smokers
            if (policy.getSmokingStatus().equals("smoker")) {
                smokerCount++;
            } else {
                nonSmokerCount++;
            }
        }

        // Display smoker/non-smoker counts
        System.out.println("The number of policies with a smoker is: " + smokerCount);
        System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);
    }
}