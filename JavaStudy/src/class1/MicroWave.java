package class1;

public class MicroWave {
	boolean adapter;			// ����Ϳ� ���� ����
	int timeSwitch;		// �� ������ �������� ����
	
	
	//����Ͱ� �����ִ��� �˱� ���� �޼���
	boolean getAdapter() {
		return adapter;
	}
	
	//����͸� �Űų� ���� �� �����ϱ� ���� �޼���
	void setAdapter(boolean flag) {
		this.adapter = flag;
	}
	
	//�ð� ������ ������� �����ߴ��� �˱� ���� �޼���
	int timeSwitch() {
		return timeSwitch;
	}
	
	//�ð� ������ ���� timeSwitch�� ���� ������ �־��ش�.
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