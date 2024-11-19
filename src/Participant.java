//Md Mridul Hossain
//Assignment #2
//16/11/2024

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Participant {
    private String participantID = "";
    private String participantName = "";
    private int[] diyaCollection = new int[5];
    public static int variableForID = 0;

    public Participant(String participantID, String participantName, int[] diyaCollection) {
        this.participantID = participantID;
        this.participantName = participantName;
        this.diyaCollection = diyaCollection;
    }

    //copy constructor
    public Participant(Participant p, String participantID) {
        this.participantID = participantID;
        this.participantName = p.getParticipantName();
        this.diyaCollection = p.getDiyaCollection();
    }

    public void setParticipantID(String participantID) {
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

    public Participant clone() {
        Scanner input = new Scanner(System.in);

        System.out.println("Type new participant ID: ");
        participantID = input.nextLine();

        return new Participant(this, participantID);
    }

    public String toString() {
        return "Participant ID: " + participantID + ", Name: " + participantName + " Diya Collection: " + Arrays.toString(diyaCollection);
    }

    public boolean equals() {
        for (int i = 0; i < ParticipantList.allParticipants.size(); i++) {
            if (participantName.equals(ParticipantList.allParticipants.get(i).getParticipantName()) && Arrays.equals(diyaCollection, ParticipantList.allParticipants.get(i).getDiyaCollection())) {
                return true;
            }
        }

        return false;
    }
}
