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
	 * Զ�̴��������urlΪԶ�������ĵ�ַ
	 * @param urlRomoteԶ�������ĵ�ַ
	 * @param url ��Ҫ�򿪵���վ��ַ
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
	 * ��ǰ�������
	 */
	@Keyword
	public void maximize(){
		driver.manage().window().maximize();
	}
	
	/**
	 * �ȴ�
	 * @param second �ȴ���ʱ�䣬����Ϊ��λ
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
	 * ʹ��Id����WebElement
	 * @param id
	 * @return ����ָ��Id��Ӧ��WebElement
	 */
	@Keyword
	public WebElement findElementById(String id){
		return driver.findElement(By.id(id));
	}
	/**
	 * ����id��������
	 * @param id Ԫ��
	 * @param text ���������
	 */
	@Keyword
	public void inputtext(String id,String text){
		driver.findElement(By.id(id)).sendKeys(text);
	}
	
	/**
	 * �ύidԪ�����ڵı�
	 * @param id Ԫ�ص�ID
	 */
	@Keyword
	public void submit(String id){
		driver.findElement(By.id(id)).submit();
	}
	
	/**
	 * �ر����д���
	 */
	@Keyword
	public void closeAllWindow(){
		driver.quit();
	}
	
	/**
	 * ��ӡ��־
	 * @param msg ��Ҫ��ӡ����־��Ϣ
	 */
	@Keyword
	public void log(String msg){
		System.out.println(msg);
	}
}
