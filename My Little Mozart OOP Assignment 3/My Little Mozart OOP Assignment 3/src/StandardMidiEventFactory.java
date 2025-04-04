import javax.sound.midi.*;

/*
 * This class implements the createNoteOn and createNoteOff methods from the MidiEventFactory interface. Unlike the staccato and legato event factories this class creates a 
 * standard musical experience, therefore we do not add any ticks to the beginning or ending of the notes.
 */

public class StandardMidiEventFactory implements MidiEventFactory {
	@Override
	public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
		ShortMessage message = new ShortMessage();
		message.setMessage(ShortMessage.NOTE_ON, channel, note, velocity);
		return new MidiEvent(message, tick);
	}
	public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
		ShortMessage message = new ShortMessage();
		message.setMessage(ShortMessage.NOTE_OFF, channel, note, 0);
		return new MidiEvent(message, tick);
	}
}
