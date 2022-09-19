package class1;

public class MicroWave {
	boolean adapter;			// 어댑터에 대한 변수
	int timeSwitch;		// 몇 분으로 돌리지에 변수
	
	
	//어댑터가 꼽혀있는지 알기 위한 메서드
	boolean getAdapter() {
		return adapter;
	}
	
	//어댑터를 꼽거나 뺏을 때 설정하기 위한 메서드
	void setAdapter(boolean flag) {
		this.adapter = flag;
	}
	
	//시간 설정을 몇분으로 설정했는지 알기 위한 메서드
	int timeSwitch() {
		return timeSwitch;
	}
	
	//시간 설정에 따라 timeSwitch에 값을 적절히 넣어준다.
	void setTimeSwitch(int time) {
		if(time == 0)
			timeSwitch = 30;
		else if(time == 1) {
			timeSwitch = 60;
		}
		else if(time == 2) {
			timeSwitch = 90;
		}
	}
}