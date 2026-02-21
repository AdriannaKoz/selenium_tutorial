from selenium import webdriver
from time import sleep

driver = webdriver.Chrome()
driver.get("https://www.wp.pl/")
driver.maximize_window()
sleep(5)
driver.quit()