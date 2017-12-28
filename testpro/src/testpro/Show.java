package testpro;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Show implements Runnable
{
	@Override
	public void run() {
		// TODO Auto-generated method stub
//		MainUI.slider.addChangeListener(new ChangeListener() {
//			
//			@Override
//			public void stateChanged(ChangeEvent e) {
//				// TODO Auto-generated method stub
//				anim.requestFocus();
//				anim.speed=100*(5-MainUI.slider.getValue());
//				
//			}
//		});
//		MainUI.setallenable(false);
		anim.addpart(part,analyse);
//		MainUI.setallenable(true);
	}
	Part part;ShowAnim anim;
	Analyse analyse=null;
	public Show(Part part,ShowAnim anim) {
		// TODO Auto-generated constructor stub
		this.anim=anim;
		this.part=part;
		analyse=new Analyse(anim, part);
	}
	
}
