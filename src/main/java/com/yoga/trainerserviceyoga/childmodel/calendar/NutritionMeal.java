package com.yoga.trainerserviceyoga.childmodel.calendar;

import com.yoga.trainerserviceyoga.childmodel.Remainder;

public class NutritionMeal {
	private int foodId;
	private String catagory1;
	private String catagory2;
	private String foodName;
	private int foodCode;
	private NutriValue totalFat;
	private NutriValue calcium;
	private String iron;
	private String cholesterol;
	private NutriValue energy;
	private String pottasium;
	private String sodium;
	private NutriValue carboHydrate;
	private NutriValue protein;
	private NutriValue totalFibre;
	private String publish;
	private String description;
	private String imgUrl;
	private String brandOwner;
	private String source;
	private Object quantity;
	private String foodStatus;
	private String createdBy;
	private Remainder remainder;
	private String time;
	private int refId;
	private int actualQuantity;
	private int servingSize;
	private Macros macros;
	private String units;
    private DailyValues dailyValues;
	
	public DailyValues getDailyValues() {
		return dailyValues;
	}
	public void setDailyValues(DailyValues dailyValues) {
		this.dailyValues = dailyValues;
	}
	
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
	}
	public Macros getMacros() {
		return macros;
	}
	public void setMacros(Macros macros) {
		this.macros = macros;
	}
	public int getServingSize() {
		return servingSize;
	}
	public void setServingSize(int servingSize) {
		this.servingSize = servingSize;
	}
	
	
	public int getActualQuantity() {
		return actualQuantity;
	}
	public void setActualQuantity(int actualQuantity) {
		this.actualQuantity = actualQuantity;
	}
	public int getRefId() {
		return refId;
	}
	public void setRefId(int refId) {
		this.refId = refId;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public String getCatagory1() {
		return catagory1;
	}
	public void setCatagory1(String catagory1) {
		this.catagory1 = catagory1;
	}
	public String getCatagory2() {
		return catagory2;
	}
	public void setCatagory2(String catagory2) {
		this.catagory2 = catagory2;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public int getFoodCode() {
		return foodCode;
	}
	public void setFoodCode(int foodCode) {
		this.foodCode = foodCode;
	}
	public NutriValue getTotalFat() {
		return totalFat;
	}
	public void setTotalFat(NutriValue totalFat) {
		this.totalFat = totalFat;
	}
	public NutriValue getCalcium() {
		return calcium;
	}
	public void setCalcium(NutriValue calcium) {
		this.calcium = calcium;
	}
	public String getIron() {
		return iron;
	}
	public void setIron(String iron) {
		this.iron = iron;
	}
	public String getCholesterol() {
		return cholesterol;
	}
	public void setCholesterol(String cholesterol) {
		this.cholesterol = cholesterol;
	}
	public NutriValue getEnergy() {
		return energy;
	}
	public void setEnergy(NutriValue energy) {
		this.energy = energy;
	}
	public String getPottasium() {
		return pottasium;
	}
	public void setPottasium(String pottasium) {
		this.pottasium = pottasium;
	}
	public String getSodium() {
		return sodium;
	}
	public void setSodium(String sodium) {
		this.sodium = sodium;
	}
	public NutriValue getCarboHydrate() {
		return carboHydrate;
	}
	public void setCarboHydrate(NutriValue carboHydrate) {
		this.carboHydrate = carboHydrate;
	}
	public NutriValue getProtein() {
		return protein;
	}
	public void setProtein(NutriValue protein) {
		this.protein = protein;
	}
	public NutriValue getTotalFibre() {
		return totalFibre;
	}
	public void setTotalFibre(NutriValue totalFibre) {
		this.totalFibre = totalFibre;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getBrandOwner() {
		return brandOwner;
	}
	public void setBrandOwner(String brandOwner) {
		this.brandOwner = brandOwner;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public Object getQuantity() {
		return quantity;
	}
	public void setQuantity(Object quantity) {
		this.quantity = quantity;
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
	public Remainder getRemainder() {
		return remainder;
	}
	public void setRemainder(Remainder remainder) {
		this.remainder = remainder;
	}
}
