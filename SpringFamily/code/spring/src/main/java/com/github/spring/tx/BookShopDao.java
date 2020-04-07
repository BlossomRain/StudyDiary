package com.github.spring.tx;

public interface BookShopDao {

	//获取书名
	public int findBookPriceByIsbn(String isbn);
	
	//获取库存
	public void updateBookStock(String isbn);
	
	//更新账户
	public void updateUserAccount(String username, int price);
}
