import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

/*
 * This class implements the createNoteOn and createNoteOff methods from the MidiEventFactory interface. In music, legato indicates that the 
 * notes are played smoothly, to achieve this effect with MIDI data, we add ticks to createNoteOff which causes notes to play longer, achieving
 * a more smooth musical experience.
 */

public class LegatoMidiEventFactory implements MidiEventFactory{
	@Override
	public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
		ShortMessage message = new ShortMessage();
		message.setMessage(ShortMessage.NOTE_ON, channel, note, velocity);
		return new MidiEvent(message, tick);
	}
	public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
		ShortMessage message = new ShortMessage();
		message.setMessage(ShortMessage.NOTE_OFF, channel, note, 0);
		return new MidiEvent(message, tick+80);
	}
}
