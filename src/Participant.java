import java.util.Scanner;

public class Participant {
    private String participantID = "";
    private String participantName = "";
    private int[] diyaCollection = new int[5];

    public Participant(String participantID, String participantName, int[] diyaCollection){
        this.participantID = participantID;
        this.participantName = participantName;
        this.diyaCollection = diyaCollection;
    }

    public Participant(Participant p, String participantID){
        this.participantID = participantID;
        this.participantName = p.participantName;
        this.diyaCollection = p.diyaCollection;
    }

    public void setParticipantID(String participantID){
        this.participantID = participantID;
    }

    public String getParticipantID() {
        return participantID;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    public String getParticipantName() {
        return participantName;
    }

    public void setDiyaCollection(int[] diyaCollection) {
        this.diyaCollection = diyaCollection;
    }

    public int[] getDiyaCollection() {
        return diyaCollection;
    }

    //ongoing
//    public Participant clone(){
//        Scanner input = new Scanner(System.in);
//
//        System.out.println("Type new participant ID: ");
//        participantID = input.nextLine();
//        System.out.println("Which participant do you want to clone: ");
//        String cloneParticipantID = input.nextLine();
//
//        new Participant()
//
//        return
//    }
}
