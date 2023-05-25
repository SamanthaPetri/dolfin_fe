from selenium import webdriver
from selenium.webdriver.common.keys import Keys

# Initialize the WebDriver (Chrome in this example)
driver = webdriver.Chrome()

# Open the website
driver.get("https://dolfintechnology.com")


# Find a button by its ID and click it
element = driver.find_element_by_id("home-submit-button")
element.click()

# Assert the page title to validate successful navigation
assert "Success" in driver.title

# Close the browser
driver.quit()
