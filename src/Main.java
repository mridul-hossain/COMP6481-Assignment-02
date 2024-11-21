//Md Mridul Hossain
//Assignment #2
//16/11/2024

/**
 * The {@code Main} class is the entry point for the competition program.
 * It handles user input for participant data, processes the results, and
 * displays competition outcomes based on the {@code CompetitionResult} class.
 *
 * <p>Class created for Assignment #2 by Md Mridul Hossain on 16/11/2024.</p>
 *
 * <p>Example usage:</p>
 * <pre>{@code
 * java Main
 * }</pre>
 *
 * <p>Flow:</p>
 * <ol>
 * <li>Accepts participant details as input.</li>
 * <li>Processes the list of participants and calculates results.</li>
 * <li>Displays the awards or status for specified participants.</li>
 * </ol>
 *
 * @author Md Mridul Hossain
 * @version 1.0
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    /**
     * The main method serves as the starting point of the application.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String participantID = "";
        String participantName = "";

        ParticipantList participantList = new ParticipantList();
        ParticipantList participantCloneList = new ParticipantList(participantList);

        System.out.println("Enter how many participant information you want to add:");
        int numberOfParticipants = Integer.valueOf(input.nextLine());

        System.out.println("Enter participant information:");
        for(int i = 0; i < numberOfParticipants; i++){
            int[] diyaCollection = new int[5];
            String participantInfo = input.nextLine();
            String[] participantInfoSplitted = participantInfo.split(" ");
            participantID = "P" + String.valueOf(Participant.variableForID);
            participantName = participantInfoSplitted[0];
            for(int j = 0; j < 5; j++){
                diyaCollection[j] = Integer.valueOf(participantInfoSplitted[j+1]);
            }

            Participant p = new Participant(participantID, participantName, diyaCollection);
            participantList.addToStart(p);
            Participant.variableForID++;
        }

        System.out.println("Enter how many participant's result you want to check:");
        int numberOfParticipantsResult = Integer.valueOf(input.nextLine());

        ArrayList<String> participantsForCheckResult = new ArrayList<>();
        String[] participantsResult = new String[numberOfParticipantsResult];

        System.out.println("Enter participants:");
        for(int x = 0; x < numberOfParticipantsResult; x++){
            String nameOfParticipant = input.nextLine();
            participantsForCheckResult.add(nameOfParticipant);
        }

        System.out.println("Result:");

        participantList.getAllParticipants();
        CompetitionResult competitionResult = new CompetitionResult();
        competitionResult.sortParticipants();

        for(int i = 0; i < participantsForCheckResult.size(); i++){
            System.out.println(competitionResult.showResult(participantsForCheckResult.get(i)));
        }

        //creating test object
//        Participant testParticipant = new Participant("P5","ShimmeringSage",new int[]{04, 03, 20, 07, 10});

        //testing insertAtIndex method
//        participantList.insertAtIndex(testParticipant, 4);

        //testing deleteFromIndex method
//        participantList.deleteFromIndex(4);

        //testing deleteFromStart method
//        participantList.deleteFromStart();

        //testing replaceAtIndex method
//        participantList.replaceAtIndex(testParticipant,4);

        //testing find method
//        Participant result = participantList.find("P4");
//        if(result == null){
//            System.out.println("No participant found" + "\nIteration count: " + ParticipantList.iterationCount);
//        }else{
//            System.out.println(result.getParticipantID()+ " " + result.getParticipantName() + " " + Arrays.toString(result.getDiyaCollection()) + "\nIteration count: " + ParticipantList.iterationCount);
//        }

        //testing contains method
//        System.out.println(participantList.contains("P4"));

        //testing equals method of ParticipantList class
//        participantCloneList = participantList;
//        System.out.println(participantList.equals(participantCloneList));

        //testing equals method of Participant class
//        participantList.getAllParticipants();
//        System.out.println(testParticipant.equals());

        //testing toString method of Participant class
//        System.out.println(testParticipant.toString());

        //method for showing all participants
//        participantList.showAllParticipants();

        //testing isInTopThree method of CompetitionResult class
//        participantList.getAllParticipants();
//        CompetitionResult competitionResult = new CompetitionResult();
//        System.out.println(competitionResult.isInTheTopThree(testParticipant));
    }
}