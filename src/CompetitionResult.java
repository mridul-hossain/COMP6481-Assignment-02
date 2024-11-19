//Md Mridul Hossain
//Assignment #2
//16/11/2024

/**
 * The CompetitionResult class evaluates participants in a competition,
 * determining their rankings based on decorative values and associated costs.
 *
 * <p>
 * Responsibilities:
 * <ul>
 *   <li>Check if a participant is in the top three.</li>
 *   <li>Sort participants based on decorative values and costs.</li>
 *   <li>Calculate decorative values and costs.</li>
 *   <li>Determine specific awards for participants.</li>
 * </ul>
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>
 *     CompetitionResult result = new CompetitionResult();
 *     String status = result.showResult("ParticipantName");
 * </pre>
 * </p>
 *
 * Author: Md Mridul Hossain
 * Date: 16/11/2024
 */

import java.util.ArrayList;
import java.util.Arrays;

public class CompetitionResult implements Lightable{
    /**
     * Checks if a participant is in the top three.
     *
     * @param p the participant to check
     * @return {@code true} if the participant is in the top three, {@code false} otherwise
     */
    @Override
    public boolean isInTheTopThree(Participant p) {
        ArrayList<Participant> topThreeParticipant = new ArrayList<>();
        sortParticipants();
        boolean flag = false;
        for(int i = 0; i < ParticipantList.allParticipants.size(); i++){
            flag = true;
            int count = 0;
            for(int j = 0; j < ParticipantList.allParticipants.size(); j++){
                if(calculateDecorativeValue(i) == calculateDecorativeValue(j)){
                    count++;
                }
            }
            if(i == 0){
                topThreeParticipant.add(ParticipantList.allParticipants.get(i));
            }
            if(count > 1 && calculateDecorativeValue(i) == secondLargestDecorativeValue()){
                if(calculateDecorativeCost(i) == lowestDecorativeCost(calculateDecorativeValue(i))){
                    topThreeParticipant.add(ParticipantList.allParticipants.get(i));
                }
            }
            if(count > 1 && calculateDecorativeValue(i) == thirdLargestDecorativeValue()){
                if(calculateDecorativeCost(i) == lowestDecorativeCost(calculateDecorativeValue(i))){
                    topThreeParticipant.add(ParticipantList.allParticipants.get(i));
                }
            }
            if(count == 1 && calculateDecorativeValue(i) == secondLargestDecorativeValue()){
                topThreeParticipant.add(ParticipantList.allParticipants.get(i));
            }
            if(count == 1 && calculateDecorativeValue(i) == thirdLargestDecorativeValue()){
                topThreeParticipant.add(ParticipantList.allParticipants.get(i));
            }
        }

        for(int i = 0; i < topThreeParticipant.size(); i++){
            if(topThreeParticipant.get(i).getParticipantID().equals(p.getParticipantID()) && topThreeParticipant.get(i).getParticipantName().equals(p.getParticipantName()) && Arrays.equals(topThreeParticipant.get(i).getDiyaCollection(), p.getDiyaCollection())){
                return true;
            }
        }
        return false;
    }

    /**
     * Sorts all participants by decorative value in descending order.
     * If values are equal, participants are sorted by decorative cost in ascending order.
     */
    public void sortParticipants(){
        for(int i = 0; i < ParticipantList.allParticipants.size() - 1; i++){
            boolean swapped = false;
            for(int j = 0; j < ParticipantList.allParticipants.size() - 1 - i; j++){
                if(calculateDecorativeValue(j+1) > calculateDecorativeValue(j)){
                    Participant participant = ParticipantList.allParticipants.get(j + 1);
                    ParticipantList.allParticipants.set(j + 1, ParticipantList.allParticipants.get(j));
                    ParticipantList.allParticipants.set(j, participant);
                    swapped = true;
                }
                if(calculateDecorativeValue(j+1) == calculateDecorativeValue(j)){
                    if(calculateDecorativeCost(j + 1) < calculateDecorativeCost(j)){
                        Participant participant = ParticipantList.allParticipants.get(j + 1);
                        ParticipantList.allParticipants.set(j + 1, ParticipantList.allParticipants.get(j));
                        ParticipantList.allParticipants.set(j, participant);
                        swapped = true;
                    }
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * Calculates the decorative value for a participant based on their diya collection.
     *
     * @param i the index of the participant in the list
     * @return the calculated decorative value
     */
    public int calculateDecorativeValue(int i){
        int decorativeValue = (ParticipantList.allParticipants.get(i).getDiyaCollection()[0] * 8) + (ParticipantList.allParticipants.get(i).getDiyaCollection()[1] * 7) + (ParticipantList.allParticipants.get(i).getDiyaCollection()[2] * 9) + (ParticipantList.allParticipants.get(i).getDiyaCollection()[3] * 6) + (ParticipantList.allParticipants.get(i).getDiyaCollection()[4] * 7);
        return decorativeValue;
    }

    /**
     * Calculates the decorative cost for a participant based on their diya collection.
     *
     * @param i the index of the participant in the list
     * @return the calculated decorative cost
     */
    public double calculateDecorativeCost(int i){
        double decorativeCost = (ParticipantList.allParticipants.get(i).getDiyaCollection()[0] * 3) + (ParticipantList.allParticipants.get(i).getDiyaCollection()[1] * 2.5) + (ParticipantList.allParticipants.get(i).getDiyaCollection()[2] * 4) + (ParticipantList.allParticipants.get(i).getDiyaCollection()[3] * 2) + (ParticipantList.allParticipants.get(i).getDiyaCollection()[4] * 3.5);
        return decorativeCost;
    }

    /**
     * Displays the result for a specific participant, including their award or status.
     *
     * @param participantName the name of the participant
     * @return a string describing the participant's status or award
     */
    public String showResult(String participantName){
        sortParticipants();
        boolean flag = false;
        String status = "";
        for(int i = 0; i < ParticipantList.allParticipants.size(); i++){
            if(participantName.equals(ParticipantList.allParticipants.get(i).getParticipantName())){
                flag = true;
                int count = 0;
                for(int j = 0; j < ParticipantList.allParticipants.size(); j++){
                    if(calculateDecorativeValue(i) == calculateDecorativeValue(j)){
                        count++;
                    }
                }
                if(i == 0){
                    status = participantName + " wins Luminary Legend award with having collection of highest decorative value";
                }
                if(count > 1 && calculateDecorativeValue(i) == secondLargestDecorativeValue()){
                    if(calculateDecorativeCost(i) == lowestDecorativeCost(calculateDecorativeValue(i))){
                        status = participantName + " wins Artisan's Heart award with having collection of second highest decorative value and lowest material cost";
                    }
                }
                if(count > 1 && calculateDecorativeValue(i) == secondLargestDecorativeValue()){
                    if(calculateDecorativeCost(i) != lowestDecorativeCost(calculateDecorativeValue(i))){
                        status = participantName + " is not in the top three owing the collection of higher material cost";
                    }
                }
                if(count > 1 && calculateDecorativeValue(i) == thirdLargestDecorativeValue()){
                    if(calculateDecorativeCost(i) == lowestDecorativeCost(calculateDecorativeValue(i))){
                        status = participantName + " wins Candlelight Dreamer award with having collection of third highest decorative value and lowest material cost";
                    }
                }
                if(count > 1 && calculateDecorativeValue(i) == thirdLargestDecorativeValue()){
                    if(calculateDecorativeCost(i) != lowestDecorativeCost(calculateDecorativeValue(i))){
                        status = participantName + " is not in the top three owing the collection of higher material cost";
                    }
                }
                if(count == 1 && calculateDecorativeValue(i) == secondLargestDecorativeValue()){
                    status = participantName + " wins Artisan's Heart award with having collection of second highest decorative value";
                }
                if(count == 1 && calculateDecorativeValue(i) == thirdLargestDecorativeValue()){
                    status = participantName + " wins Candlelight Dreamer award with having collection of third highest decorative value";
                }
                if(count == 1 && calculateDecorativeValue(i) < secondLargestDecorativeValue() || calculateDecorativeValue(i) < thirdLargestDecorativeValue()){
                    status = participantName + " is not in top three owing to collection of lower decorative value";
                }
            }
        }
        if(flag == false){
            status = "Could not find the participant in the participant list";
        }
        return status;
    }

    /**
     * Finds the lowest decorative cost among participants with the same decorative value.
     *
     * @param decorativeValue the decorative value to filter participants
     * @return the lowest decorative cost
     */
    public double lowestDecorativeCost(int decorativeValue){
        double lowest = -1.0;

        for (int i = 0; i < ParticipantList.allParticipants.size(); i++) {
            if (lowest < calculateDecorativeCost(i) && calculateDecorativeValue(i) == decorativeValue) {
                lowest = calculateDecorativeCost(i);
            }
        }

        return lowest;
    }

    /**
     * Determines the second highest decorative value among all participants.
     *
     * @return the second highest decorative value
     */
    public int secondLargestDecorativeValue(){
        int largest = 0;
        int secondLargest = 0;

        for (int i = 0; i < ParticipantList.allParticipants.size(); i++) {
            if (calculateDecorativeValue(i) > largest) {
                secondLargest = largest;
                largest = calculateDecorativeValue(i);
            } else if (calculateDecorativeValue(i) > secondLargest && calculateDecorativeValue(i) != largest) {
                secondLargest = calculateDecorativeValue(i);
            }
        }

        return secondLargest;
    }

    /**
     * Determines the third highest decorative value among all participants.
     *
     * @return the third highest decorative value
     */
    public int thirdLargestDecorativeValue(){
        int largest = 0;
        int secondLargest = 0;
        int thirdLargest = 0;

        for (int i = 0; i < ParticipantList.allParticipants.size(); i++) {
            if (calculateDecorativeValue(i) > largest) {
                thirdLargest = secondLargest;
                secondLargest = largest;
                largest = calculateDecorativeValue(i);
            } else if (calculateDecorativeValue(i) > secondLargest && calculateDecorativeValue(i) != largest) {
                thirdLargest = secondLargest;
                secondLargest = calculateDecorativeValue(i);
            } else if (calculateDecorativeValue(i) > thirdLargest && calculateDecorativeValue(i) != secondLargest && calculateDecorativeValue(i) != largest) {
                thirdLargest = calculateDecorativeValue(i);
            }
        }

        return thirdLargest;
    }
}
