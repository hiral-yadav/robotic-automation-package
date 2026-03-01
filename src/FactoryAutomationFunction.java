import java.util.Scanner;

public class FactoryAutomationFunction {

    private static final Long BULKY_PACKAGE_LIMIT= 1000000L;
    private static final Long DIMENSION_LIMIT= 150L;
    private static final Long WEIGHT_LIMIT= 20L;

    public static void main(String[] args) throws Exception{
        System.out.println("Please enter width of the package in cm:");

        Scanner scanner = new Scanner(System.in);
        Long width = scanner.nextLong();

        System.out.println("Please enter height of the package in cm:");
        Long height = scanner.nextLong();

        System.out.println("Please enter length of the package in cm:");
        Long length = scanner.nextLong();

        System.out.println("Please enter mass of the package in kg:");
        Long mass = scanner.nextLong();

        String stack = sort(width, height, length, mass);
        System.out.println("Package should be sent to " + stack + " stack");
    }

    public static String sort(Long width,
                            Long height,
                            Long length,
                            Long mass) {

        Boolean isBulky = isBulkyPackage(width, height, length);
        Boolean isHeavy = isHeavyPackage(mass);

        if (isBulky && isHeavy){
            System.out.println("Package is bulky and heavy");
            return PackageType.BULKY_AND_HEAVY_PACKAGE.getDispatchStack();
        } else if (isBulky) {
            System.out.println("Package is bulky");
           return PackageType.BULKY_OR_HEAVY_PACKAGE.getDispatchStack();
        } else if (isHeavy) {
            System.out.println("Package is heavy");
           return PackageType.BULKY_OR_HEAVY_PACKAGE.getDispatchStack();
        }
        else
            return PackageType.STANDARD_PACKAGE.getDispatchStack();
    }

    private static Boolean isBulkyPackage(Long width,
                            Long height,
                            Long length) {
        long volume = width * height * length;
        return (volume >= BULKY_PACKAGE_LIMIT) ||
            (width >= DIMENSION_LIMIT) || (height >= DIMENSION_LIMIT) || (length >= DIMENSION_LIMIT);
    }

    private static Boolean isHeavyPackage(Long mass) {
        return mass >= WEIGHT_LIMIT;
    }
}