import javax.sound.midi.*;

/*
 * Implements the applyInstrument method from the Instrument strategy interface by overriding it with its own implementation. Is identical to the other instrument
 * strategies besides its MIDI instrument ID which is 33. Throws the InvalidMidiDataException when passed invalid MIDI data. 
 */

public class ElectricBassGuitarStrategy implements InstrumentStrategy {
	@Override
	public void applyInstrument(Track track, int channel) throws InvalidMidiDataException {
		ShortMessage message = new ShortMessage();
		message.setMessage(ShortMessage.PROGRAM_CHANGE, channel, 33, 0);
		track.add(new MidiEvent(message, 0));
	}	
}
