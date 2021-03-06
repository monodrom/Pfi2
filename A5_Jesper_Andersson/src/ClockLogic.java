
public class ClockLogic implements ClockInterface{
	
	private ClockGUI clockGUI;
	public int alarmHour;
	public int alarmMinute;
	public boolean alarmSet;
	
	public ClockLogic(ClockGUI clockGUI2){
		this.clockGUI = clockGUI2;
		Thread cThread = new ClockThread(this);
		cThread.setName("ClockUpdateThread");
		cThread.start();
	}
	
	public void setAlarm(int hours, int minutes){
		if(hours >= 0 && hours < 24 && minutes >= 0 && minutes <60){
			alarmHour = hours;
			alarmMinute = minutes;
			alarmSet = true;
		}
	}
	
	public void clearAlarm(){
		alarmSet = false;
	}
	
	public void update(int hourIn, int minuteIn, int secondIn){
		clockGUI.setTimeOnLabel(hourIn, minuteIn, secondIn);
		if(alarmSet){
			if( alarmHour == hourIn && alarmMinute == minuteIn){
				clearAlarm();
			}
		}
	}
}