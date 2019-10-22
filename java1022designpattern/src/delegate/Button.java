package delegate;

public class Button {
	private OnClickListener onClickListener;
	
	public void setOnClickListener(OnClickListener onClickListener) {
		this.onClickListener = onClickListener;
	}

	public Button() {
		System.out.printf("버튼을 출력\n");
	}
	
	public void onClick() {
		if(onClickListener == null) {
			return;
		}
		onClickListener.onClick();
	}
}
