public static int findAngle(int hour, int min)
{
	if (hour > 24 || hour < 0)
	{
		throw new ArgumentException(string.Format("invalid hour: {0}", hour));
	}
	else if (min > 60 || min < 0)
	{
		throw new ArgumentException(string.Format("invalid minute: {0}", min));
	}

	hour = hour % 12;
	int perhour = 360 / 12;
	int hourAngle = hour * perhour + perhour*(min / 60);
	int minAngle = 360 / 60 * min;
	
	return Math.abs(hourAngle - minAngle);	
}
	