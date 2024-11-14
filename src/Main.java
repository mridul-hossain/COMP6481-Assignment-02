import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String participantID = "";
        String participantName = "";

        System.out.println("Enter how many participant you want to add:");
        int numberOfParticipants = Integer.valueOf(input.nextLine());

        ParticipantList participantList = new ParticipantList();

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

        ParticipantList.ParticipantNode current = participantList.getHead();
        while(current != null){
            System.out.println(current.getP().getParticipantID() + current.getP().getParticipantName() + Arrays.toString(current.getP().getDiyaCollection()));
            current = current.getNode();
        }
    }
}