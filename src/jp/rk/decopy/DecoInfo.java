package jp.rk.decopy;

public class DecoInfo {
	private Placement placement;
	private String decoStr;
	public DecoInfo(){
		placement = Placement.Left;
		decoStr = ">";
	}

	public Placement getPlacement(){
		return this.placement;
	}
	public void setPlacement(Placement placement){
		this.placement = placement;
	}

	public String getDecoStr(){
		return this.decoStr;
	}
	public void setDecoStr(String decoStr){
		this.decoStr = decoStr;
	}
}
