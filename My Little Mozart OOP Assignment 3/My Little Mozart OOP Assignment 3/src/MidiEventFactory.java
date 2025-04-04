import javax.sound.midi.*;

/*
 * This interface is implemented by the staccato, legato, and standard MidiEventFactory classes to dynamically change the length at which the notes read form MIDI files are played without having to change the code
 * by overriding the createNoteOn and createNoteOff methods. Which determine when a note begins and ends. 
 */

public interface MidiEventFactory {
	MidiEvent createNoteOn (int tick, int note, int velocity, int channel) throws InvalidMidiDataException;
	MidiEvent createNoteOff (int tick, int note, int channel) throws InvalidMidiDataException;
}
