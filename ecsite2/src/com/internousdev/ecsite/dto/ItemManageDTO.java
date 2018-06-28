package com.internousdev.ecsite.dto;

public class ItemManageDTO {

		public String itemName;
		public String itemPrice;
		public String itemStock;
		public String itemCategory;
		public String id;

		public String getItemCategory() {
			return itemCategory;
		}
		public void setItemCategory(String itemCategory) {
			this.itemCategory = itemCategory;
		}
		public String getItemName() {
			return itemName;
		}
		public void setItemName(String itemName) {
			this.itemName = itemName;
		}
		public String getItemPrice() {
			return itemPrice;
		}
		public void setItemPrice(String itemPrice) {
			this.itemPrice = itemPrice;
		}

		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getItemStock() {
			return itemStock;
		}
		public void setItemStock(String itemStock) {
			 this.itemStock = itemStock;
		}
	}
