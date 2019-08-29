# coding=utf-8
from selenium import webdriver
import time
b = webdriver.Firefox()
b.get("http://www.baidu.com")
time.sleep(2)
b.set_window_size(480,800)
b.find_element_by_id("kw").send_keys("selenium")
b.find_element_by_id("su").click()
b.quit()