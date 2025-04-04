import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            List<MidiEventData> midiEvents = CSVparser.parseCsv("C:/Users/upsny/Downloads/mystery_song.csv");
            Sequence sequence = new Sequence(Sequence.PPQ, 384);
            Track track = sequence.createTrack();

            /*
             * You can change weather the music is played normally, legato, or staccato by commenting out or un-commenting whatever you prefer
             */
            
            MidiEventFactoryAbstract factoryAbstract = new StandardMidiEventFactoryAbstract();
            // MidiEventFactoryAbstract factoryAbstract = new LegatoMidiEventFactoryAbstract();
            // MidiEventFactoryAbstract factoryAbstract = new StaccatoMidiEventFactoryAbstract();
            MidiEventFactory factory = factoryAbstract.createFactory();

            InstrumentStrategy instrumentStrategy = new ElectricBassGuitarStrategy();
            instrumentStrategy.applyInstrument(track, 1);

            instrumentStrategy = new TrumpetStrategy();
            instrumentStrategy.applyInstrument(track, 0);

           /*
            * You can change the pitch strategy by commenting out or un-commenting the desired pitch.
            */
           // PitchStrategy pitchStrategy = new HigherPitchStrategy();
           PitchStrategy pitchStrategy = new LowerPitchStrategy();

            for (MidiEventData event : midiEvents) {
                int modifiedNote = pitchStrategy.modifyPitch(event.getNote());

                if (event.getNoteOnOff() == ShortMessage.NOTE_ON) {
                    track.add(factory.createNoteOn(
                            event.getStartEndTick(),
                            modifiedNote,
                            event.getVelocity(),
                            event.getChannel()
                    ));
                } else {
                    track.add(factory.createNoteOff(
                            event.getStartEndTick(),
                            modifiedNote,
                            event.getChannel()
                    ));
                }
            }

            /*
             * Plays the sequence
             */
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.setSequence(sequence);
            sequencer.start();

            while (sequencer.isRunning() || sequencer.isOpen()) {
                Thread.sleep(100);
            }

            Thread.sleep(500);
            sequencer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

