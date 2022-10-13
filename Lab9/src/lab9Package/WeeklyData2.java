package lab9Package;

import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WeeklyData2 {
	private Integer year;
	private Integer week;
	private Integer cases;
	private Integer deaths;
	private String country;
	private String continent;
	private Double rate;

	public WeeklyData2(String line) throws Exception {
		Pattern pt;
		pt = Pattern.compile("(\\d{2}/\\d{2}/\\d{4}),((\\d{4})-(\\d{2})),(\\d+),(\\d+),(\\b[A-Z][a-z]+),(\\b[A-Z]{2}),(\\b[A-Z]{3}),(\\d+),(\\b[A-Z][a-z]+),(\\d*\\.?\\d+)");
		Matcher mt = pt.matcher(line);
		if(mt.find()) 
		{
			this.year = Integer.parseInt(mt.group(3));
			this.week = Integer.parseInt(mt.group(4));
			this.cases = Integer.parseInt(mt.group(5));
			this.deaths = Integer.parseInt(mt.group(6));
			this.country = mt.group(7);
			this.continent = mt.group(11);
			this.rate = Double.parseDouble(mt.group(12));
		} else {
			throw new Exception("Invalid line: "+line);
		}
	}
	public String toString() {
		return "Year: "+year+", week: "+week+", cases: "+cases+", deaths: "
				+deaths+", country: "+country+", continent: "+continent+", rate: "+rate;
	}
	public boolean equals(WeeklyData ob) {
		if(ob.getYear()==year && ob.getWeek()==week && ob.getCases()==cases && ob.getDeaths()==deaths 
				&& ob.getCountry()==country && ob.getWeek()==week && ob.getContinent()==continent && ob.getRate()==rate) 
		{
			return true;
		}
		return false;
	}
	public int getYear() {
		return year;
	}
	public int getWeek() {
		return week;
	}
	public int getCases() {
		return year;
	}
	public int getDeaths() {
		return week;
	}
	public String getCountry() {
		return country;
	}
	public String getContinent() {
		return continent;
	}
	public Double getRate() {
		return rate;
	}
	public static void main(String[] args) {
		System.out.println("...");
	}
}
