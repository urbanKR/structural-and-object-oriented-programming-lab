package lab9Package;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WeeklyData {
	private Integer year;
	private Integer week;
	private Integer cases;
	private Integer deaths;
	private String country;
	private String continent;
	private Double rate;

	public WeeklyData(String line) throws Exception {
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
		} 
		else 
		{
			throw new Exception("Invalid line: "+line);
		}
	}
	public Integer getYear() {
		return year;
	}
	public Integer getWeek() {
		return week;
	}
	public Integer getCases() {
		return cases;
	}
	public String getCountry() {
		return country;
	}
	public Integer getDeaths() {
		return deaths;
	}
	public String getContinent() {
		return continent;
	}
	public Double getRate() {
		return rate;
	}
	public String toString() {
		return "WeeklyData:"+"year: "+year+", week: "+week+", cases: "+cases+", deaths: "+deaths+
				", country: '"+country+'\'' +", continent='"+continent+'\'' +", rate="+rate;
	}
	public boolean equals(Object ob) {
		if(this == ob) 
		{
			return true;
		}
		if(ob == null || getClass() != ob.getClass()) 
		{
			return false;
		}
		WeeklyData that = (WeeklyData) ob;
		return Objects.equals(year, that.year) && Objects.equals(week, that.week) 
				&& Objects.equals(cases, that.cases) && Objects.equals(deaths, that.deaths) 
				&& Objects.equals(country, that.country) && Objects.equals(continent, that.continent) 
				&& Objects.equals(rate, that.rate);
	}
}
