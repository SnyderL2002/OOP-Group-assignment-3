import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

/*
 * Implements the applyInstrument method from the Instrument strategy interface by overriding it with its own implementation. Is identical to the other instrument
 * strategies besides its MIDI instrument ID which is 0. Throws the InvalidMidiDataException when passed invalid MIDI data. 
 */


public class AcousticGrandPianoStrategy implements InstrumentStrategy {
	@Override
	public void applyInstrument(Track track, int channel) throws InvalidMidiDataException {
		ShortMessage message = new ShortMessage();
		message.setMessage(ShortMessage.PROGRAM_CHANGE, channel, 0, 0);
		track.add(new MidiEvent(message, 0));
	}
}
