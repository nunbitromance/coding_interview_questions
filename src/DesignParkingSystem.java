// Parking spot design
// 1. Only allow certain cars to park in certain spots. (compact cars can park in compact spots) 
// 2. Write a method for valet parkers to get a parking space that can fit the car they are trying to park. 
// 3. A count of all open spots on a floor. 
public enum CarSize
{
	Compact = 0,
	Regular
}

public class Car
{
	private CarSize Size {get;set;}
}

public class ParkingSensor
{
	private ParkingSpot Spot {get;set;}
}

public class ParkingSpot
{
	private CarSize Size {get;set;}
	private Guid Id {get;set;}
	private bool IsOccupied {get;set;}
	private ParkingFloor Floor {get;set;}
	
	public bool CanFit(Car c)
	{
		return c.Size == this.Size;
	}
}

public class ParkingFloor
{
	private List<ParkingSpot> RegularSpots {get;set;}
	private List<ParkingSpot> CompactSpots {get;set;}
	private int RegularOccupied {get;set;}
	private int CompactOccupied {get;set;}

	public bool CanFit(Car c)
	{
		if (c.CarSize == Regular)
		{
			return RegularOccupied < RegularSpots.Count;
		}
		else if (c.CarSize == Compact)
		{
			return CompactOccupied < CompactSpots.Count;
		}
		else
		{
			throw new ArgumentException("invalid type");
		}
	}
}

public class ParkingSystem
{
	private List<ParkingFloor> Floors {get;set;}
	private Dictionary<string, ParkingSpot> SensorSpots {get;set;}
	
	public bool CanPark(Car c)
	{
		foreach (ParkingFloor f in Floors)
		{
			if (f.CanFit(c))
			{
				return true;
			}
		}
		return false;
	}
	
	public int GetOpenSpotsCount(int floorNum)
	{
		
	}
	
	public void Acquire(string sensorId)
	{
		SecsorSpots[sensorId].Occupired = true;	
	}
	
	public void Release(string sensorId)
	{
		SensorSpots[sensorId].Occupied = false;
	}
	
	
}
