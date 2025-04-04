
/*
 * This class implements the createFactory method from the MidiEventFactoryAbstract interface, in compliance with the abstract factory design strategy learned in class. It does
 * this so we can dynamically change weather or not a MIDI file is played in legato, staccato, or in this case normally, without having to change the code.
 */

public class StandardMidiEventFactoryAbstract implements MidiEventFactoryAbstract {
	public MidiEventFactory createFactory() {
		return new StandardMidiEventFactory();
	}
}
