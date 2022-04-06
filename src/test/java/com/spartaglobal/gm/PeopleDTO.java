package com.spartaglobal.gm;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PeopleDTO{

	@JsonProperty("films")
	private List<String> films;

	@JsonProperty("homeworld")
	private String homeworld;

	@JsonProperty("gender")
	private String gender;

	@JsonProperty("skin_color")
	private String skinColor;

	@JsonProperty("edited")
	private String edited;

	@JsonProperty("created")
	private String created;

	@JsonProperty("mass")
	private String mass;

	@JsonProperty("vehicles")
	private List<String> vehicles;

	@JsonProperty("url")
	private String url;

	@JsonProperty("hair_color")
	private String hairColor;

	@JsonProperty("birth_year")
	private String birthYear;

	@JsonProperty("eye_color")
	private String eyeColor;

	@JsonProperty("species")
	private List<Object> species;

	@JsonProperty("starships")
	private List<String> starships;

	@JsonProperty("name")
	private String name;

	@JsonProperty("height")
	private String height;

	public List<String> getFilms(){
		return films;
	}

	public String getHomeworld(){
		return homeworld;
	}

	public String getGender(){
		return gender;
	}

	public String getSkinColor(){
		return skinColor;
	}

	public String getEdited(){
		return edited;
	}

	public String getCreated(){
		return created;
	}

	public String getMass(){
		return mass;
	}

	public List<String> getVehicles(){
		return vehicles;
	}

	public String getUrl(){
		return url;
	}

	public String getHairColor(){
		return hairColor;
	}

	public String getBirthYear(){
		return birthYear;
	}

	public String getEyeColor(){
		return eyeColor;
	}

	public List<Object> getSpecies(){
		return species;
	}

	public List<String> getStarships(){
		return starships;
	}

	public String getName(){
		return name;
	}

	public String getHeight(){
		return height;
	}

	public boolean checkCreateFormat() {
		String regex = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}.\\d{6}Z";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(getCreated());
		return m.matches();
	}

	public boolean checkEditedFormat() {
		String regex = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}.\\d{6}Z";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(getEdited());
		return m.matches();
	}

	public boolean checkIfNull(String value){
		return value.equals(null);
	}

	public boolean checkIfEmpty(String value){
		return value.isEmpty();
	}

	public boolean isNameNull(){
		return checkIfNull(name);
	}

	public boolean isNameEmpty(){
		return checkIfEmpty(name);
	}

	public boolean isBirthYearNull(){
		return checkIfNull(birthYear);
	}

	public boolean isBirthYearEmpty(){
		return checkIfEmpty(birthYear);
	}

	public boolean isEyeColourNull(){
		return checkIfNull(eyeColor);
	}

	public boolean isEyeColourEmpty(){
		return checkIfEmpty(eyeColor);
	}

	public boolean isGenderNull(){
		return checkIfNull(gender);
	}

	public boolean isGenderEmpty(){
		return checkIfEmpty(gender);
	}

	public boolean isHairColourNull(){
		return checkIfNull(hairColor);
	}

	public boolean isHairColourEmpty(){
		return checkIfEmpty(hairColor);
	}

	public boolean isHeightNull(){
		return checkIfNull(gender);
	}

	public boolean isHeightEmpty(){
		return checkIfEmpty(height);
	}

	public boolean isNotnull(String number){
		if(number != "null"){
			return true;
		}else {
			return false;
		}
	}

	public boolean isNotEqualToZero(String Number){
		int number = Integer.parseInt(Number);
		if(number != 0){
			return true;
		}else {
			return false;
		}
	}

	public boolean isHeightGreaterThan0(){
		int number = Integer.parseInt(getHeight());
		if(number > 0){
			return true;
		}else {
			return false;
		}
	}

	public boolean isMassGreaterThan0(){
		int number = Integer.parseInt(getMass());
		if(number > 0){
			return true;
		}else {
			return false;
		}
	}

	public boolean isHeightInt(){
		try {
			int number = Integer.parseInt(getHeight());
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public boolean isMassInt(){
		try {
			int number = Integer.parseInt(getMass());
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public Integer covertHeightToInteger(){
		Integer height = Integer.parseInt(getHeight());
		return height;
	}

	public Integer covertMassToInteger(){
		Integer mass = Integer.parseInt(getMass());
		return mass;
	}

	public String getLastThreeCharactersOfDOB() {
		char[] birthYearArray = birthYear.toCharArray();
		String lastChars = null;
		lastChars = String.valueOf(birthYearArray[birthYear.length() - 3] + birthYearArray[birthYear.length() - 2] + birthYearArray[birthYear.length() - 1]);
		return lastChars;
	}

	public double getFirstNumbersOfDOB(){
		char[] birthYearArray = birthYear.toCharArray();
		String firstPart= null;
		for (int i =0;  i < birthYearArray.length-3; i++){
			firstPart = firstPart + birthYearArray[i];
		}
		Double firstNumbers = Double.parseDouble(firstPart);
		return firstNumbers;
	}

	public boolean checkIfDateIsValid(){
		return getBirthYear().matches("\\d{1,3}[A-Z]{3}");
	}

	public boolean checkIfGenderIsValid(){
		String[] validGenders = {"male", "female", "unknown", "n/a"};
		for(String genders : validGenders) {
			if (gender.toLowerCase().equals(genders)) {
				return true;
			}
		}
		return false;
	}

	public boolean checkIfURLIsValid(String url){
		String regex = "((http|https)://)(www.)?"
				+ "[a-zA-Z0-9@:%._\\+~#?&//=]"
				+ "{2,256}\\.[a-z]"
				+ "{2,6}\\b([-a-zA-Z0-9@:%"
				+ "._\\+~#?&//=]*)";
		return url.matches(regex);
	}

	public int checkStatusCodeOfURL(String url){
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
		HttpResponse<String> response = null;
		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		return response.statusCode();
	}

	public boolean checkIfURLsAreValidInArray(List<String> array){
		if (array == null) {
			return false;
		} else {
			for (int i = 0; i < array.size(); i++) {
				if (checkIfURLIsValid(array.get(i)) == false) {
					return false;
				}
			}
			return true;
		}
	}
}