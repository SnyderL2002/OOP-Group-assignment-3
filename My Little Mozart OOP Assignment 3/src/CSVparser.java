import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.sound.midi.*;

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
