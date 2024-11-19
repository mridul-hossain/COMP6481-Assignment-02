//Md Mridul Hossain
//Assignment #2
//16/11/2024

/**
 * The {@code Lightable} interface defines the behavior for determining if a participant is in the top three.
 *
 * <p>Interface created for Assignment #2 by Md Mridul Hossain on 16/11/2024.</p>
 *
 * <p>Example usage:</p>
 * <pre>{@code
 * Lightable lightable = new SomeImplementation();
 * Participant participant = new Participant(...);
 * boolean isTopThree = lightable.isInTheTopThree(participant);
 * }</pre>
 *
 * @author Md Mridul Hossain
 * @version 1.0
 */
public interface Lightable {
    /**
     * Determines if the given participant is among the top three.
     *
     * @param p the participant to check
     * @return {@code true} if the participant is in the top three, {@code false} otherwise
     */
    public boolean isInTheTopThree(Participant p);
}
