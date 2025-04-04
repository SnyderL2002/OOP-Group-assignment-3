
/*
 * This class contains getters and setters for the various variable types we draw from MIDI files, all of which are type cast to int when read from the file.
 */

public class MidiEventData {
	private int startEndTick, velocity, note, channel, noteOnOff ;
	private int instrument;
	public MidiEventData ( int startEndTick, int velocity, int note,
			int channel, int instrument, int noteOnOff) {
		this.startEndTick = startEndTick;
		this.velocity = velocity;
		this.note = note;
		this.channel = channel;
		this.instrument = instrument;
		this.noteOnOff = noteOnOff;
	}
	
	public int getStartEndTick() {
		return startEndTick;
	}
	
	public void setStartEndTick(int i) {
		startEndTick = i;
	}
	
	public int getVelocity() {
		return velocity;
	}
	
	public void setVelocity(int i) {
		velocity = i;
	}
	
	public int getNote() {
		return note;
	}
	
	public void setNote(int i) {
		note = i;
	}
	
	public int getChannel() {
		return channel;
	}
	
	public void setChannel(int i) {
		channel = i;
	}
	
	public int getNoteOnOff() {
		return noteOnOff;
	}
	
	public void setNoteOnOff(int i) {
		noteOnOff = i;
	}
	
	public int getInstrument() {
		return instrument;
	}
	
	public void setInstrument(int i) {
		instrument = i;
	}
}