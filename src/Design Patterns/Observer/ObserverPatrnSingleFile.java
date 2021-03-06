
import java.util.ArrayList;

class ObserverPatrnSingleFile
{
	public static void main(String[] args) 
	{
		WeatherStation theweathrstn = new WeatherStation();

		HandHeldDevice hd = new HandHeldDevice(theweathrstn);
		
		theweathrstn.setMeasurements(10, 20, 30);			 
	}	
}

interface Observer
{
	public void update(int temp, int hum, int pressure);
}

interface Subject
{
	public void registerObserver(Observer ob);
	public void removeObserver(Observer ob);
	public void notifyObservers();
}

interface display
{
	public void displayContent();
}

class WeatherStation implements Subject
{
	private ArrayList<Observer> observers;
	private int temprature, humidity, pressure;

	public WeatherStation()
	{
		observers = new ArrayList<Observer>();
	}

	public void registerObserver(Observer ob)
	{
		observers.add(ob);
	}		 

	public void removeObserver(Observer ob)
	{
		int i = observers.indexOf(ob);

		if( i >= 0)
		{
			observers.remove(ob);
		}
	}

	public void notifyObservers()
	{
		for(int i = 0 ; i < observers.size() ; i++)
		{
			Observer theob = (Observer)observers.get(i);
			theob.update(temprature, humidity, pressure);
		}
	}	

	public void measurementsChanged()
	{
		notifyObservers();
	}

	public void setMeasurements(int temp, int hum, int pressure)
	{
		this.temprature = temp;
		this.humidity = hum;
		this.pressure = pressure;
		measurementsChanged();
	}

}

class HandHeldDevice implements Observer, display
{
	
	private int temprature, humidity, pressure;
	private Subject weastn;

	public HandHeldDevice(WeatherStation ws)
	{
		weastn = ws;
		weastn.registerObserver(this);
	}

	public void displayContent()
	{
		System.out.println("HandHeldDevice received updated readings::");
		System.out.println("temprature, humidity, pressure : " + temprature +" "+ humidity +" "+ pressure);
	}

	public void update(int temp, int hum, int press)
	{
		this.temprature = temp; 
		this.humidity = hum; 
		this.pressure = press;
		displayContent();
	}
}


