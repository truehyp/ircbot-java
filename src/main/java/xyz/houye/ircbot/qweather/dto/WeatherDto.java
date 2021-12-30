package xyz.houye.ircbot.qweather.dto;

public class WeatherDto {
	private String fxDate;
	private String tempMax;
	private String tempMin;
	private String textDay;
	private String textNight;
	private String windDirDay;
	private String windScaleDay;
	private String windDirNight;
	private String windScaleNight;

	
	public String getWindDirDay() {
		return windDirDay;
	}
	public void setWindDirDay(String windDirDay) {
		this.windDirDay = windDirDay;
	}
	public String getWindDirNight() {
		return windDirNight;
	}
	public void setWindDirNight(String windDirNight) {
		this.windDirNight = windDirNight;
	}
	public String getFxDate() {
		return fxDate;
	}
	public void setFxDate(String fxDate) {
		this.fxDate = fxDate;
	}
	public String getWindScaleNight() {
		return windScaleNight;
	}
	public void setWindScaleNight(String windScaleNight) {
		this.windScaleNight = windScaleNight;
	}
	public String getfxDate() {
		return fxDate;
	}
	public void setfxDate(String fxdate) {
		fxDate = fxdate;
	}
	public String getTempMax() {
		return tempMax;
	}
	public void setTempMax(String tempMax) {
		this.tempMax = tempMax;
	}
	public String getTempMin() {
		return tempMin;
	}
	public void setTempMin(String tempMin) {
		this.tempMin = tempMin;
	}
	public String getTextDay() {
		return textDay;
	}
	public void setTextDay(String textDay) {
		this.textDay = textDay;
	}
	public String getTextNight() {
		return textNight;
	}
	public void setTextNight(String textNight) {
		this.textNight = textNight;
	}
	public String getWindScaleDay() {
		return windScaleDay;
	}
	public void setWindScaleDay(String windScaleDay) {
		this.windScaleDay = windScaleDay;
	}
	@Override
	public String toString() {
		return  fxDate
				+" "+tempMin+"℃"
				+"-"+tempMax+"℃"
				+" day {"+textDay
				+" "+windDirDay
				+windScaleDay
				+"} night {"+textNight
				+" "+windDirNight
				+windScaleNight
				+"}";
	}
	
	

}
