
/*
 * This interface is implemented by the various MidiEventFactoryAbstract classes to dynamically change if a MIDI file is played normally, staccato, or legato without having to change the code.
 * That would make this the product interface of our factory design strategy.
 */

public interface MidiEventFactoryAbstract {
		MidiEventFactory createFactory();
}
