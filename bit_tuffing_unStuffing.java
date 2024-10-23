import java.util.Scanner;
public class bit_tuffing_unStuffing {
    public static String bitStuffing(String input){
        StringBuilder stuffedData = new StringBuilder();
        int count = 0;
        for(int i = 0; i < input.length(); i++){
            char bit = input.charAt(i);
            stuffedData.append(bit);
            if(bit == '1'){
                count++;
            }
            else{
                count = 0;
            }
            if (count == 5){
                stuffedData.append("0");
                count = 0;
            }
        }
        return stuffedData.toString();
    }
    public static String bitUnstuffing(String stuffedData){
        StringBuilder unstuffedData = new StringBuilder();
        int count = 0;
        for(int i = 0; i < stuffedData.length(); i++){
            char bit = stuffedData.charAt(i);
            unstuffedData.append(bit);
            if(bit == '1'){
                count++;

            }
            else{
                count = 0;
            }
            if (count == 5){
                i++;
                count = 0;
            }
        }
        return unstuffedData.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Enter the Binary Data:  ");
            String input = sc.nextLine();
            if(input.equalsIgnoreCase("exit")){
                System.out.println("Exiting from the Program");
                break;
            }
            String bitStuffing = bitStuffing(input);
            System.out.println("After Bit Stuffing " + bitStuffing);
            String UnstuffedData = bitUnstuffing(bitStuffing);
            System.out.println("After Unstuffing " + UnstuffedData);
        }
        sc.close();
    }
}