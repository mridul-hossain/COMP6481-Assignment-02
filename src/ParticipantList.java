//Md Mridul Hossain
//Assignment #2
//16/11/2024

/**
 * The {@code ParticipantList} class represents a collection of participants
 * managed using a linked list structure.
 *
 * <p>Class created for Assignment #2 by Md Mridul Hossain on 16/11/2024.</p>
 *
 * <p>This class provides methods to add, remove, find, and manipulate participants in the list.</p>
 *
 * <p>Example usage:</p>
 * <pre>{@code
 * ParticipantList list = new ParticipantList();
 * Participant participant = new Participant("P001", "John Doe", new int[]{10, 20, 30});
 * list.addToStart(participant);
 * }</pre>
 *
 * @author Md Mridul
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class ParticipantList {
    private ParticipantNode head;
    private int size;
    public static ArrayList<Participant> allParticipants = new ArrayList<>();

    /**
     * Constructs an empty {@code ParticipantList}.
     */
    public ParticipantList(){
        this.head = null;
        this.size = 0;
    }

    /**
     * Constructs a copy of the given {@code ParticipantList}.
     *
     * @param participantList the {@code ParticipantList} to copy
     */
    //copy constructor
    public ParticipantList(ParticipantList participantList){
        this.head = participantList.getHead();
        this.size = participantList.getSize();
    }

    /**
     * Represents a node in the linked list of participants.
     */
    public class ParticipantNode{
        private Participant p;
        private ParticipantNode node;

        /**
         * Constructs an empty {@code ParticipantNode}.
         */
        public ParticipantNode(){
            this.p = null;
            this.node = null;
        }

        /**
         * Constructs a {@code ParticipantNode} with the given participant and next node.
         *
         * @param p the participant object
         * @param node the next node in the list
         */
        public ParticipantNode(Participant p, ParticipantNode node){
            this.p = p;
            this.node = node;
        }

        public void setP(Participant p) {
            this.p = p;
        }

        public Participant getP() {
            return p;
        }

        public void setNode(ParticipantNode node) {
            this.node = node;
        }

        public ParticipantNode getNode() {
            return node;
        }

        /**
         * Creates a clone of this {@code ParticipantNode}.
         *
         * @return a new {@code ParticipantNode} with cloned participant and node reference
         */
        //clone method
        public ParticipantNode clone() {
            return new ParticipantNode(this.p.clone(), this.node);
        }
    }

    public void setHead(ParticipantNode head){
        this.head = head;
    }

    public ParticipantNode getHead() {
        return head;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    /**
     * Adds a participant to the start of the list.
     *
     * @param p the participant to add
     */
    public void addToStart(Participant p){
        head = new ParticipantNode(p, head);
        size++;
    }

    /**
     * Collects all participants in a static {@code ArrayList}.
     */
    //using this method to store all participants information in a static arraylist so that I can sort the participants as per value and cost
    public void getAllParticipants(){
        ParticipantNode current = head;
        while (current != null){
            allParticipants.add(current.getP());
            current = current.node;
        }
    }

    /**
     * Inserts a participant at the specified index.
     *
     * @param p the participant to insert
     * @param index the index at which to insert the participant
     * @throws NoSuchElementException if the index is invalid
     */
    public void insertAtIndex(Participant p, int index) {
        if (index < 0 || index >= size){
            throw new NoSuchElementException("Invalid index.");
        }
        if (index == 0){
            addToStart(p);
        }else{
            ParticipantNode prev = head;
            for (int i = 1; i < index; i++){
                prev = prev.node;
            }
            prev.node = new ParticipantNode(p, prev.node);
            size++;
        }
    }

    /**
     * Delete a participant to the start of the list.
     *
     */
    public void deleteFromStart() {
        if (head != null) {
            head = head.node;
            size--;
        }
    }

    /**
     * Delete a participant to the start of the list.
     *
     * @param index the index from where to delete
     */
    public void deleteFromIndex(int index) {
        if (index < 0 || index >= size) {
            throw new NoSuchElementException("Invalid index.");
        }

        if (index == 0) {
            deleteFromStart();
            return;
        }

        ParticipantNode current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.node;
        }
        current.node = current.node.node;
        size--;
    }

    /**
     * Adds a participant to the start of the list.
     *
     * @param p the participant to replace
     * @param index the index number where to replace the participant data
     */
    public void replaceAtIndex(Participant p, int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index. No replacement made.");
            return;
        }

        ParticipantNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.node;
        }
        current.p = p;
    }

    /**
     * Adds a participant to the start of the list.
     *
     * @param participantID the participant to find the list
     */
    public Participant find(String participantID) {
        ParticipantNode current = head;
        while (current != null) {
            if (current.p.getParticipantID().equals(participantID)){
                return current.p.clone();
            }
            current = current.node;
        }
        return null;
    }

    /**
     * Adds a participant to the start of the list.
     *
     * @param participantID the participant exist in the list if exist then return true otherwise false
     */
    public boolean contains(String participantID) {
        ParticipantNode current = head;
        while (current != null) {
            if (current.p.getParticipantID().equals(participantID)) {
                return true;
            }
            current = current.node;
        }
        return false;
    }

    /**
     * Adds a participant to the start of the list.
     *
     * @param participantList the participant list is same as the current participant list
     */
    public boolean equals(ParticipantList participantList) {
        if (participantList == null) {
            return false;
        }

        ParticipantList otherList = (ParticipantList) participantList;

        if (this.size != otherList.size) {
            return false;
        }

        ParticipantNode currentThis = this.head;
        ParticipantNode currentOther = otherList.head;

        while (currentThis != null && currentOther != null) {
            if (!currentThis.p.equals(currentOther.p)) {
                return false;
            }
            currentThis = currentThis.node;
            currentOther = currentOther.node;
        }

        return true;
    }

    public void showAllParticipants(){
        ParticipantNode current = head;
        while(current != null){
            System.out.println(current.p.getParticipantID() + " " + current.p.getParticipantName() + " " + Arrays.toString(current.p.getDiyaCollection()));
            current = current.node;
        }
    }
}
