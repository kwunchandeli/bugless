package com.kun.bugless.selenium2library.keyword;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.kun.bugless.core.annotation.Keyword;

public class Selenium2Library {
	
	private WebDriver driver;
	
	Selenium2Library(){
		
	}
	/**
	 * 远程打开浏览器，url为远程主机的地址
	 * @param urlRomote远程主机的地址
	 * @param url 需要打开的网站地址
	 */
	@Keyword
	public void openBrowser(String urlRomote,String url){
		ChromeOptions chromeOptions = new ChromeOptions();
		try {
			this.driver = new RemoteWebDriver(new URL(url), chromeOptions);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.get(url);
	}
	
	/**
	 * 当前窗口最大化
	 */
	@Keyword
	public void maximize(){
		driver.manage().window().maximize();
	}
	
	/**
	 * 等待
	 * @param second 等待的时间，以秒为单位
	 */
	@Keyword
	public void sleep(int second){
		try {
			Thread.sleep(second*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 使用Id查找WebElement
	 * @param id
	 * @return 返回指定Id对应的WebElement
	 */
	@Keyword
	public WebElement findElementById(String id){
		return driver.findElement(By.id(id));
	}
	/**
	 * 根据id输入内容
	 * @param id 元素
	 * @param text 输入的内容
	 */
	@Keyword
	public void inputtext(String id,String text){
		driver.findElement(By.id(id)).sendKeys(text);
	}
	
	/**
	 * 提交id元素所在的表单
	 * @param id 元素的ID
	 */
	@Keyword
	public void submit(String id){
		driver.findElement(By.id(id)).submit();
	}
	
	/**
	 * 关闭所有窗口
	 */
	@Keyword
	public void closeAllWindow(){
		driver.quit();
	}
	
	/**
	 * 打印日志
	 * @param msg 需要打印的日志信息
	 */
	@Keyword
	public void log(String msg){
		System.out.println(msg);
	}
}
