import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.sound.midi.*;

/*
 * The CSVparser Class reads data from MIDI files line by line and stores them into the MidiEventData List. From there using a while loop we read each line from the MIDI file.
 * Utilizing the split method we truncate the strings read from the MIDI file using commas as a NULL terminator and eliminating whitespace. Once the data from the string is truncated
 * it is stored in a string array, from there we assign each piece of data to their respective categories, startEndTick being at the 0th index, note_on_off being at the 1st index,
 * channel being at the 2nd index, note being at the third index, velocity being at the 4th index, and instrument being at the 5th index. These values are type cast to integers to be 
 * easily utilized by the various methods in this program.
 */

public class CSVparser {
	public static List<MidiEventData> parseCsv(String filepath) throws IOException {
		List<MidiEventData> events = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new FileReader(filepath));
		String data;
		while((data=reader.readLine())!=null) {
			String[] values = data.split(",\\s*");
			
			int startEndTick = Integer.parseInt(values[0]);
			int channel = Integer.parseInt(values[2]);
			int note = Integer.parseInt(values[3]);
			int velocity = Integer.parseInt(values[4]);
			int instrument = Integer.parseInt(values[5]);
			int noteOnOff = values[1].equals("Note_on_c") ? ShortMessage.NOTE_ON : ShortMessage.NOTE_OFF;
			
			events.add(new MidiEventData(startEndTick, velocity, note, channel, instrument, noteOnOff));
		}
		reader.close();
		return events;
	}
		
}
