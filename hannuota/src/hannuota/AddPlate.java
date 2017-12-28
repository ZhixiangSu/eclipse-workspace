package hannuota;

public class AddPlate implements Runnable
{
	
	Plateform plateform;
	Plate plate;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		add();
	}
	public AddPlate(Plateform plateform,Plate plate) {
		// TODO Auto-generated constructor stub
		this.plate=plate;
		this.plateform=plateform;
	}
	public void add()
	{
		plateform.plates.add(plate);
		for(int i=0;i<=(Hannuota.number-plateform.plates.size())*plate.height;i++)
		{
			plate.setBounds(plateform.x-plate.width/2,i,plate.width, plate.height);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
