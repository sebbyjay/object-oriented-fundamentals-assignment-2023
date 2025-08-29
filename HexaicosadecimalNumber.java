import java.util.*;
import java.io.*;

public class HexaicosadecimalNumber { // FOR FUTURE: IF NEGATIVE, TREAT AS IF NO NEGATIVE, ADD NEG AT THE END

    //attributes
    private String StringRepresentation;
    private double doubleRepresentation;

    //constructors for string and double
    public HexaicosadecimalNumber(String inputString){
        this.StringRepresentation = inputString;
        this.doubleRepresentation = HexaicosadecimalStringToDouble(inputString);
    }
    public HexaicosadecimalNumber(double inputDouble){
        this.doubleRepresentation = inputDouble;
        //this.StringRepresentation = doubleToHexaicosadecimalString(inputDouble);
    }
    //toString function
    @Override
    public String toString() {
        return this.StringRepresentation + this.doubleRepresentation;
    }

    //conversion functions
    private double HexaicosadecimalStringToDouble(String StringRepresentation) {
        int acc = 0;
        for(int i = 0; i < StringRepresentation.length(); i++) {
            char c = StringRepresentation.charAt(i);
            int baseValue = c - 97;
            acc += baseValue * Math.pow(26, StringRepresentation.length() - (i + 1));
        }
        return acc;
    }

    /*private String doubleToHexaicosadecimalString(double d) {
        System.out.println("NOT IMPLEMENTED");
    }*/

    //main function
    public static void main(String[] args) throws IOException{
        
        Scanner scan = new Scanner(System.in);

        while(true){//base mode selector
            System.out.print("What mode would you like to choose, 'h' for hexaicosadecimal, 'd' for decimal, 'q' to quit: ");
            String baseType = scan.nextLine();
            baseType = baseType.toLowerCase();

            if(baseType.equals("h")) {
                System.out.print("Input a Hexaicosadecimal number: ");
                String hexNumber = scan.nextLine();
                hexNumber = hexNumber.toLowerCase();
                HexaicosadecimalNumber h = new HexaicosadecimalNumber(hexNumber);
                System.out.println(h.toString());
                break;
            }
            else if(baseType.equals("d")) {
                System.out.print("Input a Decimal number: ");
                //double decNumber = scan.nextDouble();
                //Hexa
                //System.out.print(doubleRepresentation);
                break;
            }
            else if(baseType.equals("q")) {
                System.out.print("Quitting...");
                break;
            }
            else {
                System.out.print("INVALID INPUT");
                baseType = scan.nextLine();
            }
        }

    }

}