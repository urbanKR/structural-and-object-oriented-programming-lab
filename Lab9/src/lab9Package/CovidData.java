package lab9Package;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class CovidData {
	protected ArrayList<WeeklyData> allWeeks = new ArrayList<WeeklyData>();
	protected Scanner fileScan = null;
	protected int line = 0;
	protected int counter=0;
	public void readFromFile(String fileName) throws FileFormatException, FileNotFoundException {
		fileScan = new Scanner(new File(fileName));
		while (fileScan.hasNextLine()) {
			String singleLine = fileScan.nextLine();
			line++;
			try {
				allWeeks.add(new WeeklyData(singleLine));
			} catch (Exception e) {
				System.out.println("Wrong line nr: "+line);
				counter++;
			}
		}
		if(fileScan != null) 
		{
			fileScan.close();
		}
	}

	public int getTotalCases() {
		int totalCases = 0;
		for (WeeklyData weeklyData : allWeeks) {
			if(weeklyData.getCases() != null) 
			{
				totalCases += weeklyData.getCases();
			}
		}
		return totalCases;
	}
	
	public int getCounter() {
		return counter;
	}

	public int getTotalCases(String continent) {
		int totalCases = 0;
		for (WeeklyData weeklyData : allWeeks) {
			if(weeklyData.getCases() != null && Objects.equals(weeklyData.getContinent(), continent)) 
			{
				totalCases += weeklyData.getCases();
			}
		}
		return totalCases;
	}

	public int getTotalCases(int week) {
		int totalCases = 0;
		for (WeeklyData weeklyData : allWeeks) {
			if(weeklyData.getCases() != null && weeklyData.getWeek() == week) 
			{
				totalCases += weeklyData.getCases();
			}
		}
		return totalCases;
	}

	public int getTotalCases(String continent, int week) {
		int totalCases = 0;

		for (WeeklyData weeklyData : allWeeks)
		{
			if(weeklyData.getCases() != null && Objects.equals(weeklyData.getContinent(), continent) &&
					weeklyData.getWeek() == week)
			{
				totalCases += weeklyData.getCases();
			}
		}
		return totalCases;
	}

	public int getTotalDeaths() {
		int totalDeaths = 0;

		for (WeeklyData weeklyData : allWeeks)
		{
			if(weeklyData.getDeaths() != null)
			{
				totalDeaths += weeklyData.getDeaths();
			}
		}
		return totalDeaths;
	}

	public int getTotalDeaths(String continent) {
		int totalDeaths = 0;
		for (WeeklyData weeklyData : allWeeks)
		{
			if(weeklyData.getDeaths() != null && Objects.equals(weeklyData.getContinent(), continent))
			{
				totalDeaths += weeklyData.getDeaths();
			}
		}
		return totalDeaths;
	}

	public int getTotalDeaths(int week) {
		int totalDeaths = 0;
		for (WeeklyData weeklyData : allWeeks)
		{
			if(weeklyData.getDeaths() != null && weeklyData.getWeek() == week)
			{
				totalDeaths += weeklyData.getDeaths();
			}
		}
		return totalDeaths;
	}

	public int getTotalDeaths(String continent, int week) {
		int totalDeaths = 0;
		for (WeeklyData weeklyData : allWeeks)
		{
			if(weeklyData.getDeaths() != null && weeklyData.getWeek() == week && Objects.equals(weeklyData.getContinent(), continent))
			{
				totalDeaths += weeklyData.getDeaths();
			}
		}
		return totalDeaths;
	}
}