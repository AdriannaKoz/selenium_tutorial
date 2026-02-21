from selenium import webdriver
from time import sleep
from selenium.webdriver.common.by import By

driver = webdriver.Chrome()
driver.get("https://automationpractice.techwithjatin.com/")
driver.maximize_window()
sign_in_a = driver.find_element(By.XPATH, "//a[@title='Log in to your customer account']")
sign_in_a.click()
sleep(5)
driver.quit()