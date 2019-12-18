package com.xiaoyong.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "xy", type = "sellsouse")
public class SellHouse implements Serializable {
	@Id
	private Integer id;
	@Field(index = true, analyzer = "ik_smart", store = true, searchAnalyzer = "ik_smart", type = FieldType.text)
	private String keywords;
	private String description;
	private String provider;
	private String title;
	private String houseType;
	private String area;
	private String toward;
	private String story;
	private String address;
	private String sellPrice;
	private String unitPrice;
	private String publishTime;
	private String rmk;
	private String checkStatus;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHouseType() {
		return houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getToward() {
		return toward;
	}

	public void setToward(String toward) {
		this.toward = toward;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(String sellPrice) {
		this.sellPrice = sellPrice;
	}

	public String getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}

	public String getRmk() {
		return rmk;
	}

	public void setRmk(String rmk) {
		this.rmk = rmk;
	}

	public String getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
	}

	@Override
	public String toString() {
		return "SellHouse [id=" + id + ", keywords=" + keywords + ", description=" + description + ", provider="
				+ provider + ", title=" + title + ", houseType=" + houseType + ", area=" + area + ", toward=" + toward
				+ ", story=" + story + ", address=" + address + ", sellPrice=" + sellPrice + ", unitPrice=" + unitPrice
				+ ", publishTime=" + publishTime + ", rmk=" + rmk + ", checkStatus=" + checkStatus + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((checkStatus == null) ? 0 : checkStatus.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((houseType == null) ? 0 : houseType.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((keywords == null) ? 0 : keywords.hashCode());
		result = prime * result + ((provider == null) ? 0 : provider.hashCode());
		result = prime * result + ((publishTime == null) ? 0 : publishTime.hashCode());
		result = prime * result + ((rmk == null) ? 0 : rmk.hashCode());
		result = prime * result + ((sellPrice == null) ? 0 : sellPrice.hashCode());
		result = prime * result + ((story == null) ? 0 : story.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((toward == null) ? 0 : toward.hashCode());
		result = prime * result + ((unitPrice == null) ? 0 : unitPrice.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SellHouse other = (SellHouse) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (checkStatus == null) {
			if (other.checkStatus != null)
				return false;
		} else if (!checkStatus.equals(other.checkStatus))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (houseType == null) {
			if (other.houseType != null)
				return false;
		} else if (!houseType.equals(other.houseType))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (keywords == null) {
			if (other.keywords != null)
				return false;
		} else if (!keywords.equals(other.keywords))
			return false;
		if (provider == null) {
			if (other.provider != null)
				return false;
		} else if (!provider.equals(other.provider))
			return false;
		if (publishTime == null) {
			if (other.publishTime != null)
				return false;
		} else if (!publishTime.equals(other.publishTime))
			return false;
		if (rmk == null) {
			if (other.rmk != null)
				return false;
		} else if (!rmk.equals(other.rmk))
			return false;
		if (sellPrice == null) {
			if (other.sellPrice != null)
				return false;
		} else if (!sellPrice.equals(other.sellPrice))
			return false;
		if (story == null) {
			if (other.story != null)
				return false;
		} else if (!story.equals(other.story))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (toward == null) {
			if (other.toward != null)
				return false;
		} else if (!toward.equals(other.toward))
			return false;
		if (unitPrice == null) {
			if (other.unitPrice != null)
				return false;
		} else if (!unitPrice.equals(other.unitPrice))
			return false;
		return true;
	}

}
