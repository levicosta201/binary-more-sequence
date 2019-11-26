import java.util.Timer;
import java.util.TimerTask;

public class Main {

    /**
     * instatiate timer to period call function
     */
    private static Timer timer = new Timer();

    /**
     * Store sonds
     */
    private static final long SECONDS = 1000;

    /**
     * Store minutes
     */
    private static final long MINUTES = SECONDS * 60;

    /**
     * Store hour
     */
    private static final long HOURS = MINUTES * 60;

    /**
     * @param args
     */
    public static void main(String args[]) {
        generateTest();
    }

    /**
     * Function to convert Integer value to binary String
     * @param number
     * @returnz String
     */
    public static String intToBinary(Integer number) {
        return Integer.toBinaryString(number);
    }

    /**
     * Function to count zero sequence in one Strint
     * @param binary
     * @return Integer
     */
    public static Integer countZeroSequence(String binary) {

        //split using number one with reference because is binary
        String[] sequence_count = binary.split("1");
        Integer bigger_sequence = 0;

        for (int i = 0; i < sequence_count.length; i++) {
            int current_lenght = sequence_count[i].length();
            int previous_lenght = getPrevious(sequence_count, i).length();

            //validate why variable is more and store in bigger sequence
            if(current_lenght > previous_lenght && bigger_sequence < current_lenght)
                bigger_sequence = current_lenght;
        }
        return bigger_sequence;
    }

    /**
     * Function to get previou value from array
     * @param array
     * @param index
     * @return
     */
    public static String getPrevious(String[] array, Integer index) {
        if(index <= 0)
            return "";
        return array[index-1];
    }

    /**
     * function to use for test, call period countZeroSequence() function
     */
    public static void generateTest() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Integer random_number = getRandomIntegerBetweenRange(1, 2147483647);
                String binary = intToBinary(random_number);
                System.out.println("Number generated: " + random_number + "\n"
                    + "Binary: " + binary + "\n"
                    + "More Sequence: " + countZeroSequence(binary) + "\n"
                    + "----------------------------------------- \n\n");
            }
        }, 0, SECONDS * 5);
    }

    public static Integer getRandomIntegerBetweenRange(Integer min, Integer max){
        Integer rand_value = (int)(Math.random() * ((max-min) + 1)) + min;
        return Integer.valueOf(rand_value);
    }

}
