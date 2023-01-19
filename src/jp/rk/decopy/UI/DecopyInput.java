package jp.rk.decopy.UI;

import jp.rk.decopy.Placement;

public class DecopyInput {
	private Placement _placement;
	private String _decoStr;
	public DecopyInput(){
		_placement = Placement.Left;
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
