
/*
 * This is an interface to be overridden by the HigherPitchStrategy method and the LowerPitchStrategy method. 
 */

public interface PitchStrategy {
	int modifyPitch(int note);
}
