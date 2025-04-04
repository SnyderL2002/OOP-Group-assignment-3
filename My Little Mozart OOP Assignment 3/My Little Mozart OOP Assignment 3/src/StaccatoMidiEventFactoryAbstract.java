
/*
 * This class implements the createFactory method from the MidiEventFactoryAbstract interface, in compliance with the abstract factory design strategy learned in class. It does
 * this so we can dynamically change weather or not a MIDI file is played in legato or staccato without having to change the code.
 */

public class StaccatoMidiEventFactoryAbstract implements MidiEventFactoryAbstract{
	@Override
	public MidiEventFactory createFactory() {
		return new StaccatoMidiEventFactory();
	}
}
