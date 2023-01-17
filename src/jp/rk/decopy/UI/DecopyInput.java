package jp.rk.decopy.UI;

import jp.rk.decopy.Placement;

public class DecopyInput {
	private Placement _placement = Placement.Left;
	private String _decoStr;
	public DecopyInput(){
		_decoStr = ">";
	}

	public Placement getPlacement(){
		return _placement;
	}
	public void setPlacement(Placement placement){
		_placement = placement;
	}

	public String getDecoStr(){
		return _decoStr;
	}
	public void setDecoStr(String decoStr){
		_decoStr = decoStr;
	}
}
