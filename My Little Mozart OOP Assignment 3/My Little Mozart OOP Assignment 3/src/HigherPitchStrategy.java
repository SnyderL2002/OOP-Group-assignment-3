
/*
 * This class implements the modifyPitch method from the PitchStrategy interface. It is nearly identical to its sibling
 * class LowerPitchStrategyMethod, using the modifyPitch method to take in a note int and adds 2 to it to raise the pitch.
 */

public class HigherPitchStrategy implements PitchStrategy {
	public int modifyPitch(int note) {
		return note+2;
	}
}
