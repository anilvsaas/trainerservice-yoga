package com.yoga.trainerserviceyoga.model;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yoga.trainerserviceyoga.childmodel.AltMeasure;
import com.yoga.trainerserviceyoga.childmodel.calendar.DailyValues;
import com.yoga.trainerserviceyoga.childmodel.calendar.Macros;
import com.yoga.trainerserviceyoga.childmodel.calendar.NutriValue;
import com.yoga.trainerserviceyoga.childmodel.calendar.Photo;
import com.yoga.trainerserviceyoga.childmodel.calendar.Quantity;

public class NutritionMealModel {
	private String food_name;
	private String brand_name;
	private Quantity serving_qty;
	private String serving_unit;
	private NutriValue serving_weight_grams;
	private NutriValue nf_calories;
	private NutriValue nf_total_fat;
	private float nf_saturated_fat;
	private Integer nf_cholesterol;
	private float nf_sodium;
	private NutriValue nf_total_carbohydrate;
	private NutriValue nf_dietary_fiber;
	private float nf_sugars;
	private NutriValue nf_protein;
	private float nf_potassium;
	private String nix_brand_name;
	private String nix_brand_id;
	private String nix_item_name;
	private String nix_item_id;
	private String upc;
	private List<AltMeasure> alt_measures = new ArrayList<AltMeasure>();
	private Photo photo;
	private Macros macros;
	private DailyValues dailyValues;
	private String foodStatus;
	private String createdBy;
	private Integer refId;
	private String time;
	private String consumedTime;
	
	public String getFood_name() {
		return food_name;
	}
	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}
	public String getBrand_name() {
		return brand_name;
	}
	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}
	public Quantity getServing_qty() {
		return serving_qty;
	}
	public void setServing_qty(Quantity serving_qty) {
		this.serving_qty = serving_qty;
	}
	public String getServing_unit() {
		return serving_unit;
	}
	public void setServing_unit(String serving_unit) {
		this.serving_unit = serving_unit;
	}
	public NutriValue getServing_weight_grams() {
		return serving_weight_grams;
	}
	public void setServing_weight_grams(NutriValue serving_weight_grams) {
		this.serving_weight_grams = serving_weight_grams;
	}
	public NutriValue getNf_calories() {
		return nf_calories;
	}
	public void setNf_calories(NutriValue nf_calories) {
		this.nf_calories = nf_calories;
	}
	public NutriValue getNf_total_fat() {
		return nf_total_fat;
	}
	public void setNf_total_fat(NutriValue nf_total_fat) {
		this.nf_total_fat = nf_total_fat;
	}
	public float getNf_saturated_fat() {
		return nf_saturated_fat;
	}
	public void setNf_saturated_fat(float nf_saturated_fat) {
		this.nf_saturated_fat = nf_saturated_fat;
	}
	public Integer getNf_cholesterol() {
		return nf_cholesterol;
	}
	public void setNf_cholesterol(Integer nf_cholesterol) {
		this.nf_cholesterol = nf_cholesterol;
	}
	public float getNf_sodium() {
		return nf_sodium;
	}
	public void setNf_sodium(float nf_sodium) {
		this.nf_sodium = nf_sodium;
	}
	public NutriValue getNf_total_carbohydrate() {
		return nf_total_carbohydrate;
	}
	public void setNf_total_carbohydrate(NutriValue nf_total_carbohydrate) {
		this.nf_total_carbohydrate = nf_total_carbohydrate;
	}
	public NutriValue getNf_dietary_fiber() {
		return nf_dietary_fiber;
	}
	public void setNf_dietary_fiber(NutriValue nf_dietary_fiber) {
		this.nf_dietary_fiber = nf_dietary_fiber;
	}
	public float getNf_sugars() {
		return nf_sugars;
	}
	public void setNf_sugars(float nf_sugars) {
		this.nf_sugars = nf_sugars;
	}
	public NutriValue getNf_protein() {
		return nf_protein;
	}
	public void setNf_protein(NutriValue nf_protein) {
		this.nf_protein = nf_protein;
	}
	public float getNf_potassium() {
		return nf_potassium;
	}
	public void setNf_potassium(float nf_potassium) {
		this.nf_potassium = nf_potassium;
	}
	public String getNix_brand_name() {
		return nix_brand_name;
	}
	public void setNix_brand_name(String nix_brand_name) {
		this.nix_brand_name = nix_brand_name;
	}
	public String getNix_brand_id() {
		return nix_brand_id;
	}
	public void setNix_brand_id(String nix_brand_id) {
		this.nix_brand_id = nix_brand_id;
	}
	public String getNix_item_name() {
		return nix_item_name;
	}
	public void setNix_item_name(String nix_item_name) {
		this.nix_item_name = nix_item_name;
	}
	public String getNix_item_id() {
		return nix_item_id;
	}
	public void setNix_item_id(String nix_item_id) {
		this.nix_item_id = nix_item_id;
	}
	public String getUpc() {
		return upc;
	}
	public void setUpc(String upc) {
		this.upc = upc;
	}
	public List<AltMeasure> getAlt_measures() {
		return alt_measures;
	}
	public void setAlt_measures(List<AltMeasure> alt_measures) {
		this.alt_measures = alt_measures;
	}
	public Photo getPhoto() {
		return photo;
	}
	public void setPhoto(Photo photo) {
		this.photo = photo;
	}
	public Macros getMacros() {
		return macros;
	}
	public void setMacros(Macros macros) {
		this.macros = macros;
	}
	public DailyValues getDailyValues() {
		return dailyValues;
	}
	public void setDailyValues(DailyValues dailyValues) {
		this.dailyValues = dailyValues;
	}
	public String getFoodStatus() {
		return foodStatus;
	}
	public void setFoodStatus(String foodStatus) {
		this.foodStatus = foodStatus;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Integer getRefId() {
		return refId;
	}
	public void setRefId(Integer refId) {
		this.refId = refId;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getConsumedTime() {
		return consumedTime;
	}
	public void setConsumedTime(String consumedTime) {
		this.consumedTime = consumedTime;
	}
	
}
