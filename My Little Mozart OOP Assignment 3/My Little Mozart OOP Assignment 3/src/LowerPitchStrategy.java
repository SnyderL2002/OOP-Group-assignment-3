
/*
 * This class implements the modifyPitch method from the PitchStrategy interface. It is nearly identical to its sibling
 * class HigherPitchStrategyMethod, using the modifyPitch method to take in a note int and subtracts 2 from it to lower the pitch.
 */

public class LowerPitchStrategy implements PitchStrategy{
	public int modifyPitch(int note) {
		return note-2;
	}
}
