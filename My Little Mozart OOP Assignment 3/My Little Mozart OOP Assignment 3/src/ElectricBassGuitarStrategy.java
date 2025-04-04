import javax.sound.midi.*;

public class ElectricBassGuitarStrategy implements InstrumentStrategy {
	@Override
	public void applyInstrument(Track track, int channel) throws InvalidMidiDataException {
		ShortMessage message = new ShortMessage();
		message.setMessage(ShortMessage.PROGRAM_CHANGE, channel, 33, 0);
		track.add(new MidiEvent(message, 0));
	}	
}
