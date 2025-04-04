import javax.sound.midi.*;

/*
 * This interface is implemented by the various instrument strategy methods which override its applyInstrument method.
 */

public interface InstrumentStrategy {
	void applyInstrument (Track track, int channel) throws InvalidMidiDataException;
}
